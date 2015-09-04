package com.webonise.crbs.service.impl.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.junit.Test;

import com.webonise.conferenceRoomBooking.dao.RoomDao;
import com.webonise.conferenceRoomBooking.exception.DaoException;
import com.webonise.conferenceRoomBooking.model.Room;
import com.webonise.conferenceRoomBooking.service.impl.RoomServiceImpl;

public class RoomServiceImplTest extends TestCase {

	private RoomServiceImpl roomService;
	private RoomDao roomDaoMock;

	@Override
	public void setUp() {
		roomService = new RoomServiceImpl();
		roomDaoMock = EasyMock.createMock(RoomDao.class);
		roomService.setDao(roomDaoMock);
	}

	@Override
	public void tearDown() {
		roomService = null;
		roomService = null;
	}

	@Test
	public void testgetAllRoomDetails() throws DaoException {
		List<Room> room = new ArrayList<Room>();
		EasyMock.expect(roomDaoMock.getAllRoomDetails()).andReturn(room);
		EasyMock.replay(roomDaoMock);
		assertEquals(room, roomService.getAllRoomDetails());
		EasyMock.verify(roomDaoMock);
	}

	@Test
	public void testgetRoomDetail() throws DaoException {
		Room employee = new Room();
		EasyMock.expect(roomDaoMock.getRoomDetail(1)).andReturn(employee);
		EasyMock.replay(roomDaoMock);
		assertEquals(employee, roomService.getRoomDetail(1));
		EasyMock.verify(roomDaoMock);
	}

}
