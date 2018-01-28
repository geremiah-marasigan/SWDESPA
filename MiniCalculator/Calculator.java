public class Calculator{
	private Adder adder;
	private Subtracter subtracter;
	private Divider divider;
	private Multiplier multiplier;
	
	public Calculator(){
		adder = new Adder();
		subtracter = new Subtracter();
		divider = new Divider();
		multiplier = new Multiplier();
	}

	public void calculate(String[] input){
		int answer = Integer.parseInt(input[0]);
		for (int i = 0; i < input.length; i++) {
			if (i%2!=0)
				switch(input[i]){
				case "+": answer = adder.add(answer, Integer.parseInt(input[i+1])); break;
				case "-": answer = subtracter.subtract(answer, Integer.parseInt(input[i+1])); break;
				case "/": answer = divider.divide(answer, Integer.parseInt(input[i+1])); break;
				case "x": answer = multiplier.multiply(answer, Integer.parseInt(input[i+1])); break;
			}
		}
		
		System.out.println(answer);
	}
	
}