package com.ck.spb.crudemployee.service;

import com.ck.spb.crudemployee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
