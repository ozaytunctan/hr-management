package com.tr.hr.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tr.hr.common.ServiceResult;
import com.tr.hr.common.enums.ServiceResultType;
import com.tr.hr.dto.EmployeeDto;
import com.tr.hr.dto.PagedResultDto;
import com.tr.hr.dto.PhoneDto;
import com.tr.hr.entity.Employee;
import com.tr.hr.entity.Phone;
import com.tr.hr.exceptions.NotFoundEmployeeException;
import com.tr.hr.repository.EmployeeRepository;
import com.tr.hr.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public ServiceResult<EmployeeDto> getEmployeeById(Long id) {
		EmployeeDto employeeDto = this.employeeRepository.findEmployeeById(id)
				.map(employee -> new EmployeeDto(employee.getId(),
						employee.getFirstName(),
						employee.getLastName(),
						mapDto(employee.getPhones())))
				.orElseThrow(() -> new NotFoundEmployeeException("error.employee.not.found",new Object[] {id}));
		
		return new ServiceResult<EmployeeDto>(employeeDto, ServiceResultType.SUCCESS);
	}
	
	private List<PhoneDto> mapDto(List<Phone>phones){
		return Optional.ofNullable(phones)
		.orElseGet(Collections::emptyList)
		.stream()
        .map(phone->new PhoneDto(phone.getId(),phone.getTitle(),phone.getPhone()))
        .collect(Collectors.toList());
	}

	@Override
	public ServiceResult<Void> deleteEmployeeById(Long id) {
		this.employeeRepository.deleteById(id);
		return new ServiceResult<Void>(ServiceResultType.SUCCESS);
	}

	@Override
	public ServiceResult<Employee> createEmployee(Employee employee) {
		this.employeeRepository.save(employee);
		return new ServiceResult<>(employee, ServiceResultType.SUCCESS);
	}

	@Override
	public ServiceResult<Employee> updateEmploye(Long id, Employee employee) {
		Employee currentEmployee = this.employeeRepository.findEmployeeById(id)
				.orElseThrow(() -> new NotFoundEmployeeException("Employee by id " + id + " not found"));
		currentEmployee.setFirstName(employee.getFirstName());
		currentEmployee = this.employeeRepository.saveAndFlush(currentEmployee);
		return new ServiceResult<Employee>(currentEmployee, ServiceResultType.SUCCESS);
	}

	@Override
	public ServiceResult<List<Employee>> getEmployees() {
		return new ServiceResult<>(this.employeeRepository.findAll(), ServiceResultType.SUCCESS);
	}

	@Override
	public ServiceResult<PagedResultDto<EmployeeDto>> getEmployees(Integer page, Integer pageSize) {
		Page<Employee> employeeList = this.employeeRepository.findAll(PageRequest.of(page, pageSize));

		PagedResultDto<EmployeeDto> result = new PagedResultDto<>(
				employeeList.getContent().stream()
						.map(employee -> new EmployeeDto(employee.getId(), employee.getFirstName(),
								employee.getLastName()))
						.collect(Collectors.toList()),
				employeeList.getTotalElements(), employeeList.getNumber(), employeeList.getSize());

		return new ServiceResult<>(result, ServiceResultType.SUCCESS);
	}

	@Override
	public ServiceResult<PagedResultDto<EmployeeDto>> searchByFirstNameContaining(String firstName, Integer pageNumber,
			Integer pageSize) {
		
		Page<Employee> employess = this.employeeRepository.findByFirstNameContainingIgnoreCase(firstName,
				PageRequest.of(pageNumber, pageSize));

	
		PagedResultDto<EmployeeDto> result = new PagedResultDto<>(
				employess.getContent().stream()
						.map(employee -> new EmployeeDto(employee.getId(), employee.getFirstName(),
								employee.getLastName()))
						.collect(Collectors.toList()),
				employess.getTotalElements(), employess.getNumber(), employess.getSize());

		return new ServiceResult<>(result, ServiceResultType.SUCCESS);
	}

}
