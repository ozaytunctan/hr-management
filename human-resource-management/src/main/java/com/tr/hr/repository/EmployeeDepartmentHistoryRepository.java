package com.tr.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tr.hr.entity.EmployeeDepartmentHistory;

@Repository
public interface EmployeeDepartmentHistoryRepository  extends JpaRepository<EmployeeDepartmentHistory, Long>{

}
