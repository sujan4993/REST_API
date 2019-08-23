package com.sujan.service;

import com.sujan.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int id);

    public  void save(Employee employee);

    public  void deleteById(int id);
}
