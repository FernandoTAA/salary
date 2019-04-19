package com.fernandotaa.salary.controller.util;

import com.fernandotaa.salary.model.Employee;
import com.fernandotaa.salary.model.SalaryDeduction;
import com.fernandotaa.salary.view.vo.EmployeeVO;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

/**
 * Utility class for common actions for employee
 */
final public class EmployeeUtils {

    private EmployeeUtils() {
    }

    /**
     * Convert {@link Employee} object to {@link EmployeeVO} object including salary deduction summarize the list.
     *
     * @param employee - Conversion source to convert
     * @param salaryDeductions - Salary Deductions to summarize
     * @return Conversion target converted
     */
    public static EmployeeVO convertOrmToVo(Employee employee, Collection<SalaryDeduction> salaryDeductions) {
        return new EmployeeVO(employee.getId(), employee.getName(), employee.getSalary(), sumSalaryDeductions(salaryDeductions));
    }

    private static BigDecimal sumSalaryDeductions(Collection<SalaryDeduction> salaryDeductions) {
        if (Objects.isNull(salaryDeductions) || salaryDeductions.isEmpty()) {
            return BigDecimal.ZERO;
        }
        return salaryDeductions.stream().
                map(SalaryDeduction::getDeduction).
                filter(Objects::nonNull).
                reduce((a, c) -> a.add(c)).
                orElse(BigDecimal.ZERO);
    }
}
