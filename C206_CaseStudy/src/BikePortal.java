import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * I declare that this code was writen by me.
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

		memberList.add(new Member("Charmain", "CharmainIsCool", "CharmainAwesome", "Competitive"));
		memberList.add(new Member("Adam", "AdminIsCool", "AdamAwesome", "Competitive"));

		adminList.add(new Admin("Charmain", "Charmaintan08@gmail.com", "CharmainAwesome"));
		adminList.add(new Admin("kween", "kween08@gmail.com", "kweenAwesome"));

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

		eventList.add(new Event("Exclusive Bike Ride", "Competitive", LocalDate.parse("08/15/2023", dateFormatter),
				LocalTime.parse("14:30", timeFormatter), "Suntec City"));

		int option = 0;

		while (option != OPTION_EXIT) {

			// ADMIN
			BikePortal.loginTypeMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				BikePortal.adminMenu();
				int choice = Helper.readInt("Enter an option > ");

				if (choice == 1) {
					BikePortal.setHeader("View All User");
					BikePortal.viewAllUser(memberList);
				} else if (choice == 2) {
					BikePortal.setHeader("View Registrations");
					BikePortal.viewAllReg(regList);
				} else if (choice == 3) {
					BikePortal.setHeader("Delete User");
					BikePortal.deleteMember(memberList);
				} else if (choice == 4) {

				} else if (choice == 5) {
					BikePortal.setHeader("Delete Registration");
					BikePortal.removeReg(regList);
				} else if (choice == 6) {
					System.out.println("Logged Out");
					break;
				} else {
					System.out.println("Invalid Choice");

				}

			} else if (option == 2) {
				// USER
				BikePortal.userMenu();
				int choice = Helper.readInt("Enter an option > ");
				if (choice == 1) {
					BikePortal.setHeader("Create a Group");

				} else if (choice == 2) {
					BikePortal.setHeader("View all Group");

				} else if (choice == 3) {
					BikePortal.setHeader("Join a Group");
				} else if (choice == 4) {
					BikePortal.setHeader("Delete an exiting Group");
				} else if (choice == 5) {
					Event newEvent = createEvent();
					if (addEvent(eventList, newEvent) == true) {
						BikePortal.setHeader("Create an event");
						BikePortal.addEvent(eventList, newEvent);
						System.out.println("Successfully Added ");

					} else {
						System.out.println("Unsuccessful");
					}

				} else if (choice == 6) {
					BikePortal.setHeader("View all Events ");
					BikePortal.viewAllEvent(eventList);
				} else if (choice == 7) {
					BikePortal.setHeader("Delete Existing Event");
				} else if (choice == 8) {
					BikePortal.setHeader("Create a Discussion");
				} else if (choice == 9) {
					BikePortal.setHeader("View All Discussion");
				} else if (choice == 10) {
					BikePortal.setHeader("Join a Discussion");
				} else if (choice == 11) {
					BikePortal.setHeader("Delete an Existing Discussion");
				}

				else {
					System.out.println("Invalid Choice");
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
		Helper.line(80, "-");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	//-------------------------------------------MEMBER------------------------------------------------------------
	
	//Obtaining all the Member from the memberList
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
		// checking if user have input all the fields required
		memberList.add(newMember);

	}
	
	public static void deleteMember(ArrayList<Member> memberList) {
		Member mem;
		String deleteUser = Helper.readString("Enter the user to delete > ");
		for (int i = 0; i < memberList.size(); i++) {
			mem = memberList.get(i);
			if (mem.getUsername().equalsIgnoreCase(deleteUser)) {
				memberList.remove(i);
				break;
			}
		}
		System.out.println("User not found");

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
	
	public static boolean addEvent(ArrayList<Event> eventList, Event newEvent) {
		Event event;
		// checking if user already exist
		for (int i = 0; i < eventList.size(); i++) {
			event = eventList.get(i);
			if (event.getEventName().equalsIgnoreCase(newEvent.getEventName()))
				return (false);
		}
		if ((newEvent.getEventName().isEmpty()) || (newEvent.getDifficulty().isEmpty())
				|| (newEvent.getEventDate() == null) || (newEvent.getEventTime() == null)
				|| (newEvent.getVenue().isEmpty())) {
			System.out.println("Please fill in the entire thing");
			return (false);
		}
		return (true);

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

	public static void removeReg(ArrayList<Registration> regList) {
		Registration reg;
		String removeReg = Helper.readString("Enter the username to remove from registration list > ");
		for (int i = 0; i < regList.size(); i++) {
			reg = regList.get(i);
			if (reg.getUsername().equalsIgnoreCase(removeReg)) {
				regList.remove(i);
				break;
			} else {
				System.out.println("User not found");
			}
		}

	}

}
