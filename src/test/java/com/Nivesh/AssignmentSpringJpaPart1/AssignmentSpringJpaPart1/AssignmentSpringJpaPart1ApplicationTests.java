package com.Nivesh.AssignmentSpringJpaPart1.AssignmentSpringJpaPart1;

import com.Nivesh.AssignmentSpringJpaPart1.AssignmentSpringJpaPart1.Employee.Entity.Employee;
import com.Nivesh.AssignmentSpringJpaPart1.AssignmentSpringJpaPart1.Repos.EmployeeRespository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class AssignmentSpringJpaPart1ApplicationTests {

	@Autowired
	EmployeeRespository employeeRespository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate()
	{
		Employee employee = new Employee();
		employee.setName("Jayant");
		employee.setAge(28);
		employee.setLocation("Bhopal");

		employeeRespository.save(employee);
	}

	@Test
	public void testUpdate()
	{
		Employee employee = employeeRespository.findById(3).get();
		employee.setLocation("Indore");

		employeeRespository.save(employee);
	}

	@Test
	public void testRead()
	{
		Employee employee = employeeRespository.findById(3).get();
		assertNotNull(employee);

		assertEquals("Parit", employee.getName());
	}

	@Test
	public void testDelete()
	{
		if(employeeRespository.existsById(4))
			employeeRespository.deleteById(4);
	}

	@Test
	public void testCount()
	{
		System.out.println("total records are "+employeeRespository.count());
	}

	@Test
	public void testFindByName()
	{
		List<Employee> list = employeeRespository.findByName("Parth");
		list.forEach(p -> System.out.println("Employee name parth has id no "+p.getId()));
	}

	@Test
	public void testFindByNameLike()
	{
		List<Employee> list = employeeRespository.findByNameLike("A%");
		list.forEach(p -> System.out.println(p.getName()));
	}

/*	@Test
	public void testFindAgeBetween()
	{
		List<Employee> list = employeeRespository.findByAgeBetween(28, 32);
		list.forEach(p -> System.out.println(p.getName()));
	}

 */

	@Test
	public void testFindAllPagingAndSorting()
	{
		 PageRequest pageRequest = PageRequest.of(0, 2, Sort.Direction.DESC, "name");
		 employeeRespository.findAll(pageRequest).forEach(p -> System.out.println(p.getName()));
	}
}




