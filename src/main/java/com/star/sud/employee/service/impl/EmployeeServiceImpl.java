package com.star.sud.employee.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.star.sud.constant.Constants;
import com.star.sud.employee.dao.IEmployeeDao;
import com.star.sud.employee.model.TEmployee;
import com.star.sud.employee.service.IEmployeeService;
import com.star.sud.employeer.dto.EmployeeDetails;
import com.star.sud.status.AppServiceStatus;
import com.star.sud.status.AppServiceStatus.STATUS;

public class EmployeeServiceImpl implements IEmployeeService {

	// Static Attributes
	//////////////////////
	private static final Logger log = Logger.getLogger(EmployeeServiceImpl.class);

	// Attributes
	///////////////
	@Autowired
	@Qualifier("employeeDao")
	private IEmployeeDao dao;

	@Override
	public AppServiceStatus addEmployee(EmployeeDetails dto) {
		log.debug("addEmployee");
		AppServiceStatus status = new AppServiceStatus();
		try {

			TEmployee entity = new TEmployee();
			dto.copyBeanProperties(entity);
			entity.setEmpId(String.valueOf(System.nanoTime()));
			entity.setEmpStatus(Constants.ACTIVE_STATUS);
			dao.add(entity);

			status.setStatus(STATUS.SUCCESS);
		} catch (Exception e) {
			log.error("addEmployee", e);
			status.setStatus(STATUS.FAILED);
			status.setMessage(e.getMessage());
		}
		return status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.star.sud.employee.service.IEmployeeService#getAllEmployees()
	 */
	@Override
	public List<EmployeeDetails> getAllEmployees() {
		log.debug("getAllEmployees");
		try {
			List<EmployeeDetails> employeeDetails = new ArrayList<>();

			String query = "from TEmployee o where o.empStatus= :empStatus";

			Map<String, Object> parameters = new HashMap<>();
			parameters.put("empStatus", Constants.ACTIVE_STATUS);

			List<TEmployee> tEmployees = dao.getByQuery(query, parameters);

			tEmployees.stream().forEach(employees -> {
				EmployeeDetails emDetails = new EmployeeDetails();
				employees.copyBeanProperties(emDetails);
				employeeDetails.add(emDetails);
			});

			return employeeDetails;
		} catch (Exception e) {
			log.error("getAllEmployees", e);
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.star.sud.employee.service.IEmployeeService#modifyEmployee(java.lang.
	 * String)
	 */
	@Override
	public EmployeeDetails modifyEmployee(String radio) {
		log.debug("modifyEmployee");
		try {

			if (null == radio)
				throw new Exception("radio param is null or empty");

			EmployeeDetails dto = new EmployeeDetails();

			TEmployee entity = dao.find(radio);
			entity.copyBeanProperties(dto);

			return dto;

		} catch (Exception e) {
			log.error("modifyEmployee", e);
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.star.sud.employee.service.IEmployeeService#updateEmployee(com.star.sud.
	 * employeer.dto.EmployeeDetails)
	 */
	@Override
	public AppServiceStatus updateEmployee(EmployeeDetails dto) {
		log.debug("updateEmployee");
		AppServiceStatus status = new AppServiceStatus();
		try {

			if (null == dto)
				throw new Exception("dto param is null or empty");

			if (null == dto.getEmpId())
				throw new Exception("empId param is null or empty");

			TEmployee storedEntity = dao.find(dto.getEmpId());

			TEmployee updated = new TEmployee();
			dto.copyBeanProperties(updated);
			BeanUtils.copyProperties(updated, storedEntity);
			updated.setEmpStatus(Constants.ACTIVE_STATUS);
			dao.update(updated);
			status.setStatus(STATUS.SUCCESS);

		} catch (Exception e) {
			log.error("deleteEmployee", e);
			status.setStatus(STATUS.FAILED);
		}
		return status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.star.sud.employee.service.IEmployeeService#deleteEmployee(java.lang.
	 * String)
	 */
	@Override
	public AppServiceStatus deleteEmployee(String radio) {
		log.debug("deleteEmployee");
		AppServiceStatus status = new AppServiceStatus();
		try {

			if (null == radio)
				throw new Exception("radio param is null or empty");

			TEmployee entity = dao.find(radio);
			if (null == entity)
				throw new Exception("entity param is null oe empty");

			dao.remove(entity);
			status.setStatus(STATUS.SUCCESS);

		} catch (Exception e) {
			log.error("deleteEmployee", e);
			status.setStatus(STATUS.FAILED);
		}
		return status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.star.sud.employee.service.IEmployeeService#viewEmployee(java.lang.String)
	 */
	@Override
	public EmployeeDetails viewEmployee(String radio) {
		log.debug("viewEmployee");
		try {

			if (null == radio)
				throw new Exception("radio param is null or empty");

			TEmployee entity = dao.find(radio);
			EmployeeDetails dto = new EmployeeDetails();
			entity.copyBeanProperties(dto);
			return dto;

		} catch (Exception e) {
			log.error("viewEmployee", e);
			return null;
		}
	}

}
