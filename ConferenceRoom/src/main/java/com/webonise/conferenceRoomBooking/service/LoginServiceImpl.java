package com.webonise.conferenceRoomBooking.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.webonise.conferenceRoomBooking.dao.LoginDao;
import com.webonise.conferenceRoomBooking.exception.DaoException;
import com.webonise.conferenceRoomBooking.model.Employee;
import com.webonise.conferenceRoomBooking.model.EmployeeRole;

@Service("loginService")
public class LoginServiceImpl implements UserDetailsService {

	@Autowired
	private LoginDao loginDao;

	@Override
	public UserDetails loadUserByUsername(String employeeId)
			throws UsernameNotFoundException {
		Employee employee = null;
		try {
			employee = loginDao.findByEmployeeId(employeeId);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		List<GrantedAuthority> authorities = buildUserAuthority(employee
				.getEmployeeRole());
		return buildUserForAuthentication(employee, authorities);
	}

	private User buildUserForAuthentication(Employee employee,
			List<GrantedAuthority> authorities) {
		return new User(employee.getEmployeeId(), employee.getPassword(),
				employee.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(EmployeeRole employee) {
		Set<GrantedAuthority> setAuthorities = new HashSet<GrantedAuthority>();
		setAuthorities.add(new SimpleGrantedAuthority(employee.getRoleName()));
		List<GrantedAuthority> gratendAuthority = new ArrayList<GrantedAuthority>(
				setAuthorities);

		return gratendAuthority;
	}

}
