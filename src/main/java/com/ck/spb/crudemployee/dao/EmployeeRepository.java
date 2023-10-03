package com.ck.spb.crudemployee.dao;

import com.ck.spb.crudemployee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
