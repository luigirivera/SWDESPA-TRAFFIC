public class MobileApp extends TrafficObserver {
	private static int count = 1;
	
	public MobileApp(TrafficSubject model) {
		super(model);
		this.number = count;
		count++;
	}

	public void update() {
		System.out.println(model.getArea() + "\n");
		for (Road road : model.getState()) {
			System.out.println(road.getNorthbound().getCondition().toString() + " (NB) - " 
							 + road.getNorthbound().getAdvisory().toString() + " - "+ road.getName() + " - "
							 + road.getSouthbound().getAdvisory().toString() + " - (SB) "
							 + road.getSouthbound().getCondition().toString());
		}
	}
}