package model.user;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * is serializable through {@link #userID}
 * 
 * @author mmuerz
 *
 */
@SuppressWarnings("serial") // is serializable through userID
public class User implements Serializable {

	/**
	 * unique per user, primary databasekey
	 */
	private BigDecimal userID = null;
	private String firstName = "";
	private String surName = "";
	private String middleName = "";
	private String title = "";

	private String loginName = "";
	private Date birthdate = null;

	private String language = null;

	public User() {
		super();
	}

	public User(BigDecimal userID, String firstName, String surName, String middleName, String title, String loginName,
			Date birthdate, String language) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.surName = surName;
		this.middleName = middleName;
		this.title = title;
		this.loginName = loginName;
		this.birthdate = birthdate;
		this.language = language;
	}

	public BigDecimal getUserID() {
		return userID;
	}

	public void setUserID(BigDecimal userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String printHelloMsg() {

		StringBuilder helloMsg = new StringBuilder("");
		switch (language) {
		default:
		case "english": {
			helloMsg.append("Hello ");
			break;
			}
		case "german": {
			helloMsg.append("Hallo ");
			break;
			}
		}
			helloMsg.append(firstName);
			helloMsg.append(" ");
			helloMsg.append(surName);
			helloMsg.append("!");

		return helloMsg.toString();
	}

	/**
	 * @return {@link String} Representation of a {@link User} Objekt.
	 */
	@Override
	public String toString() {

		StringBuilder tmpReturn = new StringBuilder("");
		switch (language) {
		default:
		case "english": {
			tmpReturn.append("user: id: <");
			tmpReturn.append(userID.toString());
			tmpReturn.append("> loginname: <");
			tmpReturn.append(loginName);
			tmpReturn.append(">, surname: <");
			tmpReturn.append(surName);
			tmpReturn.append("> firstname: <");
			tmpReturn.append(firstName);
			tmpReturn.append("> language: <");
			tmpReturn.append(language);
			tmpReturn.append(">");
			break;
		}
		case "german": {
			tmpReturn.append("Benutzer: ID: <");
			tmpReturn.append(userID.toString());
			tmpReturn.append("> Login-Name: <");
			tmpReturn.append(loginName);
			tmpReturn.append(">, Nachname: <");
			tmpReturn.append(surName);
			tmpReturn.append("> Vorname: <");
			tmpReturn.append(firstName);
			tmpReturn.append("> Sprache: <");
			tmpReturn.append("Deutsch");
			tmpReturn.append(">");
			break;
		}
		}
		tmpReturn.append("");

		return tmpReturn.toString();
	}

}
