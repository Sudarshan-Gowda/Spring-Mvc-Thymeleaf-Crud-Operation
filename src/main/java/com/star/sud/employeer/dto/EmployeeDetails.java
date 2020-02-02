/**
 * 
 */
package com.star.sud.employeer.dto;

import com.star.sud.abs.dto.AbstractDTO;

/**
 * @author Sudarshan
 *
 */
public class EmployeeDetails extends AbstractDTO<EmployeeDetails> {

	// Static Attributes
	/////////////////////
	private static final long serialVersionUID = -7181343756875385421L;

	// Attributes
	/////////////////
	private String empId;

	private String empName;

	private String empDesign;

	private String empDept;

	private String empAddress;

	// Properties
	/////////////////
	/**
	 * @return the empId
	 */

	/**
	 * @return the empName
	 */
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
	 * @return the empId
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}

}
