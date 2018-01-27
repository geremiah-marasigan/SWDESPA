import java.util.Scanner;

public class Driver{
	public static void main(String args[]){
		Scanner reader = new Scanner(System.in);
		Calculator calc;
		String input;
		
		do{
			input = reader.nextLine();
			if(!input.equals("***"))
				calc = new Calculator(input);

		}while(!input.equals("***"));
	}
}