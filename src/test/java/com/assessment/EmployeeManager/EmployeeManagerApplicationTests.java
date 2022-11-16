package com.assessment.EmployeeManager;

import com.assessment.EmployeeManager.Model.Employee;
import com.assessment.EmployeeManager.Repository.EmployeeRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeManagerApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	@Order(1)
	public void testCreate() throws ParseException {
		Employee e = new Employee();
		String p = "yyyy-mm-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(p);
		Date d = simpleDateFormat.parse("2021-06-15");
		e.setEmployeeid(8);
		e.setEmployeename("Asha");
		e.setSalary(40000);
		e.setDepartmentname("ANZ-Institutional");
		e.setDbupdatedate(d);
		employeeRepository.save(e);
		assertNotNull(employeeRepository.findById(8).get());
	}
	@Test
	@Order(2)
	public void testGetAll(){
		List<Employee> list = employeeRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	@Test
	@Order(3)
	public void testGetOne(){
		Employee e = employeeRepository.findById(8).get();
		assertEquals(40000,e.getSalary());
	}
	@Test
	@Order(4)
	public void testUpdate(){
		Employee e = employeeRepository.findById(8).get();
		e.setSalary(55000);
		employeeRepository.save(e);
		assertNotEquals(60000,employeeRepository.findById(8).get().getSalary());
	}
	@Test
	@Order(5)
	public void testDelete(){
		employeeRepository.deleteById(8);
		assertThat(employeeRepository.existsById(8)).isFalse();
	}

}
