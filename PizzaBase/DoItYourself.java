package PizzaBase;

import java.util.*;
import java.io.*;


public class DoItYourself extends Pizza implements Action, Serializable{

	private List<Topping> topping;

	public DoItYourself(){
		super(null, 0, null, null);
		this.topping = new LinkedList<Topping>();
	}

	public DoItYourself(String name, int numberOfPizzas, Size size, Base base){
		super(name, numberOfPizzas, size, base);
		this.topping = new LinkedList<Topping>();
	}

	public void addTopping(Topping topping){
		this.topping.add(topping);
	}

	public List<Topping> getTopping(){
		return new LinkedList<Topping>(this.topping);
	}

	@Override
	public double computePrice(){
		double price = 0;
		switch(super.getBase()){
			case DEEPCRUST : price = 150;
				break;
			case CRISPYBASE : price = 100;
				break;
		}
		switch(super.getSize()){
			case SIXINCH : price *= 1;
				break;
			case NINEINCH : price *= 1.5;
				break;
			case TWELVEINCH : price *= 2;
				break;
		}
		for(Topping t : this.topping){
			price += t.getPrice() * t.getNumberOfToppings();
		}

		return price;
	}

	public String prepare(){
		return "Preparing Toppings.....";
	}

	public String process(){
		return "Waiting to cook.....";
	}

	public String serve(){
		return "Serving Pizza.....";
	}

	public String toString(){
		return super.getName() +" ("+ super.getSize() +")   =   $"+ this.computePrice() +"  x  "+ super.getNumberOfPizzas() +"  =  $"+ this.computePrice()*super.getNumberOfPizzas();
	}

}