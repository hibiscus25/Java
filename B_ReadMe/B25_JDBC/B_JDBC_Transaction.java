package B_ReadMe.B25_JDBC;

import java.sql.*;

public class B_JDBC_Transaction {
        public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        public static final String DB_URL = "jdbc:mysql://database-1.c0nqcnerv9wp.us-east-1.rds.amazonaws.com:3306/database_name";
        public static final String USER = "maven";
        public static final String PASS = "1291328diMA";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement st = connection.createStatement()) {
            // отключаем autoCommit
            connection.setAutoCommit(false);

            // cоздаем таблицу - эти запросы не подлежат rollback()
            st.execute("DROP TABLE IF EXISTS JDBC3");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS JDBC3(ID INT NOT NULL AUTO_INCREMENT, NAME VARCHAR(30) NOT NULL, CONSTRAINT JDBC3_PK PRIMARY KEY (ID))");


            // наполняем таблицу - эти запросы подледжат rollback
            // rollback - подлежат запросы добавления и обновления
            st.executeUpdate("INSERT INTO JDBC3 (NAME) VALUES ('Inferno')");
                // точка сохранения - rollback() работает после точки сохранения
                Savepoint savepoint = connection.setSavepoint();
            st.executeUpdate("INSERT INTO JDBC3 (NAME) VALUES ('Davinchi')");
            st.executeUpdate("INSERT INTO JDBC3 (NAME) VALUES ('Solomn key')");
            st.executeUpdate("INSERT INTO JDBC3 (NAME) VALUES ('Cod')");
            st.executeUpdate("INSERT INTO JDBC3 (NAME) VALUES ('World')");

        //    connection.rollback();                    // не используем savepoint
            connection.rollback(savepoint);
            connection.commit();
            connection.releaseSavepoint(savepoint);     // можно без этого метода
        }

        //--------------------------------------------------------------------------------------------------------------
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement st = connection.createStatement()) {
            st.execute("DROP TABLE IF EXISTS JDBC3");
            System.out.println("Таблица удалена");
        }
    }
}
