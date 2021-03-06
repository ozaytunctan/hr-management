package com.tr.hr.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.tr.hr.entity.base.BaseEntity;

@Entity()
@Table(name = "EMPLOYEE")
@SequenceGenerator(name = "idGenerator", sequenceName = "SQ_EMPLOYEE", initialValue = 1, allocationSize = 100)
public class Employee extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "IDENTITY_NUMBER", length = 11, unique = true)
	private String identityNumber;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Transient
	private String fullName;

	@Column(name = "GENDER")
	private boolean gender;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
	private List<Phone> phones = new ArrayList<>();

	@Column(name = "BIRTH_DATE")
	@Temporal(TemporalType.DATE)
	private Date birthDate;


	public Employee() {
		super(0l);

	}

	public Employee(Long id) {
		super(id);
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

	public void addPhone(Phone phone) {
		phone.setEmployee(this);
		this.phones.add(phone);
	}

	public String getFullName() {
		StringBuilder fullNameBuilder = new StringBuilder();
		fullNameBuilder.append(this.firstName == null ? "" : this.firstName);
		fullNameBuilder.append(" ");
		fullNameBuilder.append(this.lastName == null ? "" : this.lastName);
		return fullNameBuilder.toString();
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null || obj.getClass().equals(this.getClass()))
			return false;

		Employee employee = (Employee) obj;

		return employee.getId().equals(this.getId()) && employee.getFirstName().equals(this.firstName);

	}

	
}