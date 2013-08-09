package myung.utility.simple.login.model;

public class UserInfo {
	private String _memberId;
	private String _password;
	private String _emailAddress;
	private String _name;

	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return _memberId;
	}

	/**
	 * @param memberId
	 *            the memberId to set
	 */
	public void setMemberId(String memberId) {
		this._memberId = memberId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return _password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this._password = password;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return _emailAddress;
	}

	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this._emailAddress = emailAddress;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return _name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this._name = name;
	}
	
}
