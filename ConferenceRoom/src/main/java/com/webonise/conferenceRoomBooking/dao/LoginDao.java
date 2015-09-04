package com.webonise.conferenceRoomBooking.dao;

import com.webonise.conferenceRoomBooking.exception.DaoException;
import com.webonise.conferenceRoomBooking.model.Employee;

public interface LoginDao {
	Employee findByEmployeeId(String employeeId) throws DaoException;
}
