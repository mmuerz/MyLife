package view.root;

import controll.MainApplet;
import javafx.fxml.FXML;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 * 
 * @author MMuerz
 */
public class RootLayoutController {

	// Reference to the main application
	private static RootLayoutController instance;
	private MainApplet mainApp = MainApplet.getInstance();

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApplet(MainApplet mainApp) {
		this.mainApp = mainApp;
	}

	/**
	 * Creates an empty address book.
	 */
	@FXML
	private void handleNew() {
		if (mainApp != null) {
		}
	}

	public static RootLayoutController getInstance() {
		if (instance == null)
			instance = new RootLayoutController();
		return instance;
	}
}
