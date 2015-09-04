package com.webonise.crbs.service.impl.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.junit.Test;

import com.webonise.conferenceRoomBooking.dao.ScheduledEventDao;
import com.webonise.conferenceRoomBooking.exception.DaoException;
import com.webonise.conferenceRoomBooking.model.ScheduledEvent;
import com.webonise.conferenceRoomBooking.service.impl.ScheduledEventServiceImpl;

public class ScheduledEventServiceImplTest extends TestCase {

	private ScheduledEventServiceImpl eventService;
	private ScheduledEventDao scheduledEventDaoMock;
	private ScheduledEvent scheduleDetail;

	@Override
	public void setUp() {
		eventService = new ScheduledEventServiceImpl();
		scheduledEventDaoMock = EasyMock.createMock(ScheduledEventDao.class);
		eventService.setDao(scheduledEventDaoMock);
		scheduleDetail = new ScheduledEvent();
	}

	@Override
	public void tearDown() {
		eventService = null;
		scheduledEventDaoMock = null;
	}

	@Test
	public void testInsertScheduledRoomDetail() throws DaoException {
		scheduledEventDaoMock.insertScheduledRoomDetail(scheduleDetail);
		EasyMock.expectLastCall().once();
		EasyMock.replay(scheduledEventDaoMock);
		EasyMock.verify();
	}

	@Test
	public void testDeleteEventfromSystem() throws DaoException {
		scheduledEventDaoMock.deleteEventfromSystem(1);
		EasyMock.expectLastCall().once();
		EasyMock.replay(scheduledEventDaoMock);
		EasyMock.verify();
	}

	@Test
	public void testViewUserBooking() throws DaoException {
		List<ScheduledEvent> events = new ArrayList<ScheduledEvent>();
		EasyMock.expect(scheduledEventDaoMock.viewUserBooking("wl307"))
				.andReturn(events);
		EasyMock.replay(scheduledEventDaoMock);
		assertEquals(events, eventService.viewUserBooking("wl307"));
		EasyMock.verify(scheduledEventDaoMock);
	}
}
