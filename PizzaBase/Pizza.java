package PizzaBase;

import java.io.*;

public abstract class Pizza implements Serializable{

	private String name;
	private int numberOfPizzas;
	private Size size;
	private Base base;

	public Pizza(){
		this.name = null;
		this.numberOfPizzas = 0;
		this.size = null;
		this.base = null;
	}

	public Pizza(String name, int numberOfPizzas, Size size, Base base){
		this.name = name;
		this.numberOfPizzas = numberOfPizzas;
		this.size = size;
		this.base = base;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setNumberOfPizzas(int numberOfPizzas){
		this.numberOfPizzas = numberOfPizzas;
	}

	public void setSize(Size size){
		this.size = size;
	}

	public void setBase(Base base){
		this.base = base;
	}

	public String getName(){
		return this.name;
	}

	public int getNumberOfPizzas(){
		return this.numberOfPizzas;
	}

	public Size getSize(){
		return this.size;
	}

	public Base getBase(){
		return this.base;
	}

	public abstract double computePrice();

}