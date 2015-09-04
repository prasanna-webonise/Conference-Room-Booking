package com.webonise.conferenceRoomBooking.dao;

import java.util.List;

import com.webonise.conferenceRoomBooking.exception.DaoException;
import com.webonise.conferenceRoomBooking.model.Room;

public interface RoomDao {
	public boolean addRoom(Room room) throws DaoException;

	public List<Room> getAllRoomDetails() throws DaoException;

	public Room getRoomDetail(int rid) throws DaoException;

	public boolean deleteRoomfromSystem(int roomId) throws DaoException;
}
