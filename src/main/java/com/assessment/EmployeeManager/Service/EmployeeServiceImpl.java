package com.assessment.EmployeeManager.Service;

import com.assessment.EmployeeManager.Exception.DataNotFound;
import com.assessment.EmployeeManager.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeServiceImpl{

    List<Employee> getAllEmployee();

    Employee getEmployee(Integer id) throws DataNotFound;

    Employee createEmployee(Employee session);

    void deleteEmployee(Integer id) throws DataNotFound;

    Employee updateEmployee(Integer id, Employee employee) throws DataNotFound;
}
