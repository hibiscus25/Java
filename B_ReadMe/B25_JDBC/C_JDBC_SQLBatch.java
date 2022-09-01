package B_ReadMe.B25_JDBC;

import java.sql.*;

public class C_JDBC_SQLBatch {
        public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        public static final String DB_URL = "jdbc:mysql://database-1.c0nqcnerv9wp.us-east-1.rds.amazonaws.com:3306/database_name";
        public static final String USER = "maven";
        public static final String PASS = "1291328diMA";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement st = connection.createStatement()) {
            connection.setAutoCommit(false);

            // запросы делаются одним Batch, что уменьшает время выполнения запроса
            st.addBatch("DROP TABLE IF EXISTS JDBC3");
            st.addBatch("CREATE TABLE IF NOT EXISTS JDBC3(ID INT NOT NULL AUTO_INCREMENT, NAME VARCHAR(30) NOT NULL, CONSTRAINT JDBC3_PK PRIMARY KEY (ID))");
            st.addBatch("INSERT INTO JDBC3 (NAME) VALUES ('Inferno')");
            st.addBatch("INSERT INTO JDBC3 (NAME) VALUES ('Davinchi')");
            st.addBatch("INSERT INTO JDBC3 (NAME) VALUES ('Solomn key')");
            st.addBatch("INSERT INTO JDBC3 (NAME) VALUES ('Cod')");
            st.addBatch("INSERT INTO JDBC3 (NAME) VALUES ('World')");

            if(st.executeBatch().length == 7) {
                System.out.println("все прошло успешно");
                connection.commit();
            }else {
                System.out.println("возникла ошибка");
                connection.rollback();
            }
        }
    }
}
