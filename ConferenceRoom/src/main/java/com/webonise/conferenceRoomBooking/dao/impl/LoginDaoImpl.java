package com.webonise.conferenceRoomBooking.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webonise.conferenceRoomBooking.dao.LoginDao;
import com.webonise.conferenceRoomBooking.model.Employee;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {

	static final Logger logger = Logger.getLogger(LoginDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	private Session session = null;
	private Transaction tx = null;

	@Override
	public Employee findByEmployeeId(String employeeId) {
		Employee employee = null;
		try {
			session = sessionFactory.openSession();
			tx = session.getTransaction();
			session.beginTransaction();
			employee = (Employee) session.load(Employee.class, new String(
					employeeId));
			tx.commit();
		} catch (HibernateException e) {

		}
		return employee;
	}

}
