package com.bezkoder.spring.jpa.h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.jpa.h2.model.Allocation;
import com.bezkoder.spring.jpa.h2.model.Employee;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Integer> {

    List<Allocation> findByEmployeeContaining(Employee emp);

}
