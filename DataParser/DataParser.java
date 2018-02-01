import java.util.*;
import java.io.*;

public abstract class DataParser {
	protected ArrayList<List> records;
	public void parseDataAndGenerateOutput() {
		readData();
		processData();
		writeData();
	}
	abstract void readData();
	abstract void processData();
	
	public void writeData() {
		System.out.println("Output generated, writing to CSV");
			StringBuilder builder = new StringBuilder();
			for(int i = 0; i < records.size(); i++){
				for(int j = 0; j < records.get(i).size(); j++){
					builder.append(records.get(i).get(j));
					builder.append(",");
				}
				builder.append(System.getProperty("line.separator"));
			}
		//System.out.println(builder.toString());
		try{
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("output.csv", true))); 
			System.out.print(builder.toString());
			writer.write(builder.toString());
			writer.flush();
			writer.close();
		} catch (IOException e){
			
		}
	}
}
