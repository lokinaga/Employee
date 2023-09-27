package com.onesoft.employee.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onesoft.employee.entity.Employee;
import com.onesoft.employee.repository.EmployeeRepository;
@Repository
public class EmployeeDao {
	public static Logger log = Logger.getLogger(EmployeeDao.class);
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
		PropertyConfigurator.configure("log.properties");
		 log.info( er.findAll());
		
		return er.findAll();
	}
	public String setAllEmp(List<Employee> e) {
		er.saveAll(e);
		
		return "saved Employee Salary";
	}

}
