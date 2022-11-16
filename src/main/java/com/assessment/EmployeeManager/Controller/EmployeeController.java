package com.assessment.EmployeeManager.Controller;

import com.assessment.EmployeeManager.Model.Employee;
import com.assessment.EmployeeManager.Repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> list(){
        return employeeRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Employee get(@PathVariable Integer id){
        return employeeRepository.getReferenceById(id);
    }

    @PostMapping
    public Employee create(@RequestBody final Employee employee){
        return employeeRepository.saveAndFlush(employee);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id){
        employeeRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Employee update(@PathVariable Integer id,@RequestBody Employee employee){
        Employee existingEmployee = employeeRepository.getReferenceById(id);
        BeanUtils.copyProperties(employee,existingEmployee,"employeeId");
        return employeeRepository.saveAndFlush(existingEmployee);
    }

}
