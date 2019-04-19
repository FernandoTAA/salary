package com.fernandotaa.salary.view;

import com.fernandotaa.salary.controller.EmployeeController;
import com.fernandotaa.salary.view.component.table.TableModel;
import com.fernandotaa.salary.view.vo.EmployeeVO;

import javax.swing.*;
import java.awt.*;

/**
 * Main frame to show a table with employee's data
 */
public class EmployeeListFrame extends JFrame {

    private EmployeeController employeeController = new EmployeeController();
    private TableModel<EmployeeVO> model = createTableModel();

    /**
     * Constructor to initialize all components
     */
    public EmployeeListFrame() {
        super("Funcionários");
        initFrame();
        initTable();
        loadTable();
        showFrame();
    }

    /**
     * Initialize frame
     */
    private void initFrame() {
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    /**
     * Initialize table model to render component table data
     */
    private TableModel<EmployeeVO> createTableModel() {
        TableModel<EmployeeVO> model = new TableModel<>();
        model.addColmun("Código", EmployeeVO::getId);
        model.addColmun("Nome", EmployeeVO::getName);
        model.addColmun("Salário Bruto", EmployeeVO::getGrossSalary);
        model.addColmun("Salário descontos", EmployeeVO::getTotalDeduction);
        model.addColmun("Salário Líquido", EmployeeVO::getNetSalary);
        return model;
    }

    /**
     * Initialize component table
     */
    private void initTable() {
        JTable table = new JTable();
        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(table);
        add(scroll, BorderLayout.CENTER);
        table.setModel(model);
    }

    /**
     * Load table content async
     */
    private void loadTable() {
        new Thread(() -> model.setRows(employeeController.findEmployees())).start();
    }

    /**
     * Show the frame
     */
    public void showFrame() {
        setVisible(true);
    }

}
