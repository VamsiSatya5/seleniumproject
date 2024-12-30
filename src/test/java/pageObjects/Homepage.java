package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {
	
	
	
	public Homepage(WebDriver driver)
	{
			super(driver);
		
	}



@FindBy(xpath="//span[normalize-space()='My Account']") WebElement linkAccount;

@FindBy(xpath="//a[normalize-space()='Register']") WebElement regAccount;
@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']") WebElement logAccount;

public void clickMyAccount() 
{
	linkAccount.click();
}
public void clickLoginAccount()
{
	regAccount.click();
	
}
public void clickLogin() {
	
	logAccount.click();
	
}

}