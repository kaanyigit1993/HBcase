import java.net.MalformedURLException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


import static io.appium.java_client.touch.offset.ElementOption.element;

public class HepsiBuradaCase1 extends CapabilitiesClass{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Konum']").click();
		
		//driver.findElementsByClassName("android.widget.ImageView").get(0).click();
		driver.findElementByXPath("//*[@content-desc='İl seçin']").click();
		
		String containedTextKontrolEdilecekIlBilgisi = "Kocaeli";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedTextKontrolEdilecekIlBilgisi + "\").instance(0))")); 
		driver.findElementByXPath(("//*[@text='Kocaeli']")).click();
		
		driver.findElementByXPath("//*[@content-desc='İlçe seçin']").click();
		
		String containedText1 = "İzmit";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText1 + "\").instance(0))")); 
		driver.findElementByXPath(("//*[@text='İzmit']")).click();
		
		driver.findElementByXPath("//*[@content-desc='Mahalle seçin']").click();
		String containedText2 = "Topçular";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText2 + "\").instance(0))")); 
		driver.findElementByXPath(("//*[@text='Topçular']")).click();
		
		driver.findElementByXPath("//android.widget.Button[@text='Kaydet']").click();
		
		String popUpMessage = driver.findElementByXPath("//android.widget.TextView[@text='Konumunuz kaydedildi.']").getAttribute("name");
		try {
			Assert.assertEquals("Konumunuz kaydedildi.", popUpMessage);
			System.out.println("Adres bilgisi başarıyla kaydedildi!" + popUpMessage);
			
			
			driver.findElementByXPath("//android.widget.TextView[@text='Kategoriler']").click();
			
			/**
			int count = 11;
			
			Random r = new Random(); 
			int a = r.nextInt(count);
			
			driver.findElementsByClassName("android.view.ViewGroup").get(a).click();
			*/
			driver.findElementByXPath("//android.widget.TextView[@text='Spor Giyim - Aksesuar']").click();
			
			String yarinKapindaIlBilgisi = driver.findElementByXPath("//android.widget.TextView[@text='Kocaeli']").getAttribute("name");
			
			/*
			if (containedTextKontrolEdilecekIlBilgisi == yarinKapindaIlBilgisi) {
				System.out.println("İl bilgisi eşleşiyor, case başarıyla tamamlanmıştır! = " + yarinKapindaIlBilgisi);
			}else {
				System.out.println("Hatalı il bilgisi");
			}
			*/
			Assert.assertEquals("Kocaeli", yarinKapindaIlBilgisi);
			System.out.println("İl bilgisi doğru gelmektedir. = " + yarinKapindaIlBilgisi);
			
		}catch (Exception e)
		{
			System.out.println("Adres bilgisi kayıt edilemedi!");
		}
		
	}

}
