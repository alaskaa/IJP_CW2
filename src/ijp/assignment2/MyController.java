package ijp.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.*;

/**
 * The Controller class that is hooked up to the fxml file and controls it.
 *
 * @author Sibylle Sehl
 * @version Version 3, 28th Nov 2016
 */
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

	/**
	 * Initialises the first view visible in the location and initialises an
	 * object of the world
	 */
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

	/**
	 * Fulfils the actions that need to be performed in the GUI when the forward
	 * button is pressed
	 * 
	 * @param event
	 *            the Action event is hooked up to the gui.fxml "Forward" button
	 */
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

	/**
	 * Fulfils the actions that need to be performed in the GUI when the turn
	 * left button is pressed
	 * 
	 * @param event
	 *            the Action event is hooked up to the gui.fxml "Turn left"
	 *            button
	 */
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

	/**
	 * Fulfils the actions that need to be performed in the GUI when the turn
	 * right button is pressed
	 * 
	 * @param event
	 *            the Action event is hooked up to the gui.fxml "Turn right"
	 *            button
	 */
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

	/**
	 * Fulfils the actions that need to be performed in the GUI when Sword is
	 * picked up; including disabling the visibility of the picking up the menu
	 * item
	 * 
	 * @param event
	 *            the Action event is hooked up to the gui.fxml Pick up Menu for
	 *            a Sword
	 */
	public void pickUpSword(ActionEvent event) {
		world.pickUpItem(world.getSwordItem());
		pickSword.setVisible(false);
		dropSword.setVisible(true);
		swordView.setImage(world.getSwordItem().getItemImage());
		swordViewGame.setVisible(false);
		swordView.setVisible(true);
	}

	/**
	 * Fulfils the actions that need to be performed in the GUI when the sword
	 * is dropped; including disabling the visibility of the drop the sword menu
	 * item and enabling the pick sword menu item.
	 * 
	 * @param event
	 *            the Action event is hooked up to the gui.fxml Drop Menu for a
	 *            sword
	 */
	public void dropSword(ActionEvent event) {
		world.dropItem(world.getSwordItem());
		pickSword.setVisible(true);
		dropSword.setVisible(false);
		swordViewGame.setVisible(true);
		swordView.setVisible(false);
	}

	/**
	 * Fulfils the actions that need to be performed in the GUI when the owl is
	 * picked up; including disabling the visibility of the pick up the owl menu
	 * item
	 * 
	 * @param event
	 *            the Action event is hooked up to the gui.fxml Pick up Menu for
	 *            an owl
	 */
	public void pickUpOwl(ActionEvent event) {
		world.pickUpItem(world.getOwlItem());
		pickOwl.setVisible(false);
		dropOwl.setVisible(true);
		owlView.setImage(world.getOwlItem().getItemImage());
		owlViewGame.setVisible(false);
		owlView.setVisible(true);
	}

	/**
	 * Fulfils the actions that need to be performed in the GUI when the owl is
	 * dropped; including disabling the visibility of the drop the owl menu item
	 * and enabling the pick owl menu item.
	 * 
	 * @param event
	 *            the Action event is hooked up to the gui.fxml Drop Menu for an
	 *            owl
	 */
	public void dropOwl(ActionEvent event) {
		world.dropItem(world.getOwlItem());
		pickOwl.setVisible(true);
		dropOwl.setVisible(false);
		owlViewGame.setVisible(true);
		owlView.setVisible(false);
	}

	/**
	 * Fulfils the actions that need to be performed in the GUI when the potion
	 * is picked up; including disabling the visibility of the pick up the
	 * potion menu item
	 * 
	 * @param event
	 *            the Action event is hooked up to the gui.fxml Pick up Menu for
	 *            a potion
	 */
	public void pickUpPotion(ActionEvent event) {
		world.pickUpItem(world.getPotionItem());
		pickPotion.setVisible(false);
		dropPotion.setVisible(true);
		potionView.setImage(world.getPotionItem().getItemImage());
		potionViewGame.setVisible(false);
		potionView.setVisible(true);
	}

	/**
	 * Fulfils the actions that need to be performed in the GUI when the potion
	 * is dropped; including disabling the visibility of the drop the potion
	 * menu item and enabling the pick potion menu item.
	 * 
	 * @param event
	 *            the Action event is hooked up to the gui.fxml Drop Menu for a
	 *            potion
	 */
	public void dropPotion(ActionEvent event) {
		world.dropItem(world.getPotionItem());
		pickPotion.setVisible(true);
		dropPotion.setVisible(false);
		potionViewGame.setVisible(true);
		potionView.setVisible(false);
	}

	/**
	 * Complex method to check whether the currentLocation contains a Sword, Owl
	 * or Potion. Sets the inGame views and menu item views accordingly. Called
	 * whenever going forward.
	 */
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
