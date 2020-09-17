package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignInObject {
	public static AndroidDriver<AndroidElement> driver;
	
	public SignInObject(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	//by objects for wait
	public static By homePage = By.id("in.amazon.mShop.android.shopping:id/alexa_decorator_fragment");
	public static By signInPage = By.className("android.widget.EditText");
	//methods
	@AndroidFindBy(xpath="//android.widget.Button[@text='Sign in']")
	private static MobileElement signInOption;
	public static MobileElement getsignInOption() {
		return signInOption;
	}
	@AndroidFindBy(className="android.widget.EditText")
	private static MobileElement enterUserId;
	public static MobileElement getEnterUserId() {
		return enterUserId;
	}
	@AndroidFindBy(className="android.widget.Button")
	private static MobileElement continueOption;
	public static MobileElement getContinueOption() {
		return continueOption;
	}
	@AndroidFindBy(className="android.widget.EditText")
	private static MobileElement enterPassword;
	public static MobileElement getEnterPassword() {
		return enterPassword;
	}
}








