package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProducCheckObject {
	
public static AndroidDriver<AndroidElement> driver;
	
	public ProducCheckObject(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);	
	}
	
	@AndroidFindBy(className="android.widget.TextView")
	private static MobileElement addToCart;
	public static MobileElement getAddToCart() {
		return addToCart;
	}
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Mi TV 4X 163.9 cm (65 Inches) 4K Ultra HD Android LED TV (Black)']")
	private static MobileElement product;
	public static MobileElement getProduct() {
		return product;
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
	@AndroidFindBy(xpath="//android.widget.Button[@text=' Size name: 65 Inches ']")
	private static MobileElement size;
	public static MobileElement getSize() {
		return size;
	}
}









