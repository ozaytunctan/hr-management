package com.tr.hr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.tr.hr.entity.base.BaseEntity;

@Entity
@Table(name = "POSITION")
@SequenceGenerator(name = "idGenerator", sequenceName = "SQ_POSITION", initialValue = 1, allocationSize = 100)
public class Position extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "CODE")
	private String code;
	
	@Column(name = "NAME")
	private String name;
	
	
	public Position(Integer id) {
		super(id);
	}

	public Position() {
		this(0);
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
	
	

}
