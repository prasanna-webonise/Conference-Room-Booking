package com.webonise.conferenceRoomBooking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.webonise.conferenceRoomBooking.exception.DaoException;
import com.webonise.conferenceRoomBooking.model.Room;

@Service
public interface RoomService {
	public List<Room> getAllRoomDetails() throws DaoException;

	public Room getRoomDetail(int rid) throws DaoException;

	public boolean deleteRoomfromSystem(int roomId) throws DaoException;

	public boolean addRoom(Room room) throws DaoException;
}
