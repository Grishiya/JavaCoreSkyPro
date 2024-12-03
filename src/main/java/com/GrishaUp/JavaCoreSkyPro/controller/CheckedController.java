package com.GrishaUp.JavaCoreSkyPro.controller;

import com.GrishaUp.JavaCoreSkyPro.dtoEmployee.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckedController {
    @GetMapping
    public String getEmployee() {
        Employee employee = new Employee("Вася", "Пупкин");
        return employee.toString();
    }
}
