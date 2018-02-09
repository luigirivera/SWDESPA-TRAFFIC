import java.util.List;
import java.util.ArrayList;

public class TrafficSubject {
	private List<TrafficObserver> views;
	private List<Road> roads;
	private String area; // Metro Cebu

	public TrafficSubject(String area) {
		views = new ArrayList<TrafficObserver>();
		roads = new ArrayList<Road>();
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	public void updateAll() {
		for (TrafficObserver to : views) {
			to.update();
		}
	}

	public void attach(TrafficObserver to) {
		if (!views.contains(to)) {
			views.add(to);
			to.setModel(this);
		}
	}

	public List<Road> getState() {
		return roads;
	}

	public void setState(List<Road> roads) {
		this.roads = roads;
		this.updateAll();
	}
}
