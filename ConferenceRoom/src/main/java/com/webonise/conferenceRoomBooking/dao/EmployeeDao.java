package com.webonise.conferenceRoomBooking.dao;

import java.util.List;

import com.webonise.conferenceRoomBooking.exception.DaoException;
import com.webonise.conferenceRoomBooking.model.Employee;

public interface EmployeeDao {
	public void signUp(Employee employee) throws DaoException;

	public List<Employee> getAllEmployeeDetails() throws DaoException;

	public Employee findEmployee(String employeeid) throws DaoException;
}
