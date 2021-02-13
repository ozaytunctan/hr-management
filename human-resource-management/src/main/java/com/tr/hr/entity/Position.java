package com.tr.hr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.tr.hr.entity.base.BaseEntity;
import com.tr.hr.enums.PositionLevel;

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
	
	@Column(name = "LEVEL")
	@Enumerated(EnumType.ORDINAL)
	private PositionLevel level=PositionLevel.DEFAULT;
	
	
	

	public Position() {
		this(0);
	}
	
	public Position(Integer id) {
		super(id);
	}

	public Position(Integer id,String code, String name,PositionLevel level) {
		super(id);
		this.level=level;
		this.code=code;
		this.name=name;
	}
	
	public Position(String code, String name,PositionLevel level) {
		this(0,code,name,level);
	}

	public Position(String code, String name) {
		this(code,name,PositionLevel.DEFAULT);
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

	public PositionLevel getLevel() {
		return level;
	}

	public void setLevel(PositionLevel level) {
		this.level = level;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null || obj.getClass().equals(this.getClass()))
			return false;

		Position position = (Position) obj;

		return position.getId().equals(this.getId()) && position.name.equals(this.name);

	}
	
	

}
