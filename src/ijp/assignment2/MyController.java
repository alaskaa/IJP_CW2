package ijp.assignment2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MyController {
		
		@FXML
		private ImageView imageView;
		
		@FXML
		private ImageView basketView;

		public void Initialise() {
			Image image = new Image("/pictures/loc1-front.png");
			imageView.setImage(image);
		}
		
		public void sayHello(ActionEvent event) {
			System.out.println("Hello");
		}
		
		public void goForward(ActionEvent event) {
			MapWorld world = new MapWorld();
			world.goForward();
		}
		
		public void turnLeft(ActionEvent event) {
			MapWorld world = new MapWorld();
			world.turnLeft();
			// call to MapWorld
		}
		
		public void turnRight(ActionEvent event) {
			MapWorld world = new MapWorld();
			world.turnRight();
			
		}
	}

