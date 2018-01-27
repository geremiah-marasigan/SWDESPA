public class Calculator{
	private String[] parsedInput;
	private int operand1;
	private int operand2;
	private String operator;

	public Calculator(){
		this.parsedInput = new String[3];
		this.operand1 = 0;
		this.operand2 = 0;
		this.operator = "";
	}

	public void calculate(String input){
		int answer = 0;
		this.parsedInput = input.split(" ");
		this.operand1 = Integer.parseInt(this.parsedInput[0]);
		this.operator = this.parsedInput[1];
		this.operand2 = Integer.parseInt(this.parsedInput[2]);
		switch(operator){
			case "+": answer = operand1 + operand2; break;
			case "-": answer = operand1 - operand2; break;
			case "/": answer = operand1 / operand2; break;
			case "x": answer = operand1 * operand2; break;
		}
		
		
		System.out.println(answer);
	}

}