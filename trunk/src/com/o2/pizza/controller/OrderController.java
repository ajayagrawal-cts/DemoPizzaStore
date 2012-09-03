package com.o2.pizza.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.o2.pizza.form.Order;

@Controller
public class OrderController {

	@RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
	public ModelAndView saveOrder(Model orderModel,
			@ModelAttribute("order") @Valid Order order, BindingResult result) {
		String message = new String();
		String view;
		if (result.hasErrors()) {
			view = "order";
			message = "Error: please correct fields";

		} else {
			view = "acknowledge";
			message = "Pizza order with below details successfully accepted:"
					+ order;

		}
		return new ModelAndView(view, "message", message);

	}

	@RequestMapping("/order")
	public ModelAndView acceptOrder() {

		return new ModelAndView("order", "order", new Order());
	}
}