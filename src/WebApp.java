import java.util.Arrays;

public class WebApp extends TrafficObserver {
	private static int count = 1;

	public WebApp(TrafficSubject model) {
		super(model);
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
	
	public static void main(String[] args) {
		TrafficSubject ts = new TrafficSubject("Metro Cebu");
		ts.setState(Arrays.asList(new Road("Osmena Boulevard"), new Road("Colon")));
		ts.getState().get(0).getNorthbound().setAdvisory(TrafficAdvisory.BLOCKING);
		WebApp wa = new WebApp(ts);
		wa.update();
	}
}
