package CFMProject.AddressBook2;

import java.util.List;
import java.util.Objects;

import javax.management.AttributeNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContactService {
	//General reference so it does nto need to be modified for different types of databases
		
	// interface 
	private final ContactRepository repository;
	
	//ContactRepository repository = new ContactRepository();
	
	/**
	 * @param repository
	 */
	public ContactService(ContactRepository repository) {
		this.repository = repository;
	}
	
	/**
	 * @return all contacts in the repository
	 */
	public List<Contact> findAll() {
		return repository.findAll();
	}
	
	
	//add a new Contact to the list
	/**
	 * @param contact is added to the repository
	 */
	public void add(Contact contact) {
		repository.save(contact);
	}
	
	//Delete a Contact from the list
	/**
	 * @param id
	 */
	public void deleteContacts(String id) {
		boolean exists = repository.existsById(id);
		if(!exists) {
			throw new IllegalStateException("Contact with ID " + id + " does not exist.");
		}
		else {
			repository.deleteById(id);
		}
	}

	/**
	 * @param id to find the contact by their id regarding update, delete and details buttons
	 * @return contact if found, otherwise return nothing
	 */
	public Contact findById(String id) {
		if(repository.existsById(id))
		{
			return repository.findById(id);
		}
		return null;
	}

	/** Save the contact after updates were made
	 * @param contact
	 * @throws AttributeNotFoundException
	 */
	public void updateContact(Contact contact) throws AttributeNotFoundException{
		repository.save(contact);
	}

	/** Saving a contact with updated parameters
	 * @param id
	 * @param fname
	 * @param lname
	 * @param phoneNumber
	 * @param email
	 * @param streetname
	 * @param city
	 * @param state
	 * @param postalcode
	 * @param country
	 */
	@Transactional
	public void updateContact(String id, String fname, String lname,String phoneNumber, String email,
			String streetname, String city, String state, String postalcode, String country) {
		// TODO Auto-generated method stub
		Contact contact = (Contact) repository.findById(id);
		if(fname != null && fname.length() > 0 && !Objects.equals(contact.getFname(), fname)) {
			contact.setFname(fname);
		}
		if(lname != null && lname.length() > 0 && !Objects.equals(contact.getLname(), lname)) {
			contact.setLname(lname);
		}
		if(phoneNumber != null && phoneNumber.length() > 0 && !Objects.equals(contact.getPhoneNumber(), phoneNumber)) {
			contact.setPhoneNumber(phoneNumber);
		}
		if(email != null && email.length() > 0 && !Objects.equals(contact.getEmail(), email)) {
			contact.setEmail(email);
		}
		if(streetname != null && streetname.length() > 0 && !Objects.equals(contact.getStreetname(), streetname)) {
			contact.setStreetname(streetname);
		}
		if(city != null && city.length() > 0 && !Objects.equals(contact.getCity(), city)) {
			contact.setCity(city);
		}
		if(state != null && state.length() > 0 && !Objects.equals(contact.getState(), state)) {
			contact.setState(state);
		}
		if(postalcode != null && postalcode.length() > 0 && !Objects.equals(contact.getPostalcode(), postalcode)) {
			contact.setPostalcode(state);
		}
		if(country != null && country.length() > 0 && !Objects.equals(contact.getCountry(), country)) {
			contact.setCountry(country);
		} 
	}

	/**
	 * @param keyword as the string to search for
	 * @return either the contact with the name matching keyword or all of the contacts if nothing was found
	 */
	public List<Contact> findByName(String keyword) {
		if(keyword != null) {
		return repository.findByName(keyword);
		}
		return repository.findAll();
	}
}
