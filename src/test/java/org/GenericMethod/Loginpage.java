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

import org.apache.commons.codec.language.bm.Lang;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utilities.BaseUtility;

public class Loginpage {

	BaseUtility bs = new BaseUtility();
	private WebDriver driver;
	GenericMethod gn = new GenericMethod();
	Dashboadpage  db = new Dashboadpage();

	public void LoginField(WebDriver driver) throws InterruptedException {

		List<WebElement> eles = driver.findElements(By.xpath(
				"//input[@id='ion-input-0' and @name='loginName']|//input[@id='ion-input-1' and @name='password']"));
		for (WebElement ele : eles) {

			try {

				if (ele.getAttribute("name").equalsIgnoreCase("loginName")) {
					ele.sendKeys("smbt-08-sa");

				} else if (ele.getAttribute("name").equalsIgnoreCase("password")) {
					ele.sendKeys(Keys.DELETE);
					ele.sendKeys("Smbt@123");
					gn.wait(10);

				}

			} catch (Exception e) {

				System.out.println(e);

			}

		}

		gn.SwichToFramforTab(driver);
		WebElement submitbutton = driver.findElement(By.xpath("//ion-button[@type='submit']"));
		submitbutton.click();
		System.out.println("successfully click login button");
		WebElement dashboadpage = driver.findElement(By.xpath("//h4[text()=' Dashboard ']"));
		if (dashboadpage.getText().equalsIgnoreCase("Dashboard")) {

			System.out.println("successfully display '" + dashboadpage.getText() + "'");
			db.opdModule(driver);
			
		}

	}

}
