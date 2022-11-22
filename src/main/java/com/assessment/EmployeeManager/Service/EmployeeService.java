package com.assessment.EmployeeManager.Service;

import com.assessment.EmployeeManager.Model.Employee;
import com.assessment.EmployeeManager.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceImpl{

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService(){

    }

    @Override
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Integer id){
        return employeeRepository.getReferenceById(id);
    }

    @Override
    public Employee createEmployee(Employee session){
        return employeeRepository.save(session);
    }

    @Override
    public void deleteEmployee(Integer id){
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee){
        if (employeeRepository.existsById(id)){
            employeeRepository.save(employee);
        }
        return employee;
    }

}
