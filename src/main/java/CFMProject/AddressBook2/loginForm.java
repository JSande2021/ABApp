package CFMProject.AddressBook2;

/**
 * @author Joeseph Sande
 *
 */

public class loginForm {

	private String username;
	private String password;

	/**
	 * 
	 * @param username
	 * @param password
	 */
	public loginForm(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	/**
	 * 
	 */
	public loginForm() {
		this.username = "admin";
		this.password = "admin";
	}

	/**
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
