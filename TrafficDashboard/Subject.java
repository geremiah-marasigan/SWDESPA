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
		roads.add(new Road(RoadName.Osmena.toString(), Traffic.Heavy.toString(), Traffic.Light.toString(), "", ""));
		roads.add(new Road(RoadName.Colon.toString(), Traffic.Light.toString(), Traffic.Heavy.toString(), "", ""));
		roads.add(new Road(RoadName.V.toString(), Traffic.Light.toString(), Traffic.Heavy.toString(), "", ""));
		roads.add(new Road(RoadName.Marcelo.toString(), Traffic.Heavy.toString(), Traffic.Light.toString(), "", ""));
		roads.add(new Road(RoadName.Mactan.toString(), Traffic.Heavy.toString(), Traffic.Light.toString(), "", ""));
		
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