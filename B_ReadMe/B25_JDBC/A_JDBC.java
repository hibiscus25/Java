package B_ReadMe.B25_JDBC;

import javax.imageio.ImageIO;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;

/*  При работе с БД используют следующие типы Statement'ов, различающихся по назначению:
        - java.sql.Statement — Statement общего назначения;
        - java.sql.PreparedStatement — Statement выполнения запросов c параметрами, обозначенными символом '?' в теле запроса;
        - java.sql.CallableStatement — Statement вызова хранимых процедур.

    Интерфейс java.sql.ResultSet позволяет извлекать информацию из базы данных.

*/
public class A_JDBC {
    // данные для подключения к базе данных
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://database-1.c0nqcnerv9wp.us-east-1.rds.amazonaws.com:3306/database_name";
    public static final String USER = "maven";
    public static final String PASS = "1291328diMA";

    // SQL - запросы
    private static String createTable = "CREATE TABLE JDBC1 (ID INT NOT NULL AUTO_INCREMENT, NAME VARCHAR(30) NOT NULL, CONSTRAINT JDBC1_PK PRIMARY KEY (ID))";
    private static String addName1 = "INSERT INTO JDBC1 (NAME) VALUES ('INFERNO')";
    private static String addName2 = "INSERT INTO JDBC1 SET NAME = 'SOLOMON'";

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        //------------------------------------- подключение к базе данных ----------------------------------------------
                // 1. подгружаем библиотеку - mysql-connector-java-8.0.27.jar
                // 2. подключаем  properties
            Class.forName(JDBC_DRIVER);
        try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement statement = connection.createStatement()) {

        //------------------------------------------- cоздаем таблицу --------------------------------------------------
            //добавляем таблицу с данными
            statement.executeUpdate("DROP TABLE IF EXISTS JDBC1");
                statement.executeUpdate(createTable);
                statement.executeUpdate(addName1);
                statement.executeUpdate(addName2);

            // получаем данные
            ResultSet resultset = statement.executeQuery("SELECT * FROM JDBC1");
            while(resultset.next()){
                System.out.println(resultset.getInt(1));
                System.out.println(resultset.getString(2));
                System.out.println("-----------------------------");
            }

            ResultSet resultSet2 = statement.executeQuery("SELECT NAME FROM JDBC1 WHERE ID=1");
            while(resultSet2.next())
                System.out.println(resultSet2.getString(1));
            System.out.println("-----------------------------");


        //---------------------- PreparedStatement - предназначен для предотвращения SQl Injection ---------------------
            int userId = 1;
            PreparedStatement pStat = connection.prepareStatement("SELECT * FROM JDBC1 WHERE ID = ?");
                pStat.setInt(1, userId);
                ResultSet resultSet3 = pStat.executeQuery();
                while(resultSet3.next())
                    System.out.println("userId - " + resultSet3.getInt("id") + "   name - " + resultSet3.getString(2));
            System.out.println("-----------------------------");



        //---- BLOB - Binary Large Objects (для байтовых) ---------  CLOB - Character Large Objects (для текстовых) ----
            statement.executeUpdate("ALTER TABLE JDBC1 ADD IMG BLOB");            //    добавление столбца BLOB

            // создали файл - нужно его открыть и нарисовать что - то, так числиться пустым
            File file = new File("src/B_ReadMe/B25_JDBC/0.1_java.png");
            File outputFile = new File("src/B_ReadMe/B25_JDBC/0.2_java.png");

            BufferedImage image = ImageIO.read(file);                                    // записали image в blob
            Blob blob = connection.createBlob();
            OutputStream out = blob.setBinaryStream(1);
            ImageIO.write(image, "png", out);
            out.close();

            // добавление в базу
            PreparedStatement pStatm = connection.prepareStatement("INSERT INTO JDBC1 (NAME, IMG) VALUES(?, ?)");
                pStatm.setString(1,"inferno-two");
                pStatm.setBlob(2, blob);
                pStatm.execute();

            // чтение из базы
            ResultSet resultSet4 = statement.executeQuery("SELECT * FROM JDBC1");
                while (resultSet4.next()){
                    Blob blob2 = resultSet4.getBlob("IMG");
                    if(blob2 != null) {
                        BufferedImage image2 = ImageIO.read(blob2.getBinaryStream());
                        ImageIO.write(image2, "png", outputFile);
                    }
                }

            // удаление файлов
            outputFile.delete();


        //------------------------------------------------ DATE --------------------------------------------------------
           statement.executeUpdate("ALTER TABLE JDBC1 ADD DT DATE;");               // добавление столбца DATE

           PreparedStatement preStat = connection.prepareStatement("INSERT INTO JDBC1 (NAME, DT) VALUES(?, ?)");
                preStat.setString(1,"GLOBAL DATE");
                preStat.setDate(2, new Date(1555151515151l));
                preStat.execute();

           statement.executeUpdate("INSERT INTO JDBC1 (NAME, DT) VALUES('newDate', {d '2017-02-08'})");

           ResultSet resultSet5 = statement.executeQuery("SELECT * FROM JDBC1");
           while (resultSet5.next()){
               Date date = resultSet5.getDate("DT");
               if(date != null)
                    System.out.println(date);
           }
            System.out.println("-----------------------------");


        //--------------------------------------------- Хранимые процедуры ---------------------------------------------
            CallableStatement callableStatement = connection.prepareCall("{call JDBCount(?)}");
            callableStatement.registerOutParameter(1, Types.INTEGER);       // назначает значение Integer
            callableStatement.execute();
            System.out.println(callableStatement.getInt(1));
            System.out.println("-----------------------------");

            CallableStatement callableStatement2 = connection.prepareCall("{call getBooks(?)}");
            callableStatement2.setInt(1, 2);
            if (callableStatement2.execute()) {
                ResultSet resultSet = callableStatement2.getResultSet();
                while (resultSet.next())
                    System.out.println(resultSet.getInt("id") + "  -  " + resultSet.getString("name"));
                System.out.println("-----------------------------");
            }


        //------------------------------------------ Множественные результаты ------------------------------------------
            CallableStatement callableStatement3 = connection.prepareCall("{call getCount()}");
            boolean hasResults = callableStatement3.execute();
                while (hasResults){
                    ResultSet resultSet = callableStatement3.getResultSet();
                    while (resultSet.next())
                        System.out.println(resultSet.getInt(1));
                    hasResults = callableStatement3.getMoreResults();
                }
            System.out.println("-----------------------------");


        //------------------------------------------ Scrollable RowSet -------------------------------------------------
            // TYPE_SCROLL_INSENSITIVE - без учета изменений в базе данных     TYPE_SCROLL_SENSITIVE  - с учетом изменений
            // CONCUR_READ_ONLY - только чтение                                CONCUR_UPDATABL        - можем обновлять
        Statement statement5 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            // с preparedStatement аналогично
        // PreparedStatement preparedStatement = connection.prepareStatement("пишем sql запрос", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement5.executeQuery("SELECT * FROM JDBC1");
            if(resultSet.next())
                System.out.println(resultSet.getString("name"));
            if(resultSet.next())
                System.out.println(resultSet.getString("name"));
            if(resultSet.next())
                System.out.println(resultSet.getString("name"));

            System.out.println();
            if(resultSet.relative(2))                                       // через 2 - вперед
                System.out.println(resultSet.getString("name"));
            if(resultSet.relative(-2))                                      // через 2 - назад
                System.out.println(resultSet.getString("name"));

            System.out.println();
            if(resultSet.absolute(2))                                       // значение 2 ячейки от начала
                System.out.println(resultSet.getString("name"));

            System.out.println();
            if(resultSet.first())                                                 // первый в таблице
                System.out.println(resultSet.getString("name"));
            if(resultSet.last())                                                  // последний в таблице
                System.out.println(resultSet.getString("name"));
            System.out.println("-----------------------------");


        //------------------------------------------ Update ResultSet --------------------------------------------------
            Statement statement6 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            // с preparedStatement аналогично
            ResultSet result = statement6. executeQuery("SELECT * FROM JDBC1");
                while(result.next())
                    System.out.println(result.getInt(1) + " -  " + result.getString(2));
            System.out.println();

            result.last();                                                  // идем до последнего
            result.updateString("name", "NEWnew");            // обновление имени
            result.updateRow();

            result.moveToInsertRow();                                       // идем до последнего
            result.updateString("name", "insertedNEW");       // добавляем новое значение
            result.insertRow();

            result.absolute(4);                                       // идем к 3 графе
            result.deleteRow();                                            // удаляем ее

            result.beforeFirst();
            while(result.next())
                System.out.println(result.getInt(1) + " -  " + result.getString(2));
            System.out.println("-----------------------------");


        //--------------------------------------------- Metadata -------------------------------------------------------
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSet6 = databaseMetaData.getTables(null, null, null, new String[]{"Table"});
            while(resultSet6.next()){
                System.out.println(resultSet6.getString(1));      //     имя базы
                System.out.println(resultSet6.getString(3));      //     имя таблицы
                break;
            }

            System.out.println();
            ResultSet resultSet7 = statement.executeQuery("SELECT * FROM JDBC1");
            ResultSetMetaData resultSetMetaData = resultSet7.getMetaData();
            System.out.println("Название таблицы: " + resultSetMetaData.getTableName(1));
            System.out.println("Количество колонок: " + resultSetMetaData.getColumnCount());
            for(int i = 1; i<=resultSetMetaData.getColumnCount(); i++){
                System.out.println(resultSetMetaData.getColumnLabel(i));
                System.out.println(resultSetMetaData.getColumnClassName(i));
                System.out.println(resultSetMetaData.getColumnTypeName(i));
                System.out.println(resultSetMetaData.getPrecision(i));
                System.out.println("Допускает значение NULL (0-N /1-Y) - " + resultSetMetaData.isNullable(i));
                    if(i <= resultSetMetaData.getColumnCount() - 1)
                        System.out.println("---");
            }
            System.out.println("-----------------------------");
        }


        //---------------------------------- Кэширование результата запроса - CachedRowSet -----------------------------
            ResultSet resultSet10 = getData();
            while(resultSet10.next())
                System.out.println(resultSet10.getInt(1) + " -  " + resultSet10.getString(2));
            System.out.println();

            // если вернулась большая таблица из нее можно еще делать запросы для получения данных
            CachedRowSet cachedRowSet = (CachedRowSet) resultSet10;
                    cachedRowSet.setUrl(DB_URL);
                    cachedRowSet.setUsername(USER);
                    cachedRowSet.setPassword(PASS);

                // одиночный вывод
                cachedRowSet.setCommand("SELECT * FROM JDBC2 WHERE ID = ? ");
                    cachedRowSet.setInt(1,2);
                cachedRowSet.execute();
                while(cachedRowSet.next())
                     System.out.println(cachedRowSet.getInt(1) + " -  " + cachedRowSet.getString(2));
                System.out.println();

                // выводим батчами
                int count = 1;
                int page  = 3;
                cachedRowSet.setCommand("SELECT * FROM JDBC2");
                    cachedRowSet.setPageSize(page);                   //количество выводов за один раз
                    cachedRowSet.execute();
                do{
                    System.out.println("-- c " + count + " по  " + page );
                    while(cachedRowSet.next())
                        System.out.println(cachedRowSet.getInt(1) + " -  " + cachedRowSet.getString(2));
                    count +=3;
                    page+=3;
                }while (cachedRowSet.nextPage());
                System.out.println("-----------------------------");


                // редактирования данных
                // TODO выдает ошибку при акцепте, что - то с commit связано или многопоточностью
//                ResultSet resultSet2 = getData();
//                CachedRowSet cachedRowSet2 = (CachedRowSet) resultSet2;
//                    cachedRowSet2.setTableName("JDBC2");
//                    cachedRowSet2.absolute(2);
//                    cachedRowSet2.deleteRow();
//                    cachedRowSet2.beforeFirst();
//                    while(cachedRowSet2.next())
//                        System.out.println(cachedRowSet2.getInt(1) + " -  " + cachedRowSet2.getString(2));
                // чтобы изменения передались в базу данных есть два способа акцептить данные
                   // 1 -вариант
//                    cachedRowSet2.setUrl(DB_URL);
//                    cachedRowSet2.setUsername(USER);
//                    cachedRowSet2.setPassword(PASS);
//                    cachedRowSet2.acceptChanges();
                   // 2 -вариант
//               cachedRowSet2.acceptChanges(DriverManager.getConnection(DB_URL,USER, PASS));
//                System.out.println("-----------------------------");

        //------------------------------------ удаляем таблицы из базы данных ------------------------------------------
        try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS JDBC1");
            statement.executeUpdate("DROP TABLE IF EXISTS JDBC2");
            System.out.println("Таблицы из базы данных удалены");
        }
    }


    public static ResultSet getData() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement stat = connection.createStatement()) {
            // cоздаем таблицу
            stat.execute("DROP TABLE IF EXISTS JDBC2");
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS JDBC2(ID INT NOT NULL AUTO_INCREMENT, NAME VARCHAR(30) NOT NULL, CONSTRAINT JDBC2_PK PRIMARY KEY (ID))");
            stat.executeUpdate("INSERT INTO JDBC2 (NAME) VALUES ('Inferno')", Statement.RETURN_GENERATED_KEYS);
            stat.executeUpdate("INSERT INTO JDBC2 (NAME) VALUES ('Davinchi')", Statement.RETURN_GENERATED_KEYS);
            stat.executeUpdate("INSERT INTO JDBC2 (NAME) VALUES ('Solomn key')", Statement.RETURN_GENERATED_KEYS);
            stat.executeUpdate("INSERT INTO JDBC2 (NAME) VALUES ('Cod')", Statement.RETURN_GENERATED_KEYS);
            stat.executeUpdate("INSERT INTO JDBC2 (NAME) VALUES ('World')", Statement.RETURN_GENERATED_KEYS);

            // без этих записей код свалится, так как при возврате закрывается connection
            // чтобы это избежать используется CashedRowSet
            // есть еще FilteredRowSet, JdbcRowSet, JoinRowSet, WebRowSet - отличие только в форме хранения
            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet cachedRowSet = factory.createCachedRowSet();

            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM JDBC2");
            cachedRowSet.populate(resultSet);

            return cachedRowSet;            //является наследником resultSet, поэтому подходит
        }
    }
}
