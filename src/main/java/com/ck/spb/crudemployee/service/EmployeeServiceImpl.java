package com.ck.spb.crudemployee.service;


import com.ck.spb.crudemployee.dao.EmployeeDAO;
import com.ck.spb.crudemployee.dao.EmployeeRepository;
import com.ck.spb.crudemployee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
//    using JPARepository instead of Repository annotation
//    private EmployeeDAO employeeDAO;
    private EmployeeRepository employeeDAO;

    @Autowired
//    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
    public EmployeeServiceImpl(EmployeeRepository employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = this.employeeDAO.findById(id);
        Employee employee = null;
        if (result.isPresent()) {
            employee = result.get();
        } else {
            throw new RuntimeException("Employee not found: " + id);
        }
        return employee;
    }

//    jpa repository provides this
//    @Transactional
    @Override
    public Employee save(Employee employee) {
        return this.employeeDAO.save(employee);
    }

//    jpa repository provides this
//    @Transactional
    @Override
    public void deleteById(int id) {
        this.employeeDAO.deleteById(id);
    }
}
