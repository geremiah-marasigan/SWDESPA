import java.util.Scanner;

public class Driver{
	public static void main(String args[]){
		Scanner reader = new Scanner(System.in);
		Calculator calc = new Calculator();
		String input;
		
		do{
			input = reader.nextLine();
			if(!input.equals("***"))
				calc.calculate(input.split(" "));

		}while(!input.equals("***"));
	}
}