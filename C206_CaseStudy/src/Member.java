/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism 
 *
 * 22012568,2 Aug 20232:13:05 pm...
 */

/**
 * @author 22012568
 *
 */
public class Member extends Accounts{
	private String username;
	private String preference;
	private String bike;
	
	/**
	 * @param name
	 * @param permission
	 * @param username
	 * @param password
	 */
	public Member(String name, String password, String username, String preference, String bike) {
		super(name, password);
		this.username = username;
		this.preference = preference;
		this.bike = bike;
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
		System.out.println("Password: "+ getPassword());
		System.out.println("Name: "+ getName());
		System.out.println("Preference: "+ preference);
		System.out.println("Bike: " + bike);
	}

	public void setBike(String bike) {
		this.bike = bike;
	}
	
	

	
}
