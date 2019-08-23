package com.sujan.service;

import com.sujan.model.Employee;
import com.sujan.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService  {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> emp = repository.findById(id);

        Employee employee = null;

        if(emp.isPresent()){
            employee=emp.get();
        }
        else {
            throw new RuntimeException("The Record of the following id is not present");
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
