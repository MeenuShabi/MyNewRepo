package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNg3 {
	
	
	SoftAssert softAssert = new SoftAssert();
  @Test(priority=1)
  public void createUser() {
	  
	  System.out.println("I'm in end test");
	  System.out.println("Before assertion");
	  Assert.assertTrue(4>3,"Verifying element"); //in industry we use regular assert
	 
	  System.out.println("After assertion");
	  Assert.assertEquals("abc","abc");
  }
  
  @Test(priority=2, dependsOnMethods = "createUser")
  public void editUser()
  {
	  System.out.println("Before assertion");
	 softAssert.assertTrue(2>3,"verifying element");
	  System.out.println("After assert");
	  softAssert.assertAll(); //similar to error collector in junit
  }
  
  
  
 
  
  @Test(priority=3, dependsOnMethods = "editUser")
  public void deletUser() {
	  
	  System.out.println("I'm in end test");
	  System.out.println("Before assertion");
	  softAssert.assertTrue(2>3,"Verifying element"); //in industry we use regular assert
	  System.out.println("after assertion");
	  softAssert.assertEquals("abc","abc");
	  softAssert.assertAll();
  }
  
  
}
