package testCases;

import mainMethods.*;
import pageObjects.*;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SignIn extends Base {
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		return FatchExcelData.excelData(System.getProperty("user.dir")+"\\programData.xlsx","Sheet1");
	}
	@Test(dataProvider="getExcelData")
	public void signIn(String username,String password) throws IOException, InterruptedException {
		services = startServer();
		AndroidDriver<AndroidElement> driver = Capabilities();//getting capabilities in the driver
		Reporter.log("driver fatched");
		SignInObject signin =new SignInObject(driver); //sending driver in the pageobject class
		Reporter.log("In the sign-in class");
		Utility.getWaitDriver(driver).until(ExpectedConditions.presenceOfElementLocated(SignInObject.homePage));//let the home page gets loaded
		try {
			if(SignInObject.getsignInOption().isDisplayed()) {
				SignInObject.getsignInOption().click();//clicking on the sign-in option from homepage
				Utility.getWaitDriver(driver).until(ExpectedConditions.presenceOfElementLocated(SignInObject.signInPage));//wait until userid option comes
				SignInObject.getEnterUserId().sendKeys(username);//userid entered
				driver.hideKeyboard();
				SignInObject.getContinueOption().click();//continue
				Thread.sleep(5000);
				SignInObject.getEnterPassword().sendKeys(password);//enter password
				driver.hideKeyboard();
				SignInObject.getContinueOption().click();//continue
				Reporter.log("sign-in successfully");
			}
			else {
				Reporter.log("already sign-in");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		services.stop();
	}	
	@BeforeTest
	public void killAllNodes() throws IOException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");//to kill the appium server if already running in the local machine
		Reporter.log("Killing all the running server");
	}
}
