package CFMProject.AddressBook2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Joeseph Sande
 *
 */

@SpringBootApplication
public class AddressBookApplication {

	/**
	 * 
	 * @param args runs the Spring Boot Application at the localhost port 27016
	 */
	// http://www.localhost:27016/Contact/login
	public static void main(String[] args) {
		SpringApplication.run(AddressBookApplication.class, args);
	}
	
}
