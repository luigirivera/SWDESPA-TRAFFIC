import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class AdminMenu {
	private TrafficSubject model;
	private Scanner sc;
	
	public AdminMenu(TrafficSubject model) {
		this.model = model;
		
		List<Road> roads = new ArrayList<Road>();
		roads.add(new Road("Osmena Boulevard"));
		roads.add(new Road("Colon"));
		roads.add(new Road("V. Rama"));
		roads.add(new Road("Marcelo Fernan Bridge"));
		roads.add(new Road("Mactan-Mandaue Bridge"));
		
		model.setState(roads);
		
	}
	
	private void attachObserver(TrafficObserver to, String label) {
		model.attach(to);
		System.out.println(label + " " + to.getNumber() + " was added!");
	}

	private void updateRoad(Road r) {
		List<Road> roads = model.getState();
		
		for(int i=0; i<roads.size(); i++)
			if(roads.get(i).getName().equals(r.getName()))
				roads.set(i,r);
			
		model.setState(roads);
	}
	
	private Road chooseRoad(){
		int roadNumber=1;
		int choice;
		
		System.out.println("\n");
		for(Road road : model.getState()){
			System.out.println("[" + roadNumber + "]" + " " + road.getName());
			roadNumber++;
		}
		choice = Integer.valueOf(sc.next());

		//we need exception handling here for out of bounds - Luigi  <---------------------------------
		return model.getState().get((choice-1));
	}
	
	private void updateCondition(Direction d){
		int input;
		
		System.out.println("\nHow is the traffic?\n" + "[1] Light\n" + 
							"[2] Medium\n" + "[3] Heavy");
		input = Integer.valueOf(sc.next());
		
		switch(input){
			case 1: d.setCondition(TrafficCondition.LIGHT);
				break;
			case 2: d.setCondition(TrafficCondition.MEDIUM);
				break;
			case 3: d.setCondition(TrafficCondition.HEAVY);
				break;
			default: System.out.println("Invalid input. Going back");
				break;
		}
	}
	
	private void updateAdvisory(Direction d){
		int input;
		
		System.out.println("\nWhat is the situation?\n" + "[1] Accident\n" + 
							"[2] Flood\n" + "[3] Repair\n" + "[4] Blocking\n" + "[5] NONE");
		input = Integer.valueOf(sc.next());
		
		switch(input){
			case 1: d.setAdvisory(TrafficAdvisory.ACCIDENT);
				break;
			case 2: d.setAdvisory(TrafficAdvisory.FLOOD);
				break;
			case 3: d.setAdvisory(TrafficAdvisory.REPAIR);
				break;
			case 4: d.setAdvisory(TrafficAdvisory.BLOCKING);
				break;
			case 5: d.setAdvisory(TrafficAdvisory.NONE);
				break;
			default: System.out.println("Invalid input. Going back");
				break;
		}		
	}
	
	private void updateDirection(Direction d) {
		int input;
		System.out.println("\nWhat information?\n" + "[1] Traffic Condition\n" + 
							"[2] Traffic Advisory");
		input = Integer.valueOf(sc.next());
		
		switch(input){
			case 1: 
				this.updateCondition(d);
				break;
			case 2: 
				this.updateAdvisory(d);
				break;
			default: System.out.println("Invalid input. Going back");
				break;
		}
	}

	public void start() {
		Road newRoad;
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
				break;
			case 2:
				this.attachObserver(new WebApp(), "Web App");
				break;
			case 3:
				System.out.println("\nWhat NB Road?");
				newRoad = chooseRoad();
				this.updateDirection(newRoad.getNorthbound());
				updateRoad(newRoad);
				break;
			case 4:
				System.out.println("\nWhat SB Road?");
				newRoad = chooseRoad();
				this.updateDirection(newRoad.getSouthbound());
				updateRoad(newRoad);
				break;
			case 5: 
				break;
			default: System.out.println("Invalid input");
				break;
			}
			System.out.println("\n");
			newRoad = null;
		} while (input != 5);
		sc.close();
	}
}