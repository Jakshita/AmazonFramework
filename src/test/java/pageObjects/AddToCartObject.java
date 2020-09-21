package pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class AddToCartObject {
	public static AndroidDriver<AndroidElement> driver;
	public AddToCartObject(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);		
	}
	public static By homePage = By.id("in.amazon.mShop.android.shopping:id/alexa_decorator_fragment");//by object for giving wait conditions
	public static By searchPage = By.className("android.view.View");//by object for giving wait conditions
	//methods
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Search']")
	private static MobileElement searchOption;
	public static MobileElement getSearchOption() {
		return searchOption;
	}
	@AndroidFindBy(uiAutomator ="new UiSelector().className(\"android.view.View\").index(0)")
	private static List<MobileElement> productList;
	public static List<MobileElement> getProductList() {
		return productList;
	}
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Add to Cart']")
	private static MobileElement addToCartOption;
	public static MobileElement getAddToCartOption() {
		return addToCartOption;
		
	}
	@AndroidFindBy(xpath="//android.view.View[@text='DONE']")
	private static MobileElement done;
	public static MobileElement getDone() {
		return done;	
	}
	@AndroidFindBy(className="android.widget.Button")
	private static MobileElement size;
	public static MobileElement getSize() {
		return size;
	}
	@AndroidFindBy(className="android.view.View")
	private static MobileElement name;
	public static MobileElement getName() {
		return name;
	}
	@AndroidFindBy(className="android.widget.EditText")
	private static MobileElement price;
	public static MobileElement getPrice() {
		return price;
	}
}
