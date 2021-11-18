package CFMProject.AddressBook2;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoIterable;

/**
 * @author Joeseph Sande
 *
 */

////localhost:27017/login
public class MongoDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String uri = "mongodb+srv://dbAdmin:Sopheye35@cluster0.4uedj.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
		//Try to Connect to local instance in SECURED mode with user name and password
		try {
			MongoClient mongoClient = MongoClients.create(uri);
	
		MongoIterable<String> dbNames = mongoClient.listDatabaseNames();
		
		//add all database names to the list to connect (In this case there is one, 
		//so the @SuppressWarnings ignores that there are not multiple database names to connect to.)
		for(@SuppressWarnings("unused") String dbName : dbNames) {
			System.out.println(dbNames);
		} 
		}
		//catch exception if the account could not log in
		catch(Exception e) {
			System.out.println("This account could not log in");
		}
	}
}
