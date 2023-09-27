package com.onesoft.employee.controller;



import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onesoft.employee.entity.Employee;
import com.onesoft.employee.exception.AgeNotFountException;
import com.onesoft.employee.exception.NameNotFoundException;
import com.onesoft.employee.exception.SalaryNotFoundException;
import com.onesoft.employee.service.EmployeeService;


@RestController

public class EmployeeController {
	public static Logger log = Logger.getLogger(EmployeeController.class);
	@Autowired
	EmployeeService es;
	
	@PostMapping(value="/add")
	public String insertEmployee(@RequestBody Employee e) {
		return es.insertEmployee(e);
	}
	@PostMapping(value="/addList")
	public String insertAllEmployee(@RequestBody List<Employee> d)throws AgeNotFountException{
		return es.insertAllEmployee(d);
	}
	@GetMapping(value="/getid/{id}")
	public Employee getById(@PathVariable int id) {
		return es.getById(id);
	}
    @GetMapping(value="/getByAge/{e}")
	public List<Employee> getByAge(@PathVariable int e)throws AgeNotFountException{
	return es.getByAge(e);
}
   @GetMapping(value="/getByName/{name}")
   public List<Employee> getByName(@PathVariable String name)throws NameNotFoundException{
	   return es.getByName(name);
	   
   }
   @GetMapping(value="/getBySalary/{salary}")
   public List<Employee> getBySalary(@PathVariable int salary)throws SalaryNotFoundException{
	   return es.getBySalary(salary);
   }
   @GetMapping(value="/getAllEmployee")
   public List<Employee> getAllEmployee(){
	   PropertyConfigurator.configure("log.properties");
		 log.info( es.getAllEmployee());
	   return es.getAllEmployee()
;   }
   @PostMapping(value="/setAllEmployee")
   public String setAllEmp(@RequestBody List<Employee> emp) throws SalaryNotFoundException{
	   return es.setAllEmp(emp);
   }
   
   
   
 
   
}
