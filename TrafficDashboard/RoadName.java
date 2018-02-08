public enum RoadName {
	Osmena, Colon, V, Marcelo, Mactan;
	public String toString() {
		switch(this) {
		case Osmena: return "Osmena Boulevard";
		case Colon: return name();
		case V: return "V. Rama";
		case Marcelo: return "Marcelo Fernan Bridge";
		case Mactan: return "Mactan-Mandaue Bridge";
		default: return "No Road";
		}
	}
}