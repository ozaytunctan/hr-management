package com.tr.hr.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.tr.hr.entity.base.BaseEntity;
import com.tr.hr.enums.PhoneTitle;

@Entity
@Table(name = "PHONE")
@SequenceGenerator(name = "idGenerator", sequenceName = "SQ_PHONE", initialValue = 1, allocationSize = 100)
public class Phone extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	@Column(name = "TITLE")
	private PhoneTitle title;

	@Transient
	private String countryCode;

	@Transient
	private String areaCode;

	@Transient
	private String number;

	@Column(name = "NUMBER", nullable = false, length = 12, unique = true)
	private String phone;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")
	private Employee employee;

	public Phone(Long id) {
		super(id);
	}

	public Phone() {
		this(0l);
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		if (phone != null)
			phone = phone.trim();

		this.phone = phone;
	}

	public void updatePhone() {
		ceatePhone(countryCode, areaCode, number);
	}

	public void ceatePhone(String countryCode, String areaCode, String number) {
		StringBuilder phoneBuilder = new StringBuilder();
		phoneBuilder.append(countryCode == null ? "" : countryCode);
		phoneBuilder.append(areaCode == null ? "" : areaCode);
		phoneBuilder.append(number == null ? "" : number);
		String currentPhone = phoneBuilder.toString();
		setPhone(currentPhone.isEmpty() ? this.phone : currentPhone);
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public PhoneTitle getTitle() {
		return title;
	}

	public void setTitle(PhoneTitle title) {
		this.title = title;
	}

}
