package Steps;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Util.Lib;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class GUIStepDefinition extends Lib {

	public static WebDriver driver = null;

	@Before
	public void initial() throws IOException {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resource\\ObjectRepo\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		driver.get(readproperties("url"));
	}

	@Given("^User at homepage$")
	public void homepage() {
		System.out.println("I am at google signup homepage " + driver.getTitle());
		String exptitle= "Create your Google Account";
		String Acttitle = driver.getTitle();
		
		//better way to compare instead of using if and else 
		
		Assert.assertEquals("Wrong Homepage ERROR",exptitle, Acttitle);
	}
	

	@When("^$")
	public void enterfirstname() throws IOException {
		FindEle(driver, readproperties("firstname")).sendKeys("Bryan");
	}

	@When("^User enter firstname \"([^\"]*)\"$")
	public void user_enter_firstname(String arg1) throws Throwable {
		FindEle(driver, readproperties("firstname")).sendKeys(arg1);
	}

	@When("^User enter lastname \"([^\"]*)\"$")
	public void user_enter_lastname(String arg1) throws Throwable {
		FindEle(driver, readproperties("lastname")).sendKeys(arg1);
	}

	@When("^User enter username \"([^\"]*)\"$")
	public void user_enter_username(String arg1) throws Throwable {
		FindEle(driver, readproperties("username")).sendKeys(arg1);
	}
	@When("^User enter password \"([^\"]*)\"$")
	    public void user_enter_password(String arg1) throws Throwable {
		FindEle(driver, readproperties("password")).sendKeys(arg1);
	}
	@When("^User enter confirm \"([^\"]*)\"$")
	    public void user_enter_confirm(String arg1) throws Throwable {
		FindEle(driver, readproperties("confirm")).sendKeys(arg1);
	}
	@Then("^User click next$")
	public void user_click_next() throws Throwable {
		FindEle(driver, readproperties("next")).click();
	}

	@Then("^User will see error message$")
	public void user_will_see_error_message() throws IOException {
		String experror = "Use 8 characters or more for your password";
		String acterror = FindEle(driver, readproperties("errormessage")).getText();
		Assert.assertEquals("error message is not matching",experror, acterror);
	}
	@After
	public void teardown() {
//		driver.manage().deleteAllCookies();
//		driver.close();
	}
}