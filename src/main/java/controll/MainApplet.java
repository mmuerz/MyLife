package controll;

import java.io.IOException;

import allg.util.MyException;
import controll.login.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.user.User;

public class MainApplet extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	private static MainApplet instance = null;
	private static User user = null;
	private String language = "English";

	public String getLanguage() {
		return language;
	}

	public static MainApplet getInstance() {
		if (instance == null)
			instance = new MainApplet();
		return instance;
	}

	private MainApplet() {

	}


	public static void main(String[] args) {
		launch(args);
	}
	
	public void doLogin() throws MyException {
		if (!validUser(user)) {
			throw new MyException(user);
		}
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApplet.class.getResource("../view/home/HomeScene.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle(user.printHelloMsg());
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();
			// return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean validUser(User user2) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApplet.class.getResource("../view/login/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage arg0) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("MyLife");

		this.primaryStage.getIcons().add(new Image("file:ressources/AddBooIcon.png"));

		initRootLayout();
		showLoginScene();

	}

	/**
	 * Shows the person overview inside the root layout.
	 */
	public void showLoginScene() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApplet.class.getResource("../view/login/LoginScene.fxml"));
			AnchorPane loginScene = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(loginScene);

			// Give the controller access to the main app.
			LoginController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
