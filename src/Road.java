
public class Road {
	private String name;
	private Direction northbound;
	private Direction southbound;

	class Direction {
		private TrafficCondition condition;
		private TrafficAdvisory advisory;
		
		public Direction() {
			this.condition = TrafficCondition.LIGHT;
			this.advisory = TrafficAdvisory.NONE;
		}

		public TrafficCondition getCondition() {
			return condition;
		}

		public void setCondition(TrafficCondition condition) {
			this.condition = condition;
		}

		public TrafficAdvisory getAdvisory() {
			return advisory;
		}

		public void setAdvisory(TrafficAdvisory advisory) {
			this.advisory = advisory;
		}

	}
	
	public Road() {
		name = "noname";
		northbound = new Direction();
		southbound = new Direction();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Direction getNorthbound() {
		return northbound;
	}

	public Direction getSouthbound() {
		return southbound;
	}
}
