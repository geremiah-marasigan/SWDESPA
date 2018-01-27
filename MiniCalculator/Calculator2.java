public class Calculator{

	public Calculator(String input){
		calculate(input.split(" "));
	}

	public void calculate(String[] input){
		int answer = Integer.parseInt(input[0]);
		for (int i = 0; i < input.length; i++) {
			if (i%2!=0)
				switch(input[i]){
				case "+": answer += Integer.parseInt(input[i+1]); break;
				case "-": answer -= Integer.parseInt(input[i+1]); break;
				case "/": answer /= Integer.parseInt(input[i+1]); break;
				case "x": answer *= Integer.parseInt(input[i+1]); break;
			}
		}
		
		System.out.println(answer);
	}
	
}