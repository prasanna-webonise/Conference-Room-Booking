package com.webonise.conferenceRoomBooking.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webonise.conferenceRoomBooking.dao.RoomDao;
import com.webonise.conferenceRoomBooking.exception.DaoException;
import com.webonise.conferenceRoomBooking.model.Room;
import com.webonise.conferenceRoomBooking.redis.CacheService;

@Component
public class RoomDaoImpl implements RoomDao {

	static final Logger logger = Logger.getLogger(RoomDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;



	@Autowired
	private CacheService cacheService;

	private Session session;

	@Transactional
	@Override
	public boolean addRoom(Room room) throws DaoException {
		session = sessionFactory.openSession();
		session.save(room);
		cacheService.save(room);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Room> getAllRoomDetails() throws DaoException {
		List<Room> rooms = new ArrayList<Room>();
		try {
			session = sessionFactory.openSession();
			rooms = session.createQuery("from Room").list();
		} catch (Exception e) {
			logger.error("Exception caught!! " + e.getCause());
			logger.error("Exception caught!! " + e.getMessage());
		}
		return rooms;
	}

	@Transactional
	@Override
	public Room getRoomDetail(int roomid) throws DaoException {
		Room room = new Room();
		session = sessionFactory.openSession();
		Query query = session.createQuery("from Room where roomId=:roomid");
		query.setParameter("roomid", roomid);
		@SuppressWarnings("unchecked")
		List<Room> list = query.list();
		Iterator<Room> roomIterator = list.iterator();
		while (roomIterator.hasNext()) {
			Room roomdetail = roomIterator.next();
			room = roomdetail;
		}
		return room;
	}

	@Transactional
	@Override
	public boolean deleteRoomfromSystem(int roomId) throws DaoException {
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			session.beginTransaction();
			session.delete(session.get(Room.class, roomId));
			tx.commit();
		} catch (HibernateException e) {
			logger.error("Exception caught!! " + e.getCause());
			logger.error("Exception caught!! " + e.getMessage());
			return false;
		}
		return true;

	}

	

	
}
