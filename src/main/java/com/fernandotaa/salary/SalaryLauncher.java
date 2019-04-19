package com.fernandotaa.salary;

import com.fernandotaa.salary.view.EmployeeListFrame;

import javax.swing.*;

/**
 * Main class used to launch the application Salary
 */
public class SalaryLauncher {

    public static void main(String[] args) {
        EmployeeListFrame employeeListFrame = new EmployeeListFrame();
        employeeListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
