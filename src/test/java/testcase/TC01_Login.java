package testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobj.Loginpage;
import testbase.BaseClass;

public class TC01_Login extends BaseClass {
		
	@Test
	public void test() throws IOException {
		
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		
		Loginpage lp=new Loginpage(driver);
		
		try{
		lp.clicksignin();
		lp.email("abcmno@gmail.com");
		lp.passwrod("abc1234");
		lp.submit();
		String getmsg=lp.cfnname();
		System.out.println(getmsg);
		if(getmsg.equals("John K")) {
        Assert.assertTrue(true);
		}
		}
        catch(Exception e) {
        	screenshot("test",driver);
			 Assert.assertTrue(false);
		}
		lp.logout();
	}
}
