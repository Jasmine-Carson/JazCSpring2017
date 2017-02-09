//Jasmine Carson
//APCS 1st Period
public abstract class Ticket {
	int number;
	public Ticket(int num){
		number = num;
	}
	public abstract int getPrice();
	public String toString(){
		return("Number: "+number+", Price: "+this.getPrice());
	}
}
