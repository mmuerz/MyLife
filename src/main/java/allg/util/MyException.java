package allg.util;

import model.user.User;

public class MyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -259180324971945352L;



	public MyException() {
		super();
	}

	public MyException(String message) {
		super(message);
	}

	public MyException(Throwable cause) {
		super(cause);
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public MyException(User aUser) {
		super(getLoginStatement(aUser).toString());
	}



	private static StringBuilder getLoginStatement(User aUser) {

		StringBuilder tmpReturn = new StringBuilder("Login");
		switch(aUser.getLanguage()){
		default:
		case "english":{
			tmpReturn.append(" of user: ");
			tmpReturn.append(aUser.toString());
			tmpReturn.append(" was unsuccessful! \n Cause:");
			break;
		}
		case "german":{
			tmpReturn.append(" des Benutzers: ");
			tmpReturn.append(aUser.toString());
			tmpReturn.append(" war nicht erfolgreich! \n Ursache:");
			break;
		}
		}
		return null;
	}

}
