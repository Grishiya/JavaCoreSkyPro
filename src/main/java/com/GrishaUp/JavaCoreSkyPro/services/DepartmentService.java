package com.GrishaUp.JavaCoreSkyPro.services;

import com.GrishaUp.JavaCoreSkyPro.dtoEmployee.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getEmployeeWithMaxSalaryInDepartment(int department);

    Employee getEmployeeWithMinSalaryInDepartment(int department);

    Collection<Employee> getAllEmployeesDepartment(int department);

    Map<Integer, List<Employee>> getAllGroupingByDepartment();
}
