
public class WebApp implements TrafficObserver {
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
			
		}
	}
}
