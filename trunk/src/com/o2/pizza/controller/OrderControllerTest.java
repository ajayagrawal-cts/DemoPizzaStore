/**
 * 
 */
package com.o2.pizza.controller;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.o2.pizza.form.Order;

/**
 * @author ctsinpun
 *
 */
public class OrderControllerTest {

	/**
	 * Test method for {@link com.o2.pizza.controller.OrderController#saveOrder(com.o2.pizza.form.Order, org.springframework.validation.BindingResult)}.
	 */
	@Test
	public void testSaveOrder() {
		OrderController controller = new OrderController();
		BindingResult result = null;
		Order order = new Order();
		//controller.saveOrder(order, result);
	}

	/**
	 * Test method for {@link com.o2.pizza.controller.OrderController#acceptOrder()}.
	 */
	@Test
	public void testAcceptOrder() {
		OrderController controller = new OrderController();
		ModelAndView  modelAndView = controller.acceptOrder();
		assertNotNull("Model and View object not returned", modelAndView );
		assertEquals("View name is invalid, expected is order", "order", modelAndView.getViewName());
		Map<String, Object> map = modelAndView.getModel();
		assertNotNull("Model object not returned", map);
		assertNotNull("Model returned with invalid key, expected is: command", map.get("command"));
		assertTrue("Type of model incorrect, expected is: com.o2.pizza.form.Order", map.get("command") instanceof Order);
	}

}
