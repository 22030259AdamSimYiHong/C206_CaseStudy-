/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism 
 *
 * 22012568,2 Aug 20232:13:22 pm...
 */

/**
 * @author 22012568
 *
 */
public class Bike {
	private String bikeName;
	private String bikeType;
	

	/**
	 * @param bikeName
	 * @param bikeType
	 */
	public Bike(String bikeName, String bikeType) {
		this.bikeName = bikeName;
		this.bikeType = bikeType;
	}

	public String getBikeType() {
		return bikeType;
	}

	public void setBikeType(String bikeType) {
		this.bikeType = bikeType;
	}

	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}

	public String getBikeName() {
		return bikeName;
	}
	
	

}
