public enum Advisory {
	Accident,Flood,RoadRepair,RoadBlocking,None;
	public String toString() {
		switch(this) {
			case Accident: return "Accident";
			case Flood: return "Flood";
			case RoadRepair: return "Road Repair";
			case RoadBlocking: return "Road Blocking";
			case None: return "";
			default: return "No input";
		}
	}
}