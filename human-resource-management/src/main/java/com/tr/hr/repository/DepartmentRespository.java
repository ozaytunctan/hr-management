package com.tr.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tr.hr.entity.Department;

@Repository
public interface DepartmentRespository extends JpaRepository<Department, Integer> {

}
