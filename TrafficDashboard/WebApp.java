public class WebApp extends Observer{
	private int id;
	
	public WebApp(Subject subject, int id){
		this.subject = subject;
		this.id = id;
		this.subject.attach(this);
	}

	public void update(){
		String tempNA = "";
		String tempSA = "";
		System.out.println("Web App " + id);
		System.out.println("Metro Cebu");
		System.out.format("%-32s%-32s%-32s%n","","NB","SB");
		for(Road r: subject.getState()){
			tempNA = "";
			tempSA = "";
			if(!(r.getNorthA().equals("")))
				tempNA = " (" + r.getNorthA() + "!)";
			if(!(r.getSouthA().equals("")))
				tempSA = " (" + r.getSouthA() + "!)";
			System.out.format("%-32s%-32s%-32s%n", r.getName(), r.getNorthB() + tempNA, r.getSouthB() + tempSA);
		}
	}



}
