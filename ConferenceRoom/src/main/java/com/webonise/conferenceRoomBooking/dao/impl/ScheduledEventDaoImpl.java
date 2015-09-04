package com.webonise.conferenceRoomBooking.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webonise.conferenceRoomBooking.dao.ScheduledEventDao;
import com.webonise.conferenceRoomBooking.exception.DaoException;
import com.webonise.conferenceRoomBooking.model.ScheduledEvent;
import com.webonise.conferenceRoomBooking.redis.CacheService;

@Component
public class ScheduledEventDaoImpl implements ScheduledEventDao {

	static final Logger logger = Logger.getLogger(ScheduledEventDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Session session;

	@Autowired
	private CacheService cacheService;

	@Transactional
	@Override
	public void insertScheduledRoomDetail(ScheduledEvent scheduleDetail)
			throws DaoException {
		System.out.println(scheduleDetail.getEmployee());
		session = sessionFactory.openSession();
		session.save(scheduleDetail);
		cacheService.save(scheduleDetail);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<ScheduledEvent> viewUserBooking(String employeeId) {
		List<ScheduledEvent> employeeBookings = new ArrayList<ScheduledEvent>();
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ScheduledEvent.class);
		criteria.add(Restrictions.eq("employee.employeeId", employeeId));
		employeeBookings = criteria.list();
		return employeeBookings;
	}

	@Override
	public void deleteEventfromSystem(int eventId) throws DaoException {
		
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			session.beginTransaction();
			session.delete(session.get(ScheduledEvent.class, eventId));
			tx.commit();
		} catch (HibernateException e) {
			logger.error("Exception caught!! " + e.getCause());
			logger.error("Exception caught!! " + e.getMessage());
		}
	}

}
