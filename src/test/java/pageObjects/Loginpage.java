package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage {
	
	public Loginpage(WebDriver driver)
	{
			super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='input-email']") WebElement email;
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	@FindBy(xpath="//input[@value='Login']") WebElement loginBtn;
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement loginConfirmation;
	public void sendEmail(String mail) {
		email.sendKeys(mail);
	}
	
	public void sendPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void loginButton() {
		loginBtn.click();
	}
	public String getLoginConformation() {
		return loginConfirmation.getText();
	}

}
