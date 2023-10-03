package com.ck.spb.crudemployee.controller;

import com.ck.spb.crudemployee.entity.Employee;
import com.ck.spb.crudemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return this.employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        Employee employee = this.employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee not found: " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        // forcing entityManager.merge to create new employee
        // instead of updating existing
        employee.setId(0);
        return this.employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return this.employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee employee = this.employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee does not exists: " + employeeId);
        }
        this.employeeService.deleteById(employeeId);
        return "Employee: " + employeeId + " deleted";
    }
}
