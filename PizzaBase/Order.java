package PizzaBase;

import java.util.*;
import java.io.*;

public class Order implements Serializable{

	private Customer customer;
	private List<Pizza> pizza;
	private List<Beverage> beverage;

	public Order(){
		this.customer = null;
		this.pizza = new LinkedList<Pizza>();
		this.beverage = new LinkedList<Beverage>();
	}

	public Order(Customer customer, Pizza pizza, Beverage beverage){
		this.customer = customer;
		this.pizza = new LinkedList<Pizza>();
		this.beverage = new LinkedList<Beverage>();
		this.pizza.add(pizza);
		this.beverage.add(beverage);
	}

	public void setCustomer(Customer customer){
		this.customer = customer;
	}

	public Customer getCustomer(){
		return this.customer;
	}

	public void addPizza(Pizza pizza){
		this.pizza.add(pizza);
	}

	public void addBeverage(Beverage beverage){
		this.beverage.add(beverage);
	}

	public List<Pizza> getPizza(){
		return new LinkedList<Pizza>(this.pizza);
	}

	public List<Beverage> getBeverage(){
		return new LinkedList<Beverage>(this.beverage);
	}

	public void backToOne(){
		this.pizza = new LinkedList<Pizza>();
		this.beverage = new LinkedList<Beverage>();
	}

	public double computeTotalPrice(){
		double price = 0;
		for(Pizza p : this.pizza){
			price += p.computePrice() * p.getNumberOfPizzas();
		}
		for(Beverage b : this.beverage){
			price += b.computePrice() * b.getNumberOfBeverages();
		}
		
		return price;
	}

}
