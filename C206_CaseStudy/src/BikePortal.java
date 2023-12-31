import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * I declare that this code was writen by me....
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

	private static final int OPTION_EXIT = 3;

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
		ArrayList<Bike> bikeList = new ArrayList<Bike>();

		bikeList.add(new Bike("BMW", "Sport"));
		discussionList.add(new Discussion("Competitve", "Mount Bike", "What are the features? "));

		regList.add(new Registration("CharmainTAN", "Charmain123", "CharmainTanIsAwesome", "Competitive"));
		memberList.add(new Member("CharmainTAN", "Charmain123", "CharmainTanIsAwesome", "Competitive"));

		memberList.add(new Member("Charmain", "CharmainIsCool", "CharmainAwesome", "Competitive"));
		memberList.add(new Member("Adam", "AdminIsCool", "AdamAwesome", "Casual"));
		memberList.add(new Member("testUser", "user", "user", "Intermediate"));

		adminList.add(new Admin("Charmain", "CharmainAwesome", "Charmaintan08@gmail.com"));
		adminList.add(new Admin("kween", "kweenAwesome", "kween08@gmail.com"));
		adminList.add(new Admin("admin", "1234", "admin@admin.com"));

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

		eventList.add(new Event("Competitive", "Exclusive Bike Ride", LocalDate.parse("08/15/2023", dateFormatter),
				LocalTime.parse("14:30", timeFormatter), "Suntec City"));
		eventList.add(new Event("Casual", "Exclusive Bike Ride", LocalDate.parse("08/15/2023", dateFormatter),
				LocalTime.parse("14:30", timeFormatter), "Suntec City"));
		eventList.add(new Event("Intermediate", "Exclusive Bike Ride", LocalDate.parse("08/15/2023", dateFormatter),
				LocalTime.parse("14:30", timeFormatter), "Suntec City"));

		grpList.add(new Group("kween", "kweenAwesome", "kween08@gmail.com"));

		loginTypeMenu();
		int option = Helper.readInt("Enter choice > ");

		while (option != OPTION_EXIT) {
			if (option == 1) {
				String loginEmail = Helper.readString("Enter email address > ");
				String loginPW = Helper.readString("Enter password > ");
				if (BikePortal.adminLogin(adminList, loginEmail, loginPW)) {
					adminMenu();
					int internalOption = Helper.readInt("Enter choice > ");
					while (internalOption != 5) {
						if (internalOption == 1) {
							BikePortal.setHeader("View All Users");
							BikePortal.viewAllUser(memberList);
							BikePortal.userPMenu();
							int userOption = Helper.readInt("Enter an option > ");
							while (userOption != 2) {
								if (userOption == 1) {
									BikePortal.deleteMember(memberList, regList);
								}
								BikePortal.setHeader("View All Users");
								BikePortal.viewAllUser(memberList);
								BikePortal.userPMenu();
								userOption = Helper.readInt("Enter an option > ");
							}
							BikePortal.adminMenu();
							internalOption = Helper.readInt("Enter an option > ");
						} else if (internalOption == 2) {
							BikePortal.setHeader("View All Registrations");
							BikePortal.viewAllReg(regList);
							BikePortal.regMenu();
							int regOption = Helper.readInt("Enter an option > ");
							while (regOption != 2) {
								if (regOption == 1) {
									BikePortal.removeReg(regList, memberList);
								}
								BikePortal.setHeader("View All Registrations");
								BikePortal.viewAllReg(regList);
								BikePortal.regMenu();
								regOption = Helper.readInt("Enter an option > ");
							}
							BikePortal.adminMenu();
							internalOption = Helper.readInt("Enter an option > ");
						} else if (internalOption == 3) {
							BikePortal.setHeader("View All Groups");
							BikePortal.viewAllGrp(grpList);
							BikePortal.groupMenu();
							int grpOption = Helper.readInt("Enter an option > ");
							while (grpOption != 2) {
								if (grpOption == 1) {
									BikePortal.deleteGrp(grpList);
								}
								BikePortal.setHeader("View All Groups");
								BikePortal.viewAllGrp(grpList);
								BikePortal.groupMenu();
								grpOption = Helper.readInt("Enter an option > ");
							}
							BikePortal.adminMenu();
							internalOption = Helper.readInt("Enter an option > ");
						} else if (internalOption == 4) {
							BikePortal.viewAllEvent(eventList);
							BikePortal.eventMenu();
							int eventOption = Helper.readInt("Enter an option > ");
							while (eventOption != 2) {
								if (eventOption == 1) {
									BikePortal.deleteEvent(eventList);
								}
								BikePortal.setHeader("View All Groups");
								BikePortal.viewAllEvent(eventList);
								BikePortal.eventMenu();
								eventOption = Helper.readInt("Enter an option > ");
							}
							BikePortal.adminMenu();
							internalOption = Helper.readInt("Enter an option > ");
						}
					}
				}
			} else if (option == 2) {
				BikePortal.userSMenu();
				int internalOption = Helper.readInt("Enter an option > ");
				while (internalOption != 3) {
					if (internalOption == 1) {
						String loginEmail = Helper.readString("Enter username > ");
						String loginPW = Helper.readString("Enter password > ");
						if (BikePortal.userLogin(memberList, loginEmail, loginPW)) {
							BikePortal.userMenu();
							int loginOption = Helper.readInt("Enter an option > ");
							while (loginOption != 6) {
								if (loginOption == 1) {
									BikePortal.setHeader("View All Groups");
									BikePortal.viewAllGrp(grpList);
									BikePortal.currentGMenu();
									int grpOption = Helper.readInt("Enter an option > ");
									while (grpOption != 5) {
										if (grpOption == 1) {
											// need to create a method to view groups that user is currently in
										} else if (grpOption == 2) {
											BikePortal.createGrp(memberList, grpList);
										} else if (grpOption == 3) {
											BikePortal.joinGrp(grpList, memberList);
										} else if (grpOption == 4) {
											BikePortal.viewAllDiscussion(discussionList);
										}
									}
								} else if (loginOption == 2) {
									BikePortal.setHeader("View All Events");
									BikePortal.recommendEvents(memberList, eventList, loginEmail);
									BikePortal.currentEMenu();
									int eventOption = Helper.readInt("Enter an option > ");
									while (eventOption != 4) {
										if (eventOption == 1) {
											// need to create a method to view events that user is currently in
										} else if (eventOption == 2) {
											BikePortal.createEvent();
										} else if (eventOption == 3) {
//											BikePortal.
										}
									}
								} else if (loginOption == 3) {
									int UserOption = 0;
									while (UserOption != 2) {
										BikePortal.findUser(memberList);
										UserOption = Helper.readInt("Enter an option > ");
									}
									BikePortal.userMenu();
									loginOption = Helper.readInt("Enter option: ");
								} else if (loginOption == 4) {
									// charmain add your fucking code here
								} else if (loginOption == 5) {
									// delete this part
								}
							}

						}
					}
				}
			}
			BikePortal.loginTypeMenu();
			option = Helper.readInt("Enter choice > ");
		}
		System.out.println("Good Bye!");

	}

	public static void loginTypeMenu() {
		BikePortal.setHeader("LOGIN METHOD");
		System.out.println("1. Interact as Admin");
		System.out.println("2. Interact as User");
		System.out.println("3. Quit Program");
	}

	public static void adminMenu() {
		BikePortal.setHeader("MY BIKE PORTAL - ADMIN CONTROL");
		System.out.println("1. View all User Accounts");
		System.out.println("2. View all Registrations");
		System.out.println("3. View all Groups");
		System.out.println("4. View all events");
		System.out.println("5. Logout");
		Helper.line(110, "-");

	}

	public static void userMenu() {
		BikePortal.setHeader("MY BIKE PORTAL");
		System.out.println("1. Groups");
		System.out.println("2. Events");
		System.out.println("3. Users");
		System.out.println("4. Bikes");
		System.out.println("5. Profile");
		System.out.println("6. Logout");
		Helper.line(110, "-");
	}

	public static void setHeader(String header) {
		Helper.line(110, "-");
		System.out.println(header);
		Helper.line(110, "-");
	}

	public static void groupMenu() {
		BikePortal.setHeader("GROUP PAGE");
		System.out.println("1. Delete a group");
		System.out.println("2. Return to previous page");
	}

	public static void regMenu() {
		BikePortal.setHeader("REGISTRATION PAGE");
		System.out.println("1. Remove registration");
		System.out.println("2. Return to previous page");
	}

	public static void userPMenu() {
		BikePortal.setHeader("USER PAGE");
		System.out.println("1. Delete user");
		System.out.println("2. Return to previous page");
	}

	public static void eventMenu() {
		BikePortal.setHeader("EVENT PAGE");
		System.out.println("1. Delete event");
		System.out.println("2. Return to previous page");
	}

	public static void userSMenu() {
		BikePortal.setHeader("USER OPTION");
		System.out.println("1. Login");
		System.out.println("2. Sign up");
		System.out.println("3. Return to previous page");
	}

	public static void currentGMenu() {
		BikePortal.setHeader("GROUP PAGE");
		System.out.println("1. View current groups");
		System.out.println("2. Create");
		System.out.println("3. Join");
		System.out.println("4. View discussions");
		System.out.println("5. Return to previous page");
	}

	public static void currentG2Menu() {
		BikePortal.setHeader("GROUP PAGE");
		System.out.println("1. Leave");
		System.out.println("2. Return to previous page");
	}

	public static void discussionMenu() {
		BikePortal.setHeader("DISCUSSION PAGE");
		System.out.println("1. Leave discussion");
		System.out.println("2. Return to previous page");
	}

	public static void currentEMenu() {
		BikePortal.setHeader("Event PAGE");
		System.out.println("1. View current events");
		System.out.println("2. Create");
		System.out.println("3. Join");
		System.out.println("4. Return to previous page");
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
		if (email.contains("@gmail.com")) {
			if (password.length() == 8) {
				return (true);
			} else {
				System.out.println("Weak password");
			}
		} else {
			System.out.println("Invalid email");
		}

		return (false);
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

	public static void findUser (ArrayList<Member> memberList) {
        BikePortal.setHeader("Search for Biker");
        String username = Helper.readString("Enter Username: ");
        String output = "";
        output += String.format("%-20s %-20s\n", "USERNAME", "PREFERENCE");
        boolean isFound = false;
        for (int i = 0; i < memberList.size(); i++) {
          Member m = memberList.get(i);
            if (m.getUsername().toLowerCase().contains(username.toLowerCase())) {
            output += String.format("%-20s %-20s\n", m.getUsername(), m.getPreference());
            isFound = true;
            break;
            
            } else {
                isFound = false;
            }
        }

        if(isFound == false) {
            System.out.println("There is no such user\n");
        } else { 
        System.out.println(output);
        }
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

	public static void deleteMember(ArrayList<Member> memberList, ArrayList<Registration> regList) {
		boolean isFound = false;
		Member mem;
		String deleteUser = Helper.readString("Enter the user to delete > ");
		for (int i = 0; i < memberList.size(); i++) {
			mem = memberList.get(i);
			if (mem.getUsername().equalsIgnoreCase(deleteUser)) {
				memberList.remove(i);
				System.out.println(deleteUser + " was deleted successfully");
				Registration reg;
				for (int x = 0; x < regList.size(); x++) {
					reg = regList.get(x);
					if (reg.getUsername().equalsIgnoreCase(deleteUser)) {
						regList.remove(x);
					}
				}
				isFound = true;
				break;
			}

		}
		if (!isFound) {
			System.out.println("User not found");
		}

	}

	public static Admin inputAdmin() {

		// write your code here
		String name = Helper.readString("Enter name > ");
		String email = Helper.readString("Enter email > ");
		String password = Helper.readString("Enter password > ");
		if (BikePortal.validateRegAdmin(email, password) == true) {
			Admin newAdmin = new Admin(name, email, password);
			return newAdmin;
		}
		return null;

	}

	public static void addAdmin(ArrayList<Admin> adminList, Admin newAdmin) {
		// write your code here
		Admin admin;
		for (int i = 0; i < adminList.size(); i++) {
			admin = adminList.get(i);
			if (admin.getEmail().equalsIgnoreCase(newAdmin.getEmail()))
				return;
		}
		if ((newAdmin.getName().isEmpty()) && (newAdmin.getEmail().isEmpty()) && (newAdmin.getPassword().isEmpty())) {
			return;
		}

		adminList.add(newAdmin);
	}

	public static String retrieveAllAdmin(ArrayList<Admin> adminList) {
		// obtaining member
		String output = "";
		for (int i = 0; i < adminList.size(); i++) {
			output += String.format("%-15s %-25s %-25s \n", adminList.get(i).getName(), adminList.get(i).getEmail(),
					adminList.get(i).getPassword());
		}
		return output;
	}

	public static void viewAllAdmin(ArrayList<Admin> adminList) {
		// printing user
		BikePortal.setHeader("MEMBER LIST");
		String output = String.format("%-15s %-25s %-25s\n", "NAME", "EMAIL", "PASSWORD");
		output += retrieveAllAdmin(adminList);
		System.out.println(output);
	}

	public static boolean userLogin(ArrayList<Member> memberList, String username, String password) {
		for (Member member : memberList) {
			if (username.equalsIgnoreCase(member.getUsername()) && password.equals(member.getPassword())) {
				return true;
			}
		}
		return false;
	}

//----------------------------------------------------Event------------------------------------------------------------------
	public static String retrieveAllEvent(ArrayList<Event> eventList) {
		// obtaining member
		String output = "";
		for (int i = 0; i < eventList.size(); i++) {
			output += String.format("%-15s %-25s %-25s %-25s %-15s\n", eventList.get(i).getDifficulty(),
					eventList.get(i).getEventName(), eventList.get(i).getEventDate(), eventList.get(i).getEventTime(),
					eventList.get(i).getVenue());
		}
		return output;
	}

	public static void viewAllEvent(ArrayList<Event> eventList) {
		// printing user
		BikePortal.setHeader("EVENT LIST");
		String output = String.format("%-15s %-25s %-25s %-25s %-15s\n", "DIFFICULTY", "EVENT NAME", "DATE", "TIME ",
				"VENUE");
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

	public static void deleteEvent(ArrayList<Event> eventList) {
		String deleteEvent = Helper.readString("Enter Event Name > ");

		Event foundEvent = null;
		for (Event event : eventList) {
			if (event.getEventName().equalsIgnoreCase(deleteEvent)) {
				foundEvent = event;
				break;
			}
		}

		if (foundEvent != null) {
			eventList.remove(foundEvent);
			System.out.println(deleteEvent + " was successfully deleted");
		} else {
			System.out.println("Event not found");
		}
	}

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

	public static void removeReg(ArrayList<Registration> regList, ArrayList<Member> memberList) {
		boolean isFound = false;
		Registration reg;
		String removeReg = Helper.readString("Enter the username to remove > ");
		for (int i = 0; i < regList.size(); i++) {
			reg = regList.get(i);
			if (reg.getUsername().equalsIgnoreCase(removeReg)) {
				regList.remove(i);
				isFound = true;
				Member mem;
				for (int x = 0; x < memberList.size(); x++) {
					mem = memberList.get(i);
					if (mem.getUsername().equalsIgnoreCase(removeReg)) {
						memberList.remove(x);
					}
					System.out.println(removeReg + " was removed from the registration list");
					break;
				}
			}
		}
		if (!isFound) {
			System.out.println("User not found");
		}

	}
	// ------------------------------------------Group-----------------------------------------------------------

	// Create a Group
	public static void createGrp(ArrayList<Member> memberList, ArrayList<Group> grpList) {
		String grpName = Helper.readString("Enter group name > ");
		String grpDescription = Helper.readString("Enter group description > ");
		String grpPreference = Helper.readString("Enter group preference > ");
		boolean grpDuplicate = true;
		for (Group x : grpList) {
			if (x.getGroupName().equalsIgnoreCase(grpName)) {
				grpDuplicate = false;
				break;
			}
		}

		if (grpDuplicate == true) {
			System.out.println("Group name " + grpName + " already exist. Please enter another name.");
		}

		Group newGroup = new Group(grpPreference, grpName, grpDescription);

		char addMembers = Helper.readChar("Do you want to add members? (Y/N) > ");
		while (addMembers == 'Y' || addMembers == 'y') {
			System.out.println("Available members:");
			for (int i = 0; i < memberList.size(); i++) {
				Member member = memberList.get(i);
				if (!newGroup.getMemberList().contains(member)) {
					System.out.println(String.format("%d. %s", i + 1, member.getUsername()));
				}
			}

			int memberNumber = Helper.readInt("Enter member number to add > ");

			if (memberNumber >= 1 && memberNumber <= memberList.size()) {
				Member selectedMember = memberList.get(memberNumber - 1);
				if (!newGroup.getMemberList().contains(selectedMember)) {
					newGroup.addMember(selectedMember);
					System.out.println(selectedMember.getUsername() + " has been added to the group.");
				} else {
					System.out.println(selectedMember.getUsername() + " is already a member of the group.");
				}
			} else {
				System.out.println("Invalid member number.");
			}

			addMembers = Helper.readChar("Do you want to add another member? (Y/N) > ");
		}

		grpList.add(newGroup);
		System.out.println("Group " + grpName + " has been created successfully!");

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

	public static Group joinGrp(ArrayList<Group> grpList, ArrayList<Member> memberList) {
		Group groupToJoin = null; // Declare the variable outside the loop

		while (true) {
			String groupName = Helper.readString("Enter Group Name to Join (or type 'exit' to cancel) > ");

			if (groupName.equalsIgnoreCase("exit")) {
				System.out.println("Joining group canceled.");
				return null;
			}

			// Find the group to join
			for (Group group : grpList) {
				if (group.getGroupName().equalsIgnoreCase(groupName)) {
					groupToJoin = group;
					break;
				}
			}

			if (groupToJoin != null) {
				// Add the member to the group (assuming you have a member instance)
				// groupToJoin.addMember(memberToJoin);
				System.out.println("You have successfully joined the group: " + groupName);
				break; // Exit the loop after successful join
			} else {
				System.out.println("Group not found. Please try again.");
			}
		}
		return groupToJoin;
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
		String deleteGrp = Helper.readString("Enter Group Name > ");

		Group foundGroup = null;
		for (Group grp : grpList) {
			if (grp.getGroupName().equalsIgnoreCase(deleteGrp)) {
				foundGroup = grp;
				break;
			}
		}

		if (foundGroup != null) {
			grpList.remove(foundGroup);
			System.out.println(deleteGrp + " was successfully deleted");
		} else {
			System.out.println("Group not found");
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

	// --------------------------------------bike------------------------------------------------------
	public static void addBike(ArrayList<Bike> bikeList, Bike newBike) {
		Bike bike;
		// checking if user already exist
		for (int i = 0; i < bikeList.size(); i++) {
			bike = bikeList.get(i);
			if (bike.getBikeName().equalsIgnoreCase(newBike.getBikeName()))
				return;
		}
		if ((newBike.getBikeName().isEmpty()) || (newBike.getBikeType().isEmpty())) {
			System.out.println("Please fill in the entire thing");
			return;
		}
		bikeList.add(newBike);

	}

	public static void recommendEvents(ArrayList<Member> memberList, ArrayList<Event> eventList,
			String loggedInMemberName) {
		BikePortal.setHeader("RECOMMENDED EVENTS");
		String output = String.format("%-15s %-25s %-25s %-25s %-15s\n", "DIFFICULTY", "EVENT NAME", "DATE", "TIME ",
				"VENUE");

		for (Member mem : memberList) {
			if (mem.getUsername().equalsIgnoreCase(loggedInMemberName)) {
				String preference = mem.getPreference();
				for (Event event : eventList) {
					if (event.getDifficulty().equalsIgnoreCase(preference)) {
						output += String.format("%-15s %-25s %-25s %-25s %-15s\n", event.getDifficulty(),
								event.getEventName(), event.getEventDate(), event.getEventTime(), event.getVenue());
					}
				}
				break; // No need to continue once the logged-in member is found
			}
		}

		System.out.println(output);
	}

}

// test v2
