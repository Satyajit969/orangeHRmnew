package orangeHRMcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import OrangeHRM.library.Adminmoduleutils;
import OrangeHRM.library.User;
import Utils.Xlutils;

public class Userregtestcases  extends Adminmoduleutils{
	String datafile = "D:\\satya\\selenium work\\ORANGEHRM_DDT\\Testdatafiles\\Book1.xlsx";
	String datasheet = "userreg";
	@Test
	public void checkusereg() throws IOException, InterruptedException
	{ 
		        int rowcount = Xlutils.getRowCount(datafile, datasheet);
		        User us = new User();
				String role,username,empname,pwod;
			for(int i=1;i<=rowcount;i++)
			{
				role = Xlutils.getStringCellData(datafile, datasheet, i, 0);
				 username = Xlutils.getStringCellData(datafile, datasheet, i, 1);
				 empname = Xlutils.getStringCellData(datafile, datasheet, i, 2);
			  
			   pwod = Xlutils.getStringCellData(datafile, datasheet, i, 3);
			   
			   boolean res = us.addUser(role,  username,empname, pwod);
			   
			   Assert.assertTrue(res);
			   
			   if(res)
			   {
				   Xlutils.setCellData(datafile, datasheet, i, 4, "pass");
				   Xlutils.fillGreenColor(datafile, datasheet, i, 4);
			   }
	}

}
}