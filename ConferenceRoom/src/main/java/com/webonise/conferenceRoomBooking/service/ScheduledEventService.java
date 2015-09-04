package com.webonise.conferenceRoomBooking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.webonise.conferenceRoomBooking.exception.DaoException;
import com.webonise.conferenceRoomBooking.model.ScheduledEvent;

@Service
public interface ScheduledEventService {

	void insertScheduledRoomDetail(ScheduledEvent scheduleDetail)
			throws DaoException;

	List<ScheduledEvent> viewUserBooking(String employeeId) throws DaoException;

	void deleteEventfromSystem(int eventId) throws DaoException;

}
