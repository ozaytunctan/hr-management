package com.tr.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tr.hr.common.ServiceResult;
import com.tr.hr.dto.EmployeeDto;
import com.tr.hr.dto.PagedResultDto;
import com.tr.hr.service.EmployeeService;
import com.tr.hr.service.MessageService;

@RestController
@RequestMapping(path = "/api/v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	@Qualifier("defaultRestTemplate")
	private RestTemplate defRestTemplate;

	

	@GetMapping(path="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ServiceResult<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
		return this.employeeService.getEmployeeById(id);
	}

	@GetMapping(path = "/all")
	public ServiceResult<PagedResultDto<EmployeeDto>> getEmployees(
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
		return this.employeeService.getEmployees(page, pageSize);
	}

	@GetMapping(path = "/search")
	public ServiceResult<PagedResultDto<EmployeeDto>> searchByFirstNameContaining(
			@RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
			@RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
			@RequestParam(name = "firstName") String firstName) {
		return this.employeeService.searchByFirstNameContaining(firstName,pageNumber, pageSize);
	}

	@PostMapping(path = "/add")
	public ServiceResult<EmployeeDto> createEmpployee(@RequestBody() EmployeeDto employeeDto) {
		return this.employeeService.createEmployee(employeeDto);
	}

	@PutMapping(path = "/update/{id}")
	public ServiceResult<EmployeeDto> updateEmployee(@PathVariable("id") Long id, @RequestBody() EmployeeDto employeeDto) {
		return this.employeeService.updateEmploye(id, employeeDto);
	}

	@DeleteMapping(path = "/delete/{id}")
	public ServiceResult<Void> deleteEmployeeById(@PathVariable(name = "id", required = true) Long id) {
		return this.employeeService.deleteEmployeeById(id);
	}

}
