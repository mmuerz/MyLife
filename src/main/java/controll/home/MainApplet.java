package controll.home;

public class MainApplet {

	private static MainApplet instance = null;

	public static MainApplet getInstance() {
		if (instance == null)
			instance = new MainApplet();
		return instance;
	}

	private MainApplet() {

	}

}
