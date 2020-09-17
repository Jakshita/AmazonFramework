package pageObjects;

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
	public static By homePage = By.id("in.amazon.mShop.android.shopping:id/alexa_decorator_fragment");
	
	//methods
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Search']")
	private static MobileElement searchOption;
	public static MobileElement getSearchOption() {
		return searchOption;
	}
	@AndroidFindBy(xpath="//android.widget.Image[@text='Mi TV 4X 163.9 cm (65 Inches) 4K Ultra HD Android LED TV (Black)']")
	private static MobileElement tvOptions;
	public static MobileElement getTvsOption() {
		return tvOptions;
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
	@AndroidFindBy(xpath="//android.widget.Button[@text=' Size name: 65 Inches ']")
	private static MobileElement size;
	public static MobileElement getSize() {
		return size;
	}
	@AndroidFindBy(xpath="//android.view.View[@text='Mi TV 4X 163.9 cm (65 Inches) 4K Ultra HD Android LED TV (Black)']")
	private static MobileElement name;
	public static MobileElement getName() {
		return name;
	}
	@AndroidFindBy(xpath="//android.widget.EditText[@text='rupees 54,999']")
	private static MobileElement price;
	public static MobileElement getPrice() {
		return price;
	}
}












