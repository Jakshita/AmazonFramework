package mainMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	public static AndroidDriver<AndroidElement> driver;
	public static AppiumDriverLocalService services;
	
	public AppiumDriverLocalService startServer() {
		if(!checkIfServerIsRunnning(4723)) {
			services = AppiumDriverLocalService.buildDefaultService();
			services.start();
		}
		return services;
	}
	public static boolean checkIfServerIsRunnning(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	public static AndroidDriver<AndroidElement> Capabilities() throws IOException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 240);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,Utility.getProperty("DeviceName"));
		cap.setCapability("appPackage",Utility.getProperty("PkgName"));
		cap.setCapability("appActivity",Utility.getProperty("ActivityName"));
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, Utility.getProperty("automationName"));
		cap.setCapability(MobileCapabilityType.NO_RESET,Utility.getProperty("noReset"));
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,Utility.getProperty("plateformName"));
		cap.setCapability(MobileCapabilityType.APPIUM_VERSION, 10);		
		System.out.println("cap set");
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("driver returned successfully");
		return driver;
	
	}
	public static void getScreenshot(String s) throws IOException {
		File scrnshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new File(System.getProperty("user.dir")+"\\"+s+".png"));
	}
	
}










