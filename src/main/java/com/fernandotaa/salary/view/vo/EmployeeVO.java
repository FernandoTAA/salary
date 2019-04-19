package com.fernandotaa.salary.view.vo;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Value object for employee
 */
public class EmployeeVO {

    private Integer id;
    private String name;
    private BigDecimal grossSalary;
    private BigDecimal totalDeduction;

    public EmployeeVO(Integer id, String name, BigDecimal grossSalary, BigDecimal totalDeduction) {
        this.id = id;
        this.name = name;
        this.grossSalary = grossSalary;
        this.totalDeduction = totalDeduction;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getGrossSalary() {
        return grossSalary;
    }

    public BigDecimal getTotalDeduction() {
        return totalDeduction;
    }

    public BigDecimal getNetSalary() {
        if (Objects.isNull(grossSalary)) {
            return BigDecimal.ZERO;
        }
        if (Objects.isNull(totalDeduction)) {
            return grossSalary;
        }
        return grossSalary.subtract(totalDeduction);
    }
}
