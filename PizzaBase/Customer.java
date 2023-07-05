package PizzaBase;

import java.io.*;
	
public class Customer implements Serializable{
	
	private String name;
	private double money;

	public Customer(){
		this.name = null;
		this.money = 0;
	}

	public Customer(String name, double money) throws NoMoneyException{
		this.name = name;
		if(money <= 0){
			throw new NoMoneyException();
		} else{
			this.money = money;
		}
	}

	public void setName(String name){
		this.name = name;
	}

	public void setMoney(double money) throws NoMoneyException{
		if(money <= 0){
			throw new NoMoneyException();
		} else{
			this.money = money;
		}
	}

	public String getName(){
		return this.name;
	}

	public double getMoney(){
		return this.money;
	}

}