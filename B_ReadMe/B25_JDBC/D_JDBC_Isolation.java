package B_ReadMe.B25_JDBC;

import java.sql.*;

// таблица JDBC3 - создана в JDBC_SQLBatch
public class D_JDBC_Isolation {
        public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        public static final String DB_URL = "jdbc:mysql://database-1.c0nqcnerv9wp.us-east-1.rds.amazonaws.com:3306/database_name";
        public static final String USER = "maven";
        public static final String PASS = "1291328diMA";

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
        Class.forName(JDBC_DRIVER);

        // Dirty Reads - грязное чтение (еще не обновились данные в базе, а другой метод уже прочитал данные)
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement st = connection.createStatement()) {
            System.out.println("Dirty Reads ");
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

            st.execute("UPDATE JDBC3 SET NAME = 'NEWNEW' WHERE ID = 1");
            new OtherTransBad().start();
            Thread.sleep(2000);
            new OtherTransGood().start();     // для решения необходимо установить уровень TRANSACTION_READ_COMMITTED
            Thread.sleep(3000);
            connection.rollback();

            ResultSet res = st.executeQuery("SELECT * FROM JDBC3");
            System.out.print("Реальные:\t\t");
            while (res.next())
                System.out.print(res.getString(2) + "\t\t");
            System.out.println();
            System.out.println("----------------------------------------");
        }


        // Non-Repeatable Reads - не консистентность данных (между первым и вторым чтением из базы произошло обновление данных)
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement st = connection.createStatement()) {
            System.out.println("Non-Repeatable Reads ");
            connection.setAutoCommit(false);
    //        connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);  // ошибка
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);    // решение - такой уровень изоляции

            ResultSet resultSet = st.executeQuery("SELECT * FROM JDBC3");
            System.out.print("Первое чтение:\t\t");
            while(resultSet.next())
                System.out.print(resultSet.getString(2) + "\t\t");
            System.out.println();

            new OtherTrans().start();
            Thread.sleep(2000);

            ResultSet resultSet2 = st.executeQuery("SELECT * FROM JDBC3");
            System.out.print("Второе чтение:\t\t");
            while(resultSet2.next())
                System.out.print(resultSet2.getString(2)+ "\t\t");
            System.out.println();
            connection.commit();

            ResultSet resultSet3 = st.executeQuery("SELECT * FROM JDBC3");
            System.out.print("Третье чтение:\t\t");
            while(resultSet3.next())
                System.out.print(resultSet3.getString(2)+ "\t\t");
            System.out.println();
            System.out.println("----------------------------------------");
        }



        // Phantoms Reads - не консистентность данных (между первым и вторым чтением из базы произошло добавление данных)
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement st = connection.createStatement()) {
            System.out.println("Phantoms Reads ");
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            ResultSet resultSet = st.executeQuery("SELECT COUNT(*) FROM JDBC3");
            System.out.print("Первое чтение:\t\t");
            while(resultSet.next())
                System.out.print(resultSet.getInt(1));
            System.out.println();

            new OtherTransaction().start();
            Thread.sleep(2000);

            ResultSet resultSet2 = st.executeQuery("SELECT COUNT(*) FROM JDBC3");
            System.out.print("Второе чтение:\t\t");
            while(resultSet2.next())
                System.out.print(resultSet2.getInt(1));
            System.out.println();
            System.out.println("----------------------------------------");
        }

        //--------------------------------------- удаление таблицы из БД ---------------------------------------------------
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement st = connection.createStatement()) {
            st.execute("DROP TABLE IF EXISTS JDBC3");
            System.out.println("Таблица удалена");
        }
    }


    //--------------------------------------------- Dirty Reads --------------------------------------------------------
    static class OtherTransBad extends Thread{
        @Override
        public void run(){
            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement st = connection.createStatement()) {
                connection.setAutoCommit(false);
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

                ResultSet res = st.executeQuery("SELECT * FROM JDBC3");
                System.out.print("Метод Bad:\t\t");
                while (res.next())
                    System.out.print(res.getString(2) + "\t\t");
                System.out.println();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    static class OtherTransGood extends Thread{
        @Override
        public void run(){
            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement st = connection.createStatement()) {
                connection.setAutoCommit(false);
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

                ResultSet res = st.executeQuery("SELECT * FROM JDBC3");
                System.out.print("Метод Good:\t\t");
                while (res.next())
                    System.out.print(res.getString(2) + "\t\t");
                System.out.println();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }


    //-------------------------------------------- Non-Repeatable Reads ------------------------------------------------
    static class OtherTrans extends Thread{
        @Override
        public void run(){
            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement st = connection.createStatement()) {
                connection.setAutoCommit(false);
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                    st.executeUpdate("UPDATE JDBC3 SET NAME = 'NEWInfr' WHERE ID=1");
                connection.commit();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }


    //----------------------------------------------- Phantoms Reads ---------------------------------------------------
    static class OtherTransaction extends Thread{
        @Override
        public void run(){
            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement st = connection.createStatement()) {
                connection.setAutoCommit(false);
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                st.executeUpdate("INSERT INTO JDBC3 (NAME) VALUES ('NEW NEW')");
                connection.commit();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
