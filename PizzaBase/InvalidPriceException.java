package PizzaBase;

class InvalidPriceException extends Exception{

	public InvalidPriceException(){
		super("The price is not valid!");
	}

}