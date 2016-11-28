package ijp.assignment2;

import java.util.ArrayList;

import javafx.scene.image.Image;

/**
 * The MapWorld class models the world as a whole including the Locations and
 * the functions a user needs to perform navigating in it.
 *
 * @author Sibylle Sehl
 * @version Version 3, 28th Nov 2016
 */
public class MapWorld {

	private Coordination direction;
	private Location currentLocation;
	private Location nextLoc;
	private Image currentImage;
	private Image currentMapView;
	private int facing;
	private ArrayList<Item> inventory;

	private Location loc1;
	private Location loc2;
	private Location loc3;
	private Location loc4;
	private Location loc5;
	private Location loc6;
	private Location loc7;

	private Item swordItem = new Item(new Image("/pictures/sword.png"));
	private Item owlItem = new Item(new Image("/pictures/owl.png"));
	private Item potionItem = new Item(new Image("/pictures/potion.png"));

	public MapWorld() {
		createLocations();
		inventory = new ArrayList<Item>();
		facing = 0;
		updateCoordinates(facing);
	}

	/**
	 * Creates the Location objects, sets the images, sets exits and adds items
	 * to three locations.
	 */
	private void createLocations() {

		loc1 = new Location();
		loc1.setImages(fillLocations("1"));
		loc2 = new Location();
		loc2.setImages(fillLocations("2"));
		loc3 = new Location();
		loc3.setImages(fillLocations("3"));
		loc3.addItemToLocation(owlItem);
		loc4 = new Location();
		loc4.setImages(fillLocations("4"));
		loc5 = new Location();
		loc5.setImages(fillLocations("5"));
		loc5.addItemToLocation(swordItem);
		loc6 = new Location();
		loc6.setImages(fillLocations("6"));
		loc7 = new Location();
		loc7.setImages(fillLocations("7"));
		loc7.addItemToLocation(potionItem);

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

		setCurrentLocation(loc1);

	}

	/**
	 * Adds pictures for each location and its directions to an array
	 * 
	 * @param num
	 *            the number associated with each location (1st, 2nd...)
	 * 
	 * @returns an array of images for each location including each coordinate
	 *          picture and a map
	 */
	public Image[] fillLocations(String num) {

		String n = "/pictures/loc" + num + "-north.png";
		String e = "/pictures/loc" + num + "-east.png";
		String s = "/pictures/loc" + num + "-south.png";
		String w = "/pictures/loc" + num + "-west.png";
		String m = "/pictures/map_loc" + num + ".png";
		Image imageN = new Image(n);
		Image imageE = new Image(e);
		Image imageS = new Image(s);
		Image imageW = new Image(w);
		Image imageM = new Image(m);
		Image[] pictures = { imageN, imageE, imageS, imageW, imageM };
		return pictures;
	}

	/**
	 * Go a step forward in the logical map, enter a new location if
	 * currentLocation has a new exit
	 */
	public void goForward() {
		Location nextLocation = currentLocation.getExit(direction);

		if (nextLocation == null) {

		} else {
			currentLocation = nextLocation;
			updatePicture();
			updateMap();
			nextLoc = currentLocation.getExit(direction);

		}

	}

	/**
	 * Turn left in the logical map
	 */
	public void turnLeft() {
		facing -= 1;
		if (facing < 0) {
			facing = 3;
		}
		updateCoordinates(facing);
		updatePicture();
		nextLoc = currentLocation.getExit(direction);

	}

	/**
	 * Turn right in the logical map
	 */
	public void turnRight() {
		facing += 1;
		if (facing > 3) {
			facing = 0;
		}
		updateCoordinates(facing);
		updatePicture();
		nextLoc = currentLocation.getExit(direction);

	}

	/**
	 * Updates the direction based on the specified integer value of facing
	 * 
	 * @param facing
	 *            a value indicating which direction one is currently looking at
	 */
	public void updateCoordinates(int facing) {
		switch (facing) {
		case 0:
			direction = Coordination.NORTH;
			break;
		case 1:
			direction = Coordination.EAST;
			break;
		case 2:
			direction = Coordination.SOUTH;
			break;
		case 3:
			direction = Coordination.WEST;
			break;

		}
	}

	/**
	 * Updates the current image for a location based on the facing value and
	 * accesses the location's picture at fixed position in array
	 */
	public void updatePicture() {
		if (facing == 0) {
			currentImage = currentLocation.getImages()[0];
		} else if (facing == 1) {
			currentImage = currentLocation.getImages()[1];
		} else if (facing == 2) {
			currentImage = currentLocation.getImages()[2];
		} else {
			currentImage = currentLocation.getImages()[3];
		}
	}

	/**
	 * Updates the map based on the currentLocation and retrieves the image from
	 * last index in each location's image array
	 */
	public void updateMap() {
		currentMapView = currentLocation.getImages()[4];
	}

	/**
	 * Returns the the image the user currently looking at, which was updated in
	 * the updatePicture() method
	 * 
	 * @returns the current image the user is looking at
	 */
	public Image getImage() {
		return currentImage;
	}

	/**
	 * Returns the location the user is currently in
	 * 
	 * @returns the current location
	 */
	public Location getCurrentLocation() {
		return currentLocation;
	}

	/**
	 * Sets the currentLocation; mutator method included for completeness
	 * 
	 * @param currentLocation
	 *            the current location the user is in
	 */
	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}

	/**
	 * Retrieves a new location at an exit
	 * 
	 * @returns the next location
	 */
	public Location getNextLocation() {
		return nextLoc;
	}

	/**
	 * Picking up an item in the world; removing it from currentLocation and
	 * adding it to the inventory
	 * 
	 * @param i
	 *            a specific item found at the location
	 */
	public void pickUpItem(Item i) {
		if (currentLocation.hasPortableItem(i)) {
			currentLocation.removeItemFromLocation(i);
			inventory.add(i);
		}
	}

	/**
	 * Dropping an item in the world; removing it from the inventory and adding
	 * it to the currentLocation
	 * 
	 * @param i
	 *            a specific item in the inventory
	 */
	public void dropItem(Item i) {
		if (currentLocation.hasPortableItem(i) == false) {
			inventory.remove(i);
			currentLocation.addItemToLocation(i);
		}
	}

	/**
	 * Accessor method to access the Owl Item in Controller
	 * 
	 * @returns the owl Item
	 */
	public Item getOwlItem() {
		return owlItem;
	}

	/**
	 * Accessor method to access the Sword Item in Controller
	 * 
	 * @returns the sword Item
	 */
	public Item getSwordItem() {
		return swordItem;
	}

	/**
	 * Accessor method to access the Potion Item in Controller
	 * 
	 * @returns the potion Item
	 */
	public Item getPotionItem() {
		return potionItem;
	}

	/**
	 * Retrieves the map image in the world
	 * 
	 * @returns the image of the map based on logical map location
	 */
	public Image getCurrentMapView() {
		return currentMapView;
	}

	/**
	 * Sets the current MapView to a specified image
	 * 
	 * @param an
	 *            image for the current view of the map
	 */
	public void setCurrentMapView(Image currentMapView) {
		this.currentMapView = currentMapView;
	}

}
