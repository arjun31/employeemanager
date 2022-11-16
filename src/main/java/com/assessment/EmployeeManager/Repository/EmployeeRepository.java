package com.assessment.EmployeeManager.Repository;

import com.assessment.EmployeeManager.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
