package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Lib {

	static WebDriver driver;

	public static String GNprinttitle(WebDriver driver) {
		String value = driver.getTitle();
		return value;

	}

	public static WebElement FindEle(WebDriver driver, String xpath) {
		// The above function pretty much takesthe place of driver.findElement...It's
		// shorter.
		WebElement Ele = driver.findElement(By.xpath(xpath));
		return Ele;
	}

	public static String readproperties(String key) throws IOException {
		File fl = new File("src\\test\\resource\\ObjectRepo\\locator.properties");
		FileInputStream fis = new FileInputStream(fl);
		Properties prop = new Properties();
		prop.load(fis);
		String locatr = prop.getProperty(key);
		return locatr;

	}

	public static void takescreensho(WebDriver driver) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	}

	public void selectDay() {
		WebElement element = driver.findElement(By.xpath(""));
		Select r = new Select(element);
		r.selectByVisibleText("");

	}

}
