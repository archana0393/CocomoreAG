package StepDefinitions;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Steps.PublicVicoProfilePageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class PublicVicoProfile {
	WebDriver driver;
	PublicVicoProfilePageSteps pvicoprofile;
	@Given("Browser is open and user is taken to internal vico login page")
	public void browsee_is_open_and_user_is_taken_to_internal_vicoprofile_page()  {
		System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://vicoland:fFierOce@qa-fe.vicoland.com/en/login");
		System.out.println("Browser is open and user is taken to internal vico login page");
	}
	@And("^User enters (.*) and (.*) and logged in to the application.$")
	public void user_is_logged_in_to_the_application(String email,String password) throws InterruptedException, AWTException, IOException {
		pvicoprofile=new PublicVicoProfilePageSteps(driver);
		pvicoprofile.Login(email, password);
	}
	@And("User visits profile tab.")
	public void user_visits_profile_tab() {
		pvicoprofile.profileTabclick();
	}
	@When("User click on link to access public vico profile page under vico name")
	public void user_click_on_link_to_access_public_vico_profile_page_under_vico_name() throws InterruptedException, AWTException, IOException {
		pvicoprofile.linkClick();
		pvicoprofile.navigateNewWindow();
	}
	@Then("Public vico profile page is displayed in a new tab also vico details are displayed.")
	public void public_vico_profile_page_is_displayed_in_a_new_tab() throws InterruptedException {
		pvicoprofile.PublicVicoPageCheck();
		pvicoprofile.scrollOverthePage();
		pvicoprofile.vicoDetails();
		driver.quit();

	}
}
