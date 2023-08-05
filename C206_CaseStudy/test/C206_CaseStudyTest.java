import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

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

	private ArrayList<Member> memberList;
	private ArrayList<Admin> adminList;
	private ArrayList<Discussion> discussionList;

	public C206_CaseStudyTest
	{
		super();
	}

	@Before
	public void setUp() throws Exception {
		// Prepare Test Data (name, password)
		m1 = new Member("Keith", "Password1", "001", "Casual");
		m2 = new Member("Kween", "Password2", "002", "Competitive");
		m3 = new Member("Charmain", "Password3", "003", "Intermediate");
		a1 = new Admin("Yi Tuck", "Password4", "yituck@admin.com");
		a2 = new Admin("Kenneth", "Password5", "kenneth@admin.com");
		a3 = new Admin("Adam", "Password6", "adam@admin.com");
		d1 = new Discussion("Easy", "location","Where is it located at?");
		d2 = new Discussion("Medium", "Bike", "What Bikes are allowed?");
		d3 = new Discussion("Hard", "Bike", "Is modded allowed?");

		memberList = new ArrayList<Member>();
		adminList = new ArrayList<Admin>();
		discussionList = new ArrayList<Discussion>();
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	public void testaddMember() {
		// Item list is not null and it is empty
		assertNotNull("Test if there is valid member arraylist to add to", memberList);
		assertEquals("Test that the member arraylist is empty.", 0, memberList.size());

		// Given an empty list, after adding 1 item, the size of the list is 1
		BikePortal.addMember(memberList, m1);
		assertEquals("Test that the Camcorder arraylist size is 1.", 1, memberList.size());

		// Add Member
		BikePortal.addMember(memberList, m2);
		assertEquals("Test that the Member arraylist size is now 2.", 2, memberList.size());
		

		// Test case 1: Test that there are missing details
		Member missing = new Member("Bob", "", "", "");
		BikePortal.addMember(memberList, missing);
		assertEquals("Test that the Member arraylist size is unchange.", 2, memberList.size());

		// Test Case 2: Add an item that already exists in the list
		BikePortal.addMember(memberList, m2);
		assertEquals("Test that the Camcorder arraylist size is unchange.", 2, memberList.size());

	}

	public void testaddMembertoEvent() {
		
	}
	
	public void testaddMembertoGroup() {
		
	}
	
	//pls look at the code again, refer to ResourceCentre's codes not jujst do on your own.
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
		memberList = null;
		adminList = null;
		discussionList = null;
	}

}
