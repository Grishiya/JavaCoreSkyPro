package com.GrishaUp.JavaCoreSkyPro.services;

import com.GrishaUp.JavaCoreSkyPro.dtoEmployee.Employee;
import com.GrishaUp.JavaCoreSkyPro.exception.EmployeeNotFoundException;
import com.GrishaUp.JavaCoreSkyPro.exception.NoSpaceForEmployeeException;
import com.GrishaUp.JavaCoreSkyPro.exception.RetryEmployeeAdditionException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int MAX_SIZE = 10;
    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public String createEmployee(String firstName, String lastName,int salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.size() == 10) {
            throw new NoSpaceForEmployeeException("\"Извини,наш штат полон,приходи позже\"");
        }
        if (employees.containsKey(employee.getFirstName() + employee.getLastName())) {
            throw new RetryEmployeeAdditionException("Ты уже тут работаешь дурень");
        }
        employees.put(employee.getFirstName() + employee.getLastName(), employee);

        return "Поздравляю " + employee.getFirstName() + " " + employee.getLastName();
    }

    @Override
    public String deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFirstName()+employee.getLastName())) {
            employees.remove(employee.getFirstName()+employee.getLastName());
            return firstName + " " + lastName + " уволен";
        }
        throw new EmployeeNotFoundException("У нас нет таких сотрудников");
    }

    @Override
    public String searchEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (
                employees.containsKey(employee.getFirstName()+employee.getLastName())) {
            return "Cотрудник " + firstName + lastName + " найден";
        }
        throw new EmployeeNotFoundException("У нас нет таких сотрудников");
    }
    @Override
    public Collection<Employee> getAllEmployee(){
        return employees.values();
    }
}
