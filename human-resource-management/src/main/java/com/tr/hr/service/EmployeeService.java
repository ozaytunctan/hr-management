package com.tr.hr.service;

import java.util.List;

import com.tr.hr.common.ServiceResult;
import com.tr.hr.dto.EmployeeDto;
import com.tr.hr.dto.PagedResultDto;

public interface EmployeeService {

	public ServiceResult<EmployeeDto> getEmployeeById(Long id);

	public ServiceResult<Void> deleteEmployeeById(Long id);

	public ServiceResult<EmployeeDto> createEmployee(EmployeeDto employeeDto);

	public ServiceResult<EmployeeDto> updateEmploye(Long id, EmployeeDto employeeDto);

	public ServiceResult<List<EmployeeDto>> getEmployees();

	public ServiceResult<PagedResultDto<EmployeeDto>> getEmployees(Integer pageNumber, Integer pageSize);

	public ServiceResult<PagedResultDto<EmployeeDto>> searchByFirstNameContaining(String firstName,Integer pageNumber, Integer pageSize);
	
	
}
