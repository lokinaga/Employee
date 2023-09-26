package com.onesoft.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onesoft.employee.entity.Employee;
import com.onesoft.employee.repository.EmployeeRepository;
@Repository
public class EmployeeDao {
@Autowired
EmployeeRepository er;
	public String insertEmployee(Employee e) {
		er.save(e);
		return "saved successfully";
	}
	public String insertAllEmployee(List<Employee> d) {
	    er.saveAll(d);
	    return "saved Sucessfully";
		
	}
	public Employee getById(int id) {
		
		return er.findById(id).get();
	}
	public List<Employee> getByAge(int e) {
		
		return er.getByAge(e);
	}
	public List<Employee> getByName(String name) {
		
		return er.getByName(name);
	}
	public List<Employee> getBySalary(int salary) {
		
		return er.getBySalary(salary);
	}
	public List<Employee> getAllEmployee() {
		
		return er.findAll();
	}
	public String setAllEmp(List<Employee> e) {
		er.saveAll(e);
		
		return "saved Employee Salary";
	}

}
