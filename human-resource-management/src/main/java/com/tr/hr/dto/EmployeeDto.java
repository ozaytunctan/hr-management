package com.tr.hr.dto;

import java.util.Date;
import java.util.List;

import com.tr.hr.dto.base.BaseDto;

public class EmployeeDto extends BaseDto<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String firstName;

	private String lastName;

	private String fullName;

	private boolean gender;

	private List<PhoneDto> phones;

	private Date birthDate;

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

	public EmployeeDto(Long id, String firstName, String lastName, List<PhoneDto> phones) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
		this.phones = phones;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public List<PhoneDto> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneDto> phones) {
		this.phones = phones;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
