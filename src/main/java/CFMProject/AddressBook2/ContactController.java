package CFMProject.AddressBook2;

import java.util.List;

import javax.management.AttributeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Session session = new Session(); ADD THIS INTO THE PROGRAM

//http://localhost:27016/api/v1/Contact
/**
 * @author Joeseph Sande
 *
 */
@Controller
@RequestMapping(path = { "/Contact", "" })
public class ContactController {

	private final ContactService contactService;

	// to get login form page
	/**
	 * @return login page
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginForm() {
		return "login";
	}

	// checking for login credentials
	/**
	 * @param loginForm takes in the login form credentials to evaluate whether they match the saved credentials to log in
	 * @param model takes the model and retrieves its content to perform the operations
	 * @return Contact page if proper credentials else login page if incorrect
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute(name = "loginForm") loginForm loginForm, Model model) {

		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		int attempts = 0;
		if ("admin".equals(username) && "admin".equals(password)) {
			model.addAttribute("Contact", contactService.findAll());
			
			return "Contact";
		} else {
			model.addAttribute("invalidCredentials", true);
			attempts++;
			if (attempts == 3) {
				model.addAttribute("Attempts have exceeeded 3", true);
			}
			return "login";
		}
	}

	/**
	 * @param contactService sets the contactService for this Controller
	 */
	@Autowired
	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}

	// DISPLAY MAIN SCREEN HANDLER
	/**
	 * @param model takes the contents of the model and adds all contacts to the view
	 * @return Contact html page
	 */
	@GetMapping({ "/Contact", "" })
	String getContacts(Model model) {
		model.addAttribute("Contact", contactService.findAll());
		return "Contact";
	}

	// DISPLAY ALL CONTACTS HANDLER
	/**
	 * @param model takes the contents of the model and adds all contacts to the view
	 * @return Contact html page
	 */
	@GetMapping("/displayAll")
	public String displayAll(Model model) {
		model.addAttribute("Contact", contactService.findAll());
		return "Contact";
	}

	// ADD CONTACT FORM
	/**
	 * @param model 
	 * @return newContact page
	 */
	@GetMapping("/showNewContactForm")
	public String showNewContactForm(Model model) {
		Contact contact = new Contact();
		model.addAttribute("Contact", contact);
		return "newContact";
	}

	// SAVE CONTACTS
	/**
	 * @param contact create a new contact (object/document)
	 * @param model taking the information input to create a new contact in MongoDB
	 * @return Contact page view for the user after saving the contact
	 */
	@PostMapping("/saveContact")
	public String saveContact(@ModelAttribute("Contact") Contact contact, Model model) {
		contactService.add(contact);
		return "Contact";
	}

	// DELETE CONTACT
	/**
	 * @param id
	 * @return Contact page after deletion
	 */
	@PostMapping(path = "{id}")
	public String deleteContact(@PathVariable("id") String id) {
		contactService.deleteContacts(id);
		return "Contact";
	}

	/**
	 * @param id
	 * @param model
	 * @return updateContact page
	 */
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") String id, Model model) {
		Contact contact = contactService.findById(id);
		// .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		model.addAttribute("Contact", contact);
		return "updateContact";
	}

	/**
	 * @param id
	 * @param model
	 * @return contactDetails page
	 */
	@GetMapping("/details/{id}")
	public String contactDetailsForm(@PathVariable("id") String id, Model model) {
		Contact contact = contactService.findById(id);
		// .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		model.addAttribute("Contact", contact);
		return "contactDetails";
	}

	/**
	 * @param id
	 * @param model
	 * @param contact
	 * @return Contact page after updating
	 * @throws AttributeNotFoundException
	 */
	@PostMapping(value = { "/Contact/updateContacts/{id}" })
	public String updateContact(@PathVariable("id") String id, Model model, Contact contact)
			throws AttributeNotFoundException {
		contactService.updateContact(contact);
		return "Contact";
	}


	
	/**
	 * 
	 * @param keyword
	 * @param contact
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/Contact/search", method= RequestMethod.GET)
	public String search(@Param("keyword") String keyword, Contact contact, Model model) {
		List<Contact> contacts = contactService.findByName(keyword);
		//Optional<Contact> contacts = contactService.addByfName(keyword);
		try{model.addAttribute("contacts", contacts);
		model.addAttribute("keyword", contactService.findByName(keyword));
		} catch(Exception x) {
			model.addAttribute("keyword", contactService.findAll());
		}
		return "searchPage";
	}
	
}
