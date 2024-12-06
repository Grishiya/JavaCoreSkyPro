package com.GrishaUp.JavaCoreSkyPro.controller;

import com.GrishaUp.JavaCoreSkyPro.dtoEmployee.Employee;
import com.GrishaUp.JavaCoreSkyPro.services.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalaryInDepartment(@RequestParam int department) {
        return departmentService.getEmployeeWithMaxSalaryInDepartment(department);
    }
}
