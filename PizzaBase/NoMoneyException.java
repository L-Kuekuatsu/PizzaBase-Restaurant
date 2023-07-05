package PizzaBase;

class NoMoneyException extends Exception{

	public NoMoneyException(){
		super("You can't order with this amount of money!");
	}

}