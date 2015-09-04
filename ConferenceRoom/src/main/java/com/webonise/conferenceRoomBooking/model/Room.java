package com.webonise.conferenceRoomBooking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.webonise.conferenceRoomBooking.redis.cache.Cachable;

@Entity
@Table(name = "room")
public class Room implements Cachable {

	public static final String OBJECT_KEY = "ROOM";

	@Id
	@Column(name = "room_id")
	@GeneratedValue
	private int roomId;

	@Column(name = "floor_number")
	private int floorNo;

	@NotEmpty
	@Column(name = "description")
	private String description;

	@Min(3)
	@Column(name = "capacity")
	private int capacity;

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String getKey() {
		return new Integer(roomId).toString();
	}

	@Override
	public String getObjectKey() {
		return OBJECT_KEY;
	}

}
