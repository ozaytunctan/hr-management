package com.tr.hr.dto.base;

import java.io.Serializable;
import java.util.Date;

public class BaseDto<ID extends Number> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ID id;

	private String createdBy;

	private Date createdDate = new Date();

	private Date updateDate;

	public BaseDto(ID id) {
		setId(id);
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
