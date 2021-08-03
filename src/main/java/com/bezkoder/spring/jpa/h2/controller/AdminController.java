package com.bezkoder.spring.jpa.h2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.jpa.h2.model.Allocation;
import com.bezkoder.spring.jpa.h2.model.Employee;
import com.bezkoder.spring.jpa.h2.repository.AllocationRepository;
import com.bezkoder.spring.jpa.h2.repository.EmployeeRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    EmployeeRepository employeeRepository;
    
    @Autowired
    AllocationRepository allocationRepo;

    
    @GetMapping("/allocations")
    public ResponseEntity<List<Allocation>> getAllAllocations(
	    @RequestParam(required = false) Integer employeeId) {
	List<Allocation> allocations;
	try {
	    if (employeeId == null) {
		allocations = allocationRepo.findAll();
	    } else {
		Employee emp = new Employee();
		emp.setId(employeeId);
		allocations = allocationRepo.findByEmployeeContaining(emp);
	    }

	    if (allocations.isEmpty()) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    return new ResponseEntity<>(allocations, HttpStatus.OK);
	} catch (Exception e) {
	    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }
    
    
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(
	    @RequestParam(required = false) String name) {
	List<Employee> employees;
	try {
	    if (name == null)
		employees = employeeRepository.findAll();
	    else
		employees = employeeRepository.findByNameContaining(name);

	    if (employees.isEmpty()) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    return new ResponseEntity<>(employees, HttpStatus.OK);
	} catch (Exception e) {
	    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
	Optional<Employee> empData = employeeRepository.findById(id);

	if (empData.isPresent()) {
	    return new ResponseEntity<>(empData.get(), HttpStatus.OK);
	} else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody @Validated Employee emp) {
	try {
	    Employee e = employeeRepository.save(emp);
	    return new ResponseEntity<>(e, HttpStatus.CREATED);
	} catch (Exception e) {
	    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id,
	    @RequestBody Employee employee) {
	Optional<Employee> empData = employeeRepository.findById(id);

	if (empData.isPresent()) {
	    return new ResponseEntity<>(employeeRepository.save(empData.get()), HttpStatus.OK);
	} else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(
	    @PathVariable("id") int id) {
	try {
	    employeeRepository.deleteById(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }

    @GetMapping("/employees/billable")
    public ResponseEntity<List<Employee>> findAllBillable() {
	try {
	    List<Employee> employees = employeeRepository.findByBillable(true);

	    if (employees.isEmpty()) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(employees, HttpStatus.OK);
	} catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }
}
