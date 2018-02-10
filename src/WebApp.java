/*
 * LOPEZ, LUIS ENRICO D.
 * RIVERA, LOUIE IV Y.
 * SWDESPA S17
 */

import java.util.Arrays;

public class WebApp extends TrafficObserver {
	private static int count = 1;

	public WebApp() {
		this.number = count;
		count++;
	}
	
	private String directionToString(Direction d) {
		if(d.getAdvisory().equals(TrafficAdvisory.NONE))
			return d.getCondition().toString();
		else
			return String.format("%s (%s!)", d.getCondition().toString(), d.getAdvisory().toString());
	}

	public void update() {
		System.out.println("Web App " + this.number);
		System.out.println(model.getArea());
		System.out.println(String.format("%-25s%-25s%-25s", " ", "NB", "SB"));
		for (Road road : model.getState()) {
			String nb = directionToString(road.getNorthbound());
			String sb = directionToString(road.getSouthbound());
			System.out.println(String.format("%-25s%-25s%-25s", road.getName(), nb, sb));
		}
	}
}
