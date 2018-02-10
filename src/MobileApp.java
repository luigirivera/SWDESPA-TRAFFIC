/*
 * LOPEZ, LUIS ENRICO D.
 * RIVERA, LOUIE IV Y.
 * SWDESPA S17
 */

public class MobileApp extends TrafficObserver {
	private static int count = 1;
	
	public MobileApp() {
		this.number = count;
		count++;
	}
	
	private String directionToStringNB(Direction d) {
		if(d.getAdvisory().equals(TrafficAdvisory.NONE))
			return d.getCondition().toString() + " (NB)";
		else
			return String.format("%s (NB) - !%s!", d.getCondition().toString(), d.getAdvisory().toString());
	}
	
	private String directionToStringSB(Direction d) {
		if(d.getAdvisory().equals(TrafficAdvisory.NONE))
			return "(SB) " + d.getCondition().toString();
		else
			return String.format("!%s! - (SB) %s ", d.getAdvisory().toString(), d.getCondition().toString());
	}

	public void update() {
		System.out.println("Mobile App " + this.number);
		System.out.println(model.getArea());
		for (Road road : model.getState()) {
			String nb = directionToStringNB(road.getNorthbound());
			String sb = directionToStringSB(road.getSouthbound());
			System.out.println(nb + " - " + road.getName() + " - " + sb);
		}
	}
}