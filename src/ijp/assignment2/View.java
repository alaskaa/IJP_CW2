package ijp.assignment2;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class View {
	
	@FXML
	private ImageView imageView;
	
	@FXML
	private ImageView basketView;

	public void Initialise() {
		Image image = new Image("witcher3.jpg");
		imageView.setImage(image);
	}
}
