package ijp.assignment2;

import java.util.ArrayList;

import javafx.scene.image.Image;

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

	public void turnLeft() {
		facing -= 1;
		if (facing < 0) {
			facing = 3;
		}
		updateCoordinates(facing);
		updatePicture();
		nextLoc = currentLocation.getExit(direction);

	}

	public void turnRight() {
		facing += 1;
		if (facing > 3) {
			facing = 0;
		}
		updateCoordinates(facing);
		updatePicture();
		nextLoc = currentLocation.getExit(direction);

	}

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

	public void updateMap() {
		currentMapView = currentLocation.getImages()[4];
	}

	public Image getImage() {
		return currentImage;
	}

	public Location getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}

	public Location getNextLocation() {
		return nextLoc;
	}

	public void pickUpItem(Item i) {
		if (currentLocation.hasPortableItem(i)) {
			currentLocation.removeItemFromLocation(i);
			inventory.add(i);
		}
	}

	public void dropItem(Item i) {
		if (currentLocation.hasPortableItem(i) == false) {
			inventory.remove(i);
			currentLocation.addItemToLocation(i);
		}
	}

	public Item getOwlItem() {
		return owlItem;
	}

	public Item getSwordItem() {
		return swordItem;
	}

	public Item getPotionItem() {
		return potionItem;
	}

	public Image getCurrentMapView() {
		return currentMapView;
	}

	public void setCurrentMapView(Image currentMapView) {
		this.currentMapView = currentMapView;
	}

}
