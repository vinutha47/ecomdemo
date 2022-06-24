package pageobj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver driver;
	
	public Loginpage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//locators
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement clicksignin;
	
	@FindBy(name="email")
	WebElement mailid;
	
	@FindBy(name="passwd")
	WebElement pw;
	
	@FindBy(xpath="//*[@id=\"SubmitLogin\"]/span")
	WebElement button;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")
	WebElement confirmname;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
	WebElement logout;
	
	//action methods
	public void clicksignin() {
		clicksignin.click();
	}
	
	public void email(String name) {
		mailid.sendKeys(name);
	}
	
	public void passwrod(String pwd) {
		pw.sendKeys(pwd);
	}
	
	public void submit() {
		button.click();
	}
	
	public String cfnname() {

		String username=confirmname.getText();
		return username;
	}
	
	
	public void logout() {
		logout.click();
	}
	
	
}
