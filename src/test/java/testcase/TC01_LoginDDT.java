package testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobj.Loginpage;
import testbase.BaseClass;
import utilities.XLUtility;

public class TC01_LoginDDT extends BaseClass {
		
	@Test(dataProvider="LoginData")
	public void test(String email,String pwd) throws IOException {
		
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		
		Loginpage lp=new Loginpage(driver);
		
		try{
		lp.clicksignin();
		lp.email(email);
		lp.passwrod(pwd);
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
	
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\testdataauto.xlsx";
		
		XLUtility xlutil=new XLUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)  //1
		{		
			for(int j=0;j<totalcols;j++)  //0
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return logindata;
				
	}
}
