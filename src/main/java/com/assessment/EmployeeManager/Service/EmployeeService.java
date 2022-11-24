package com.assessment.EmployeeManager.Service;

import com.assessment.EmployeeManager.Exception.DataNotFound;
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
    public Employee getEmployee(Integer id) throws DataNotFound
    {
        if (employeeRepository.existsById(id))
            return employeeRepository.getReferenceById(id);
        else{
            throw new DataNotFound("Requested ID not found");
        }
    }

    @Override
    public Employee createEmployee(Employee session){
        return employeeRepository.save(session);
    }

    @Override
    public void deleteEmployee(Integer id) throws DataNotFound{
        if (employeeRepository.existsById(id))
            employeeRepository.deleteById(id);
        else {
            throw new DataNotFound("Requested ID not found");
        }
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) throws DataNotFound{
        if (employeeRepository.existsById(id)){
            employeeRepository.save(employee);
        }
        else {
            throw new DataNotFound("Requested ID not found");
        }
        return employee;
    }

}
