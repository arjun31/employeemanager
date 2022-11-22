package com.assessment.EmployeeManager.Service;

import com.assessment.EmployeeManager.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeServiceImpl{
    List<Employee> getAllEmployee();

    Employee getEmployee(Integer id);

    Employee createEmployee(Employee session);

    void deleteEmployee(Integer id);

    Employee updateEmployee(Integer id, Employee employee);
}
