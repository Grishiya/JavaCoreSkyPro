package com.GrishaUp.JavaCoreSkyPro.services;

import com.GrishaUp.JavaCoreSkyPro.dtoEmployee.Employee;

public interface DepartmentService {
    Employee getEmployeeWithMaxSalaryInDepartment(int department);
}
