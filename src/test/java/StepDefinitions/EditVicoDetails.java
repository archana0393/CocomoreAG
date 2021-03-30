package StepDefinitions;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Steps.EditVicoDetailsSteps;
import Steps.PublicVicoProfilePageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditVicoDetails {
	WebDriver driver;
	EditVicoDetailsSteps editVico;
	@Given("User visits Profile editing screen")
	public void user_visits_Profile_editing_screen() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://vicoland:fFierOce@qa-fe.vicoland.com/en/login");
		driver.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys("meeraagney@gmail.com");
		driver.findElement(By.xpath("//input[@id='inputPass']")).sendKeys("Reaction123*");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//mat-icon[normalize-space()='edit']")).click();
	}
	@And("user enters (.*) and (.*)$")
	public void user_enters_name_and_we_will(String viconame,String slogan) throws InterruptedException {

		editVico=new EditVicoDetailsSteps(driver);
		editVico.editVicoDetails(viconame, slogan);
	}
	@When("user visits public vico profile page")
	public void user_visits_public_vico_profile_page() throws InterruptedException, AWTException {
		editVico.VisitPublicVicoPage();
	}
	@Then("edited details should be Updated in public vico profile page.")
	public void preview_of_edited_details_should_be_displayed_there() {
		editVico.PublicPageDetailsCheck();
		driver.quit();
	}
}
