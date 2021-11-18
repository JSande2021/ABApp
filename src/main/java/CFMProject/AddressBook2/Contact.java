package CFMProject.AddressBook2;

/**
 * @author Joeseph Sande
 *
 */
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Contact")
public class Contact {

	@Id
	protected String id;
	
	protected String fname;
	protected String lname;
	protected String phoneNumber;
	protected String email;
	protected String streetname;
	protected String city;
	protected String state;
	protected String postalcode;
	protected String country;

	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param fname
	 * @param lname
	 * @param email
	 * @param phonenumber
	 * @param streetname
	 * @param city
	 * @param state
	 * @param postalcode
	 * @param country
	 */
	public Contact(String id, String fname, String lname, String phoneNumber, String email, String streetname,
			String city, String state, String postalcode, String country) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.streetname = streetname;
		this.city = city;
		this.state = state;
		this.postalcode = postalcode;
		this.country = country;

	}

	// default constructor 
	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param fname
	 * @param lname
	 * @param email
	 * @param phonenumber
	 * @param streetname
	 * @param city
	 * @param state
	 * @param postalcode
	 * @param country
	 */
	public Contact() {
		this.id = null;
		this.fname = "";
		this.lname = "";
		this.phoneNumber = "";
		this.email = "";
		this.streetname = "";
		this.city = "";
		this.state = "";
		this.postalcode = "";
		this.country = "";
	}

	// toString method to display contacts to user
	@Override
	public String toString() {
		return "Contact [ID=" + id + ", first name=" + fname + ", last name=" + lname + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", streetname=" + streetname + ", city=" + city + ", state=" + state
				+ ", postalcode=" + postalcode + ", country=" + country + "]";
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the streetname
	 */
	public String getStreetname() {
		return streetname;
	}

	/**
	 * @param streetname the streetname to set
	 */
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the postalcode
	 */
	public String getPostalcode() {
		return postalcode;
	}

	/**
	 * @param postalcode the postalcode to set
	 */
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

}
