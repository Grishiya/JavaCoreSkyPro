package com.GrishaUp.JavaCoreSkyPro.controller;

import com.GrishaUp.JavaCoreSkyPro.dtoEmployee.Employee;
import com.GrishaUp.JavaCoreSkyPro.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/create")
    public String createEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                 @RequestParam int salary, @RequestParam int department) {
        return employeeService.createEmployee(firstName, lastName, salary, department);
    }

    @GetMapping(value = "/delete")
    public String deleteEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.deleteEmployee(firstName, lastName);
    }

    @GetMapping(value = "/search")
    public String searchEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.searchEmployee(firstName, lastName);
    }

    @GetMapping()
    public Collection<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }
}

