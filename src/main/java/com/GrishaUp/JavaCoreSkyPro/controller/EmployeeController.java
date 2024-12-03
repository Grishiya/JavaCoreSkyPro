package com.GrishaUp.JavaCoreSkyPro.controller;

import com.GrishaUp.JavaCoreSkyPro.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/create")
    public String createEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.createEmployee(firstName, lastName);
    }
}

