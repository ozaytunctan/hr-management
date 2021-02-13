package com.tr.hr.dto;

import com.tr.hr.dto.base.BaseDto;
import com.tr.hr.enums.PhoneTitle;

public class PhoneDto extends BaseDto<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private PhoneTitle title;
	
	private String countryCode;

	private String areaCode;

	private String number;

	private String phone;
	
	public PhoneDto(Long id) {
		super(id);
	}
	
	

	public PhoneDto(Long id, PhoneTitle title, String countryCode, String areaCode, String number, String phone) {
		this(id, title, phone);
		this.countryCode = countryCode;
		this.areaCode = areaCode;
		this.number = number;
	}
	
	public PhoneDto(Long id, PhoneTitle title,  String phone) {
		super(id);
		this.phone = phone;
		this.title=title;
	}



	public PhoneTitle getTitle() {
		return title;
	}

	public void setTitle(PhoneTitle title) {
		this.title = title;
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
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
}
