package PizzaBase;

import java.io.*;

public class Beverage implements Action, Serializable{

	private String name;
	private double price;
	private int numberOfBeverages;
	private BeverageSize beverageSize;

	public Beverage(){
		this.name = null;
		this.price = 0;
		this.numberOfBeverages = 0;
		this.beverageSize = null;
	}

	public Beverage(String name, double price, int numberOfBeverages, BeverageSize beverageSize) throws InvalidPriceException{
		if(price <= 0){
			throw new InvalidPriceException();
		}
		this.name = name;
		this.price = price;
		this.numberOfBeverages = numberOfBeverages;
		this.beverageSize = beverageSize;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setPrice(double price) throws InvalidPriceException{
		if(price <= 0){
			throw new InvalidPriceException();
		}
		this.price = price;
	}

	public void setNumberOfBeverages(int numberOfBeverages){
		this.numberOfBeverages = numberOfBeverages;
	}

	public void setBeverageSize(BeverageSize beverageSize){
		this.beverageSize = beverageSize;
	}

	public String getName(){
		return this.name;
	}

	public double getPrice(){
		return this.price;
	}

	public int getNumberOfBeverages(){
		return this.numberOfBeverages;
	}

	public BeverageSize getBeverageSize(){
		return this.beverageSize;
	}

	public double computePrice(){
		double price = this.price;
		switch(this.getBeverageSize()){
			case SMALL : price *= 1;
				break;
			case MEDIUM : price *= 1.5;
				break;
			case LARGE : price *= 2;
				break;
		}

		return price;
	}

	public String prepare(){
		return "Preparing Beverage.....";
	}

	public String process(){
		return "Cooling Beverages.....";
	}

	public String serve(){
		return "Serving Beverages.....";
	}

	public String toString(){
		return this.name +" ("+ this.beverageSize +")   =   $"+ this.computePrice() +"  x  "+ this.numberOfBeverages +"  =  $"+ this.computePrice()*this.numberOfBeverages;
	}

}