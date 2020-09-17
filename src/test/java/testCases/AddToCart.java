package testCases;
import mainMethods.*;
import pageObjects.AddToCartObject;
import pageObjects.ProducCheckObject;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.Assert;

public class AddToCart extends Base {
		
		
		public static String name;
		public static String size;
		public static String price;
		@DataProvider
		public Object[][] getProductSearch() throws InvalidFormatException, IOException{
			return FatchExcelData.excelData(System.getProperty("user.dir")+"\\programData.xlsx","Sheet2");
		}
		@Test(priority=1 ,dataProvider="getProductSearch")
		public void selectProduct(String s) throws IOException {
			services = startServer();
			AndroidDriver<AndroidElement> driver=Capabilities();
			AddToCartObject add =new AddToCartObject(driver);
			Utility.getWaitDriver(driver).until(ExpectedConditions.presenceOfElementLocated(AddToCartObject.homePage));
			AddToCartObject.getSearchOption().click();
			driver.getKeyboard().sendKeys(" "+s);
			driver.getKeyboard().sendKeys(Keys.ENTER);
			System.out.println("product get searched");
			Utility.getTouchAction(driver).press(PointOption.point(482,1503)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1300))).moveTo(PointOption.point(516,1592)).release().perform();
			AddToCartObject.getTvsOption().click();
		}
		@Test(dependsOnMethods={"selectProduct"} )
		public void productDetail() throws IOException {
			System.out.println("in the product detail methods");
			AddToCartObject add =new AddToCartObject(driver);
			name=AddToCartObject.getName().getText();
			size=AddToCartObject.getSize().getText();
			price=AddToCartObject.getPrice().getText();
			System.out.println(name+" "+size+" "+price);
		}
		@DataProvider
		public Object[][] getAddToCartText() throws InvalidFormatException, IOException{
			return FatchExcelData.excelData(System.getProperty("user.dir")+"\\programData.xlsx","Sheet3");
		}
		@Test(priority=3,dataProvider="getAddToCartText")
		public void addToCart(String s) throws IOException {
				System.out.println("in the add to cart method");
				Utility.getScrollTo(driver, s);
				AddToCartObject add =new AddToCartObject(driver);
				AddToCartObject.getAddToCartOption().click();
				AddToCartObject.getDone().click();
		}
		@DataProvider
		public Object[][] getProductSearchInCart() throws InvalidFormatException, IOException{
			return FatchExcelData.excelData(System.getProperty("user.dir")+"\\programData.xlsx","Sheet4");
		}
		@Test(priority=4,dependsOnMethods={"addToCart","productDetail"},dataProvider="getProductSearchInCart")
		public void checkProduct(String s) throws IOException {
			ProducCheckObject check=new ProducCheckObject(driver);
			ProducCheckObject.getAddToCart().click();
			Utility.getScrollTo(driver, s);
			check.getProduct().click();
			try {
				Assert.assertEquals(name, ProducCheckObject.getName().getText());
				System.out.println("name check");
				Assert.assertEquals(price, ProducCheckObject.getPrice().getText());
				System.out.println("price check");
				Assert.assertEquals(size, ProducCheckObject.getSize().getText());
				System.out.println("size check");
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("yippeee!!! test run successfully");
			services.stop();
		}
}