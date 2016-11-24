package ijp.assignment2;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
 
/**
 * The main program for launching a PictureViewer application.
 *
 * @author  Sibylle Sehl
 * @version Version 1, 15th Nov 2016
 */
public class MyApplication extends Application{
       


	@Override
	public void start(Stage stage){
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			String viewerFxml = "gui.fxml";
			AnchorPane page = (AnchorPane)fxmlLoader.load(
					this.getClass().getResource(viewerFxml).openStream());
			Scene scene = new Scene(page);
			stage.setScene(scene);
			stage.setResizable(false);
			
			MyController controller = (MyController) fxmlLoader.getController();
			controller.Initialise();
			
			stage.show();
		
		} catch (IOException ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
			System.exit(1);
		}
		
		
	}
	public static void main(String args[]){
		launch(args);
	}

}
