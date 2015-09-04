package com.webonise.conferenceRoomBooking;

import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webonise.conferenceRoomBooking.exception.DaoException;
import com.webonise.conferenceRoomBooking.model.Room;
import com.webonise.conferenceRoomBooking.model.ScheduledEvent;
import com.webonise.conferenceRoomBooking.service.RoomService;
import com.webonise.conferenceRoomBooking.service.ScheduledEventService;

@Component
@RequestMapping("/user")
public class EmployeeController {

	static final Logger logger = Logger.getLogger(EmployeeController.class);

	@Autowired
	private RoomService roomService;

	@Autowired
	private ScheduledEventService scheduledEventService;

	@RequestMapping("/bookingroom")
	public ModelAndView bookRoom(Model model) {
		ModelAndView view = new ModelAndView("employeebooking");
		List<Room> roomlist = null;
		try {
			roomlist = roomService.getAllRoomDetails();
		} catch (DaoException e) {
			logger.error("ERROR  :  {}", e);
		}

		model.addAttribute("roomList", roomlist);
		return view;
	}

	@RequestMapping(value = "/bookroom", method = RequestMethod.POST)
	public ModelAndView Staus(@RequestParam String roomNumber, Model model) {

		ModelAndView view = new ModelAndView("bookroom");
		Room room = null;
		try {
			room = roomService.getRoomDetail(Integer.parseInt(roomNumber));
			model.addAttribute("room", room);
			model.addAttribute("scheduleDetail", new ScheduledEvent());
		} catch (NumberFormatException | DaoException e) {
			logger.error("ERROR  :  {}", e);
		}
		return view;
	}

	@RequestMapping(value = "/compltedbooking", method = RequestMethod.POST)
	public ModelAndView book(
			@Valid @ModelAttribute("scheduleDetail") ScheduledEvent scheduleDetail,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("bookroom", "message",
					"Field can not be empty and date should be valid");
		}

		try {
			scheduledEventService.insertScheduledRoomDetail(scheduleDetail);
		} catch (DaoException e) {
			logger.error("ERROR IN EmployeeController :  {}", e);
		}
		return new ModelAndView("booked");
	}

	@RequestMapping("/viewallrooms")
	public ModelAndView viewAllRooms(Model model) {
		ModelAndView view = new ModelAndView("allroomsusers");
		try {
			List<Room> rooms = roomService.getAllRoomDetails();
			System.out.println(rooms);
			model.addAttribute("roomList", rooms);
		} catch (DaoException e) {
			logger.error("ERROR  :  {}", e);
		}
		return view;
	}

	@RequestMapping("/viewMyBookings")
	public ModelAndView viewMyBookings() {
		ModelAndView view = new ModelAndView("viewMyBookings");
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		String employeeId = authentication.getName();
		List<ScheduledEvent> employeeBookings;
		try {
			employeeBookings = scheduledEventService
					.viewUserBooking(employeeId);
			if (!employeeBookings.isEmpty()) {
				view.addObject("employeeBookings", employeeBookings);
			} else {
				return new ModelAndView("viewmybookingempty", "message",
						"YOU HAVE NOT BOOKED ANY ROOM");

			}
		} catch (DaoException e) {
			logger.error("ERROR  :  {}" + e.getMessage());
		}
		return view;
	}

	@RequestMapping(value = "/cancelBooking/{eventId}")
	public String deleteBooking(@PathVariable("eventId") int eventId,
			Model model) {
		try {
			scheduledEventService.deleteEventfromSystem(eventId);
		} catch (NumberFormatException | DaoException e) {
			model.addAttribute("message", "NO SUCH ROOM");
			logger.error("ERROR IN AdminController :  {}" + e.getMessage());
			return "deleteRoom";
		}
		return "deletevent";

	}
}
