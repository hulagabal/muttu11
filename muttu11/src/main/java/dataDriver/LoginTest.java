package dataDriver;

import org.testng.annotations.Test;

public class LoginTest {
	@Test(dataProvider = "data", dataProviderClass=GetData.class )
	public void test12(String fname, String lname) {

		System.out.println(fname + " " + lname);

	}

}
