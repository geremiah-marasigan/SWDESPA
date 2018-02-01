import java.io.*;
import java.util.*;
public class CSVDataParser extends DataParser{
	public void readData() {
		System.out.println("Reading data from csv file");
		String filename = "sample.csv";
		try{
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			String[] temp;
			while ((line = reader.readLine()) != null){
				//System.out.println(line);
				temp = line.split(",");
				super.records.add(Arrays.asList(temp));
			} 
			
			reader.close();
		}
		catch (Exception e){
			System.err.format("Exception occurred trying to read '%s'.", filename);
			e.printStackTrace();
		}
	}
	
	
	public void processData() {
		System.out.println("Looping through loaded csv");
		/*for(int i = 0; i < super.records.size(); i++)
			for(int j = 0; j < super.records.get(i).size(); j++)
				System.out.println(super.records.get(i).get(j));*/
		
	}
}
