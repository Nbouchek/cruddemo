package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRespository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRespository) {
        this.employeeRespository = employeeRespository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRespository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> byId = employeeRespository.findById(theId);
        Employee employee = null;

        if (byId.isPresent()) {
            employee = byId.get();
        } else {
            // we didn't find employee with id = theId
            throw new RuntimeException("Didn't find employee with id - " + theId);
        }
        return employee;
    }

    @Override
    public void save(Employee theEmployee) {
        employeeRespository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRespository.deleteById(theId);
    }
}
