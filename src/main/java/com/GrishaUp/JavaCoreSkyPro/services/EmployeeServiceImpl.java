package com.GrishaUp.JavaCoreSkyPro.services;

import com.GrishaUp.JavaCoreSkyPro.dtoEmployee.Employee;
import com.GrishaUp.JavaCoreSkyPro.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int MAX_SIZE = 10;
    private final Set<Employee> employees = new HashSet<>();

    @Override
    public String createEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() < 10) {
            if (employees.contains(employee)) {
                return "Ты уже тут работаешь дурень";
            }
            employees.add(employee);
        } else {
            return "Извини,наш штат полон,приходи позже";
        }

        return "Поздравляю " + employee.getFirstName() + " " + employee.getLastName();
    }

    @Override
    public String deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return firstName + " " + lastName + " уволен";
        }
        throw new EmployeeNotFoundException("У нас нет таких сотрудников");
    }

    @Override
    public String searchEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (
                employees.contains(employee)) {
            return "Cотрудник " + firstName + lastName + " найден";
        }
        throw new EmployeeNotFoundException("У нас нет таких сотрудников");
    }
}
