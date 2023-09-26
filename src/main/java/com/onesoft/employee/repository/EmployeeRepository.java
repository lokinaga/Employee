package com.onesoft.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onesoft.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
@Query(value="select * from employee_details where age = ?",nativeQuery = true)
	List<Employee> getByAge(int e);

//@Query(value="select e from Employee e where e.age<:a")
//public List<Employee> getByAge(@Param (value="a")int a);
@Query(value="select * from employee_details where name like ?",nativeQuery = true)
public List<Employee> getByName(String name);
@Query (value="select * from employee_details where salary = ?",nativeQuery = true)
public List<Employee> getBySalary(int salary);

	
}
