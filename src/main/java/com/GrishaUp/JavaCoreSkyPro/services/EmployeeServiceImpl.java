package com.GrishaUp.JavaCoreSkyPro.services;

import com.GrishaUp.JavaCoreSkyPro.dtoEmployee.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int MAX_SIZE = 10;
    private List<Employee> employees = new ArrayList<>();

    @Override
    public String createEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() < 10) {
            employees.add(employee);
        }else {
        return "Извини,наш штат полон,приходи позже";
        }

        return "Поздравляю " + employee.getFirstName() + " " + employee.getLastName();
    }

    @Override
    public String deleteEmployee(String firstName, String lastName) {
        return null;
    }

    @Override
    public String searchEmployee(String firstName, String lastName) {
        return null;
    }
}
