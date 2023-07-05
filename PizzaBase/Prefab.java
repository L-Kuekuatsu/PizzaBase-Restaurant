package PizzaBase;

import java.io.*;

public class Prefab extends Pizza implements Action, Serializable{

	private double price;

	public Prefab(){
		super(null, 0, null, null);
		this.price = 0;
	}

	public Prefab(String name, double price, int numberOfPizzas, Size size, Base base){
		super(name, numberOfPizzas, size, base);
		this.price = price;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public double getPrice(){
		return this.price;
	}

	@Override
	public double computePrice(){
		double price = this.price;
		switch(super.getBase()){
			case DEEPCRUST : price += 50;
				break;
			case CRISPYBASE : price += 0;
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

		return price;
	}

	public String prepare(){
		return "Preparing Ingredients.....";
	}

	public String process(){
		return "Cooking Pizza.....";
	}

	public String serve(){
		return "Packing Pizza.....";
	}

	public String toString(){
		return super.getName() +" ("+ super.getSize() +")   =   $"+ this.computePrice() +"  x  "+ super.getNumberOfPizzas() +"  =  $"+ this.computePrice()*super.getNumberOfPizzas();
	}

}