import java.util.Scanner;

public class AdminMenu {
	private TrafficSubject model;
	private Scanner sc;

	public AdminMenu(TrafficSubject model) {
		this.model = model;
	}
	
	private void attachObserver(TrafficObserver to, String label) {
		model.attach(to);
		System.out.println(label + " " + to.getNumber() + " was added!");
	}

	private void updateRoad(Road r) {

	}

	private void updateDirection(Direction d) {

	}

	public void start() {
		int input;
		sc = new Scanner(System.in);
		do {
			System.out.println("Welcome to DOTC " + model.getArea() + " Navigator!\n" + "[1] Add Mobile App\n"
					+ "[2] Add Web App\n" + "[3] Update Northbound of a Road\n" + "[4] Update Southbound of a Road\n"
					+ "[5] Exit");
			input = Integer.valueOf(sc.next());
			switch (input) {
			case 1:
				this.attachObserver(new MobileApp(), "Mobile App");
			case 2:
				this.attachObserver(new WebApp(), "Web App");
			case 3:
				
			default:
				break;
			}
		} while (input != 5);
		sc.close();
	}
}