package com.webonise.conferenceRoomBooking;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webonise.conferenceRoomBooking.exception.DaoException;
import com.webonise.conferenceRoomBooking.model.Employee;
import com.webonise.conferenceRoomBooking.service.EmployeeService;

@Controller
public class SignUpController {

	static final Logger logger = Logger.getLogger(SignUpController.class);
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/signup")
	public ModelAndView signup(Model model) {
		ModelAndView view = new ModelAndView("signup");
		model.addAttribute("employee", new Employee());
		return view;
	}

	@RequestMapping(value = "/signupcomplete")
	public ModelAndView signupDetails(@Valid @ModelAttribute Employee employee,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("signup", "message",
					"Field can not be empty");
		}

		ModelAndView view = new ModelAndView("signedup");
		try {
			employeeService.signUp(employee);
		} catch (DaoException e) {
			logger.error("ERROR IN : SignUpController {}", e);
		}
		return view;
	}
}
