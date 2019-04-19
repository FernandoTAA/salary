package com.fernandotaa.salary.model;

import java.math.BigDecimal;

/**
 * Entity class for salary deduction
 */
public class SalaryDeduction {

    private Short id;
    private Integer employeeId;
    private BigDecimal deduction;

    public SalaryDeduction() {
    }

    public SalaryDeduction(Short id, Integer employeeId, BigDecimal deduction) {
        this.id = id;
        this.employeeId = employeeId;
        this.deduction = deduction;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public BigDecimal getDeduction() {
        return deduction;
    }

    public void setDeduction(BigDecimal deduction) {
        this.deduction = deduction;
    }
}
