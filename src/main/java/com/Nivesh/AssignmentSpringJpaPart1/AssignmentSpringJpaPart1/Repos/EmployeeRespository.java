package com.Nivesh.AssignmentSpringJpaPart1.AssignmentSpringJpaPart1.Repos;

import com.Nivesh.AssignmentSpringJpaPart1.AssignmentSpringJpaPart1.Employee.Entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.List;

public interface EmployeeRespository extends PagingAndSortingRepository<Employee, Integer> {

    List<Employee> findByName(String name);
    List<Employee> findByNameLike(String name);

    //List<Employee> findByAgeBetween(int Age1, int Age2);

}
