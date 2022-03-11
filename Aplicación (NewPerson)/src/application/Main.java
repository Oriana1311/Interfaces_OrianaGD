package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	 // ... AFTER THE OTHER VARIABLES ...

		/**
		 * The data as an observable list of Persons.
		 */
		private ObservableList<Person> personData = FXCollections.observableArrayList();

		/**
		 * Constructor
		 */
		public Main() {
			// Add some sample data
			personData.add(new Person("Hans", "Muster"));
			personData.add(new Person("Ruth", "Mueller"));
			personData.add(new Person("Heinz", "Kurz"));
			personData.add(new Person("Cornelia", "Meier"));
			personData.add(new Person("Werner", "Meyer"));
			personData.add(new Person("Lydia", "Kunz"));
			personData.add(new Person("Anna", "Best"));
			personData.add(new Person("Stefan", "Meier"));
			personData.add(new Person("Martin", "Mueller"));
		}
	  
		/**
		 * Returns the data as an observable list of Persons. 
		 * @return
		 */
		public ObservableList<Person> getPersonData() {
			return personData;
		}
	  
	    // ... THE REST OF THE CLASS ...
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AddressApp");
		initRootLayout();
		showPersonOverview();
	}
	/** Inicializa el dise�o de la pantalla principal. */
	public void initRootLayout() {
		try {
			// Carga el XML con el dise�o principal
			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(Main.class.getResource("RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			// Se a�ade el dise�o principal a la escena
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/** Muestra el dise�o de PersonOverview dentro de la pantalla
	principal */
	public void showPersonOverview() {
		try {
			 // Load person overview.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("PersonOverview.fxml"));
	        AnchorPane personOverview = (AnchorPane) loader.load();

	        // Set person overview into the center of root layout.
	        rootLayout.setCenter(personOverview);

	        // Give the controller access to the main app.
	        PersonOverviewController controller = loader.getController();
	        controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean showPersonEditDialog(Person person) {
	    try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("PersonEditDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Person");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Set the person into the controller.
	        PersonEditDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setPerson(person);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	/** Returns the main stage. */
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
