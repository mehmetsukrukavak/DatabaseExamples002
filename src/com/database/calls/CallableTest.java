package com.database.calls;

import com.database.library.database.DatabaseUtilities;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class CallableTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = DatabaseUtilities.getConnection();

        long employeeId = 11;
        int percentage = 50;

        String sql = "CALL  public.\"EmployeeSalaryIncrease\" (?, ?)";

        CallableStatement statement = connection.prepareCall(sql);
        statement.setLong(1, employeeId);
        statement.setInt(2, percentage);
        statement.execute();
        connection.close();
    }
}
