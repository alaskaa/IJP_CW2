package ijp.assignment2;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.image.Image;

public class Location {

	private HashMap<Coordination, Location> exits;
	private Image[] picture;
	private ArrayList<Item> portableItems;

	public Location() {
		exits = new HashMap<>();
		portableItems = new ArrayList<>();
	}

	public void setExit(Coordination direction, Location neighbour) {
		exits.put(direction, neighbour);
	}

	public Location getExit(Coordination direction) {
		return exits.get(direction);
	}

	public void setImages(Image[] picture) {
		this.picture = picture;
	}

	public Image[] getImages() {
		return picture;
	}

	public void addItemToLocation(Item item) {
		portableItems.add(item);
	}

	public void removeItemFromLocation(Item item) {
		portableItems.remove(item);
	}

	public Boolean hasPortableItem(Item item) {
		return portableItems.contains(item);
	}

	public Boolean hasAPortableItem() {
		return !portableItems.isEmpty();

	}

	public ArrayList<Item> getAllItems() {
		return portableItems;
	}

}
