
package ijp.assignment2;

public class MapWorld {

	private Coordination direction;
	private Location currentLocation;
	
	public MapWorld() {
		createLocations();
	}
	
	private void createLocations() {
		Location loc1, loc2, loc3, loc4, loc5, loc6, loc7;
		
		loc1 = new Location("initial location");
		loc2 = new Location("second location");
		loc3 = new Location("third location");
		loc4 = new Location("fourth location");
		loc5 = new Location("fifth location");
		loc6 = new Location("sixth location");
		loc7 = new Location("seventh location");
		
		loc1.setExit(Coordination.NORTH, loc2);
		loc2.setExit(Coordination.EAST, loc4);
		loc2.setExit(Coordination.WEST, loc3);
		loc2.setExit(Coordination.SOUTH, loc1);
		loc3.setExit(Coordination.EAST, loc2);
		loc4.setExit(Coordination.WEST, loc2);
		loc4.setExit(Coordination.EAST, loc5);
		loc5.setExit(Coordination.WEST, loc4);
		loc5.setExit(Coordination.SOUTH, loc6);
		loc6.setExit(Coordination.NORTH, loc5);
		loc6.setExit(Coordination.SOUTH, loc7);
		loc7.setExit(Coordination.NORTH, loc6);
		
	
	currentLocation = loc1;
	}
	
	public void goForward(){
		Location nextLocation = currentLocation.getExit(direction);
		
		if(nextLocation == null) {
			System.out.println("You can't go here");
		}
		else {
			currentLocation = nextLocation;
			
		}
		
	}
	
	public void turnLeft() {
		
		Coordination direction = Coordination.NORTH;
		//needs changed - how do we initialise this
		
		switch(direction) {
			case NORTH:
				direction = Coordination.WEST;
				break;

			case WEST:
				direction = Coordination.SOUTH;
				break;

			case SOUTH:
				direction = Coordination.EAST;
				break;

			case EAST:
				direction = Coordination.NORTH;
				break;
		}
	}
	
	public void turnRight() {

		Coordination direction = Coordination.NORTH;

		switch (direction) {
			case NORTH:
				direction = Coordination.EAST;
				break;

			case WEST:
				direction = Coordination.NORTH;
				break;

			case SOUTH:
				direction = Coordination.WEST;
				break;

			case EAST:
				direction = Coordination.SOUTH;
				break;

		}
	}
		
		
	
}
