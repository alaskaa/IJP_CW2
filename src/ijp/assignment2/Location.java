package ijp.assignment2;
import java.util.HashMap;

public class Location {
	

	private HashMap<Coordination, Location> exits;
	private String description;
	
	
	//initial constructor
	public Location(String description) {
		this.description = description;
		exits = new HashMap<>();
	}
	
	
	public void setExit(Coordination direction, Location neighbour) {
		exits.put(direction, neighbour);
	}
	
	public Location getExit(Coordination direction){
		return exits.get(direction);
	}
	
	public String getDescription() {
		return description;
	}
	
	
}


	