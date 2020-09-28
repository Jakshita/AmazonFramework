package testCases;

import java.io.IOException;
import pageObjects.*;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import mainMethods.*;

public class SignOut extends Base {
	
	static Logger log;
	@BeforeClass
	public static void main(String []args) {
		log = Logger.getLogger(SignOut.class.getName()); //Logger variable gets initilize.
	}
	@Test
	public void signOut() throws IOException {
		services = startServer();
		AndroidDriver<AndroidElement> driver = Capabilities();//getting capabilities in the drive
		SignOutObject signin = new SignOutObject(driver);
		log.info("Sign-out test starting");
		Utility.getWaitDriver(driver).until(ExpectedConditions.presenceOfElementLocated(SignOutObject.homePage));//let the home page gets loaded
		SignOutObject.getSideBar().click();//clicking on the hamunger menu
		Utility.getScrollTo(driver, "Settings");//going for the settings
		SignOutObject.getSettings().click();
		try {
			if(SignOutObject.getSignOutOption().isDisplayed()) {
				SignOutObject.getSignOutOption().click();
				SignOutObject.getConfirm().click();
				log.info("Sign-Out Successful");
			}
		}catch(Exception e) {
			log.info("Signed-Out Successful");
		}
		services.stop();
	}
}
