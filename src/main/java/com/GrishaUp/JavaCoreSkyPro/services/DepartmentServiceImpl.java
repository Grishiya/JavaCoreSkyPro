package com.GrishaUp.JavaCoreSkyPro.services;

import com.GrishaUp.JavaCoreSkyPro.dtoEmployee.Employee;
import com.GrishaUp.JavaCoreSkyPro.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    @Override
    public Employee getEmployeeWithMinSalaryInDepartment(int department) {
        return employeeService.getAllEmployee().stream().filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Извинитесь"));

    }

    @Override
    public Collection<Employee> getAllEmployeesDepartment(int department) {
        return employeeService.getAllEmployee()
                .stream().filter(employee -> employee.getDepartment()==department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllGroupingByDepartment() {
        return employeeService.getAllEmployee()
                .stream().collect(Collectors.groupingBy(employee -> employee.getDepartment()));
    }

}
