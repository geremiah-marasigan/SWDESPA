package cry;

import java.io.*;

public class CSVDataParser extends DataParser{
	String csvFile = "";
	String line = "";
	String csvSplitBy =  ",";
	public void readData() {
		System.out.println("Reading data from csv file");
	}
	public void processData() {
		System.out.println("Looping through loaded csv"); 
	}
}
