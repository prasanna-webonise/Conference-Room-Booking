package com.webonise.conferenceRoomBooking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.webonise.conferenceRoomBooking.redis.cache.Cachable;

@Entity
@Table(name="employee")
public class Employee implements Cachable {
	
	public static final String OBJECT_KEY = "EMPLOYEE";
	@Id
	@NotEmpty
	@Column(name="employee_id")
	private String employeeId ;
	
	@NotEmpty
	@Column(name="employee_name")
	private String employeeName;
	
	@NotEmpty
	@Column(name="password")
	private String password;
	
	@NotEmpty
	@Column(name="city")
	private String city;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "employee")
	private EmployeeRole employeeRole  = new EmployeeRole();

	public EmployeeRole getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(EmployeeRole employeeRole) {
		this.employeeRole = employeeRole;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String getKey() {
		return employeeId;
	}

	@Override
	public String getObjectKey() {
		return OBJECT_KEY;
	}
}
