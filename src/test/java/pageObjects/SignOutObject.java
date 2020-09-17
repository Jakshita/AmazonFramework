package pageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignOutObject {
public static AndroidDriver<AndroidElement> driver;
	
	public SignOutObject(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
	}
	public static By homePage = By.id("in.amazon.mShop.android.shopping:id/alexa_decorator_fragment");
		
	//methods
	@AndroidFindBy(id="in.amazon.mShop.android.shopping:id/chrome_action_bar_burger_icon")
	private static MobileElement sideBar;
	public static MobileElement getSideBar() {
		return sideBar;
	}
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Settings']")
	private static MobileElement setting;
	public static MobileElement getSettings() {
		return setting;
	}
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Sign Out']")
	private static MobileElement signOutOption;
	public static MobileElement getSignOutOption() {
		return signOutOption;
	}
	@AndroidFindBy(xpath="//android.widget.Button[@text='Sign Out']")
	private static MobileElement confirm;
	public static MobileElement getConfirm() {
		return confirm;
	}
}










