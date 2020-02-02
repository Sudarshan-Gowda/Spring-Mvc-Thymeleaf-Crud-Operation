package com.star.sud.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.star.sud.abs.entity.AbstractEntity;

@Entity
@Table(name = "T_EMPLOYEE", catalog = "research")
public class TEmployee extends AbstractEntity<TEmployee> {

	// Static Attributes
	/////////////////////
	private static final long serialVersionUID = 7250626004401713513L;

	// Attributes
	//////////////////
	private String empId;
	private String empName;
	private String empDesign;
	private String empDept;
	private String empAddress;
	private char empStatus;

	// Override Method
	///////////////////
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(TEmployee o) {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.star.sud.abs.entity.AbstractEntity#init()
	 */
	@Override
	public void init() {

	}

	// Constructors
	////////////////
	public TEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param empId
	 * @param empName
	 * @param empDesign
	 * @param empDept
	 * @param empAddress
	 * @param empStatus
	 */
	public TEmployee(String empId, String empName, String empDesign, String empDept, String empAddress,
			char empStatus) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDesign = empDesign;
		this.empDept = empDept;
		this.empAddress = empAddress;
		this.empStatus = empStatus;
	}

	// Properties
	/////////////////
	/**
	 * @return the empId
	 */
	@Id
	@Column(name = "EMP_ID", unique = true, nullable = false, length = 35)
	public String getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	/**
	 * @return the empName
	 */
	@Column(name = "EMP_NAME", nullable = false, length = 100)
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the empDesign
	 */
	@Column(name = "EMP_DESIGN", nullable = false, length = 100)
	public String getEmpDesign() {
		return empDesign;
	}

	/**
	 * @param empDesign the empDesign to set
	 */
	public void setEmpDesign(String empDesign) {
		this.empDesign = empDesign;
	}

	/**
	 * @return the empDept
	 */
	@Column(name = "EMP_DEPT", nullable = false, length = 100)
	public String getEmpDept() {
		return empDept;
	}

	/**
	 * @param empDept the empDept to set
	 */
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	/**
	 * @return the empAddress
	 */
	@Column(name = "EMP_ADDRESS", length = 250)
	public String getEmpAddress() {
		return empAddress;
	}

	/**
	 * @param empAddress the empAddress to set
	 */
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	/**
	 * @return the empStatus
	 */
	@Column(name = "EMP_STATUS", nullable = false, length = 1)
	public char getEmpStatus() {
		return empStatus;
	}

	/**
	 * @param empStatus the empStatus to set
	 */
	public void setEmpStatus(char empStatus) {
		this.empStatus = empStatus;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
