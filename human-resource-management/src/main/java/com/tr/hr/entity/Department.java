package com.tr.hr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.tr.hr.entity.base.BaseEntity;

@Entity
@Table(name="DEPARTMENT")
@SequenceGenerator(name = "idGenerator", sequenceName = "SQ_DEPARTMENT", initialValue = 1, allocationSize = 100)
public class Department extends BaseEntity<Integer> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="CODE")
	private String code;
	
	@Column(name = "NAME")
	private String name;

	public Department() {
		this(0);
	}
	
	public Department(Integer id) {
		super(id);
	}
	
	
	public Department(Integer id, String code, String name) {
		super(id);
		this.code = code;
		this.name = name;
	}
	
	public Department(String code, String name) {
		this(0,code,name);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null || obj.getClass().equals(this.getClass()))
			return false;

		Department department = (Department) obj;

		return department.getId().equals(this.getId());

	}



}
