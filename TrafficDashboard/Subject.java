import java.util.*;

public class Subject{
	private ArrayList<Road> roads;
	private ArrayList<Observer> observers;
	
	/*Road(Name, NorthBound, SouthBound, NorthAdvisory, SouthAdvisory)*/
	public Subject(){
		roads = new ArrayList<>();
		observers = new ArrayList<>();
		
	}
	
	
	public void init(){
		roads.add(new Road("Osmena Boulevard", "Heavy", "Light", "", ""));
		roads.add(new Road("Colon", "Light", "Heavy", "", ""));
		roads.add(new Road("V. Rama", "Light", "Heavy", "", ""));
		roads.add(new Road("Marcelo Fernan Bridge", "Heavy", "Light", "", ""));
		roads.add(new Road("Mactan-Mandaue Bridge", "Light", "Light", "", ""));
		
	}
	
	public void attach(Observer observer){
		this.observers.add(observer);
	}
	
	public ArrayList<Road> getState(){
		return this.roads;
	}
	
	public Road getRoad(String name){
		for (int i = 0; i < roads.size(); i++)
			if(this.roads.get(i).getName().equals(name))
				return this.roads.get(i); 
		return null;	
	}
	
	public void updateAllObservers(){
		for(Observer observer: this.observers){
			observer.update();
		}
	}
}