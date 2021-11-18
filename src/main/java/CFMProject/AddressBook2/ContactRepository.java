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

	@Query("{$or:[{'fname' : ?0},{lname:?0}]}")
	public List<Contact> findByName(String keyword);
	
	/**
	 * @param contact
	 * @return
	 */
	//@Query("SELECT s FROM Contact s WHERE s.fname =?1")
	@Query("{'fname' : ?0}")
	Optional<Contact> findContactByfname(String fname);
	
	/**
	 * @param contact
	 * @return
	 */
	@Query("{'id': ?0}")
	//@Query("SELECT s FROM Contact s WHERE s.ID = ?1")
	Optional<Contact> findContactByID(int ID);

	/**
	 * @param contact
	 * @return
	 */
	@Query("SELECT s FROM Contact s WHERE s.lname = ?1")
	Optional<Contact> findContactBylname(String lname);

	/**
	 * @param contact
	 * @return
	 */
	@Query("SELECT s FROM Contact s WHERE s.phoneNumber = ?1")
	Optional<Contact> findContactByPhonNumber(String phoneNumber);

	/**
	 * @param contact
	 * @return
	 */
	@Query("SELECT s FROM Contact s WHERE s.email = ?1")
	Optional<Contact> findContactByEmail(String email);

	/**
	 * @param contact
	 * @return
	 */
	@Query("SELECT s FROM Contact s WHERE s.streetName = ?1")
	Optional<Contact> findContactByStreetName(String streetName);

	/**
	 * @param contact
	 * @return
	 */
	List<Contact> findAll(Sort sort);

	/**
	 * @param contact
	 * @return
	 */
	Contact findById(String iD);

	/**
	 * @param contact
	 * @return
	 */
	boolean existsById(String iD);

	/**
	 * @param contact
	 */
	void deleteById(String id);
}
