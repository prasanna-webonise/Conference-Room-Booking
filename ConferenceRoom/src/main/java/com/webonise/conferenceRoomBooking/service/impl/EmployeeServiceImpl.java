package com.webonise.conferenceRoomBooking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webonise.conferenceRoomBooking.dao.EmployeeDao;
import com.webonise.conferenceRoomBooking.exception.DaoException;
import com.webonise.conferenceRoomBooking.model.Employee;
import com.webonise.conferenceRoomBooking.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void signUp(Employee employee) throws DaoException {
		employeeDao.signUp(employee);
	}

	@Override
	public List<Employee> getAllEmployeeDetails() throws DaoException {
		return employeeDao.getAllEmployeeDetails();
	}

	@Override
	public Employee findEmployee(String employeeid) throws DaoException {
		return employeeDao.findEmployee(employeeid);
	}

	public void setDao(EmployeeDao employeeDaoMock) {
		this.employeeDao = employeeDaoMock;
	}

}
