package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registration extends Basepage  {
	
	public Registration(WebDriver driver) {
		
		super(driver);
		
	}
	
@FindBy(xpath="//input[@id='input-firstname']") WebElement firstName;
@FindBy(xpath="//input[@id='input-lastname']") WebElement lastName;
@FindBy(xpath="//input[@id='input-email']") WebElement email;
@FindBy(xpath="//input[@id='input-telephone']") WebElement phone;
@FindBy(xpath="//input[@id='input-password']") WebElement passWord;
@FindBy(xpath="//input[@id='input-confirm']") WebElement cnfrmPassWord;
@FindBy(xpath="//input[@name='agree']") WebElement chkagree;
@FindBy(xpath="//input[@value='Continue']") WebElement btnconti;
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement confirmation;

public void setFirstNAme(String fname) {
	firstName.sendKeys(fname);
}

public void setLastName(String lname) {
	lastName.sendKeys(lname);
}
public void setEmail(String mail) {
	email.sendKeys(mail);
}

public void setPhone(String tel) {
	phone.sendKeys(tel);
}
public void setPassWord(String pwd) {  //password and confirm password we can use same parameters
	passWord.sendKeys(pwd);
}
public void cnfrmPassWord(String pwd) {
	cnfrmPassWord.sendKeys(pwd);
}
public void checkList() {
	chkagree.click();
}

public void button() {
	//sol1
	btnconti.click();
	
	//sol2
	//btnconti.submit();
	
	//sol3
	//Actions act=new Actions(driver);
	//act.moveToElement(btnconti.click().perform();
	
	//sol4
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("arguments[0].click();",btnconti);
	
	//sol5
	//WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(20));
	//mywait.until(ExpectedConditions.elementToBeClickable(btnconti);
	
}

public String getConfirmation() {
	try {
		return confirmation.getText();
	}catch(Exception e) {
		return(e.getMessage());
		
	}
}




	

}
