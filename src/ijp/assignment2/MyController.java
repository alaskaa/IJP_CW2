package ijp.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.*;

public class MyController {

	private MapWorld world;
	private Image currentImage;
	private Image currentMapView;
	
	@FXML
	private ImageView imageView;
	@FXML
	private ImageView mapView;
	@FXML
	private ImageView swordView;
	@FXML
	private ImageView owlView;
	@FXML
	private ImageView potionView;
	@FXML
	private ImageView swordViewGame;
	@FXML
	private ImageView owlViewGame;
	@FXML
	private ImageView potionViewGame;

	@FXML
	private Button forward;
	@FXML
	private MenuItem pickSword;
	@FXML
	private MenuItem pickOwl;
	@FXML
	private MenuItem pickPotion;
	@FXML
	private MenuItem dropSword;
	@FXML
	private MenuItem dropOwl;
	@FXML
	private MenuItem dropPotion;
	

	public void Initialise() {
		Image image = new Image("/pictures/loc1-north.png");
		imageView.setImage(image);
		Image map = new Image("/pictures/map_loc1.png");
		world = new MapWorld();
		mapView.setImage(map);
		dropSword.setVisible(false);
		dropOwl.setVisible(false);
		dropPotion.setVisible(false);
		pickSword.setVisible(false);
		pickOwl.setVisible(false);
		pickPotion.setVisible(false);

	}

	public void goForward(ActionEvent event) {
		world.goForward();
		checkForItems();
		if (world.getNextLocation() == null) {
			currentImage = world.getImage();
			currentMapView = world.getCurrentMapView();
			mapView.setImage(currentMapView);
			imageView.setImage(currentImage);
			forward.setVisible(false);
		} else {
			currentImage = world.getImage();
			currentMapView = world.getCurrentMapView();
			mapView.setImage(currentMapView);
			imageView.setImage(currentImage);
			forward.setVisible(true);

		}

	}

	public void turnLeft(ActionEvent event) {
		world.turnLeft();
		currentImage = world.getImage();
		imageView.setImage(currentImage);
		if (world.getNextLocation() != null) {
			forward.setVisible(true);
		} else {
			forward.setVisible(false);
		}
	}

	public void turnRight(ActionEvent event) {
		world.turnRight();
		currentImage = world.getImage();
		imageView.setImage(currentImage);
		if (world.getNextLocation() != null) {
			forward.setVisible(true);
		} else {
			forward.setVisible(false);
		}
	}

	public void pickUpSword(ActionEvent event) {
		world.pickUpItem(world.getSwordItem());
		pickSword.setVisible(false);
		dropSword.setVisible(true);
		swordView.setImage(world.getSwordItem().getItemImage());
		swordViewGame.setVisible(false);
		swordView.setVisible(true);
	}

	public void dropSword(ActionEvent event) {
		world.dropItem(world.getSwordItem());
		pickSword.setVisible(true);
		dropSword.setVisible(false);
		swordViewGame.setVisible(true);
		swordView.setVisible(false);
	}

	public void pickUpOwl(ActionEvent event) {
		world.pickUpItem(world.getOwlItem());
		pickOwl.setVisible(false);
		dropOwl.setVisible(true);
		owlView.setImage(world.getOwlItem().getItemImage());
		owlViewGame.setVisible(false);
		owlView.setVisible(true);
	}

	public void dropOwl(ActionEvent event) {
		world.dropItem(world.getOwlItem());
		pickOwl.setVisible(true);
		dropOwl.setVisible(false);
		owlViewGame.setVisible(true);
		owlView.setVisible(false);
	}

	public void pickUpPotion(ActionEvent event) {
		world.pickUpItem(world.getPotionItem());
		pickPotion.setVisible(false);
		dropPotion.setVisible(true);
		potionView.setImage(world.getPotionItem().getItemImage());
		potionViewGame.setVisible(false);
		potionView.setVisible(true);
	}

	public void dropPotion(ActionEvent event) {
		world.dropItem(world.getPotionItem());
		pickPotion.setVisible(true);
		dropPotion.setVisible(false);
		potionViewGame.setVisible(true);
		potionView.setVisible(false);
	}

	public void checkForItems() {
		if (world.getCurrentLocation().hasPortableItem(world.getSwordItem())) {
			swordViewGame.setImage(world.getSwordItem().getItemImage());
			swordViewGame.setVisible(true);
			pickSword.setVisible(true);
		} else {
			pickSword.setVisible(false);
			swordViewGame.setVisible(false);
		}
		if (world.getCurrentLocation().hasPortableItem(world.getOwlItem())) {
			owlViewGame.setImage(world.getOwlItem().getItemImage());
			owlViewGame.setVisible(true);
			pickOwl.setVisible(true);
		} else {
			pickOwl.setVisible(false);
			owlViewGame.setVisible(false);
		}
		if (world.getCurrentLocation().hasPortableItem(world.getPotionItem())) {
			potionViewGame.setImage(world.getPotionItem().getItemImage());
			potionViewGame.setVisible(true);
			pickPotion.setVisible(true);
		} else {
			pickPotion.setVisible(false);
			potionViewGame.setVisible(false);
		}
	}
}
