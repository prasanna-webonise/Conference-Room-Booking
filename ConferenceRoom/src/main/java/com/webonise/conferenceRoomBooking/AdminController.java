package com.webonise.conferenceRoomBooking;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.webonise.conferenceRoomBooking.exception.DaoException;
import com.webonise.conferenceRoomBooking.model.Employee;
import com.webonise.conferenceRoomBooking.model.Room;
import com.webonise.conferenceRoomBooking.service.EmployeeService;
import com.webonise.conferenceRoomBooking.service.RoomService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final Logger logger = Logger
			.getLogger(AdminController.class);

	@Autowired
	private RoomService roomService;

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/addroom")
	public ModelAndView addRoom(Model model) {
		ModelAndView view = new ModelAndView("addroomdetails");
		model.addAttribute("room", new Room());
		return view;
	}

	@RequestMapping(value = "roomdetails")
	public ModelAndView roomDetails(@Valid @ModelAttribute Room room,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return new ModelAndView("addroomdetails", "message",
					"Description Shoud not be empty and capacity should be greater than 3");
		}
		ModelAndView view = new ModelAndView("addroomdetails");
		try {
			boolean roomstatus = roomService.addRoom(room);
			if (!roomstatus) {
				model.addAttribute("message", "COULD NOT ADD");
			} else {
				model.addAttribute("message", "SUCCESSFULLY ADDED");
			}
		} catch (DaoException e) {
			logger.error("ERROR : {}", e);
		}
		return view;
	}

	@RequestMapping("/viewallrooms")
	public ModelAndView viewAllRooms(Model model) {
		ModelAndView view = new ModelAndView("allrooms");
		try {
			List<Room> rooms = roomService.getAllRoomDetails();
			if (!rooms.isEmpty()) {
				model.addAttribute("roomList", rooms);
			} else {
				model.addAttribute("message", "NO ROOMS AVILABLE");
			}
		} catch (DaoException e) {
			logger.error("ERROR :  {}", e);
		}
		return view;
	}

	@RequestMapping(value = "/viewallrooms/{roomid}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Room getRoomDetail(@PathVariable int roomid)
			throws IOException {
		Room room = null;
		try {
			room = roomService.getRoomDetail(roomid);
		} catch (DaoException e) {
			logger.error("ERROR !!! :  {}" + e.getMessage());
		}
		return room;
	}

	@RequestMapping("/viewallusers")
	public ModelAndView allusers() {
		ModelAndView view = new ModelAndView("allUsers");
		List<Employee> userlist = null;
		try {
			userlist = employeeService.getAllEmployeeDetails();
		} catch (DaoException e) {
			logger.error("ERROR IN AdminController :  {}", e);
		}
		view.addObject("userList", userlist);
		return view;
	}

	@RequestMapping(value = "/viewallusers/{employeeid}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Employee findEmployee(

	@PathVariable String employeeid) {
		Employee employee = null;
		try {
			employee = employeeService.findEmployee(employeeid);
		} catch (DaoException e) {
			logger.error("ERROR FOUND!! :  {}" + e.getMessage());
		}
		return employee;
	}

	@RequestMapping(value = "/deleteroom")
	public ModelAndView viewAllRoom(Model model) {
		ModelAndView view = new ModelAndView("deleteRoom");
		try {
			List<Room> rooms = roomService.getAllRoomDetails();
			if (!rooms.isEmpty()) {
				model.addAttribute("roomList", rooms);
			} else {
				model.addAttribute("message", "NO ROOMS AVILABLE");
			}
		} catch (DaoException e) {
			logger.error("ERROR FOUND!! :  {}", e);
		}
		return view;
	}

	@RequestMapping(value = "/deleteRoomFromDatabase", method = RequestMethod.DELETE)
	public String deleteRoomFromDatabase(
			@RequestParam("roomNumber") int roomNumber, Model model) {
		try {
			List<Room> rooms = roomService.getAllRoomDetails();
			model.addAttribute("roomList", rooms);
			boolean checkflag = roomService.deleteRoomfromSystem(roomNumber);
			if (!checkflag) {
				model.addAttribute("message", "CAN NOT REMOVE BOOKED ROOM ");
			} else {
				model.addAttribute("message", "SUCCESSFULLY REMOVED ");
			}
		} catch (NumberFormatException | DaoException e) {
			logger.error("ERROR FOUND!! :  {}" + e.getMessage());
		}
		return "deleteRoomStatus";
	}

}
