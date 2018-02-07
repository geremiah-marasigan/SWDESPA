public class Road{
	private String name;
	private String northB; //Road State
	private String southB;
	private String northA; //Road advisory
	private String southA;
	
	public Road(String n, String nB, String sB, String nA, String sA){
		setName(n);
		setNorthB(nB);
		setSouthB(sB);
		setNorthA(nA);
		setSouthA(sA);
	}
	
	public void setName(String n){
		this.name = n;
	}
	public void setNorthB(String nB){
		this.northB = nB;
	}
	public void setSouthB(String sB){
		this.southB = sB;
	}
	public void setNorthA(String nA){
		this.northA = nA;
	}
	public void setSouthA(String sA){
		this.southA = sA;
	}
	public String getName(){
		return this.name;
	}
	public String getNorthB(){
		return this.northB;
	}
	public String getSouthB(){
		return this.southB;
	}
	public String getNorthA(){
		return this.northA;
	}
	public String getSouthA(){
		return this.southA;
	}
}