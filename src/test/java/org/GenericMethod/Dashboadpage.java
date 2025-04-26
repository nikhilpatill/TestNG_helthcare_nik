package org.GenericMethod;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.codec.language.bm.Lang;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utilities.BaseUtility;

public class Dashboadpage {

	BaseUtility bs = new BaseUtility();
	private WebDriver driver;
	GenericMethod gn = new GenericMethod();

	public void opdModule(WebDriver driver) throws InterruptedException {
		boolean isclick = true;
		int maxRetries = 5;
		int retryDelay = 3000;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// WebElement ele =
		// driver.findElement(By.xpath("(//span[@class='hide-menu'])[6]"));
		// gn.ScrollToElement(opd, driver);

		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

			WebElement opd = driver.findElement(By.xpath("//span[@class='hide-menu'])[5]"));
			gn.wait(3);
			if (opd.getText().equalsIgnoreCase("OPD")) {
				System.out.println(opd.getText());
				opd.click();
				System.out.println("opd button clicked successfully.");
			}

			WebElement opd_registration = driver.findElement(By.xpath("//h3[text()='OPD Registration']"));
			opd_registration.click();

			if (isclick == true) {
				System.out.println("OPD Registration clicked successfully.");
				this.inputField(driver);
			}

		} catch (Exception e) {

			retryClick(driver, By.xpath("//span[@class='hide-menu'])[5]"), maxRetries, retryDelay);
			// span[@class='hide-menu'])[5]
			//// span[normalize-space()='OPD']

			System.out.println("opd button clicked successfully.");

			WebElement opd_registration = driver.findElement(By.xpath("//h3[text()='OPD Registration']"));
			opd_registration.click();

			if (isclick == true) {
				System.out.println("OPD Registration clicked successfully.");
				this.inputField(driver);
			}

		}

	}

	public void inputField(WebDriver driver) {
		List<WebElement> eles = driver.findElements(By.xpath(
				"//input[@name='Title*'and @id='ion-input-5']|//input[@name='firstName']|//input[@name='lastName']|//input[@name='Gender*' and @id='ion-input-9']|//input[@name='mobileNo']|//input[@placeholder='YYYY']|//input[@name='aadharNo' and @id='ion-input-15']|//input[@name='address' and @id='ion-input-16']|//input[@name='Department*' and @id='ion-input-19']|//input[@name='Doctor*' and @id='ion-input-21']|//input[@name='VisitType *' and @id='ion-input-22']|//input[@name='PatientSource *' and @id='ion-input-23']"));
		gn.CheckVisibleElements(eles);

		for (WebElement ele : eles) {

			try {
				if (ele.getAttribute("name").equalsIgnoreCase("Title*")) {
					ele.click();
					Thread.sleep(2000);
					ele.sendKeys("Mr");
					Thread.sleep(2000);
					System.out.println("Title add successfully");
					ele.sendKeys(Keys.TAB);
				}

				else if (ele.getAttribute("name").equalsIgnoreCase("firstName")) {
					ele.sendKeys(Keys.DELETE);
					ele.sendKeys("soham");
					System.out.println("firstname add successfully");
					gn.wait(2);
					ele.sendKeys(Keys.TAB);

				} else if (ele.getAttribute("name").equalsIgnoreCase("lastName")) {
					Random random = new Random();
					int nameLength = 7; // you can set the name length you want
					StringBuilder name = new StringBuilder();

					for (int i = 0; i < nameLength; i++) {
						char randomChar = (char) ('a' + random.nextInt(26)); // random letter a-z
						name.append(randomChar);
					}

					// Capitalize the first letter
					String randomName = name.substring(0, 1).toUpperCase() + name.substring(1);

					ele.sendKeys(Keys.DELETE);
					ele.sendKeys(randomName);
					System.out.println("lastName add successfully");
					gn.wait(2);
					ele.sendKeys(Keys.TAB);

				} else if (ele.getAttribute("name").equalsIgnoreCase("Gender*")) {
					ele.click();
					Thread.sleep(2000);
					ele.sendKeys("Male");
					System.out.println("lastName add successfully");
					Thread.sleep(2000);
					ele.sendKeys(Keys.TAB);

				} else if (ele.getAttribute("name").equalsIgnoreCase("mobileNo")) {
					ele.sendKeys(Keys.DELETE);
					ele.sendKeys("1234567891");
					System.out.println("mobileNo add successfully");
					gn.wait(2);
					ele.sendKeys(Keys.TAB);

				} else if (ele.getAttribute("placeholder").equalsIgnoreCase("YYYY")) {
					ele.sendKeys(Keys.DELETE);
					ele.sendKeys("22");
					System.out.println("age add successfully");
					gn.wait(2);
					ele.sendKeys(Keys.TAB);

				}

				else if (ele.getAttribute("name").equalsIgnoreCase("aadharNo")) {
					ele.sendKeys(Keys.DELETE);
					ele.sendKeys("112234567891");
					System.out.println("mobileNo add successfully");
					gn.wait(2);
					ele.sendKeys(Keys.TAB);

				}

				else if (ele.getAttribute("name").equalsIgnoreCase("address")) {
					ele.sendKeys(Keys.DELETE);
					ele.sendKeys("pune");
					System.out.println("address add successfully");
					gn.wait(2);
					ele.sendKeys(Keys.TAB);

				} else if (ele.getAttribute("name").equalsIgnoreCase("Department*")) {
					gn.ScrollToElement(ele, driver);
					Actions actions = new Actions(driver);
					actions.moveToElement(ele).perform();
					ele.click();
					Thread.sleep(2000);
					WebElement department = driver
							.findElement(By.xpath("//div[@id='Department*']/ion-item[text()=' ANAESTHESIOLOGY ']"));
					department.click();
					Thread.sleep(2000);
					System.out.println("Department add successfully");

				} else if (ele.getAttribute("name").equalsIgnoreCase("Doctor*")) {
					Actions actions = new Actions(driver);
					actions.moveToElement(ele).perform();
					Thread.sleep(2000);
					ele.click();
					Thread.sleep(2000);
					WebElement department = driver
							.findElement(By.xpath("//div[@id='Doctor*']/ion-item[text()=' Arun kumar  Maurya ']"));
					department.click();
					Thread.sleep(2000);
					System.out.println("Doctor* add successfully");
					ele.sendKeys(Keys.TAB);

				} else if (ele.getAttribute("name").equalsIgnoreCase("VisitType *")) {
					Actions actions = new Actions(driver);
					actions.moveToElement(ele).perform();
					Thread.sleep(2000);
					ele.click();
					Thread.sleep(2000);
					WebElement department = driver
							.findElement(By.xpath("//div[@id='VisitType *']/ion-item[text()=' New ']"));
					JavascriptExecutor js = (JavascriptExecutor) driver;
					ele.sendKeys("New");
					Thread.sleep(2000);
					js.executeScript("arguments[0].click();", department);

					Thread.sleep(2000);
					System.out.println("VisitType* add successfully");
					ele.sendKeys(Keys.TAB);

				} else if (ele.getAttribute("name").equalsIgnoreCase("PatientSource *")) {
					Actions actions = new Actions(driver);
					actions.moveToElement(ele).perform();
					Thread.sleep(2000);
					ele.click();
					Thread.sleep(2000);
					WebElement department = driver
							.findElement(By.xpath("//div[@id='PatientSource *']/ion-item[text()=' Self ']"));
					actions.moveToElement(department).perform();
					Thread.sleep(2000);
					department.click();
					Thread.sleep(2000);
					System.out.println("VisitType* add successfully");
					ele.sendKeys(Keys.TAB);

				}
			} catch (Exception e) {

				// bs.sendKeysByActions(driver, ele, data);

			}

		}
	}

	public boolean retryClick(WebDriver driver, By locator, int maxRetries, int retryDelay) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement ele = driver.findElement(By.xpath("(//span[@class='hide-menu'])[5]"));
		// gn.ScrollToElement(ele, driver);

		for (int attempt = 1; attempt <= maxRetries; attempt++) {
			try {
				ele.click();
				return true;
			} catch (Exception e) {
				try {
					Thread.sleep(retryDelay);
				} catch (InterruptedException ie) {
					Thread.currentThread().interrupt();
				}
			}
		}
		return false;
	}

}
