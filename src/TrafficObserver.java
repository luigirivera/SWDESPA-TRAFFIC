/*
 * LOPEZ, LUIS ENRICO D.
 * RIVERA, LOUIE IV Y.
 * SWDESPA S17
 */

public abstract class TrafficObserver {
	protected TrafficSubject model;
	protected int number;

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
