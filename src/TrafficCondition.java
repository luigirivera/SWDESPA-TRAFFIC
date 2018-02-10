/*
 * LOPEZ, LUIS ENRICO D.
 * RIVERA, LOUIE IV Y.
 * SWDESPA S17
 */

public enum TrafficCondition {
	LIGHT, MEDIUM, HEAVY;
	
	public String toString () {
		switch(this) {
		case LIGHT: return "Light";
		case MEDIUM: return "Medium";
		case HEAVY: return "Heavy";
		default: return "invalid";
		}
	}
}
