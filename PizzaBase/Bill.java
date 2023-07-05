package PizzaBase;

import java.io.*;

public class Bill implements Serializable{

	private Order order;

	public Bill(Order order){
		this.order = order;
	}

	public String generateBill() throws InsufficientBalanceException{
		if(this.order.getCustomer().getMoney() < this.order.computeTotalPrice()){
			throw new InsufficientBalanceException();
		}else{



			String text = "";
			text += "\n\n\t\t\t    Customer's Receipt\n";
			text += "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
			text += "\tCustomer's name : " + this.order.getCustomer().getName() +"\n\n";
			text += "\tOrder : \n\n";
			if(this.order.getPizza().size() > 0){
				text += "\t       Pizza : \n\n";
				for(Pizza p : this.order.getPizza()){
					text += "\t\t       "+ p.getName() +"   ("+ p.getSize().name() +")   =   $"+ p.computePrice() +"   x   "+ p.getNumberOfPizzas() +"   =   $"+ p.computePrice()*p.getNumberOfPizzas() +"\n\n"; 
				}
			}
			if(this.order.getBeverage().size() > 0){
				text += "\t       Beverage : \n\n";
				for(Beverage b : this.order.getBeverage()){
					text += "\t\t       "+ b.getName() +"   ("+ b.getBeverageSize().name() +")   =   $"+ b.computePrice() +"   x   "+ b.getNumberOfBeverages() +"   =   $"+ b.computePrice()*b.getNumberOfBeverages() +"\n\n"; 
				}
			}
			text += "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
			text += "\n\tTotal Price : \t\t\t\t\t$" + this.order.computeTotalPrice() +"\n";
			text += "\n\tBalance : \t\t\t\t\t$" + this.order.getCustomer().getMoney() +"\n";
			text += "\n\tChange : \t\t\t\t\t$" + (this.order.getCustomer().getMoney()-this.order.computeTotalPrice()) + "\n";
			text += "\n\n\t\t       THANK YOU FOR ORDERING, COME AGAIN.\n\n";
			
			return text;
		}
	}

}
