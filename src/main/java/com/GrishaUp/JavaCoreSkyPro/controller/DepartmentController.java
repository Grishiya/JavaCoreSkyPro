package com.GrishaUp.JavaCoreSkyPro.controller;

import com.GrishaUp.JavaCoreSkyPro.dtoEmployee.Employee;
import com.GrishaUp.JavaCoreSkyPro.services.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalaryInDepartment(@RequestParam int department) {
        return departmentService.getEmployeeWithMinSalaryInDepartment(department);
    }

    @GetMapping(path = "/all",params = {"department"})
    public Collection<Employee> getAllEmployeesDepartment(@RequestParam int department) {
        return departmentService.getAllEmployeesDepartment(department);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllGroupingByDepartment() {
        return departmentService.getAllGroupingByDepartment();
    }
}
