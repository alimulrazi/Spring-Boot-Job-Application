package com.ali.first_job_app.employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(Integer id);
    void createEmployee(Employee employee);
    Employee updateEmployee(Integer id, Employee employee);
    boolean deleteEmployee(Integer id);
}
