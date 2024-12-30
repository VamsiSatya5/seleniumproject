package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccount extends Basepage {

	public Myaccount(WebDriver driver) {
		super(driver);

	}
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement loginConfirmation;

	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement logout;

	public boolean getLoginConformation() {
		try {
			return(loginConfirmation.isDisplayed());
		}catch(Exception e) {
			return false;
		}


	}

	public void signOut(){

		logout.click();

	}


}
