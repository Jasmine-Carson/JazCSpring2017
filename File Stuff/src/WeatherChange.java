import java.io.*;
import java.util.*;

public class WeatherChange {
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("weather.txt");
		Scanner input = new Scanner(f);
		if(input.hasNext()){
			double first = input.nextDouble();
			double second;
			double change;
			while(input.hasNext()){
				second = input.nextDouble();
				change = second - first;
				System.out.println(first+" to "+second+", change = "+change);
				first = second;
			}
		}
	}
}
