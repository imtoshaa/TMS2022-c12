package com.tms.jdbc.task2.transaction;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;

public class TransactionExample {
    private static final String CREATE_TABLE_QUERY = "CREATE TABLE EMPLOYEE"
            + "("
            + " ID int AUTO_INCREMENT,"
            + " NAME varchar(100) NOT NULL,"
            + " SALARY numeric(15, 2) NOT NULL,"
            + " CREATED_DATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,"
            + " PRIMARY KEY (ID)"
            + ")";
    private static final String INSERT_EMPLOYEE_QUERY = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";
    private static final String UPDATE_EMPLOYEE_QUERY = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root", "1234");
             Statement statement = conn.createStatement();
             PreparedStatement psInsert = conn.prepareStatement(INSERT_EMPLOYEE_QUERY);
             PreparedStatement psUpdate = conn.prepareStatement(UPDATE_EMPLOYEE_QUERY)) {

            statement.execute(CREATE_TABLE_QUERY);

//            conn.setAutoCommit(false);

            // Run list of insert commands
            psInsert.setString(1, "Ivan");
            psInsert.setBigDecimal(2, new BigDecimal(10));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            psInsert.setString(1, "Petr");
            psInsert.setBigDecimal(2, new BigDecimal(20));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            // below line caused error, test transaction
            // org.postgresql.util.PSQLException: No value specified for parameter 1.
            psUpdate.setBigDecimal(2, new BigDecimal(999.99));

            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));
            psUpdate.setString(2, "Ivan");
            psUpdate.execute();

//            conn.commit();
            // good practice to set it back to default true
//            conn.setAutoCommit(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
