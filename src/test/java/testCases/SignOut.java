package testCases;

import java.io.IOException;
import pageObjects.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import mainMethods.*;

public class SignOut extends Base {
	
	@Test
	public void signOut() throws IOException {
		services = startServer();
		AndroidDriver<AndroidElement> driver = Capabilities();//getting capabilities in the driver
		Reporter.log("driver fatched");
		SignOutObject signin = new SignOutObject(driver);
		Reporter.log("In the sign out test");
		Utility.getWaitDriver(driver).until(ExpectedConditions.presenceOfElementLocated(SignOutObject.homePage));//let the home page gets loaded
		SignOutObject.getSideBar().click();//clicking on the hamunger menu
		Utility.getScrollTo(driver, "Settings");//going for the settings
		SignOutObject.getSettings().click();
		try {
			if(SignOutObject.getSignOutOption().isDisplayed()) {
				SignOutObject.getSignOutOption().click();
				SignOutObject.getConfirm().click();
			}else {
				Reporter.log("Already sign-out");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		services.stop();
	}
}
