package com.ali.first_job_app.employee.impl;

import com.ali.first_job_app.employee.EmployeeService;
import com.ali.first_job_app.employee.Employee;
import com.ali.first_job_app.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
        return employeeRepository.findById(id).map(existing -> {
            existing.setFirstName(employee.getFirstName());
            existing.setLastName(employee.getLastName());
            existing.setEmail(employee.getEmail());
            existing.setDateOfBirth(employee.getDateOfBirth());
            existing.setPosition(employee.getPosition());
            existing.setContractNumber(employee.getContractNumber());
            existing.setSalary(employee.getSalary());
            return employeeRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    @Override
    public boolean deleteEmployee(Integer id) {
        try{
            employeeRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}

