package com.webonise.conferenceRoomBooking.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webonise.conferenceRoomBooking.dao.EmployeeDao;
import com.webonise.conferenceRoomBooking.exception.DaoException;
import com.webonise.conferenceRoomBooking.model.Employee;
import com.webonise.conferenceRoomBooking.model.EmployeeRole;

@Component
public class EmployeeDaoImpl implements EmployeeDao {
	static final Logger logger = Logger.getLogger(EmployeeDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Session session;

	@Transactional
	@Override
	public void signUp(Employee employee) throws DaoException {
		EmployeeRole employeeRole = new EmployeeRole();
		employeeRole.setRoleName("ROLE_USER");
		employeeRole.setEmployee(employee);
		employee.setEnabled(true);
		session = sessionFactory.openSession();
		session.save(employee);
		session.save(employeeRole);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Employee> getAllEmployeeDetails() throws DaoException {
		List<Employee> employee = new ArrayList<Employee>();
		try {
			session = sessionFactory.openSession();
			employee = session.createQuery("from Employee").list();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return employee;
	}

	@Override
	public Employee findEmployee(String employeeid) throws DaoException {
		Employee employee = new Employee();
		session = sessionFactory.openSession();
		Query query = session
				.createQuery("from Employee where employeeId=:employeeid");
		query.setParameter("employeeid", employeeid);
		@SuppressWarnings("unchecked")
		List<Employee> list = query.list();
		Iterator<Employee> employeeIterator = list.iterator();
		while (employeeIterator.hasNext()) {
			Employee employeedetail = employeeIterator.next();
			employee = employeedetail;
		}
		return employee;
	}

}
