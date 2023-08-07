import java.util.ArrayList;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism 
 *
 * 22012568,3 Aug 202311:09:22 pm...
 */

/**
 * @author 22012568
 *
 */
public class Group extends Tag{
	private String groupName;
	private String description;
	private ArrayList<Member> memberList;

	/**
	 * @param groupName
	 * @param description
	 */
	public Group(String tag,String groupName, String description) {
		super(tag);
		this.groupName = groupName;
		this.description = description;
		this.memberList = new ArrayList<>();
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	public ArrayList<Member> getMemberList() {
        return memberList;
    }

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public void addMember(Member member) {

		for (int x = 0; x < memberList.size(); x++)
			if (!(memberList.get(x).getUsername().equalsIgnoreCase(member.getUsername()))) {
				memberList.add(member);
				System.out.println(member + " has been added to the group " + groupName);
			} else {
				System.out.println(memberList.get(x).getUsername() + " is already a member of the group " + groupName);
			}
	}
	
    public void printMembers() {
        BikePortal.setHeader("MEMBERS OF GROUP: " + groupName);
        String output = String.format("%-15s %-25s %-15s\n", "NAME", "USERNAME", "PREFERENCE");
        for (Member member : memberList) {
            output += String.format("%-15s %-25s %-25s %-15s\n", member.getName(), member.getUsername(), member.getPassword(), member.getPreference());
        }
        System.out.println(output);
    }
    
   
	

	
}
