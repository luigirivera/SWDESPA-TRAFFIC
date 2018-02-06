public class MobileApp implements TrafficObserver {
	private TrafficSubject model;

	public TrafficSubject getModel() {
		return model;
	}

	public void setModel(TrafficSubject model) {
		this.model = model;
	}

	public void update() {
		System.out.println(model.getArea() + "\n");
		for (Road road : model.getState()) {
			System.out.println(road.getNorthbound.getCondition().toString() + " (NB) - " 
							 + road.getNorthbound.getAdvisory().toString() + " - "+ road.getName() + " - "
							 + road.getSouthbound.getAdvisory().toString() + " - (SB) "
							 + road.getSouthbound.getCondition.toString());
		}
	}
}