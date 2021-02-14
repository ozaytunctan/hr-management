package com.tr.hr.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tr.hr.common.ServiceResult;
import com.tr.hr.common.enums.ServiceResultType;
import com.tr.hr.dto.EmployeeDto;
import com.tr.hr.dto.PagedResultDto;
import com.tr.hr.entity.Employee;
import com.tr.hr.exceptions.NotFoundEmployeeException;
import com.tr.hr.mapper.EmployeeMapper;
import com.tr.hr.repository.EmployeeRepository;
import com.tr.hr.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired()
	private EmployeeMapper employeeMapper;

	@Override
	public ServiceResult<EmployeeDto> getEmployeeById(Long id) {

		Employee employee = this.employeeRepository.findEmployeeById(id)
				.orElseThrow(() -> new NotFoundEmployeeException("error.employee.not.found", new Object[] { id }));

		EmployeeDto employeeDto = employeeMapper.employeeToEmployeeDto(employee);

		return new ServiceResult<EmployeeDto>(employeeDto, ServiceResultType.SUCCESS);
	}

	@Override
	public ServiceResult<Void> deleteEmployeeById(Long id) {
		this.employeeRepository.deleteById(id);
		return new ServiceResult<Void>(ServiceResultType.SUCCESS);
	}

	@Override
	public ServiceResult<EmployeeDto> createEmployee(EmployeeDto employeeDto) {
		Employee employee = employeeMapper.employeeDtoToEmployee(employeeDto);

		employee = this.employeeRepository.save(employee);
		employeeDto.setId(employee.getId());

		return new ServiceResult<>(employeeDto, ServiceResultType.SUCCESS);
	}

	@Override
	public ServiceResult<EmployeeDto> updateEmploye(Long id, EmployeeDto employeeDto) {

		Employee currentEmployee = this.employeeRepository.findEmployeeById(id)
				.orElseThrow(() -> new NotFoundEmployeeException("Employee by id " + id + " not found"));

		currentEmployee.setFirstName(employeeDto.getFirstName());
		currentEmployee.setLastName(employeeDto.getFirstName());
		currentEmployee = this.employeeRepository.saveAndFlush(currentEmployee);

		employeeDto = employeeMapper.employeeToEmployeeDto(currentEmployee);

		return new ServiceResult<EmployeeDto>(employeeDto, ServiceResultType.SUCCESS);
	}

	@Override
	public ServiceResult<List<EmployeeDto>> getEmployees() {
		List<EmployeeDto> employeeDtos = employeeMapper.employeesToEmployeeDtos(this.employeeRepository.findAll());
		return new ServiceResult<>(employeeDtos, ServiceResultType.SUCCESS);
	}

	@Override
	public ServiceResult<PagedResultDto<EmployeeDto>> getEmployees(Integer page, Integer pageSize) {
		Page<Employee> employeeList = this.employeeRepository.findAll(PageRequest.of(page, pageSize));

		List<EmployeeDto> employeeDtos = employeeMapper.employeesToEmployeeDtos(employeeList.getContent());

		PagedResultDto<EmployeeDto> result = new PagedResultDto<>(employeeDtos, employeeList.getTotalElements(),
				employeeList.getNumber(), employeeList.getSize());

		return new ServiceResult<>(result, ServiceResultType.SUCCESS);
	}

	@Override
	public ServiceResult<PagedResultDto<EmployeeDto>> searchByFirstNameContaining(String firstName, Integer pageNumber,
			Integer pageSize) {

		Page<Employee> employeeList = this.employeeRepository.findByFirstNameContainingIgnoreCase(firstName,
				PageRequest.of(pageNumber, pageSize));

		List<EmployeeDto> employeeDtos = employeeMapper.employeesToEmployeeDtos(employeeList.getContent());

		PagedResultDto<EmployeeDto> result = new PagedResultDto<>(employeeDtos, employeeList.getTotalElements(),
				employeeList.getNumber(), employeeList.getSize());

		return new ServiceResult<>(result, ServiceResultType.SUCCESS);
	}

}
