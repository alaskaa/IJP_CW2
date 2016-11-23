package ijp.assignment2;
import java.util.HashMap;

import javafx.scene.image.Image;

public class Location {
	

	private HashMap<Coordination, Location> exits;
	private Image[] picture;
	
	public Location() {
		exits = new HashMap<>();
		
	}
	
	
	public void setExit(Coordination direction, Location neighbour) {
		exits.put(direction, neighbour);
	}
	
	public Location getExit(Coordination direction){
		return exits.get(direction);
	}
	
	
	public void setImages(Image[] picture) {
		this.picture=picture;
	}
	
	public Image[] getImages() {
		return picture;
	}
	
}


	