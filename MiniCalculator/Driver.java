import java.util.Scanner;

public class Driver{
	public static void main(String args[]){
		Calculator calc = new Calculator();
		Scanner reader = new Scanner(System.in);
		String input;
		
		do{
			input = reader.nextLine();
			if(!input.equals("***"))
				calc.calculate(input);

		}while(!input.equals("***"));
	}
}