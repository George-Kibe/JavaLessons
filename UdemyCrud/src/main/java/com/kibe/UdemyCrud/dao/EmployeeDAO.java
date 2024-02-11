package com.kibe.UdemyCrud.dao;

import com.kibe.UdemyCrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
