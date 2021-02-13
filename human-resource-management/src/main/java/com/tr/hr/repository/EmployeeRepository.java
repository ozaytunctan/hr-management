package com.tr.hr.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tr.hr.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Optional<Employee> findEmployeeById(Long id);

	Page<Employee> findByFirstName(String firstName, Pageable pageable);

	Page<Employee> findByFirstNameContainingIgnoreCase(String firstName, Pageable pageable);

}
