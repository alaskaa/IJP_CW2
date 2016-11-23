
package ijp.assignment2;

import javafx.scene.image.Image;

public class MapWorld {

	private Coordination direction;
	private Location currentLocation;
	private Image currentImage;

	private int facing;
	private Location loc1;
	private Location loc2;
	private Location loc3;
	private Location loc4;
	private Location loc5;
	private Location loc6;
	private Location loc7;

	public MapWorld() {
		createLocations();
		facing = 0;
		updateDir(facing);
	}

	private void createLocations() {

		loc1 = new Location();
		fillLocation1();
		loc2 = new Location();
		fillLocation2();
		loc3 = new Location();
		fillLocation3();
		loc4 = new Location();
		fillLocation4();
		loc5 = new Location();
		fillLocation5();
		loc6 = new Location();
		fillLocation6();
		loc7 = new Location();
		fillLocation7();

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


	public void updateDir(int facing) {
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

	public Image getImage() {
		return currentImage;
	}
	
	public void goForward() {
		Location nextLocation = currentLocation.getExit(direction);

		if (nextLocation == null) {
			System.out.println("You can't go here");
		} else {
			currentLocation = nextLocation;
			System.out.println(currentLocation.toString());
			updatePicture();

		}

	}

	public void turnLeft() {
		facing -= 1;
		if (facing < 0) {
			facing = 3;
		}
		updateDir(facing);
		updatePicture();
		System.out.println(facing);
	}

	public void turnRight() {
		facing += 1;
		if (facing > 3) {
			facing = 0;
		}
		updateDir(facing);
		updatePicture();
		System.out.println(facing);
	}

	public Location getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}

	public void fillLocation1() {
		Image imageN = new Image("/pictures/loc1-north.png");
		Image imageE = new Image("/pictures/loc1-east.png");
		Image imageS = new Image("/pictures/loc1-south.png");
		Image imageW = new Image("/pictures/loc1-west.png");
		Image[] pictures1 = { imageN, imageE, imageS, imageW };
		loc1.setImages(pictures1);

	}

	public void fillLocation2() {
		Image imageN = new Image("/pictures/loc2-north.png");
		Image imageE = new Image("/pictures/loc2-east.png");
		Image imageS = new Image("/pictures/loc2-south.png");
		Image imageW = new Image("/pictures/loc2-west.png");
		Image[] pictures2 = { imageN, imageE, imageS, imageW };
		loc2.setImages(pictures2);

	}

	public void fillLocation3() {
		Image imageN = new Image("/pictures/loc3-north.png");
		Image imageE = new Image("/pictures/loc3-east.png");
		Image imageS = new Image("/pictures/loc3-south.png");
		Image imageW = new Image("/pictures/loc3-west.png");
		Image[] pictures3 = { imageN, imageE, imageS, imageW };
		loc3.setImages(pictures3);

	}

	public void fillLocation4() {
		Image imageN = new Image("/pictures/loc4-north.png");
		Image imageE = new Image("/pictures/loc4-east.png");
		Image imageS = new Image("/pictures/loc4-south.png");
		Image imageW = new Image("/pictures/loc4-west.png");
		Image[] pictures4 = { imageN, imageE, imageS, imageW };
		loc4.setImages(pictures4);

	}

	public void fillLocation5() {
		Image imageN = new Image("/pictures/loc5-north.png");
		Image imageE = new Image("/pictures/loc5-east.png");
		Image imageS = new Image("/pictures/loc5-south.png");
		Image imageW = new Image("/pictures/loc5-west.png");
		Image[] pictures5 = { imageN, imageE, imageS, imageW };
		loc5.setImages(pictures5);
	}

	public void fillLocation6() {
		Image imageN = new Image("/pictures/loc6-north.png");
		Image imageE = new Image("/pictures/loc6-east.png");
		Image imageS = new Image("/pictures/loc6-south.png");
		Image imageW = new Image("/pictures/loc6-west.png");
		Image[] pictures6 = { imageN, imageE, imageS, imageW };
		loc6.setImages(pictures6);

	}

	public void fillLocation7() {
		Image imageN = new Image("/pictures/loc7-north.png");
		Image imageE = new Image("/pictures/loc7-east.png");
		Image imageS = new Image("/pictures/loc7-south.png");
		Image imageW = new Image("/pictures/loc7-west.png");
		Image[] pictures7 = { imageN, imageE, imageS, imageW };
		loc7.setImages(pictures7);

	}

}
