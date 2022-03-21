package eventosValidar;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;



public class TextDialogController {

	@FXML
	private Button botonMostrar;

	@FXML
	private TextField field;


	@FXML
	private void initialize() {
		TextInputDialog textDialog = new TextInputDialog();
		textDialog.setTitle("Ejemplo de diálogo");
		textDialog.setHeaderText("Diálogo para introducir un texto");
		

		botonMostrar.setOnAction(e -> {
			// Se incluye la respuesta del usuario un campo de tipo Text
			textDialog.showAndWait().ifPresent(response -> {
//				response = "";
//				
//				//UPPERCASE
//				textDialog.addEventFilter(KeyEvent.KEY_TYPED, (e) -> {				
//					if (Character.isUpperCase(e.getCharacter().charAt(0))) {
//						response += e.getCharacter();
//					}
//				});
				
				field.requestFocus();  //FOCUS
				field.setText(response);
			});
		}); 





	}


}
