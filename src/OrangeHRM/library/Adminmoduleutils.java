package OrangeHRM.library;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Utils.AppUtils;

public class Adminmoduleutils extends AppUtils {
	String Adminuid= "Admin";
	String Adminpwd = "Qedge123!@#";
	Loginpage lp;
	@BeforeTest
	public void adminlogin()
	{
		
	 lp = new Loginpage();
				lp.login(Adminuid,Adminpwd);
	}
	@AfterTest
	public void adminlogout()
	{
		lp.logout();	
		}

}
