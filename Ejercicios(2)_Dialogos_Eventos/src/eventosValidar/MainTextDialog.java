package eventosValidar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static javafx.scene.input.KeyCode.ENTER;
import static javafx.scene.input.KeyCode.ESCAPE;


public class MainTextDialog extends Application {

	private AnchorPane ventana;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainTextDialog.class.getResource("TextDialog.fxml"));
		ventana = (AnchorPane) loader.load();

		Scene scene = new Scene(ventana);
		
		//ENTER Y ESCAPE

//		scene.setOnKeyReleased((KeyEvent keyEvent) -> {
//			System.out.println(" -> " + keyEvent.getCode().toString( ));
//
//			if(keyEvent.getCode() == ENTER) {
//				keyEvent.consume();
//			}
//		});
//		scene.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent keyEvent) -> {
//			if (keyEvent.getCode() == ESCAPE) {
//      //       field.requestFocus(); //FOCUS
//
//			}
//
//		});

		stage.setTitle("Ejemplo TextDialog");
		stage.setScene(scene);
		stage.show();
	}

}
