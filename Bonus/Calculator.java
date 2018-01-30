public class Calculator{
	private Adder adder;
	private Subtracter subtracter;
	
	public Calculator(){
		adder = new Adder();
		subtracter = new Subtracter();
		
	}

	public void calculate(String[] input){
		int answer = Integer.parseInt(input[0]);
		for (int i = 1; i < input.length; i+=2) {
			switch(input[i]){
				case "+": answer = adder.add(answer, Integer.parseInt(input[i+1])); break;
				case "-": answer = subtracter.subtract(answer, Integer.parseInt(input[i+1])); break;
				case "/": int count = 0;
						  while(answer >= Integer.parseInt(input[i+1])){
							count++;
						    answer = subtracter.subtract(answer, Integer.parseInt(input[i+1]));
						  }	 answer = count; break;
				case "x": int temp = answer;
						  for(int j = 1; j < Integer.parseInt(input[i+1]); j++)
							answer = adder.add(answer, temp); break;
			}
		}
		
		System.out.println(answer);
	}
	
}