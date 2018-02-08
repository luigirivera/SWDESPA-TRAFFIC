
public abstract class TrafficObserver {
	protected TrafficSubject model;
	protected int number;
	
	public TrafficObserver(TrafficSubject model) {
		this.model = model;
	}

	public TrafficSubject getModel() {
		return model;
	}

	public void setModel(TrafficSubject model) {
		this.model = model;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public abstract void update(); // printing
}
