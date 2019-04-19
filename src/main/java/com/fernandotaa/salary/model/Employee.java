package com.fernandotaa.salary.model;

import java.math.BigDecimal;

/**
 * Entity class for employee
 */
public class Employee {

    private Integer id;
    private String name;
    private BigDecimal salary;

    public Employee() {
    }

    public Employee(Integer id, String name, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
