package testCases;

import java.io.IOException;
import pageObjects.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import mainMethods.*;

public class SignOut extends Base {
	
	@Test
	public void signOut() throws IOException {
		services = startServer();
		AndroidDriver<AndroidElement> driver = Capabilities();//getting capabilities in the driver
		SignOutObject signin = new SignOutObject(driver);
		Utility.getWaitDriver(driver).until(ExpectedConditions.presenceOfElementLocated(SignOutObject.homePage));//let the home page gets loaded
		SignOutObject.getSideBar().click();
		Utility.getScrollTo(driver, "Settings");
		SignOutObject.getSettings().click();
		try {
			if(SignOutObject.getSignOutOption().isDisplayed()) {
				SignOutObject.getSignOutOption().click();
				SignOutObject.getConfirm().click();
			}else {
				System.out.println("already signout");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		services.stop();
	}
}
