package com.webonise.crbs.service.impl.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.junit.Test;

import com.webonise.conferenceRoomBooking.dao.EmployeeDao;
import com.webonise.conferenceRoomBooking.exception.DaoException;
import com.webonise.conferenceRoomBooking.model.Employee;
import com.webonise.conferenceRoomBooking.service.impl.EmployeeServiceImpl;

public class EmployeeServiceImplTest extends TestCase {

	private EmployeeServiceImpl employeeService;
	private EmployeeDao employeeDaoMock;

	@Override
	public void setUp() {
		employeeService = new EmployeeServiceImpl();
		employeeDaoMock = EasyMock.createMock(EmployeeDao.class);
		employeeService.setDao(employeeDaoMock);
	}

	@Override
	public void tearDown() {
		employeeService = null;
		employeeDaoMock = null;
	}

	@Test
	public void testgetAllEmployeeDetails() throws DaoException {
		List<Employee> employees = new ArrayList<Employee>();
		EasyMock.expect(employeeDaoMock.getAllEmployeeDetails()).andReturn(
				employees);
		EasyMock.replay(employeeDaoMock);
		assertEquals(employees, employeeService.getAllEmployeeDetails());
		EasyMock.verify(employeeDaoMock);
	}

	@Test
	public void testfindEmployee() throws DaoException {
		Employee employee = new Employee();
		EasyMock.expect(employeeDaoMock.findEmployee("wl307")).andReturn(employee);
		EasyMock.replay(employeeDaoMock);
		assertEquals(employee, employeeService.findEmployee("wl307"));
		EasyMock.verify(employeeDaoMock);
	}
}
