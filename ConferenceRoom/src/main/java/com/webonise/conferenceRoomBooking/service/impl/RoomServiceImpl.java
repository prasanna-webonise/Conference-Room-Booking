package com.webonise.conferenceRoomBooking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webonise.conferenceRoomBooking.dao.RoomDao;
import com.webonise.conferenceRoomBooking.exception.DaoException;
import com.webonise.conferenceRoomBooking.model.Room;
import com.webonise.conferenceRoomBooking.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomDao roomDao;

	@Override
	public List<Room> getAllRoomDetails() {
		try {
			return roomDao.getAllRoomDetails();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Room getRoomDetail(int rid) throws DaoException {
		return roomDao.getRoomDetail(rid);
	}

	@Override
	public boolean deleteRoomfromSystem(int roomId) throws DaoException {
		return roomDao.deleteRoomfromSystem(roomId);
	}

	@Override
	public boolean addRoom(Room room) throws DaoException {
		return roomDao.addRoom(room);
	}

	public void setDao(RoomDao roomDaoMock) {
		this.roomDao = roomDaoMock;
	}

}
