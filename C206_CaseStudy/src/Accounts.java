/**
 * I declare that this code was wrriten by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism 
 *
 * 22012568,10 Aug 202312:38:06 am
 */

/**
 * @author 22012568
 *
 */
public class Accounts {
	private String name;
	private String password;

	/**
	 * @param name
	 * @param Password
	 */
	public Accounts(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
