package ijp.assignment2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MyController {
		
		private MapWorld world = new MapWorld();
		
		
		@FXML
		private ImageView imageView;


		private Image currentImage;
		
		
		//@FXML
		//private ImageView basketView;

		public void Initialise() {
			Image image = new Image("/pictures/loc1-north.png");
			imageView.setImage(image);
			
		}
		
		
		public void goForward(ActionEvent event) {
			world.goForward();
			currentImage = world.getImage();
			imageView.setImage(currentImage);
			
			//image needs to jump to next location, if there is one
			//from loc1 to lo2, etc.
			//otherwise you get an error message
		}
		
		public void turnLeft(ActionEvent event) {
			world.turnLeft();
			currentImage = world.getImage();
			imageView.setImage(currentImage);
			// image needs to load for new direction when the button is pressed
			
		}
		
		public void turnRight(ActionEvent event) {
			world.turnRight();
			currentImage = world.getImage();
			imageView.setImage(currentImage);
			// image needs to load for new direction when the button is pressed
		}
		
		
	}

