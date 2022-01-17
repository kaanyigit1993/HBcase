import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class HepsiBuradaCase2 extends CapabilitiesClass {
	public static AppiumDriver<WebElement> driver;
	public static DesiredCapabilities cap;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
		
		driver.findElementByXPath("//*[@content-desc='Süper fiyat süper teklif']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Casper Nirvana S500.1021-BV50X-G-F Intel Core i5 10210U 16GB 500GB SSD MX230 Freedos 15.6\" FHD Taşınabilir Bilgisayar']").click();
		driver.findElementsByClassName("android.widget.ImageView").get(1).click();
		
		
		
		WebElement panel = driver.findElementByClassName("android.widget.ImageView");
		
		
		SwipeScreen(panel,driver);

		SwipeScreen(panel,driver);
		
		
		driver.findElementByXPath("//*[@content-desc='Geri']").click();
		String begenilenUrunIsmi = driver.findElementByXPath("//android.widget.TextView[@text='Lenovo 400 Kablosuz Mouse GY50R91293']").getText();
		driver.findElementByXPath("//android.widget.TextView[@text='favoriye ekle']").click();
		
	
		driver.findElementById("txtUserName").click();
		driver.findElementById("txtUserName").sendKeys("tr.kaan.yigit@gmail.com");
		driver.findElementByXPath("//android.widget.Button[@text='Giriş yap']").click();
		
		driver.findElementById("txtPassword").click();
		driver.findElementById("txtPassword").sendKeys("Aa5226++");
		driver.findElementByXPath("//android.widget.Button[@text='Giriş yap']").click();
		
		String loginCheckControl = driver.findElementByXPath("//android.widget.TextView[@text='Hoş geldin Kaan Yiğit. Keyifli alışverişler dileriz.']").getAttribute("name");
		
		try {
			Assert.assertEquals("Hoş geldin Kaan Yiğit. Keyifli alışverişler dileriz.", loginCheckControl);
			System.out.println("Başarıyla Login Olunmuştur!");
			
			
			driver.navigate().back();
			
			driver.findElementByXPath("//*[@content-desc='Hesabım']").click();
			driver.findElementByXPath("//android.widget.TextView[@text='Beğendiklerim']").click();
			
			String loginSonrasiBegenilenUrunIsmi = driver.findElementByXPath("//android.widget.TextView[@text='Lenovo 400 Kablosuz Mouse GY50R91293']").getText();
					
					
			if (begenilenUrunIsmi == loginSonrasiBegenilenUrunIsmi ) {
				System.out.println("Ürün eşleşti, Case başarılı!");
			}else {
				System.out.println("Case başarısız");
			}
			
		}catch (Exception e)
		{
			System.out.println("Hatalı login!");
		}
	}
	public static void SwipeScreen(WebElement el, WebDriver driver) throws InterruptedException {
		WebElement panel = el;
		
		Dimension dimension = panel.getSize();
		
		int anchor = panel.getSize().getHeight()/2;
		
		Double ScreenWidthStart = dimension.getWidth() * 0.8;
		int scrollStart = ScreenWidthStart.intValue();
		
		Double ScreenWidthEnd = dimension.getWidth() * 0.2;
		int scrollEnd = ScreenWidthEnd.intValue();

		new TouchAction((PerformsTouchActions) driver)
		.press(PointOption.point(scrollStart,anchor))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(scrollEnd,anchor)).release().perform();
		
		Thread.sleep(3000);
		driver.quit();	
	}

}



















