package com.tr.hr.service;

import java.util.List;

import com.tr.hr.common.ServiceResult;
import com.tr.hr.dto.EmployeeDto;
import com.tr.hr.dto.PagedResultDto;
import com.tr.hr.entity.Employee;

public interface EmployeeService {

	public ServiceResult<EmployeeDto> getEmployeeById(Long id);

	public ServiceResult<Void> deleteEmployeeById(Long id);

	public ServiceResult<Employee> createEmployee(Employee employee);

	public ServiceResult<Employee> updateEmploye(Long id, Employee employee);

	public ServiceResult<List<Employee>> getEmployees();

	public ServiceResult<PagedResultDto<EmployeeDto>> getEmployees(Integer pageNumber, Integer pageSize);

	public ServiceResult<PagedResultDto<EmployeeDto>> searchByFirstNameContaining(String firstName,Integer pageNumber, Integer pageSize);
	
	
}
