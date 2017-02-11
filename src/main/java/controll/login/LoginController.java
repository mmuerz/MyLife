package controll.login;


import controll.MainApplet;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * This class defines the logic for logging in and out of
 * <p>
 * MyLife &trade;
 * <p>
 * 
 * @author mmuerz
 *
 */
public class LoginController {

	private MainApplet mainApp = null;
	@FXML
	private TextField loginName = null;
	@FXML
	private Label loginNameLabel = null;
	@FXML
	private Label passWortLabel = null;
	@FXML
	private TextField passWort = null;
	@FXML
	private Button btnLogin = null;
	@FXML
	private Button btnCancel = null;

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		mainApp = MainApplet.getInstance();
		switch (mainApp.getLanguage()) {

		case "German": {
			// Initialize Labels in German
			loginNameLabel.setText("Login Name");
			passWortLabel.setText("Passwort");
			btnLogin.setText("Einloggen");
			btnCancel.setText("Abbrechen");
			break;
		}
		// Initialize Labels in English
		case "English": 
		default: {
			loginNameLabel.setText("Loginname");
			passWortLabel.setText("password");
			btnLogin.setText("Login");
			btnCancel.setText("Cancel");
		}
		}

		// Clear Textfields details.
		clearAll();

	}

	/**
	 * 
	 */
	@FXML
	public void handleOK(){
		
	}
	/**
	 * 
	 */
	@FXML
	public void handleCancel(){
		clearAll();
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApplet mainApp) {
		this.mainApp = mainApp;

	}
	
	private void clearAll(){

		// Clear Textfields details.
		loginName.setText("");
		passWort.setText("");
	}
	
}
