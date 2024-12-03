package com.GrishaUp.JavaCoreSkyPro.services;

import com.GrishaUp.JavaCoreSkyPro.dtoEmployee.Employee;

public interface EmployeeService {
    String createEmployee(String firstName, String lastName);

    String deleteEmployee(String firstName, String lastName);

    String searchEmployee(String firstName, String lastName);
}
