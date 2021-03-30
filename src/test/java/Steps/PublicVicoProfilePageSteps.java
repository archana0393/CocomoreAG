package Steps;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PublicVicoProfilePageSteps {

	WebDriver driver;
	String parentHandle;
	public PublicVicoProfilePageSteps(WebDriver driver) {
		this.driver=driver;
	}
	By username=By.xpath("//input[@id='inputEmail']");
	By passwordField=By.xpath("//input[@id='inputPass']");
	By submitButton=By.xpath("//button[@type='submit']");
	By profileTab=By.xpath("//span[contains(text(),'Profile')]");
	By vicoAccessLink=By.xpath("//a[@href='https://qa-pub.vicoland.com/vico.php?id=18']");
	By freeAdviceBtn=By.xpath("//button[@id='ninjaDesktopContact']");
	public PublicVicoProfilePageSteps typeUserName(String email) {
		driver.findElement(username).sendKeys(email);
		return this;
	}
	public PublicVicoProfilePageSteps typePassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
		return this;
	}
	public PublicVicoProfilePageSteps submitClick() {

		driver.findElement(submitButton).click();
		return this;
	}
	public PublicVicoProfilePageSteps loginCheck() throws InterruptedException {
		Thread.sleep(3000);

		if(driver.getPageSource().contains("Your email or password is incorrect")) {
			System.out.println("Login failed, Unable to continue");
			return this;
		}
		else {
			System.out.println("Login Success, Welcome!You can Proceed");
			return this;
		}
	}

	public PublicVicoProfilePageSteps profileTabclick()	{
		driver.findElement(profileTab).click();
		System.out.println("Successfully clicked on profile tab icon");
		return this;
	}
	public PublicVicoProfilePageSteps linkClick() throws InterruptedException	{
		Thread.sleep(3000);
		parentHandle = driver.getWindowHandle();
		driver.findElement(vicoAccessLink).click();
		Thread.sleep(3000);
		return this;
	}
	public PublicVicoProfilePageSteps navigateNewWindow() throws InterruptedException, AWTException, IOException
	{
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); 
		}
		Thread.sleep(3000);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_I);
		robot.keyRelease(KeyEvent.VK_I);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyPress(KeyEvent.VK_O);
		robot.keyRelease(KeyEvent.VK_O);
		robot.keyPress(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_L);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_N);
		robot.keyPress(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_D);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_F);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_I);
		robot.keyRelease(KeyEvent.VK_I);
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_O);
		robot.keyRelease(KeyEvent.VK_O);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		robot.keyPress(KeyEvent.VK_ENTER);
		System.out.println("User clicked on the link in profile name and navigated to new tab");
		Thread.sleep(3000);
		return this;
	}
	public PublicVicoProfilePageSteps PublicVicoPageCheck() throws InterruptedException
	{

		Thread.sleep(3000);
		if(driver.getPageSource().contains("Your direct contact:")) {
			System.out.println("User is taken to pulic Vico profile page");
			return this;
		}
		else {
			System.out.println("Failed");
			return this;
		}
	}
	public PublicVicoProfilePageSteps scrollOverthePage() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,4250)", "");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-4250)", "");
		return this;
	}
	public PublicVicoProfilePageSteps vicoDetails() {
		String vicoName=driver.findElement(By.xpath("//div[@class='hero-content']//child::h1[1]")).getText();
		System.out.println("Vico name is------"+vicoName);
		String sloganName=driver.findElement(By.xpath("//div[@class='hero-content']//child::h1[2]")).getText();
		System.out.println("Slogan is------"+sloganName);
		return this;
	}
	public PublicVicoProfilePageSteps Login(String email,String password) throws InterruptedException, AWTException, IOException
	{
		typeUserName(email);
		typePassword(password);
		submitClick();
		loginCheck();
		return this;
	}
}
