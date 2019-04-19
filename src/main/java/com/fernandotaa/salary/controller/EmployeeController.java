package com.fernandotaa.salary.controller;

import com.fernandotaa.salary.controller.util.EmployeeUtils;
import com.fernandotaa.salary.model.Employee;
import com.fernandotaa.salary.model.SalaryDeduction;
import com.fernandotaa.salary.model.dao.EmployeeDAO;
import com.fernandotaa.salary.model.dao.SalaryDeductionDAO;
import com.fernandotaa.salary.view.vo.EmployeeVO;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Controller class for {@link Employee} domain.
 */
public class EmployeeController {

    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private SalaryDeductionDAO salaryDeductionDAO = new SalaryDeductionDAO();

    /**
     * Find all employees.
     *
     * @return list of employees
     */
    public List<EmployeeVO> findEmployees() {
        List<Employee> employees = employeeDAO.findEmployees();
        List<Integer> employeeIds = employees.stream().
                map(Employee::getId).
                collect(Collectors.toList());
        Map<Integer, List<SalaryDeduction>> mapSalaryDeductionsByEmployeeId =
                salaryDeductionDAO.findSalaryDeductionsByEmployeeIds(employeeIds).stream().
                        collect(Collectors.groupingBy(SalaryDeduction::getEmployeeId));
        return employees.stream().
                map(e -> EmployeeUtils.convertOrmToVo(e, mapSalaryDeductionsByEmployeeId.get(e.getId()))).
//                sorted().
                sorted(Comparator.comparing(EmployeeVO::getNetSalary).reversed()).
                collect(Collectors.toList());
    }

}
