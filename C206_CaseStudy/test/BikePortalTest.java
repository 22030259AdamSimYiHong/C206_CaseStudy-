import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BikePortalTest {
	
	// prepare test data
	private Member m1;
	private Member m2;
	private Member m3;
	private Admin a1;
	private Admin a2;
	private Admin a3;
	private Discussion d1;
	private Discussion d2;
	private Discussion d3;
	private Registration r1;
	private Registration r2;
	private Registration r3;

	private ArrayList<Member> memberList;
	private ArrayList<Admin> adminList;
	private ArrayList<Discussion> discussionList;
	private ArrayList<Registration> regList;

	@Before
	public void setUp() throws Exception {
		// Prepare Test Data (name, password)
		m1 = new Member("Keith", "Password1", "001", "Casual");
		m2 = new Member("Kween", "Password2", "002", "Competitive");
		m3 = new Member("Charmain", "Password3", "003", "Intermediate");
		a1 = new Admin("Yi Tuck", "Password4", "yituck@admin.com");
		a2 = new Admin("Kenneth", "Password5", "kenneth@admin.com");
		a3 = new Admin("Adam", "Password6", "adam@admin.com");
		d1 = new Discussion("Easy", "location", "Where is it located at?");
		d2 = new Discussion("Medium", "Bike", "What Bikes are allowed?");
		d3 = new Discussion("Hard", "Bike", "Is modded allowed?");
		r1 = new Registration("Char", "Char123", "001", "Casual");
		r2 = new Registration("Charming", "Char246", "002", "Competitive");
		r3 = new Registration("Charizard", "Char789", "003", "Casual");

		memberList = new ArrayList<Member>();
		adminList = new ArrayList<Admin>();
		discussionList = new ArrayList<Discussion>();
		regList = new ArrayList<Registration>();
		adminList.add(a1);
		adminList.add(a2);
		adminList.add(a3);
	}
//
//<<<<<<< HEAD
//	// Adam 1

	@Test
	public void testaddMember() {
		// Item list is not null and it is empty
		assertNotNull("Test if there is valid member arraylist to add to", memberList);
		assertEquals("Test that the Member arraylist is empty.", 0, memberList.size());

		// Given an empty list, after adding 1 item, the size of the list is 1
		BikePortal.addMember(memberList, m1);
		assertEquals("Test that the Member arraylist size is 1.", 1, memberList.size());

		// Add Member
		BikePortal.addMember(memberList, m2);
		assertEquals("Test that the Member arraylist size is now 2.", 2, memberList.size());

		// Test case 2: Test that there are missing details
		Member missing = new Member("Bob", "", "", "", "");
		BikePortal.addMember(memberList, missing);
		assertEquals("Test that the Member arraylist size is unchange.", 2, memberList.size());

		// Test Case 1: Add an item that already exists in the list
		BikePortal.addMember(memberList, m2);
		assertEquals("Test that the Member arraylist size is unchange.", 2, memberList.size());
		
	}
	// Adam 2
	@Test//
	public void testaddMembertoEvent() {
		// Item list is not null and it is empty
		assertNotNull("Test if there is valid memberEvent arraylist to add to", memberEventList);
		assertEquals("Test that the MemberEventarraylist is empty.", 0, memberEventList.size());
		
		// Given an empty list, after adding 1 item, the size of the list is 1
		BikePortal.addMemberEvent(memberEventList, me1);
		assertEquals("Test that the MemberEvent arraylist size is 1.", 1, memberEventList.size());
		
		// Add Member in to Events
		BikePortal.addMemberEvent(memberEventList, me2);
		assertEquals("Test that the MemberEvent arraylist size is now 2.", 2, memberEventList.size());

		// Test case 2: Test that there are missing details
		MembertoEvents missingg = new MemberEvent(" ");
		BikePortal.addMemberEvent(memberEventList, missingg);
		assertEquals("Test that the MemberEvent arraylist size is unchange.", 2, memberEventList.size());

		// Test Case 3: Add an item that already exists in the list
		BikePortal.addMemberEvent(memberGroupList, me2);
		assertEquals("Test that the MemberEvent arraylist size is unchange.", 2, memberEventList.size());
	}
// Adam 3
	@Test
	public void testaddMembertoGroup() {
		// Item list is not null and it is empty
		assertNotNull("Test if there is valid memberGroup arraylist to add to", memberGroupList);
		assertEquals("Test that the MemberGroup arraylist is empty.", 0, memberGroupList.size());
		
		// Given an empty list, after adding 1 item, the size of the list is 1
		BikePortal.addMemberEvent(memberGroupList, mg1);
		assertEquals("Test that the MemberGroup arraylist size is 1.", 1, memberGroupList.size());
		
		// Add Member in to Events
		BikePortal.addMemberEvent(memberGroupList, mg2);
		assertEquals("Test that the MemberGroup arraylist size is now 2.", 2, memberGroupList.size());

		// Test case 2: Test that there are missing details
		MembertoGroups missinggg = new MemberGroup(" ");
		BikePortal.addMemberEvent(memberGroupList, missinggg);
		assertEquals("Test that the MemberGroup arraylist size is unchange.", 2, memberGroupList.size());

		// Test Case 3: Add an item that already exists in the list
		BikePortal.addMemberGroup(memberGroupList, mg2);
		assertEquals("Test that the MemberGroup arraylist size is unchange.", 2, memberEventList.size());
	}

	// pls look at the code again, refer to ResourceCentre's codes not jujst do on
	// your own.
	public void test_search_bikers() {
		// Test case 1: Test when Biker ID exists.
		assertNotNull("test if there is valid member arraylist to loan from", memberList);
		// Adding bikers
		Boolean ok = member.doCheckMember(memberList, "m1", "001");
		assertTrue("Test if the biker id exists", ok);
		assertTrue(memberList.get(0).getIsBiker());
		assertEquals(memberList.get(0).getBikerId(), "001");
		String testOutput = "";
		testOutput += String.format("%-20s %-10s", "NAME", "BIKER ID");
		testOutput += String.format("%-20s %-10d", "Keith", 001);
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput);

		// Test case 2: Test when Biker ID does not exist.
		assertNotNull("test if there is valid member arraylist to look from", memberList);
		// Adding bikers
		m2.setIsBiker(false);
		C206.checkBiker(memberList, m2);
		assertFalse("Test that if the biker id does not exists", memberList.get(1).getIsBiker());
		ok = C206.doCheckMember(memberList, "m2", "999");
		assertFalse("Test that the biker id is not found.", ok);

		testOutput += String.format("%-20s %-10s", "NAME", "BIKER ID");
		testOutput += String.format("%-20s %-10d", "Keith", 001);
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput);

		// Test case 3: Test if the output is empty.
		ok = C206.doCheckMember(memberList, "");
		assertTrue("Test that there is no input.", ok);
		String testOutput = "";
		// Test that the details are displayed correctly
		assertEquals("Test that nothing is displayed", testOutput);

	}

	public void testJoinDiscussions() {
		//Test case 1: Test the discussion exists
		assertNotNull("test if there is valid discussion arraylist to look from", discussionList);
		  Boolean ok = Discussion.doCheckDiscussion(discussionList, "d1", "Sengkang");
	        assertTrue("Test if the discussion exists", ok);+
	        String testOutput = "";
	        testOutput += String.format("%-20s", "DISCUSSION");
	        testOutput += String.format("%-20s", "Sengkang");
	        // Test that the details are displayed correctly
	        assertEquals("Test that the display is correct.", testOutput);
	        
	        //Test case 2: Test that the details are displayed wrongly
	        assertNotNull("test if there is valid discussion arraylist to look from", discussionList);
	        d2.setIsDiscussion(false);
	        C206.checkBiker(memberList, m2);
	        assertFalse("Test that if the particular discussion does not exists", discussionList.get(1).getIsDiscussion());
	        ok = C206.doCheckDiscussion(discussionList, "d2", "999");
	        assertFalse("Test that the discussion is not found.", ok);
	        String testOutput = "No such discussion exists!";
	        
	        //Test case 3: Test if the output is empty.
	        ok = C206.doCheckDiscussion(discussionList, "");
	        assertTrue("Test that there is no input.", ok);
	        // Test that the details are displayed correctly
	        String testOutput = "";
	        assertEquals("Test that nothing is displayed", testOutput);
	}

	// Charmain
	@Test
	public void testAddReg() {
		// Reglist not null and is empty
		assertNotNull("Test if there is valid registration arraylist to add to", regList);
		assertEquals("Test that the Registration arraylist is empty.", 0, regList.size());
		// Given an empty list, after adding user, the size of the list is 1
		BikePortal.addReg(regList, r1);
		assertEquals("Test that the Registration arraylist size is 1.", 1, regList.size());
		// Add an item
		BikePortal.addReg(regList, r2);
		assertEquals("Test that the Registration arraylist size is now 2.", 2, regList.size());
		// The user just added already exist in the list
		assertSame("Test that User is added to the end of the list.", r2, regList.get(1));

		// Add an item that already exists in the list
		BikePortal.addReg(regList, r2);
		assertEquals("Test that the Registration arraylist size is unchange.", 2, regList.size());

		// Add an user that has missing detail
		Registration reg_missing = new Registration("CB0014", "", "", "");
		BikePortal.addReg(regList, reg_missing);
		assertEquals("Test that the Registration arraylist size is unchange.", 2, regList.size());
	}

	@Test
	public void testLoginAdmin() {
		assertTrue("Test that Admin Logs in with valid Username and Password",
				BikePortal.adminLogin(adminList, "yituck@admin.com", "Password4"));
		assertFalse("Test that the adminLogin does not go through.",
				BikePortal.adminLogin(adminList, "yituck@admin.com", ""));
		assertFalse("Test that the adminLogin does not go through.",
				BikePortal.adminLogin(adminList, "yituck@adbmin.com", "password4"));
	}
	@Test
	public void validate(){
		
	}
	
	// Kween

	@Test
	public void testEditMember() {
		// This is for member editing their own profile
	    // Simulate the member editing their own profile
		// Assume that existing member name is Adam Sim
	    Boolean isEdited = memberList.editMember(0, "Adam Sim Yi Hong");
	    assertTrue("Check that existing member 'Adam Sim' is edited to 'Adam Sim Yi Hong'", isEdited);

	    // Check that the member's name has been updated
	    String updatedName = memberList.viewMembers().get(0);
	    assertEquals("Adam Sim Yi Hong", updatedName);

	    // Try to edit the member's name to the same name, should still return true
	    isEdited = memberList.editMember(0, "Adam Sim Yi Hong");
	    assertTrue("Check that existing member 'Adam Sim Yi Hong' is edited to 'Adam Sim Yi Hong'", isEdited);
	}

	@Test
	public void testAddAndEditDiscussion() {
	    // This is to add in a discussion to the arrayList
	    assertNotNull("Check if there is valid discussion arraylist to add to", discussionList.discussionDescriptions);
	    discussionList.addDiscussion("Discuss about cycling tips");

	    Boolean isEdited = discussionList.editDiscussion(10, "Discuss about benefits of cycling");
	    assertFalse("Check that non-existing discussion at index 10 is edited - false?", isEdited);

	    // This is to check that the discussion name has been successfully edited
	    isEdited = discussionList.editDiscussion(0, "How to cycle?");
	    assertTrue("Check that existing discussion 'Discuss about cycling tips' at index 0 is edited to 'How to cycle?' - true", isEdited);

	    isEdited = discussionList.editDiscussion(0, "Cycling competitions");
	    assertFalse("Check that already edited discussion at index 0 is edited again - false?", isEdited);
	}

	@Test
	public void testDeleteDiscussion() {
	    // This is to check that there is a valid discussion to delete in the arrayList
	    assertNotNull("Check if there is valid discussion arraylist to delete from", discussionList.discussionDescriptions);
	    discussionList.addDiscussion("Discuss about project A");

	    // error
	    Boolean isDeleted = discussionList.deleteDiscussion(10);
	    assertFalse("Check that non-existing discussion at index 10 is deleted - false?", isDeleted);

	    // Check if the discussion can be deleted
	    isDeleted = discussionList.deleteDiscussion(0);
	    assertTrue("Check that existing discussion 'Discuss about project A' at index 0 is deleted - true", isDeleted);

	    // error
	    isDeleted = discussionList.deleteDiscussion(0);
	    assertFalse("Check that already deleted discussion at index 0 is deleted again - false?", isDeleted);
	}


	@After
	public void tearDown() throws Exception {
		m1 = null;
		m2 = null;
		m3 = null;
		a1 = null;
		a2 = null;
		a3 = null;
		d1 = null;
		d2 = null;
		d3 = null;
		r1 = null;
		r2 = null;
		r3 = null;
		memberList = null;
		adminList = null;
		discussionList = null;
		regList = null;
	}

}
