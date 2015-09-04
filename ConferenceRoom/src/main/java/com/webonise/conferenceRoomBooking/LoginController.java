package com.webonise.conferenceRoomBooking;

import org.jboss.logging.Logger;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webonise.conferenceRoomBooking.model.Employee;

@Controller
public class LoginController {

	static final Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(value = { "/", "/home" })
	public String getUserDefault() {
		return "home";
	}

	@RequestMapping("/login")
	public ModelAndView getLoginForm(@ModelAttribute Employee employee,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		String message = "";
		if (error != null) {
			message = "Incorrect username or password !";
			logger.info("INCORRECT USERNAME OR PASSWORD");
		} else if (logout != null) {
			message = "Logout successful !";
		}
		return new ModelAndView("login", "message", message);
	}

	@RequestMapping("/admin**")
	public String getAdminProfile() {
		return "admin";
	}

	@RequestMapping("/user**")
	public String getUserProfile() {
		return "user";
	}

	@RequestMapping("/403")
	public ModelAndView getAccessDenied() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String employeeId = "";
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			employeeId = userDetail.getUsername();
		}

		return new ModelAndView("403", "employeeId", employeeId);
	}

}
