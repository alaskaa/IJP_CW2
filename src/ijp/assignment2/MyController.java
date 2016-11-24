package ijp.assignment2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MyController {
		
		private MapWorld world = new MapWorld();
		private Image currentImage;
		
		
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
		private ImageView breadView;
		@FXML
		private ImageView catView;

		public void Initialise() {
			Image image = new Image("/pictures/loc1-north.png");
			imageView.setImage(image);
			Image map = new Image("/pictures/map.png");
			mapView.setImage(map);
			Image sword = new Image("/pictures/sword.png");
			swordView.setImage(sword);
			Image owl = new Image("/pictures/owl.png");
			owlView.setImage(owl);
			Image potion = new Image("/pictures/potion.png");
			potionView.setImage(potion);
			Image bread = new Image("/pictures/bread.png");
			breadView.setImage(bread);
			Image cat = new Image("/pictures/cat.png");
			catView.setImage(cat);
		}	
		
		public void goForward(ActionEvent event) {
			world.goForward();
			currentImage = world.getImage();
			imageView.setImage(currentImage);
			
		}
		
		public void turnLeft(ActionEvent event) {
			world.turnLeft();
			currentImage = world.getImage();
			imageView.setImage(currentImage);
			
		}
		
		public void turnRight(ActionEvent event) {
			world.turnRight();
			currentImage = world.getImage();
			imageView.setImage(currentImage);
		}
		
		
	}

