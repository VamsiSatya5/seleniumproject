package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccount;
import testBase.Baseclass;
import utilities.Dataprovider;

/* Data is valid -login success -test pass-valid-logout
 * Data is valid-login fail-test fail
 * Data is invalid-login success-test fail-logout
 * Data is invalid-login fail-test pass
 */
public class LoginDDT extends Baseclass {
	
	
	
	@Test(dataProvider="LoginData",dataProviderClass=Dataprovider.class)
	public void logindata(String mail,String password,String result){
		
	try {

	Homepage hp = new Homepage(driver);
	hp.clickMyAccount();
	hp.clickLogin();

	Loginpage login = new Loginpage(driver);
	login.sendEmail(mail);
	login.sendPassword(password);
	login.loginButton();

	Myaccount msg = new Myaccount(driver);
	boolean actualmessage = msg.getLoginConformation();
	
	if(result.equalsIgnoreCase("valid"))
	{
		if(actualmessage==true) {
			
			msg.signOut();
			Assert.assertTrue(true); //test pass
			
			
		}else
		{
			Assert.assertTrue(false); //test fail
			
		}
		if(result.equalsIgnoreCase("invalid")) {
			if(actualmessage==true) {
				msg.signOut();
				Assert.assertTrue(false);//test is failed
				
			}else {
				Assert.assertTrue(true);//test is pass
			}
		}
		
	}
	
	}catch(Exception e) {
		Assert.fail();
	}
	}

}
