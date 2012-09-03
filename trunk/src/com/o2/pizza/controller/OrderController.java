package com.o2.pizza.controller;
 
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.o2.pizza.form.Order;
 
@Controller
public class OrderController {
 
    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    public ModelAndView saveOrder(Model orderModel, @ModelAttribute ("order")
    @Valid Order order, BindingResult result) {
    	String message = new String();
    	if(result.hasErrors()){
    		
    		return new ModelAndView("order", "message", message);
    	}else{
    		message = "Pizza order with below details successfully accepted:\n" + order;
    	}
        
        return new ModelAndView("acknowledge", "message", message);
    }
    
    @RequestMapping("/order")
    public ModelAndView acceptOrder() {
         
        return new ModelAndView("order", "order", new Order());
    }
}