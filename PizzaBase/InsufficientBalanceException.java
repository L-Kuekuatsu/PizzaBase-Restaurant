package PizzaBase;

class InsufficientBalanceException extends Exception{

	public InsufficientBalanceException(){
		super("Insufficient Balance!");
	}

}