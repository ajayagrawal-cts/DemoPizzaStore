/**
 * 
 */
package com.o2.pizza.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;



/**
 * @author ctsinpun
 *
 */
public class Order {


		@NotBlank(message="*")
		private String name;

	@Size(min =1, max = 150)
	private String address;

	
    private Integer noOfPizzas;
	/**
	 * @return the name 
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the noOfPizzas
	 */
	public Integer getNoOfPizzas() {
		return noOfPizzas;
	}
	/**
	 * @param noOfPizzas the noOfPizzas to set
	 */
	public void setNoOfPizzas(Integer noOfPizzas) {
		this.noOfPizzas = noOfPizzas;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name: " + name + ", Address: " + address + ", No. of Pizzas: " + noOfPizzas;
	}
    
   
    
}
