/**
 * I declare that this code was written by me. 
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism 
 *
 * 22012568,2 Aug 20232:12:34 pm.
 */

/**
 * @author 22012568
 *
 */
public class Admin extends Accounts {
	private String email;
	

	/**
	 * @param name
	 * @param permission
	 */
	public Admin(String name, String password, String email) {
		super(name, password);
		this.email = email;
		// TODO Auto-generated constructor stub
	}

	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public void display() {
		System.out.println("email: "+ email);
		System.out.println("password: "+ getPassword());
		
		
	}
	

}
