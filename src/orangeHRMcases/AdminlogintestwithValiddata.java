package orangeHRMcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import OrangeHRM.library.Loginpage;
import Utils.AppUtils;
import Utils.Xlutils;

public class AdminlogintestwithValiddata extends AppUtils {
	String datafile = "D:\\satya\\selenium work\\ORANGEHRM_DDT\\Testdatafiles\\Book1.xlsx";
	String datasheet = "Adminlogin_validdata";
	
	@Test
	public void checkAdminLogin() throws IOException
	{
			
		int rowcount = Xlutils.getRowCount(datafile, datasheet);
		
		String uid,pwd;
		
		Loginpage lp = new Loginpage();
		
		for(int i=1;i<=rowcount;i++)
		{
			uid = Xlutils.getStringCellData(datafile, datasheet, i, 0);
			pwd = Xlutils.getStringCellData(datafile, datasheet, i, 1);
			lp.login(uid, pwd);
			boolean res = lp.isAdminModuleDisplayed();
			Assert.assertTrue(res);
			if(res)
			{
				Xlutils.setCellData(datafile, datasheet, i, 2, "Pass");
				Xlutils.fillGreenColor(datafile, datasheet, i, 2);
			}else
			{
				Xlutils.setCellData(datafile, datasheet, i, 2, "Fail");
				Xlutils.fillRedColor(datafile, datasheet, i, 2);
			}
			lp.logout();			
		}
		
		
		
	}
	

}
