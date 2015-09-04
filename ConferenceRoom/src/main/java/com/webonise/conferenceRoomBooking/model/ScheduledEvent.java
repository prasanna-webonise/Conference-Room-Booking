package com.webonise.conferenceRoomBooking.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;

import org.hibernate.validator.constraints.NotEmpty;

import com.webonise.conferenceRoomBooking.redis.cache.Cachable;

@Entity
@Table(name = "scheduled_event")
public class ScheduledEvent implements Cachable {

	public static final String OBJECT_KEY = "EVENT";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "event_id")
	private int eventId;

	@Future
	@Column(name = "schedule_date")
	private Date scheduleDate;

	@Column(name = "start_time")
	private String startTime;

	@Column(name = "end_time")
	private String endTime;

	@NotEmpty
	@Column(name = "purpose")
	private String purpose;

	@OneToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@OneToOne
	@JoinColumn(name = "room_id")
	private Room room;

	public ScheduledEvent() {
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public Date getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getComment() {
		return purpose;
	}

	public void setComment(String comment) {
		this.purpose = comment;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Override
	public String getKey() {
		return new Integer(eventId).toString();
	}

	@Override
	public String getObjectKey() {
		return OBJECT_KEY;
	}

}
