package mainMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

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
	public static MobileElement getRandomElement(List<MobileElement> list) 
    { 
		int n=list.size();
		list.remove(0);
		list.remove(n-1);
        Random rand = new Random(); 
        return list.get(rand.nextInt(list.size())); 
    }
}
