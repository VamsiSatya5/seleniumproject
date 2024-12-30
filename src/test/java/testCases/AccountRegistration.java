package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Registration;
import testBase.Baseclass;

public class AccountRegistration extends Baseclass {
	
	
	@Test(groups={"Sanity","Regression"})
	public void account() {
		
		logger.info("Starting the test case");
		try {
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on my account link");
		
		hp.clickLoginAccount();
		
		Registration res=new Registration(driver);
		
		logger.info("providing customer details");
		res.setFirstNAme("vamsi");
		res.setLastName(randomString());
		res.setEmail(randomString()+"@gmail.com");
		res.setPhone(randomNumber() );
		
		String password=alphaNumeric();  //Because we are storing password as both confirm password should be same right 
		
		res.setPassWord(password);
		res.cnfrmPassWord(password);
		res.checkList();
		res.button();
		
		logger.info("validating expected message");
		
		String confirmMsg=res.getConfirmation();
		//Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
		if(confirmMsg.equals("Your Account Has Been Created!")){
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test failed");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
		
		
		}
		catch(Exception e) {
			
			//logger.error("Test failed");
			//logger.debug("Debug logs");
			Assert.fail();
		}
		logger.info("Account registration is successfully done");
		}
	
}
