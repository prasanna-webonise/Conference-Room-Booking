package com.webonise.conferenceRoomBooking.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationHandlerService extends
		SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	protected String determineTargetUrl(HttpServletRequest request,
			HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String role = auth.getAuthorities().toString();

		String targetUrl = "";
		if (role.contains("ROLE_USER")) {
			targetUrl = "/user";
		} else if (role.contains("ROLE_ADMIN")) {
			targetUrl = "/admin";
		}
		return targetUrl;
	}
}
