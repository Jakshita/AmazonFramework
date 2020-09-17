package mainMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Properties;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Utility {
	
	public static void getScrollTo(AndroidDriver<AndroidElement> driver,String s) {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+s+"\").instance(0))");
	}
	
	public static String getProperty(String s) throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\mainMethods\\Global.properties");
		Properties properties = new Properties();
		properties.load(file);
		return properties.getProperty(s);
	}
	public static WebDriverWait getWaitDriver(AndroidDriver<AndroidElement> driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		return wait;
	}
	public static TouchAction getTouchAction(AndroidDriver<AndroidElement> driver) {
		TouchAction action = new TouchAction(driver);
		return action;
	}
}