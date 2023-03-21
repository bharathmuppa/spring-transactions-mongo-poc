package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeServiceInterface;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeServiceInterface employeeService;

	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return this.employeeService.createEmployee(employee);
	}

	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable String id) {
		return this.employeeService.getEmployee(id);
	}

	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
		return this.employeeService.saveEmployee2(employee);
	}
}
