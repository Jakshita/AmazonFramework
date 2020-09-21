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
	@AndroidFindBy(className="android.widget.TextView")
	private static MobileElement product;
	public static MobileElement getProduct() {
		return product;
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
	@AndroidFindBy(className="android.widget.Button")
	private static MobileElement size;
	public static MobileElement getSize() {
		return size;
	}
}
