package ijp.assignment2;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.image.Image;

/**
 * A location class that models the methods and fields for one particular
 * location.
 *
 * @author Sibylle Sehl
 * @version Version 3, 28th Nov 2016
 */
public class Location {

	private HashMap<Coordination, Location> exits;
	private Image[] picture;
	private ArrayList<Item> portableItems;

	public Location() {
		exits = new HashMap<>();
		portableItems = new ArrayList<>();
	}

	/**
	 * Sets the exits of a specific location
	 * 
	 * @param direction
	 *            the coordinate at which to find the exit
	 * @param neighbour
	 *            the neighbouring location at this exit
	 */
	public void setExit(Coordination direction, Location neighbour) {
		exits.put(direction, neighbour);
	}

	/**
	 * Returns the exit location at a specific location
	 * 
	 * @param direction
	 *            the coordinate at which to find the exit
	 * @return a specific location
	 */
	public Location getExit(Coordination direction) {
		return exits.get(direction);
	}

	/**
	 * Sets the 5 images for each direction and a map for a location
	 * 
	 * @param picture
	 *            an array of pictures for a location
	 */
	public void setImages(Image[] picture) {
		this.picture = picture;
	}

	/**
	 * Returns the pictures specific to a location. Can be accessed via index
	 * 
	 * @param picture
	 *            an array of pictures for a location
	 * @return returns an array of pictures specific to the location
	 */
	public Image[] getImages() {
		return picture;
	}

	/**
	 * Adds an item to a location
	 * 
	 * @param item
	 *            an item which can be found at this location
	 */
	public void addItemToLocation(Item item) {
		portableItems.add(item);
	}

	/**
	 * Removes an item from a location
	 * 
	 * @param item
	 *            an item which is currently at this location
	 */
	public void removeItemFromLocation(Item item) {
		portableItems.remove(item);
	}

	/**
	 * Returns true if the Location has the specified Item
	 * 
	 * @param item
	 *            an item at this location
	 * @return returns true if location holds this item
	 */
	public Boolean hasPortableItem(Item item) {
		return portableItems.contains(item);
	}

	/**
	 * Returns true if the Location has any Item
	 * 
	 * @param item
	 *            an item at this location
	 * @return returns true if location holds any item
	 */
	public Boolean hasAPortableItem() {
		return !portableItems.isEmpty();

	}

}
