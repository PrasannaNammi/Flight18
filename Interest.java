package products;

public class Interest {
	private int amount;
	private int rate;
	
public Interest(int amount,int rate) {
	this.amount=amount;
	this.rate=rate;
}
public Interest (int amount) {
	this.amount=amount;
	rate=10;
}
public int getRate() {
	return  rate;
}
public void setRate( int rate){
	this.rate=rate;
}
	
public int getAmount() {
	return amount;
}

public  void setAmount( int amount) {
	this.amount=amount;
	
}
public int getInterest() {
	return amount*rate/100;
}
}


