package com.sujan.controller;

import com.sujan.model.Employee;
import com.sujan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping()
    public String index(){

        return "<h1>Welcome to Rest API</h1>" +
                "<br>"+
                "GET All Records:/employees"+"<br>"+
                "GET Single Record:/employees/{id}"+"<br>"+
                "POST the Record :/employees"+"<br>"+
                "PUT the Record:/employees"+"<br>"+
                "DELETE the Record:/employees/{id}"+"<br>";
    }
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return service.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable("id") int id){
       Employee employee= service.findById(id);
       if(employee==null){
           throw  new RuntimeException("Employee of the id " +id+ "does not match");
       }

       return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){

        employee.setId(0);
        service.save(employee);
        service.findAll();
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        service.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable ("id") int id){
        Employee employee = service.findById(id);

        if(employee==null){
            throw new RuntimeException("Employee of the given id does not found"+id);

        }
        service.deleteById(id);
        service.findAll();

        return ("The Deleted Employee id is "+id);

        }

    }



