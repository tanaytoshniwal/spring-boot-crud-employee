package com.ck.spb.crudemployee.dao;

import com.ck.spb.crudemployee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
