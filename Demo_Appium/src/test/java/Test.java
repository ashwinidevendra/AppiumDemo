import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Test {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		DesiredCapabilities capabilities = new DesiredCapabilities();
		// 1
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "8.1");
		// 2
		File file = new File(
				"C:\\Users\\ashwini.velapure\\Downloads\\News by The Times of India Newspaper Latest News_v5.1.9.0_apkpure.com.apk");
		capabilities.setCapability("app", file.getAbsolutePath());
		// 3
		// capabilities.setCapability("browserName", "Chrome");
		// capabilities.setCapability("noReset", true);
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\ashwini.velapure\\Driver\\chromedriver.exe");
		AndroidDriver driver = new AndroidDriver(new URL("http://192.168.99.2:4723/wd/hub"), capabilities);

		// driver.get("http://www.google.com");
		driver.installApp("C:\\Users\\ashwini.velapure\\Downloads\\News by The Times of India Newspaper Latest News_v5.1.9.0_apkpure.com.apk");
		//driver.startActivity("com.toi.reader.activities", "com.toi.reader.activities.NavigationFragmentActivity");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement ele = driver.findElementByXPath("//*[@resource-id='com.toi.reader.activities:id/menu_search']");
		ele.click();
		WebElement ele2 = driver.findElementByXPath("//*[@resource-id='com.toi.reader.activities:id/search_src_text']");
		ele2.sendKeys("India");
		ele2.sendKeys(Keys.ENTER);
		System.out.println("search results are displayed");

	}

}
