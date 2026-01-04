package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


//Data is Valid - login success - test pass - logout
//				login failed - test fail
//				
//
//Data is inValid - login success - test fail - logout
//				login failed - test pass
//	


public class TC002_AccountLoginDDT extends BaseClass{
	
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups= {"regression", "master"} )
	void AccountLoginDDT(String email, String pw, String exp )
	{
		
		logger.info("******** Starting TC002 LoginDDT*********");
		try {
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(email);
		lp.setPD(pw);
		lp.login();
		
		Thread.sleep(5000);
		MyAccountPage map= new MyAccountPage(driver);
		boolean targetpage=map.isMyAccountPageExists();
		
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetpage==true) {
				map.logout();
				Assert.assertTrue(true);
				
			}
			else {
				Assert.assertTrue(false);
			}	
		}
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetpage==true) {
				map.logout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		  }
		}
		catch(Exception e) {
			Assert.fail("An Exception occurred: " + e.getMessage());
			
		}
		logger.info("******** Ending TC002 LoginDDT*********");
    }
}
