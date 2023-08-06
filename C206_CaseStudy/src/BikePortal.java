import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * I declare that this code was writen by me...
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism 
 *
 * 22012568,3 Aug 202312:05:46 pm
 */

/**
 * @author 22012568
 *
 */
public class BikePortal {

	private static final int OPTION_EXIT = 8;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		ArrayList<Member> memberList = new ArrayList<Member>();
		ArrayList<Event> eventList = new ArrayList<Event>();
		ArrayList<Registration> regList = new ArrayList<Registration>();
		ArrayList<Group> grpList = new ArrayList<Group>();
		ArrayList<Discussion> discussionList = new ArrayList<Discussion>();

		discussionList.add(new Discussion("Competitve", "Mount Bike", "What are the features? "));

		regList.add(new Registration("CharmainTAN", "Charmain123", "CharmainTanIsAwesome", "Competitive"));
		memberList.add(new Member("Charmain", "CharmainIsCool", "CharmainAwesome", "Competitive"));
		memberList.add(new Member("Adam", "AdminIsCool", "AdamAwesome", "Competitive"));

		adminList.add(new Admin("Charmain", "CharmainAwesome", "Charmaintan08@gmail.com"));
		adminList.add(new Admin("kween", "kweenAwesome", "kween08@gmail.com"));

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

		eventList.add(new Event("Exclusive Bike Ride", "Competitive", LocalDate.parse("08/15/2023", dateFormatter),
				LocalTime.parse("14:30", timeFormatter), "Suntec City"));

		grpList.add(new Group("kween", "kweenAwesome", "kween08@gmail.com"));

		int option = 0;

		while (option != OPTION_EXIT) {

			// ADMIN
			BikePortal.loginTypeMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				String email = Helper.readString("Enter your emmail registered");
				String pass = Helper.readString("Enter your password > ");
				if (BikePortal.adminLogin(adminList,email,pass) == true) {
					BikePortal.adminMenu();
					int choice = Helper.readInt("Enter an option > ");
					while (choice != 5) {
						if (choice == 1) {
							BikePortal.setHeader("View All User");
							BikePortal.viewAllUser(memberList);
							BikePortal.adminMenu();
							choice = Helper.readInt("Enter an option > ");
						} else if (choice == 2) {
							BikePortal.setHeader("View Registrations");
							BikePortal.viewAllReg(regList);
							BikePortal.adminMenu();
							choice = Helper.readInt("Enter an option > ");
						} else if (choice == 3) {
							BikePortal.setHeader("Delete User");
							BikePortal.deleteMember(memberList);
							BikePortal.adminMenu();
							choice = Helper.readInt("Enter an option > ");
						} else if (choice == 4) {
							BikePortal.setHeader("Delete Registration");
							BikePortal.removeReg(regList);
							BikePortal.adminMenu();
							choice = Helper.readInt("Enter an option > ");
						} else if (choice == 5) {
							break;
						} else {
							System.out.println("Invalid Choice");

						}
					}
				}else {
					System.out.println("Unsuccessful Log In");
				}

			} else if (option == 2) {
				// USER

				BikePortal.userMenu();
				int choice = Helper.readInt("Enter an option > ");
				while (choice != 12) {
					if (choice == 1) {
						BikePortal.setHeader("Create a Group");
						BikePortal.createGrp(memberList, grpList);
						BikePortal.userMenu();
						choice = Helper.readInt("Enter an option > ");
					} else if (choice == 2) {
						BikePortal.setHeader("View all Group");
						BikePortal.viewAllGrp(grpList);
						BikePortal.userMenu();
						choice = Helper.readInt("Enter an option > ");
					} else if (choice == 3) {
						BikePortal.setHeader("Join a Group");
						Group joinedGroup = joinAGrp(grpList, memberList);
						if (joinedGroup != null) {
							BikePortal.viewGroupMembers(grpList, joinedGroup.getGroupName());
						}
						BikePortal.userMenu();
						choice = Helper.readInt("Enter an option > ");
					} else if (choice == 4) {
						BikePortal.setHeader("Delete an exiting Group");
						BikePortal.deleteGrp(grpList);
						BikePortal.userMenu();
						choice = Helper.readInt("Enter an option > ");
					} else if (choice == 5) {
						Event newEvent = createEvent();
						BikePortal.addEvent(eventList, newEvent);
						BikePortal.userMenu();
						choice = Helper.readInt("Enter an option > ");

					} else if (choice == 6) {
						BikePortal.setHeader("View all Events ");
						BikePortal.viewAllEvent(eventList);
						BikePortal.userMenu();
						choice = Helper.readInt("Enter an option > ");
					} else if (choice == 7) {
						BikePortal.setHeader("Delete Existing Event");
						BikePortal.userMenu();
						choice = Helper.readInt("Enter an option > ");
					} else if (choice == 8) {
						BikePortal.setHeader("Create a Discussion");
						BikePortal.userMenu();
						choice = Helper.readInt("Enter an option > ");
					} else if (choice == 9) {
						BikePortal.setHeader("View All Discussion");
						BikePortal.viewAllDiscussion(discussionList);
						BikePortal.userMenu();
						choice = Helper.readInt("Enter an option > ");
					} else if (choice == 10) {
						BikePortal.setHeader("Join a Discussion");
						BikePortal.userMenu();
						choice = Helper.readInt("Enter an option > ");
					} else if (choice == 11) {
						BikePortal.setHeader("Delete an Existing Discussion");
						BikePortal.userMenu();
						choice = Helper.readInt("Enter an option > ");
					} else if (choice == 12) {
						break;
					}

					else {
						System.out.println("Invalid Choice");
					}

				}
			} else if (option == 3) {
				// SIGN UP (REG)
				BikePortal.setHeader("Registering as new user");
				BikePortal.setHeader("SIGNUP AS NEW USER");
				Registration newReg = inputUser();
				Registration addedReg = BikePortal.addReg(regList, newReg);
				if (addedReg != null) {
					System.out.println("Registration successful.");
					Member newMember = new Member(addedReg.getName(), addedReg.getUsername(), addedReg.getPassword(),
							addedReg.getPreference());
					memberList.add(newMember);
				} else {
					System.out.println("Failed to register. Required fields are missing or user already exists.");
				}

			} else if (option == OPTION_EXIT) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void loginTypeMenu() {
		BikePortal.setHeader("LOGIN METHOD");
		System.out.println("1. Log in as Admin");
		System.out.println("2. Log in as User");
		System.out.println("3. Sign Up as new user");
	}

	public static void adminMenu() {
		BikePortal.setHeader("MY BIKE PORTAL");
		System.out.println("1. View all User Account ");
		System.out.println("2. View all Registration");
		System.out.println("3. Delete an existing user");
		System.out.println("4. Remove from registration list");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}

	public static void userMenu() {
		BikePortal.setHeader("MY BIKE PORTAL");
		System.out.println("1. Create a Group ");
		System.out.println("2. View all Group ");
		System.out.println("3. Join a Group ");
		System.out.println("4. Delete an Existing Group");
		System.out.println("5. Create an event");
		System.out.println("6. View all Events ");
		System.out.println("7. Delete Existing Event");
		System.out.println("8. Create a discussion");
		System.out.println("9. View all discussion");
		System.out.println("10. Join a discussion");
		System.out.println("11. Delete an existing Discussion");
		System.out.println("12. Quit");
		Helper.line(80, "-");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// -------------------------------------------MEMBER------------------------------------------------------------
//Log in as admin

	public static boolean adminLogin(ArrayList<Admin> adminList, String email, String password) {
		for (int x = 0; x < adminList.size(); x++) {
			if ((email.equalsIgnoreCase(adminList.get(x).getEmail()))
					&& (password.equalsIgnoreCase(adminList.get(x).getPassword()))) {
				
				return true;
			}
		}
		return false;
	}
	public static boolean validateRegAdmin(String email, String password) {
		if(email.contains("@gmail.com")) {
			if(password.length()==8) {
				return(true);
			}else {
				System.out.println("Weak password");
			}
		}else {
			System.out.println("Invalid email");
		}
		
		return(false);
	}

	// Obtaining all the Member from the memberList
	public static String retrieveAllUser(ArrayList<Member> memberList) {
		// obtaining member
		String output = "";
		for (int i = 0; i < memberList.size(); i++) {
			output += String.format("%-15s %-25s %-25s %-15s\n", memberList.get(i).getName(),
					memberList.get(i).getUsername(), memberList.get(i).getPassword(),
					memberList.get(i).getPreference());
		}
		return output;
	}

	//
	public static void viewAllUser(ArrayList<Member> memberList) {
		// printing user
		BikePortal.setHeader("MEMBER LIST");
		String output = String.format("%-15s %-25s %-25s %-15s\n", "NAME", "USERNAME", "PASSWORD", "PREFERENCE");
		output += retrieveAllUser(memberList);
		System.out.println(output);
	}

	public static Registration inputUser() {
		// REG
		// user input when registering
		String name = Helper.readString("Enter Name > ");
		String username = Helper.readString("Enter Username > ");
		String password = Helper.readString("Enter Password > ");
		String preference = Helper.readString("Enter Preference > ");

		Registration newReg = new Registration(name, password, username, preference);
		return newReg;
	}

	public static void addMember(ArrayList<Member> memberList, Member newMember) {
		Member member;
		// checking if user already exist
		for (int i = 0; i < memberList.size(); i++) {
			member = memberList.get(i);
			if (member.getUsername().equalsIgnoreCase(newMember.getUsername()))
				return;
		}
		if ((newMember.getUsername().isEmpty()) || (newMember.getPassword().isEmpty())
				|| (newMember.getName().isEmpty()) || (newMember.getPreference().isEmpty())) {
			return;
		}
		// checking if user have input all the fields required
		memberList.add(newMember);

	}

	public static void deleteMember(ArrayList<Member> memberList) {
		boolean isFound = false;
		Member mem;
		String deleteUser = Helper.readString("Enter the user to delete > ");
		for (int i = 0; i < memberList.size(); i++) {
			mem = memberList.get(i);
			if (mem.getUsername().equalsIgnoreCase(deleteUser)) {
				memberList.remove(i);
				System.out.println("Deleted Successfully");
				isFound = true;
				break;
			}

		}
		if (!isFound) {
			System.out.println("User not found");
		}

	}

//----------------------------------------------------Event------------------------------------------------------------------
	public static String retrieveAllEvent(ArrayList<Event> eventList) {
		// obtaining member
		String output = "";
		for (int i = 0; i < eventList.size(); i++) {
			output += String.format("%-15s %-25s %-25s %-15s\n", eventList.get(i).getEventName(),
					eventList.get(i).getEventDate(), eventList.get(i).getEventTime(), eventList.get(i).getVenue());
		}
		return output;
	}

	public static void viewAllEvent(ArrayList<Event> eventList) {
		// printing user
		BikePortal.setHeader("EVENT LIST");
		String output = String.format("%-15s %-25s %-25s %-15s\n", "EVENT NAME", "DATE", "TIME ", "VENUE");
		output += retrieveAllEvent(eventList);
		System.out.println(output);
	}

	public static Event createEvent() {
		// REG
		// user input when registering

		String name = Helper.readString("Enter Event Name > ");
		String difficulty = Helper.readString("Enter Event Difficulty > ");
		String date = Helper.readString("Enter Event Date (mm/dd/yyyy)> ");
		String time = Helper.readString("Enter Event Time (HH:mm) > ");
		String venue = Helper.readString("Enter Event Location > ");
		LocalDate localDate = null;
		LocalTime localTime = null;
		if (!(difficulty.equalsIgnoreCase("Competitive") || difficulty.equalsIgnoreCase("Intermediate")
				|| difficulty.equalsIgnoreCase("Casual"))) {
			System.out.println("Invalid Type");
		}

		try {
			DateTimeFormatter inputFormatter2 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			localDate = LocalDate.parse(date, inputFormatter2);
		} catch (DateTimeParseException e) {
			System.out.println("Invalid date format. Please use mm/dd/yyyy format.");
			// Handle the exception or return an error message if necessary
		}

		try {
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("HH:mm");
			localTime = LocalTime.parse(time, inputFormatter);
		} catch (DateTimeParseException e) {
			System.out.println("Invalid time format. Please use HH:mm format.");
			// Handle the exception or return an error message if necessary
		}
		Event newEvent = new Event(difficulty, name, localDate, localTime, venue);
		return newEvent;
	}

	public static void addEvent(ArrayList<Event> eventList, Event newEvent) {
		Event event;
		// checking if user already exist
		for (int i = 0; i < eventList.size(); i++) {
			event = eventList.get(i);
			if (event.getEventName().equalsIgnoreCase(newEvent.getEventName()))
				return;
		}
		if ((newEvent.getEventName().isEmpty()) || (newEvent.getDifficulty().isEmpty())
				|| (newEvent.getEventDate() == null) || (newEvent.getEventTime() == null)
				|| (newEvent.getVenue().isEmpty())) {
			System.out.println("Please fill in the entire thing");
			return;
		}
		eventList.add(newEvent);

	}

//	public static void addEvent(ArrayList<Event> eventList, Event newEvent) {
//		Event event;
//		// checking if user already exist
//		for (int i = 0; i < eventList.size(); i++) {
//			event = eventList.get(i);
//			if (eventList.get(i).getEventName().equalsIgnoreCase(event.getEventName()))
//				return;
//		}
//		// checking if user have input all the fields required
//		eventList.add(newEvent);
//
//	}

//------------------------------------------------Registration-------------------------------------------------------
	public static String retrieveAllReg(ArrayList<Registration> regList) {
		// obtaining member
		String output = "";
		for (int i = 0; i < regList.size(); i++) {
			output += String.format("%-15s %-25s %-25s %-15s\n", regList.get(i).getName(), regList.get(i).getUsername(),
					regList.get(i).getPassword(), regList.get(i).getPreference());
		}
		return output;
	}

	public static void viewAllReg(ArrayList<Registration> regList) {
		// printing user
		BikePortal.setHeader("MEMBER LIST");
		String output = String.format("%-15s %-25s %-25s %-15s\n", "NAME", "USERNAME", "PASSWORD", "PREFERENCE");
		output += retrieveAllReg(regList);
		System.out.println(output);
	}

	public static Registration addReg(ArrayList<Registration> regList, Registration newReg) {
		Registration reg;
		// checking if user already exist
		for (int i = 0; i < regList.size(); i++) {
			reg = regList.get(i);
			if (reg.getUsername().equalsIgnoreCase(newReg.getUsername()))
				return (null);
		}
		if ((newReg.getUsername().isEmpty()) || (newReg.getPassword().isEmpty()) || (newReg.getName().isEmpty())
				|| (newReg.getPreference().isEmpty())) {
			return (null);
		}
		regList.add(newReg);
		return (newReg);
	}

	public static void removeReg(ArrayList<Registration> regList) {
		boolean isFound = false;
		Registration reg;
		String removeReg = Helper.readString("Enter the username to remove from registration list > ");
		for (int i = 0; i < regList.size(); i++) {
			reg = regList.get(i);
			if (reg.getUsername().equalsIgnoreCase(removeReg)) {
				regList.remove(i);
				isFound = true;
				System.out.println("Removed from Registration List");
				break;
			}
		}
		if (!isFound) {
			System.out.println("User not found");
		}

	}
	// ------------------------------------------Group-----------------------------------------------------------

	// Create a Group
	public static void createGrp(ArrayList<Member> memberList, ArrayList<Group> grpList) {
		String grpName = Helper.readString("Please Enter Group Name");
		String grpDescription = Helper.readString("Please Enter Group Description");
		String grpPreference = Helper.readString("Please Enter Group preference");
		char addMembers = Helper.readChar("Do you want to add members (y/n)");
		while (addMembers == 'y') {
			String memberName = Helper.readString("Enter member username");
			Member memberFound = null;

			for (int x = 0; x < memberList.size(); x++) {
				if (memberList.get(x).getUsername().equalsIgnoreCase(memberName)) {
					memberFound = memberList.get(x);
					break;
				}
			}
			if (memberFound != null) {
				Group group = new Group(grpName, grpDescription, grpPreference);
				// Add the selected member to the group's memberList
				group.addMember(memberFound);
				grpList.add(group);
				System.out.println(memberFound.getUsername() + " has been added to the group " + grpName);
			} else {
				System.out.println("Member not found in the member list.");
			}

			addMembers = Helper.readChar("Do you want to add more members (y/n)");
		}
	}

	public static String retrieveAllGrp(ArrayList<Group> grpList) {
		// obtaining member
		String output = "";
		for (int i = 0; i < grpList.size(); i++) {
			Group group = grpList.get(i);
			output += String.format("%-15s %-25s %-25s\n", grpList.get(i).getGroupName(),
					grpList.get(i).getDescription(), grpList.get(i).getDifficulty());
			for (Member member : group.getMemberList()) {
				output += String.format("%-15s %-25s %-25s\n", "", member.getName(), member.getUsername(),
						member.getPreference());
			}
		}
		return output;
	}

	//
	public static void viewAllGrp(ArrayList<Group> grpList) {
		// printing user
		BikePortal.setHeader("GROUP LIST");
		String output = String.format("%-15s %-25s %-25s\n", "NAME", "DESCRIPTION", "PREFERENCE");
		output += retrieveAllGrp(grpList);
		System.out.println(output);

	}

	public static Group joinAGrp(ArrayList<Group> grpList, ArrayList<Member> memberList) {
		String groupName = Helper.readString("Enter Group to Join > ");
		Group groupToJoin = null;

		// Find the group to join
		for (Group group : grpList) {
			if (group.getGroupName().equalsIgnoreCase(groupName)) {
				groupToJoin = group;
				break;
			}
		}

		if (groupToJoin != null) {
			String usernameToJoin = Helper.readString("Enter Username to Join > ");
			Member memberToJoin = null;

			// Find the member in the memberList
			for (Member member : memberList) {
				if (member.getUsername().equalsIgnoreCase(usernameToJoin)) {
					memberToJoin = member;
					break;
				}
			}

			if (memberToJoin != null) {
				// Add the member to the group
				groupToJoin.addMember(memberToJoin);
				System.out.println(memberToJoin.getUsername() + " has been added to the group " + groupName);
				return (groupToJoin);
			} else {
				System.out.println("Member not found in the member list.");
			}
		} else {
			System.out.println("Group not found.");
		}
		return (null);
	}

	public static void viewGroupMembers(ArrayList<Group> grpList, String groupName) {
		Group groupToView = null;

		for (Group group : grpList) {
			if (group.getGroupName().equalsIgnoreCase(groupName)) {
				groupToView = group;
				break;
			}
		}

		if (groupToView != null) {
			System.out.println("Members of Group: " + groupToView.getGroupName());
			for (Member member : groupToView.getMemberList()) {
				System.out.println("Name: " + member.getName());
				System.out.println("Username: " + member.getUsername());
				System.out.println("Preference: " + member.getPreference());
				System.out.println("--------------------");
			}
		} else {
			System.out.println("Group not found.");
		}
	}

	public static void deleteGrp(ArrayList<Group> grpList) {
		Group grp;
		String deleteGrp = Helper.readString("Enter Group Name > ");
		for (int i = 0; i < grpList.size(); i++) {
			grp = grpList.get(i);
			if (grp.getGroupName().equalsIgnoreCase(deleteGrp)) {
				grpList.remove(i);
				System.out.println("Successfully Deleted");
				break;
			} else {
				System.out.println("User not found");
			}
		}

	}

	// -------------------------------Discussion--------------------------------
	public static String retrieveAllDiscussion(ArrayList<Discussion> discussionList) {
		// obtaining member
		String output = "";
		for (int i = 0; i < discussionList.size(); i++) {
			output += String.format("%-15s %-25s %-25s \n", discussionList.get(i).getDifficulty(),
					discussionList.get(i).getTopic(), discussionList.get(i).getQuestion());
		}
		return output;
	}

	public static void viewAllDiscussion(ArrayList<Discussion> discussionList) {
		// printing user
		BikePortal.setHeader("MEMBER LIST");
		String output = String.format("%-15s %-25s %-25s\n", "PREFERENCE", "TOPIC", "QUESTION");
		output += retrieveAllDiscussion(discussionList);
		System.out.println(output);
	}

	public static Registration addDiscussion(ArrayList<Registration> regList, Registration newReg) {
		Registration reg;
		// checking if user already exist
		for (int i = 0; i < regList.size(); i++) {
			reg = regList.get(i);
			if (reg.getUsername().equalsIgnoreCase(newReg.getUsername()))
				return (null);
		}
		if ((newReg.getUsername().isEmpty()) || (newReg.getPassword().isEmpty()) || (newReg.getName().isEmpty())
				|| (newReg.getPreference().isEmpty())) {
			return (null);
		}
		regList.add(newReg);
		return (newReg);
	}

}
