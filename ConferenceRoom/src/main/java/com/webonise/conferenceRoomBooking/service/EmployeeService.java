package com.webonise.conferenceRoomBooking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.webonise.conferenceRoomBooking.exception.DaoException;
import com.webonise.conferenceRoomBooking.model.Employee;

@Service
public interface EmployeeService {
	public void signUp(Employee employee) throws DaoException;

	public List<Employee> getAllEmployeeDetails() throws DaoException;

	public Employee findEmployee(String employeeid) throws DaoException;
}
