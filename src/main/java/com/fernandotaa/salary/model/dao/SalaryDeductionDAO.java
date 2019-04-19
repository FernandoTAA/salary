package com.fernandotaa.salary.model.dao;

import com.fernandotaa.salary.model.SalaryDeduction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Data access object to maintain entity {@link SalaryDeduction}
 */
public class SalaryDeductionDAO {


    /**
     * Find salary deductions by employee identifications.
     *
     * @param employeeIds - employee identifications
     * @return list of salary deductions
     */
    public List<SalaryDeduction> findSalaryDeductionsByEmployeeIds(List<Integer> employeeIds) {
        if (Objects.isNull(employeeIds) || employeeIds.isEmpty()) {
            return Collections.emptyList();
        }

        List<SalaryDeduction> salaryDeductions = new ArrayList<>();

        String inStatement = employeeIds.stream().map(e -> "?").
                collect(Collectors.joining(","));
        String sql = "SELECT ID_CLIENTE, ID_DESCONTO, VL_DESCONTO FROM DESCONTOS WHERE ID_CLIENTE IN (" + inStatement + ")";
        try (Connection connection = DatabaseUtils.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            for (int i = 0; i < employeeIds.size(); i++) {
                preparedStatement.setInt(i + 1, employeeIds.get(i));
            }
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Short idSalaryDeduction = resultSet.getShort("ID_DESCONTO");
                    Integer idEmployee = resultSet.getInt("ID_CLIENTE");
                    BigDecimal salaryDeduction = resultSet.getBigDecimal("VL_DESCONTO");
                    salaryDeductions.add(new SalaryDeduction(idSalaryDeduction, idEmployee, salaryDeduction));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return salaryDeductions;
    }
}
