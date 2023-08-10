/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: {Kenneth Pang Yi Jie}
 * Student ID: {22011242}
 * Class: {C209-1D-W65E-A}
 * Date/Time created: Thursday 10-08-2023 14:51
 */

/**
 * @author solstation
 *
 */

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class BikePortalFinal {
	private static final int REG_OPTION = 2;
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
				if (BikePortalFinal.adminLogin(adminList, loginEmail, loginPW)) {
					adminMenu();
					int internalOption = Helper.readInt("Enter choice > ");
					while (internalOption != 5) {
						if (internalOption == 1) {
							BikePortalFinal.setHeader("View All Users");
//							BikePortalFinal.viewAllUser(memberList);
							BikePortalFinal.userPMenu();
							int userOption = Helper.readInt("Enter an option > ");
							while (userOption != 2) {
								if (userOption == 1) {
//									BikePortalFinal.deleteMember(memberList, regList);
								}
								BikePortalFinal.setHeader("View All Users");
//								BikePortalFinal.viewAllUser(memberList);
								BikePortalFinal.userPMenu();
								userOption = Helper.readInt("Enter an option > ");
							}
							BikePortalFinal.adminMenu();
							internalOption = Helper.readInt("Enter an option > ");
						} else if (internalOption == REG_OPTION) {
							BikePortalFinal.setHeader("View All Registrations");
//							BikePortalFinal.viewAllReg(regList);
							BikePortalFinal.regMenu();
							int regOption = Helper.readInt("Enter an option > ");
							while (regOption != 2) {
								if (regOption == 1) {
//									BikePortalFinal.removeReg(regList, memberList);
								}
								BikePortalFinal.setHeader("View All Registrations");
//								BikePortalFinal.viewAllReg(regList);
								BikePortalFinal.regMenu();
								regOption = Helper.readInt("Enter an option > ");
							}
							BikePortalFinal.adminMenu();
							internalOption = Helper.readInt("Enter an option > ");
						} else if (internalOption == 3) {
							BikePortalFinal.setHeader("View All Groups");
//							BikePortalFinal.viewAllGrp(grpList);
							BikePortalFinal.groupMenu();
							int grpOption = Helper.readInt("Enter an option > ");
							while (grpOption != 2) {
								if (grpOption == 1) {
//									BikePortalFinal.deleteGrp(grpList);
								}
								BikePortalFinal.setHeader("View All Groups");
//								BikePortalFinal.viewAllGrp(grpList);
								BikePortalFinal.groupMenu();
								grpOption = Helper.readInt("Enter an option > ");
							}
							BikePortalFinal.adminMenu();
							internalOption = Helper.readInt("Enter an option > ");
						} else if (internalOption == 4) {
//							BikePortalFinal.viewAllEvent(eventList);
							BikePortalFinal.eventMenu();
							int eventOption = Helper.readInt("Enter an option > ");
							while (eventOption != 2) {
								if (eventOption == 1) {
//									BikePortalFinal.deleteEvent(eventList);
								}
								BikePortalFinal.setHeader("View All Groups");
//								BikePortalFinal.viewAllEvent(eventList);
								BikePortalFinal.eventMenu();
								eventOption = Helper.readInt("Enter an option > ");
							}
							BikePortalFinal.adminMenu();
							internalOption = Helper.readInt("Enter an option > ");
						}
					}
				}
			} else if (option == 2) {
				BikePortalFinal.userSMenu();
				int internalOption = Helper.readInt("Enter an option > ");
				while (internalOption != 3) {
					if (internalOption == 1) {
						String loginEmail = Helper.readString("Enter username > ");
						String loginPW = Helper.readString("Enter password > ");
						if (BikePortalFinal.userLogin(memberList, loginEmail, loginPW)) {
							BikePortalFinal.userMenu();
							int loginOption = Helper.readInt("Enter an option > ");
							while (loginOption != 6) {
								if (loginOption == 1) {
									BikePortalFinal.setHeader("View All Groups");
//									BikePortalFinal.viewAllGrp(grpList);
									BikePortalFinal.currentGMenu();
									int grpOption = Helper.readInt("Enter an option > ");
									while (grpOption != 5) {
										if (grpOption == 1) {
											// need to create a method to view groups that user is currently in
										} else if (grpOption == 2) {
//											BikePortalFinal.createGrp(memberList, grpList);
										} else if (grpOption == 3) {
//											BikePortalFinal.joinGrp(grpList, memberList);
										} else if (grpOption == 4) {
//											BikePortalFinal.viewAllDiscussion(discussionList);
										}
									}
								} else if (loginOption == 2) {
									BikePortalFinal.setHeader("View All Events");
//									BikePortalFinal.recommendEvents(memberList, eventList, loginEmail);
									BikePortalFinal.currentEMenu();
									int eventOption = Helper.readInt("Enter an option > ");
									while (eventOption != 4) {
										if (eventOption == 1) {
											// need to create a method to view events that user is currently in
										} else if (eventOption == 2) {
//											BikePortalFinal.createEvent();
										} else if (eventOption == 3) {
//											BikePortalFinal.
										}
									}
								} else if (loginOption == 3) {
									int UserOption = 0;
									while (UserOption != 2) {
//										BikePortalFinal.findUser(memberList);
										UserOption = Helper.readInt("Enter an option > ");
									}
									BikePortalFinal.userMenu();
									loginOption = Helper.readInt("Enter option: ");
								} else if (loginOption == 4) {
									// charmain add your fucking code here
								} else if (loginOption == 5) {
									// delete this part
								}
							}

						}
					} else if (internalOption == 2) {
//						BikePortalFinal.inputUser(memberList, regList);
						BikePortalFinal.userSMenu();
						internalOption = Helper.readInt("Enter option: ");
					}
				}
			}
			BikePortalFinal.loginTypeMenu();
			option = Helper.readInt("Enter choice > ");
		}
		System.out.println("Good Bye!");

	}

	public static void loginTypeMenu() {
		BikePortalFinal.setHeader("LOGIN METHOD");
		System.out.println("1. Interact as Admin");
		System.out.println("2. Interact as User");
		System.out.println("3. Quit Program");
	}

	public static void adminMenu() {
		BikePortalFinal.setHeader("MY BIKE PORTAL - ADMIN CONTROL");
		System.out.println("1. View all User Accounts");
		System.out.println("2. View all Registrations");
		System.out.println("3. View all Groups");
		System.out.println("4. View all events");
		System.out.println("5. Logout");
		Helper.line(110, "-");

	}

	public static void userMenu() {
		BikePortalFinal.setHeader("MY BIKE PORTAL");
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
		BikePortalFinal.setHeader("GROUP PAGE");
		System.out.println("1. Delete a group");
		System.out.println("2. Return to previous page");
	}

	public static void regMenu() {
		BikePortalFinal.setHeader("REGISTRATION PAGE");
		System.out.println("1. Remove registration");
		System.out.println("2. Return to previous page");
	}

	public static void userPMenu() {
		BikePortalFinal.setHeader("USER PAGE");
		System.out.println("1. Delete user");
		System.out.println("2. Return to previous page");
	}

	public static void eventMenu() {
		BikePortalFinal.setHeader("EVENT PAGE");
		System.out.println("1. Delete event");
		System.out.println("2. Return to previous page");
	}

	public static void userSMenu() {
		BikePortalFinal.setHeader("USER OPTION");
		System.out.println("1. Login");
		System.out.println("2. Sign up");
		System.out.println("3. Return to previous page");
	}

	public static void currentGMenu() {
		BikePortalFinal.setHeader("GROUP PAGE");
		System.out.println("1. View current groups");
		System.out.println("2. Create");
		System.out.println("3. Join");
		System.out.println("4. View discussions");
		System.out.println("5. Return to previous page");
	}

	public static void currentG2Menu() {
		BikePortalFinal.setHeader("GROUP PAGE");
		System.out.println("1. Leave");
		System.out.println("2. Return to previous page");
	}

	public static void discussionMenu() {
		BikePortalFinal.setHeader("DISCUSSION PAGE");
		System.out.println("1. Leave discussion");
		System.out.println("2. Return to previous page");
	}

	public static void currentEMenu() {
		BikePortalFinal.setHeader("Event PAGE");
		System.out.println("1. View current events");
		System.out.println("2. Create");
		System.out.println("3. Join");
		System.out.println("4. Return to previous page");
	}

	// ADD YOUR METHODS BELOW
	
	//---------------------------------------------MEMBER---------------------------------------------------
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
			if (password.length() <= 8) {
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
		String new_username = newMember.getUsername();
		for (int i = 0; i < memberList.size(); i++) {
			member = memberList.get(i);
			String username = member.getUsername();
			if (username.equalsIgnoreCase(new_username))
				return;
		}
		if ((new_username.isEmpty()) || (newMember.getPassword().isEmpty())
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
	// --------------------------------------REG------------------------------------------------------------
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

}
