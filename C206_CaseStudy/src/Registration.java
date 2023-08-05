/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism 
 *
 * 22012568,5 Aug 20233:31:56 pm...
 */

/**
 * @author 22012568
 *
 */
public class Registration extends Accounts{
	private String username;
	private String preference;
	/**
	 * @param name
	 * @param permission
	 * @param username
	 * @param password
	 */
	public Registration(String name, String password, String username, String preference) {
		super(name, password);
		this.username = username;
		this.preference = preference;
	}
	/**
	 * @param preference the preference to set
	 */
	public String getPreference() {
		return preference;
	}
	/**
	 * @param name
	 * @param Password
	 * @param username
	 * @param preference
	 */
	
	public void setPreference(String preference) {
		this.preference = preference;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	
	public void display() {
		System.out.println("Username: "+ username);
		System.out.println("password: "+ getPassword());
		System.out.println("name: "+ getName());
		System.out.println("preference: "+ preference);
		
	}

}
