package PizzaBase;

import java.io.*;
	
public class Topping implements Serializable{

	private String name;
	private double price;
	private int numberOfToppings;

	public Topping(){
		this.name = null;
		this.price = 0;
		this.numberOfToppings = 0;
	}

	public Topping(String name, double price, int numberOfToppings) throws InvalidPriceException{
		this.name = name;
		this.numberOfToppings = numberOfToppings;
		if(price <= 0){
			throw new InvalidPriceException();
		}else{
			this.price = price;
		}
	}

	public void setPrice(double price) throws InvalidPriceException{
		if(price <= 0){
			throw new InvalidPriceException();
		}else{
			this.price = price;
		}
	}

	public void setName(String name){
		this.name = name;
	}

	public double getPrice(){
		return this.price;
	}

	public String getName(){
		return this.name;
	}

	public void setNumberOfToppings(int numberOfToppings){
		this.numberOfToppings = numberOfToppings;
	}

	public int getNumberOfToppings(){
		return this.numberOfToppings;
	}

}