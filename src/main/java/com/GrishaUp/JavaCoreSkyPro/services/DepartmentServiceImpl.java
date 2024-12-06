package com.GrishaUp.JavaCoreSkyPro.services;

import com.GrishaUp.JavaCoreSkyPro.dtoEmployee.Employee;
import com.GrishaUp.JavaCoreSkyPro.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithMaxSalaryInDepartment(int department) {
        return employeeService.getAllEmployee().stream().filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Извинитесь"));

    }
}
