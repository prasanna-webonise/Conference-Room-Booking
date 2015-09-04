package com.webonise.conferenceRoomBooking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webonise.conferenceRoomBooking.dao.ScheduledEventDao;
import com.webonise.conferenceRoomBooking.exception.DaoException;
import com.webonise.conferenceRoomBooking.model.ScheduledEvent;
import com.webonise.conferenceRoomBooking.service.ScheduledEventService;

@Service
public class ScheduledEventServiceImpl implements ScheduledEventService {

	@Autowired
	ScheduledEventDao scheduledEventDao;

	@Override
	public void insertScheduledRoomDetail(ScheduledEvent scheduleDetail)
			throws DaoException {
		System.out.println(scheduleDetail.getScheduleDate());
		scheduledEventDao.insertScheduledRoomDetail(scheduleDetail);
	}

	@Override
	public List<ScheduledEvent> viewUserBooking(String employeeId)
			throws DaoException {
		List<ScheduledEvent> scheduledrooms = scheduledEventDao
				.viewUserBooking(employeeId);
		return scheduledrooms;
	}

	@Override
	public void deleteEventfromSystem(int eventId) throws DaoException {
		scheduledEventDao.deleteEventfromSystem(eventId);
	}

	public void setDao(ScheduledEventDao scheduledEventDaoMock) {
		this.scheduledEventDao=scheduledEventDaoMock;
	}

}
