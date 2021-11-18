package CFMProject.AddressBook2;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Joeseph Sande
 *
 */

@Repository
public interface ContactRepository extends MongoRepository<Contact, Integer> {

	/**
	 * @param keyword
	 * @return contacts with keyword if found
	 */
	@Query("{$or:[{'fname' : ?0},{lname:?0}]}")
	public List<Contact> findByName(String keyword);
	
	/**
	 * @param contact
	 * @return contacts with first name if found
	 */
	//@Query("SELECT s FROM Contact s WHERE s.fname =?1")
	@Query("{'fname' : ?0}")
	Optional<Contact> findContactByfname(String fname);
	

	/**
	 * @param contact
	 * @return contacts with last name if found
	 */
	@Query("SELECT s FROM Contact s WHERE s.lname = ?1")
	Optional<Contact> findContactBylname(String lname);

	/**
	 * @param contact
	 * @return contacts with phone number if found
	 */
	@Query("SELECT s FROM Contact s WHERE s.phoneNumber = ?1")
	Optional<Contact> findContactByPhonNumber(String phoneNumber);

	/**
	 * @param contact
	 * @return contacts with email if found
	 */
	@Query("SELECT s FROM Contact s WHERE s.email = ?1")
	Optional<Contact> findContactByEmail(String email);

	/**
	 * @param contact
	 * @return contacts with street name if found
	 */
	@Query("SELECT s FROM Contact s WHERE s.streetName = ?1")
	Optional<Contact> findContactByStreetName(String streetName);

	/**
	 * @param contact
	 * @return all contacts in the list
	 */
	List<Contact> findAll(Sort sort);

	/**
	 * @param contact
	 * @return contact if found by id
	 */
	Contact findById(String iD);

	/**
	 * @param contact
	 * @return true or false if contact exists
	 */
	boolean existsById(String iD);

	/**finds contact to delete by id so returns nothing when completed
	 * @param contact
	 */
	void deleteById(String id);
}
