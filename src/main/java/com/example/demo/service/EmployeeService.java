package com.example.demo.service;

import com.example.demo.annotation.CheckEmployeeIsFunny;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService implements EmployeeServiceInterface {

	private final EmployeeRepository employeeRepository;

	@Autowired
	@Lazy
	private EmployeeService self;

	public EmployeeService getSelf() {
		return this.self;
	}

	public Employee createEmployee(Employee employee) {
		return saveEmployee(employee);
	}

	public Employee getEmployee(String id) {
		return this.employeeRepository.findById(id).orElseThrow();
	}

	public Employee updateEmployee(String id, Employee employee) {
		return this.getSelf().saveEmployee(employee);
	}

	@CheckEmployeeIsFunny(true)
	public Employee saveEmployee(Employee employee) {
		var s = this.employeeRepository.save(employee);
		throw new RuntimeException("After save throwing!");
	}
}
