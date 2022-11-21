package orangeHRMcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import OrangeHRM.library.Adminmoduleutils;
import OrangeHRM.library.Employee;
import Utils.Xlutils;

public class Empregtest extends Adminmoduleutils{
	String datafile = "D:\\satya\\selenium work\\ORANGEHRM_DDT\\Testdatafiles\\Book1.xlsx";
String datasheet = "Empreg";
      @Test 
      public void Checkempreg() throws IOException
{
		int rowcount = Xlutils.getRowCount(datafile, datasheet);
		Employee emp = new Employee();
		String fname ,lname ;
		for( int i=1;i<=rowcount;i++)
		{
			fname= Xlutils.getStringCellData(datafile, datasheet, i, 0);
			lname= Xlutils.getStringCellData(datafile, datasheet, i, 1);
			boolean res = emp.addEmployee(fname, lname);
			Assert.assertTrue(res);
			if(res)
			{
				Xlutils.setCellData(datafile, datasheet, i, 2, "pass");
				Xlutils.fillGreenColor(datafile, datasheet, i, 2);
			}
				else 
				{
					Xlutils.setCellData(datafile, datasheet, i,2, "Fail");
				   Xlutils.fillRedColor(datafile, datasheet, i, 2);
				   
				}
		
}            
}
}