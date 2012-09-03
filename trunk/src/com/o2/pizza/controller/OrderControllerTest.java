/**
 * 
 */
package com.o2.pizza.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.o2.pizza.form.Order;

/**
 * @author ctsinpun
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	
	@Mock
	BindingResult result;
	
	@Mock
	Model orderModel;
	
	OrderController controller;
	
	@Mock
	Order order;
	

	@Before
	public void setup() {
		controller = new OrderController();
	}
	/**
	 * Test method for {@link com.o2.pizza.controller.OrderController#saveOrder(com.o2.pizza.form.Order, org.springframework.validation.BindingResult)}.
	 */
	@Test
	public void itShouldSaveOrderSuccessfully() {
		// When 
		when(result.hasErrors()).thenReturn(false);
		
		//given
		order.setName("XYZ");
		order.setAddress("Pune");
		ModelAndView  modelAndView = controller.saveOrder(orderModel, order, result);
		
		//verify
		assertNotNull("Model and View object not returned", modelAndView );
		assertEquals("View name is invalid, expected is acknowledge", "acknowledge", modelAndView.getViewName());
		Map<String, Object> map = modelAndView.getModel();
		assertNotNull("Model object not returned", map);
		assertNotNull("Model returned with invalid key, expected is: message", map.get("message"));
		assertEquals("Pizza order with below details successfully accepted:"+order, map.get("message"));
		verify(result).hasErrors();
		//verify(order).toString();
	}
	
	@Test
	public void itShouldNotSaveOrderAndReturnOrderView() {
		// When 
		when(result.hasErrors()).thenReturn(true);
		
		//given
		order.setName("XYZ");
		ModelAndView  modelAndView = controller.saveOrder(orderModel, order, result);
		
		//verify
		assertNotNull("Model and View object not returned", modelAndView );
		assertEquals("View name is invalid, expected is order", "order", modelAndView.getViewName());
		Map<String, Object> map = modelAndView.getModel();
		assertNotNull("Model object not returned", map);
		assertNotNull("Model returned with invalid key, expected is: message", map.get("message"));
		assertEquals("Error: please correct fields", map.get("message"));
		verify(result).hasErrors();
		//verify(order).toString();
	}
	/**
	 * Test method for {@link com.o2.pizza.controller.OrderController#acceptOrder()}.
	 */
	@Test
	public void testAcceptOrder() {
		
		ModelAndView  modelAndView = controller.acceptOrder();
		assertNotNull("Model and View object not returned", modelAndView );
		assertEquals("View name is invalid, expected is order", "order", modelAndView.getViewName());
		Map<String, Object> map = modelAndView.getModel();
		assertNotNull("Model object not returned", map);
		assertNotNull("Model returned with invalid key, expected is: order", map.get("order"));
		assertTrue("Type of model incorrect, expected is: com.o2.pizza.form.Order", map.get("order") instanceof Order);
	}

}
