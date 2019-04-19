package com.fernandotaa.salary.model.dao;

import com.fernandotaa.salary.model.Employee;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Data access object to maintain entity {@link Employee}
 */
public class EmployeeDAO {

    /**
     * Find all employees for Database
     *
     * @return list of employees
     */
    public List<Employee> findEmployees() {
        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT ID_CLIENTE, NM_CLIENTE, VL_SALARIO_BRUTO FROM FUNCIONARIO";
        try (Connection connection = DatabaseUtils.getConnection(); Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt("ID_CLIENTE");
                    String name = resultSet.getString("NM_CLIENTE");
                    BigDecimal salary = resultSet.getBigDecimal("VL_SALARIO_BRUTO");
                    employees.add(new Employee(id, name, salary));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employees;
    }

}
