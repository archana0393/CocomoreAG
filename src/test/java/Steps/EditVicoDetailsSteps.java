package Steps;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditVicoDetailsSteps {
	WebDriver driver;
	String parentHandle;
	public EditVicoDetailsSteps(WebDriver driver) {
		this.driver=driver;

	}
	By vicoName=By.xpath("//input[@placeholder='Add Vico name']");
	By sloganField=By.xpath("//input[@placeholder='Add your slogan']");
	By saveButton=By.xpath("//span[normalize-space()='Save']");
	public EditVicoDetailsSteps editVicoDetails(String viconame,String slogan) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(vicoName).sendKeys(viconame);
		Thread.sleep(3000);
		driver.findElement(sloganField).sendKeys(slogan);
		driver.findElement(saveButton).click();
		return this;
	}
	public EditVicoDetailsSteps VisitPublicVicoPage() throws InterruptedException, AWTException	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='https://qa-pub.vicoland.com/vico.php?id=18']")).click();
		Thread.sleep(3000);
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
		Thread.sleep(3000);
		return this;
	}
	public EditVicoDetailsSteps PublicPageDetailsCheck() {

		String vicoUpdatedName=driver.findElement(By.xpath("//div[@class='hero-content']//child::h1[1]")).getText();
		System.out.println("Updated Vico name is....." +vicoUpdatedName);
		String sloganUpdatedName=driver.findElement(By.xpath("//div[@class='hero-content']//child::h1[2]")).getText();
		System.out.println("Updated Slogan name is..." +sloganUpdatedName);
		return this;
	}

}
