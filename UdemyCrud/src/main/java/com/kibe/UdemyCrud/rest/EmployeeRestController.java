package com.kibe.UdemyCrud.rest;

import com.kibe.UdemyCrud.dao.EmployeeDAO;
import com.kibe.UdemyCrud.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeDAO employeeDAO;
    // quick and dirty injection of employee DAO
    public EmployeeRestController(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }
    // expose n"/employees" to return all employees
    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return employeeDAO.findAll();
    }
}
