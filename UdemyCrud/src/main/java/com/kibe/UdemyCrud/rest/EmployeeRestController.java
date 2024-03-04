package com.kibe.UdemyCrud.rest;

import com.kibe.UdemyCrud.entity.Employee;
import com.kibe.UdemyCrud.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    // private EmployeeDAO employeeDAO;
    private EmployeeService employeeService;
    // quick and dirty injection of employee DAO
//    public EmployeeRestController(EmployeeDAO theEmployeeDAO){
//        employeeDAO = theEmployeeDAO;
//    }

    public EmployeeRestController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }

    // expose n"/employees" to return all employees
    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Optional<Employee> getEmployee(@PathVariable int employeeId){
        Optional<Employee> theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null){
            throw new RuntimeException("Employee of iD: "+employeeId+" not Found");
        }
        return  theEmployee;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        // in case they add an id, force save it to 0
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Optional<Employee> todeleteEmployee = employeeService.findById(employeeId);
        if (todeleteEmployee == null){
            throw new RuntimeException("Employee of iD: "+employeeId+" not Found or Invalid");
        }
        employeeService.deleteById(employeeId);
        return "Deleted employeed of ID: "+ employeeId;
    }
}
