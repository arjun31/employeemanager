package com.assessment.EmployeeManager.Controller;

import com.assessment.EmployeeManager.Model.Employee;
import com.assessment.EmployeeManager.Service.EmployeeService;
import com.assessment.EmployeeManager.Service.EmployeeServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    @Autowired(required = true)
    private EmployeeServiceImpl employeeServiceImpl;

    @Autowired(required = true)
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> list(){
        return employeeServiceImpl.getAllEmployee();
    }

    @GetMapping
    @RequestMapping("/get-id-no:{id}")
    public Employee get(@PathVariable Integer id){
        return employeeServiceImpl.getEmployee(id);
    }

    @PostMapping
    @RequestMapping("/create")
    public Employee create(@RequestBody final Employee employee){
        return employeeServiceImpl.createEmployee(employee);
    }

    @RequestMapping(value = "/delete-id-no:{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id){
        employeeServiceImpl.deleteEmployee(id);
    }

    @RequestMapping(value = "/update-id-no:{id}", method = RequestMethod.PUT)
    public Employee update(@PathVariable Integer id,@RequestBody Employee employee){
        Employee existingEmployee = employeeServiceImpl.getEmployee(id);
        BeanUtils.copyProperties(employee,existingEmployee,"employeeid");
        return employeeServiceImpl.updateEmployee(id,existingEmployee);
    }

}
