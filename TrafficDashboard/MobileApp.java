public class MobileApp extends Observer{
	public MobileApp(Subject subject, int id){
		this.subject = subject;
		this.id = id;
		this.subject.attach(this);
	}
	
	
	public void update(){
		String tempNA = "";
		String tempSA = "";
		System.out.println("Mobile App " + id);
		System.out.println("Metro Cebu");
		for(Road r: subject.getState()){
			tempNA = "";
			tempSA = "";
			if(!(r.getNorthA().equals("")))
				tempNA = "- !" + r.getNorthA() + "! ";
			if(!(r.getSouthA().equals("")))
				tempSA = "!" + r.getSouthA() + "! - ";
			System.out.println(r.getNorthB() + " (NB) " + tempNA + "- " + r.getName() + " - " + tempSA + "(SB) " + r.getSouthB());
		}
	}

}