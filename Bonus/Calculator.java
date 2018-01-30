public class Calculator{
	private Calculate calcu_A, calcu_S;
	public Calculator(){
		calcu_A = new Adder();
		calcu_S = new Subtracter();
	}

	public void calculate(String[] input){
		int answer = Integer.parseInt(input[0]);
		for (int i = 1; i < input.length; i+=2) {
			switch(input[i]){
				case "+": answer = ((Adder)calcu_A).Solve(answer, Integer.parseInt(input[i+1])); break;
				case "-": answer = ((Subtracter)calcu_S).Solve(answer, Integer.parseInt(input[i+1])); break;
				case "/": int count = 0;
						  while(answer >= Integer.parseInt(input[i+1])){
							count++;
						    answer = ((Subtracter)calcu_S).Solve(answer, Integer.parseInt(input[i+1]));
						  }	 answer = count; break;
				case "*":
				case "x": int temp = answer;
						  for(int j = 1; j < Integer.parseInt(input[i+1]); j++)
							answer = ((Adder)calcu_A).Solve(answer, temp); break;
			}
		}
		
		System.out.println(answer);
	}
	
}

