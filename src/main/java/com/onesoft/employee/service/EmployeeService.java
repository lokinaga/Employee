package com.onesoft.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onesoft.employee.dao.EmployeeDao;
import com.onesoft.employee.entity.Employee;
import com.onesoft.employee.exception.AgeNotFountException;
import com.onesoft.employee.exception.NameNotFoundException;
import com.onesoft.employee.exception.SalaryNotFoundException;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao ed;

	public String insertEmployee(Employee e) {

		return ed.insertEmployee(e);
	}

	public String insertAllEmployee(List<Employee> d) throws AgeNotFountException {

		List<Employee> s = d.stream().filter(x -> x.getAge() > 18).toList();
		try {
			if (s.isEmpty()) {

				throw new AgeNotFountException("invaild");
			} else {
				return ed.insertAllEmployee(d);

			}
		} catch (AgeNotFountException ae) {
			return "AgeNotAvailable";
		}

	}

	public Employee getById(int id) {

		return ed.getById(id);
	}

	public List<Employee> getByAge(int e) throws AgeNotFountException {

		List<Employee> s = ed.getByAge(e);
		if (s.isEmpty()) {
			throw new AgeNotFountException("there is no age");
		} else {
			return s;
		}
	}

	public List<Employee> getByName(String name) throws NameNotFoundException {

		List<Employee> temp = ed.getByName(name);

		if (temp.isEmpty()) {
			throw new NameNotFoundException("no data in list" + name);
		} else {
			return temp;
		}

	}

	public List<Employee> getBySalary(int salary) throws SalaryNotFoundException {
		List<Employee> d = ed.getBySalary(salary);
		if (d.isEmpty()) {
			throw new SalaryNotFoundException("there is no salary data");
		} else {
			return d;
		}
	}

	public List<Employee> getAllEmployee() {

		return ed.getAllEmployee();
	}

	public String setAllEmp(List<Employee> emp) throws SalaryNotFoundException {
		List<Employee> e = emp.stream().filter(x -> x.getSalary() < 50000).toList();

		if (e.isEmpty()) {
			throw new SalaryNotFoundException("Invalid data");
		} else {
			return ed.setAllEmp(e);
		}
	}

}
