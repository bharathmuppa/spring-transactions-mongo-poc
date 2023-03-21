package com.example.demo.service;

import com.example.demo.model.Employee;

import org.springframework.transaction.annotation.Transactional;

public interface EmployeeServiceInterface {

	EmployeeServiceInterface getSelf();

	Employee createEmployee(Employee employee);

	Employee getEmployee(String id);

	Employee updateEmployee(String id, Employee employee);

	Employee saveEmployee(Employee employee);

	@Transactional
	default Employee saveEmployee2(Employee employee) {
		return getSelf().saveEmployee(employee);
	}
}
