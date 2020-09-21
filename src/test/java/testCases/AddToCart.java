package testCases;
import mainMethods.*;
import pageObjects.AddToCartObject;
import pageObjects.ProducCheckObject;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.Assert;

public class AddToCart extends Base {
		
		
		public static String name;//declaring varibles globally so that can compare in another test
		public static String size;
		public static String price;
		@DataProvider
		public Object[][] getProductSearch() throws InvalidFormatException, IOException{
			return FatchExcelData.excelData(System.getProperty("user.dir")+"\\programData.xlsx","Sheet2");
		}
		@Test(priority=1 ,dataProvider="getProductSearch")
		public void selectProduct(String s,String s1) throws IOException, InterruptedException {
			services = startServer();
			AndroidDriver<AndroidElement> driver=Capabilities();
			Reporter.log("driver fatched");
			AddToCartObject add =new AddToCartObject(driver);
			Reporter.log("In the select product test");
			Utility.getWaitDriver(driver).until(ExpectedConditions.presenceOfElementLocated(AddToCartObject.homePage));//util homepage gets loaded
			AddToCartObject.getSearchOption().click();//going for the search option
			driver.getKeyboard().sendKeys(" "+s);
			driver.getKeyboard().sendKeys(Keys.ENTER);
			Reporter.log("product is searching");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Utility.getScrollTo(driver, s1);
			Utility.getWaitDriver(driver).until(ExpectedConditions.presenceOfElementLocated(AddToCartObject.searchPage));//wait until scroll to certain object
			List<MobileElement> prodlist = AddToCartObject.getProductList();//get the list of the diff. products
			Utility.getRandomElement(prodlist).click();//sending command to the random search from the list.
		}
		@Test(dependsOnMethods={"selectProduct"} )
		public void productDetail() throws IOException {
			Reporter.log("In the product detail test");
			AddToCartObject add =new AddToCartObject(driver);
			name=AddToCartObject.getName().getText();
			Reporter.log("name taken");
			size=AddToCartObject.getSize().getText();
			Reporter.log("size taken");
			price=AddToCartObject.getPrice().getText();
			Reporter.log("price taken");
		}
		@DataProvider
		public Object[][] getAddToCartText() throws InvalidFormatException, IOException{
			return FatchExcelData.excelData(System.getProperty("user.dir")+"\\programData.xlsx","Sheet3");
		}
		@Test(priority=3,dataProvider="getAddToCartText")
		public void addToCart(String s) throws IOException {
				Reporter.log("In the add to cart test");
				Utility.getScrollTo(driver, s);
				AddToCartObject add =new AddToCartObject(driver);
				AddToCartObject.getAddToCartOption().click();
				Reporter.log("product added to the cart");
				AddToCartObject.getDone().click();
		}
		
		@Test(priority=4,dependsOnMethods={"addToCart","productDetail"})
		public void checkProduct(String s) throws IOException {
			ProducCheckObject check=new ProducCheckObject(driver);
			ProducCheckObject.getAddToCart().click();//going to the cart
			Utility.getScrollTo(driver, name);
			ProducCheckObject.getProduct().click();
			try {
				Assert.assertEquals(name, ProducCheckObject.getName().getText());
				Reporter.log("name check");
				Assert.assertEquals(price, ProducCheckObject.getPrice().getText());
				Reporter.log("price check");
				Assert.assertEquals(size, ProducCheckObject.getSize().getText());
				Reporter.log("size check");
			}catch(Exception e) {
				e.printStackTrace();
			}
			Reporter.log("Yeah! TestRun Successfully");
			services.stop();
		}
}
