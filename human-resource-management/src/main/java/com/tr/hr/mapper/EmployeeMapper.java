package com.tr.hr.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.tr.hr.dto.EmployeeDto;
import com.tr.hr.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

	public EmployeeDto employeeToEmployeeDto(Employee employee);

	public List<EmployeeDto> employeesToEmployeeDtos(List<Employee> employee);
	
	public Employee employeeDtoToEmployee(EmployeeDto employeeDto);
	
	public List<Employee> employeeDtosToEmployees(List<EmployeeDto> employeeDtos);
}
