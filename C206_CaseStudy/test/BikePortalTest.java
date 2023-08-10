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
	private Bike b1;
	private Bike b2;

	private ArrayList<Member> memberList;
	private ArrayList<Admin> adminList;
	private ArrayList<Discussion> discussionList;
	private ArrayList<Registration> regList;
	private ArrayList<Bike> bikeList;

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
		b1 = new Bike("bmw", "sports");
		b2 = new Bike("kawasaki", "offroad");
		

		memberList = new ArrayList<Member>();
		adminList = new ArrayList<Admin>();
		discussionList = new ArrayList<Discussion>();
		regList = new ArrayList<Registration>();
		bikeList =new ArrayList<Bike>();
		adminList.add(a1);
		adminList.add(a2);
		adminList.add(a3);
		
	}
//
//<<<<<<< HEAD 1
//	// Adam 1

	@Test
	public void testaddMember() {
		// Item list is not null and it is empty
		assertNotNull("Test if there is valid member arraylist to add to", memberList);
		assertEquals("Test that the Member arraylist is empty.", 0, memberList.size());

		// Given an empty list, after adding 1 item, the size of the list is 1
		BikePortalFinal.addMember(memberList, m1);
		assertEquals("Test that the Member arraylist size is 1.", 1, memberList.size());

		// Add Member
		BikePortal.addMember(memberList, m2);
		assertEquals("Test that the Member arraylist size is now 2.", 2, memberList.size());

		// Test case 1: Test that there are missing details
		Member missing = new Member("Bob", "", "", "");
		BikePortalFinal.addMember(memberList, missing);
		assertEquals("Test that the Member arraylist size is unchange.", 2, memberList.size());

		// Test Case 2: Add an item that already exists in the list
		BikePortalFinal.addMember(memberList, m2);
		assertEquals("Test that the Member arraylist size is unchange.", 2, memberList.size());
		
	}
	// Adam 2
	@Test//
	public void testviewallMembers() {
		// Item list is not null and it is empty
		//test that all members can be viewed
		
	    assertNotNull("Check that viewed members list is not null", memberList);
	    assertEquals("Test that the Member arraylist is empty", 0, memberList.size());
	    // Add Member
	 	BikePortalFinal.addMember(memberList, m1);
	 	
	 	assertEquals("Test that the Member arraylist size is now 2.", 1, memberList.size());
	    assertTrue("Check if the viewed members list contains the test member", memberList.contains(m1));

	}
	// Adam 3
	@Test
		public void testDeleteExistingMember() {
//		test case 1
		// Add members and registrations
        BikePortalFinal.addMember(memberList, m1);
        BikePortalFinal.addMember(memberList, m2);
        BikePortalFinal.addReg(regList, r1);
        BikePortalFinal.addReg(regList, r2);

        // Initial sizes of lists
        assertEquals("Test that Member arraylist size is 2", 2, memberList.size());
        assertEquals("Test that Reg arraylist size is 2", 2, regList.size());

        // Delete a member and registration (assumed functionality)
        BikePortalFinal.deleteMember(memberList, regList, "001");

        // Check that the member and registration were removed
        assertEquals("Test that Member arraylist size is 1 after deletion", 1, memberList.size());
        assertEquals("Test that Reg arraylist size is 1 after deletion", 1, regList.size());

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
	    assertFalse("Test that the adminLogin does not go through when wrong username or password is input.",
	        BikePortal.adminLogin(adminList, "yituckadmin.com", "Password4"));
	    assertFalse("Test that the adminLogin does not go through when wrong username or password is input.",
		        BikePortal.adminLogin(adminList, "yituck@admin.com", "assword4"));
	
	    
	  }
	  @Test
	  public void testValidateRegAdmin(){
	    assertTrue("Test that Admin Reegistered with valid email and a strong password",BikePortal.validateRegAdmin("charmaintan@admin.com", "12345678"));
	    assertFalse("Test that if Admin Registers with an invalid email",BikePortal.validateRegAdmin("charmaintan_gmail.com", "12345678"));
	    assertFalse("Test that if Admin Registers with a weak password",BikePortal.validateRegAdmin("Charmaintan@gmail.com", "123456"));
	    assertFalse("Test that if Admin Registers with an invalid email and weak password",BikePortal.validateRegAdmin("chrmaint.com", "12"));
	    //test empty field
	  }
	  //charmain
	  @Test
	    public void testDeleteBike() {
	    // Test Case 1 - Loan an available Item
	      assertNotNull("test if there is valid Bike arraylist to loan from", bikeList);
	      BikePortal.deleteBike(bikeList, "bmw");
	      assertEquals("Test that the Bike arraylist size is 0.", 0, bikeList.size());
	      
	    }
	    @Test
		public void testViewAllBike() {
			// Item list is not null and it is empty
			// Test that all members can be viewed
			
		    assertNotNull("Check that viewed bike list is not null", bikeList);
		    assertEquals("Test that the Bike arraylist is empty", 0, memberList.size());
		    // Add Member
		 	BikePortalFinal.addMember(memberList, m1);
		 	assertEquals("Test that the Member arraylist size is now 2.", 1, memberList.size());
		    assertTrue("Check if the viewed members list contains the test member", memberList.contains(m1));

		}
	  @Test
	  public void testAddBike() {
			// Reglist not null and is empty
			assertNotNull("Test if there is valid bike arraylist to add to", bikeList);
			assertEquals("Test that the Bike arraylist is empty.", 0, bikeList.size());
			// Given an empty list, after adding bike, the size of the list is 1
			BikePortal.addBike(bikeList, b1);
			assertEquals("Test that the Bike arraylist size is 1.", 1, bikeList.size());
			// Add bike
			BikePortal.addBike(bikeList, b2);
			assertEquals("Test that the Bike arraylist size is now 2.", 2, bikeList.size());
			assertSame("Test that bike is added to the end of the list.", b2, bikeList.get(1));
			// Add an item that already exists in the list
			BikePortal.addBike(bikeList,b2);
			assertEquals("Test that the Bike arraylist size is unchange.", 2, bikeList.size());

			// Add an user that has missing detail
			Bike detail_missing = new Bike("yahma", "");
			BikePortal.addBike(bikeList, detail_missing);
			assertEquals("Test that the Bike arraylist size is unchange.", 2, bikeList.size());
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
	
	// Yi Tuck
	  @Test
	  public void testRecommendGroups() {
	    //Test for Casual preference and Easy difficulty
	    assertEquals("Test that Member preference matches with Discussion difficulty", m1.getPreference(), d1.getDifficulty());
	    
	    // Test for Intermediate preference and Medium difficulty
	    assertEquals("Test that Member preference matches with Discussion difficulty", m3.getPreference(), d2.getDifficulty());
	    
	    // Test that Competitive preference and Hard difficulty
	    assertEquals("Test that Member preference matches with Discussion difficulty", m2.getPreference(), d3.getDifficulty());
	    
	  }
	  
	  // Yi Tuck
	  @Test
	  public void testViewMemberGroup() {
	    // Test that Member has missing details
	    assertNull("Test that missing member name returns null", m1.getName());
	    assertNull("Test that missing member username returns null", m1.getUsername());
	    
	    // Test that members can be viewed
	    assertTrue("Test that member username is not null", m2.getUsername() != null);
	    assertTrue("Test that member name is not null", m2.getName() != null);
	    
	  }
	  
	  // Yi Tuck
	  @Test
	  public void testViewMemberdetails() {
		  // Test that no Member fields are missing
		  assertNotNull("Test that member name is not missing", m3.getName());
		  assertNotNull("Test that member password is not empty", m3.getPassword());
		  assertFalse("Test that member username is not empty", m3.getUsername() == null);
		  assertNotNull("Test that member preference is not missing", m3.getPreference());
		  // Test that Members details can be viewed
		  assertFalse("Test that the member name can be viewed", m1.getName() == null);
		  assertFalse("Test that the member username can be viewed", m1.getUsername() == null);
		  
	  }
	  
	  // Yi Tuck
	  @Test
	  public void testDeletedetails() {
		// Test that Members details can be deleted
		  assertEquals("Test that memberlist size decrease by 1", 2, memberList.size());
		  
		  for(Member member : memberList) {
			  assertNotEquals("Test that deleted member is no longer in the memberlist", "003", member.getUsername());
		  }
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
		b1=null;
		memberList = null;
		adminList = null;
		discussionList = null;
		regList = null;
		bikeList=null;
	}

}
