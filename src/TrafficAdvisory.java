
public enum TrafficAdvisory {
	ACCIDENT, FLOOD, REPAIR, BLOCKING, NONE;
	
	public String toString() {
		switch(this) {
		case ACCIDENT: return "Accident";
		case FLOOD: return "Flood";
		case REPAIR: return "Road Repair";
		case BLOCKING: return "Road Blocking";
		case NONE: return "";
		default: return "invalid";
		}
	}
}
