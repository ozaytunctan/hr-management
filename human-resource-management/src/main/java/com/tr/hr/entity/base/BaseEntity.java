package com.tr.hr.entity.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Super class
 * 
 * @author ozaytunctan
 *
 * @param <ID>
 */
@MappedSuperclass
public class BaseEntity<ID extends Number> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "idGenerator", strategy = GenerationType.SEQUENCE)
	private ID id;

	@Column(name = "CREATED_BY")
	private String createdBy="ozaytunctan";

	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.DATE)
	private Date createdDate = new Date();

	@Column(name = "UPDATED_DATE")
	@Temporal(TemporalType.DATE)
	private Date updateDate;
	
	@Column(name = "IS_ACTIVE")
	private boolean isActive=true;

	public BaseEntity(ID id) {
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}