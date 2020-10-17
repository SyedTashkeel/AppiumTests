package AppiumTestSet;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class OpenCalculator {

	// Declare a driver
	
		//WebDriver driver;
		//AndroidDriver driver;
			static AppiumDriver<MobileElement> driver;
			
	public static void main(String[] args) {
					
		// Call below function
			
		try {
			
			openCalc();
			
		} catch (Exception exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
		}
		
	}
		public static void openCalc() throws Exception {
			
			// Inititate desired capabilities
			DesiredCapabilities cap = new DesiredCapabilities();
			
			// Set capabilites for the device
			cap.setCapability("automationName", "Appium");
			cap.setCapability("deviceName", "G7 ThinQ");
			cap.setCapability("udid", "LMG710ULM9e9c7dd8");
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "8.0.0");
			
			Thread.sleep(3000);
			
			// Connect device by passing root IP and Port
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url,cap);
			
			Thread.sleep(3000);
			
			// Set capabilites for the mobile application
			// Download APK Info app to get required details on the device
			cap.setCapability(MobileCapabilityType.FULL_RESET, false);
			cap.setCapability("appPackage", "com.google.android.calculator");
			cap.setCapability("appActivity", "com.android.calculator2.Calculator");
			
			// Using Appium Desktop Inspector identify elements
			
			Thread.sleep(3000);
		
			MobileElement two = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
			MobileElement plus = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
			MobileElement three = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
			MobileElement equals = driver.findElement(By.id("com.google.android.calculator:id/eq"));
			MobileElement result = driver.findElement(By.className("android.widget.TextView"));
			
			two.click();
			plus.click();
			three.click();
			
			Thread.sleep(3000);
			
			equals.click();
			
			String res = result.getText();
			System.out.println("\n Result is:"+res);
			
			System.out.println("Test Completed..."); 
		}
}
