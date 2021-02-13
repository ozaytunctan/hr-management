package com.tr.hr.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.tr.hr.entity.base.BaseEntity;

@Entity
@Table(name = "EMPLOYEE_DEPARTMENT_HISTORY")
@SequenceGenerator(name = "idGenerator", sequenceName = "SQ_EMPLOYEE_DEPARTMENT_HISTORY", initialValue = 1, allocationSize = 100)
public class EmployeeDepartmentHistory extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "START_DATE")
	@Temporal(TemporalType.DATE)
	private Date startDate = new Date();

	@Column(name = "END_DATE")
	@Temporal(TemporalType.DATE)
	private Date endDate;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")
	private Employee employee;

	/**
	 * Not: Cascade Type önemli!! 
	 * 
	 * Cascade type Refresh çünkü Position ataması yapılacak. Veritabanındaki id olmalıdır. yoksa hata fırlatır.
	 * Cascade type Persist ise aynı id var ise veritabanındaki değeri al ekle id yok ise yeniden oluştur.
	 * Cascade type Merge ise aynı id var ise  o nesnenin değerleri ile güncellenir.
	 * Cascade type Remove ise kademlei olarak bağlı nesleri de siler
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "POSITION_ID", referencedColumnName = "ID")
	private Position position;

	/**
	 * Department
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "ID")
	private Department department;

	public EmployeeDepartmentHistory() {
		super(0l);
	}

	public EmployeeDepartmentHistory(Long id) {
		super(id);
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null || obj.getClass().equals(this.getClass()))
			return false;

		EmployeeDepartmentHistory employeeDepartmentHistory = (EmployeeDepartmentHistory) obj;

		return employeeDepartmentHistory.getId().equals(this.getId());

	}

}
