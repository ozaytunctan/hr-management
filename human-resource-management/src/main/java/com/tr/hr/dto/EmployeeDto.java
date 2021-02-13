package com.tr.hr.dto;

import com.tr.hr.dto.base.BaseDto;

public class EmployeeDto extends BaseDto<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String firstName;

	private String lastName;

	public EmployeeDto(Long id) {
		super(id);
	}

	public EmployeeDto() {
		this(0l);
	}

	public EmployeeDto(Long id, String firstName, String lastName) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
