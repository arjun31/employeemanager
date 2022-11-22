package com.assessment.EmployeeManager;


import com.assessment.EmployeeManager.Model.Employee;
import com.assessment.EmployeeManager.Repository.EmployeeRepository;
import com.assessment.EmployeeManager.Service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class EmployeeManagerApplicationTests {

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	public void testCreate(){
		Employee e = new Employee(15,"Vishal",50000,"Security",LocalDate.parse("2021-05-02"));
		when(employeeRepository.save(e)).thenReturn(e);
		assertEquals(e,employeeService.createEmployee(e));
	}

	@Test
	public void testGetAll(){
		when(employeeRepository.findAll()).thenReturn(Stream.of(new Employee(13,"Pavan",45000,"ANZ-ARC", LocalDate.parse("2021-08-15")),new Employee(14,"Mansi",50000,"ANZ-ARC", LocalDate.parse("2021-06-12"))).collect(Collectors.toList()));
		assertEquals(2,employeeService.getAllEmployee().size());
	}

	@Test
	public void testUpdate(){
		Integer id = 13;
		Employee e = new Employee(16,"Arya",35000,"Development",LocalDate.parse("2020-07-23"));
		when(employeeRepository.save(e)).thenReturn(e);
		assertEquals(e,employeeService.updateEmployee(id,e));
	}
	@Test
	public void testDelete(){
		Integer id = 14;
		employeeService.deleteEmployee(14);
		verify(employeeRepository,times(1)).deleteById(14);
	}
}
