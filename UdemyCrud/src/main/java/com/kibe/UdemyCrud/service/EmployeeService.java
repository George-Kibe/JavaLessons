package com.kibe.UdemyCrud.service;

import com.kibe.UdemyCrud.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();
    Optional<Employee> findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
