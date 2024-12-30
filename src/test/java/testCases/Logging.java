package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccount;
import testBase.Baseclass;

public class Logging extends Baseclass {

	
	//@Listeners(testCases.Mylistener)
	@Test(groups="Sanity")
	public void accountLogin() {
		
		try {
		logger.info("Login Test starting");

		Homepage hp = new Homepage(driver);
		hp.clickMyAccount();
		hp.clickLogin();

		Loginpage login = new Loginpage(driver);
		login.sendEmail("bandivamsi347@gmail.com");
		login.sendPassword("Java");
		login.loginButton();

		Myaccount msg = new Myaccount(driver);
		boolean actualmessage = msg.getLoginConformation();
		// Assert.assertEquals(actualmessage, true,"Login failed");

		AssertJUnit.assertTrue(actualmessage);
		}
		catch(Exception e) {
			
		AssertJUnit.fail();
			
		}
		
		logger.info("Login test finished");
	}

}
