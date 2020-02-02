package com.star.sud.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.star.sud.employee.controller.EmployeeController;

@Controller
public class HomePageController {

	// Static Attributes
	///////////////////////
	private static final Logger log = Logger.getLogger(HomePageController.class);
	private static final String LADING_PAGE = "home";
	private static final String ACTION_REDIRECT = "redirect:";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getLandingPage(Model model) {
		log.debug("getLandingPage");
		try {
			return ACTION_REDIRECT + EmployeeController.ROOT_URL + EmployeeController.REQ_MAP_LIST;
		} catch (Exception e) {
			log.error("getLandingPage", e);
		}
		return LADING_PAGE;
	}

}
