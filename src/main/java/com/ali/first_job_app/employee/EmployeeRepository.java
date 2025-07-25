package com.ali.first_job_app.employee;

import com.ali.first_job_app.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

