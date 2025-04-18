package org.pom_Pages;

import java.util.List;

import org.ActionClassUtility.ActionClassGenericMethod;
import org.WaitUtility.WaitGenericMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	// WEBELEMENTS
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailField;

	@FindBy(xpath = "//input[@id='pass']")
	private WebElement passwordField;

	@FindBy(xpath = "//button[text()=\"Log in\"]")
	private WebElement loginBtn;

	@FindBy(xpath = "//span[contains(text(),'Friends')]")
	private WebElement FriendsTxt;
	
	@FindBy(css = "div[class='xi81zsa x1lkfr7t xkjl1po x1mzt3pk xh8yej3 x13faqbe'] span[class='x1lliihq x6ikm8r x10wlt62 x1n2onr6']")
	private WebElement postInputFieldClick;
	
	@FindBy(css = ".x9f619.x1iyjqo2.xg7h5cd.x1pi30zi.x1swvt13.x1n2onr6.xh8yej3.x1ja2u2z.x1t1ogtf>div>div>div:first-child")
	private WebElement postInputField;
	
	//span[contains(text(),'Post')]
	
	@FindBy(xpath = "//span[contains(text(),'Post')]")
	private WebElement postBtn;
	

	// CONSTRUCTOR
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// PAGE ACTION METHODS

	public void emailField() {
		emailField.sendKeys("nikhilpatil1050@gmail.com");
	}

	public void PasswordField() {
		passwordField.sendKeys("Nikhil@123");
	}

	public void getLogin() {
		WaitGenericMethod wt = new WaitGenericMethod();

		wt.waitForclickableWebElement(driver, 25, "xpath", "//button[text()=\"Log in\"]");
		loginBtn.click();
		
	}

	public String isFriendsTxt_Display() {

		
		WaitGenericMethod wt = new WaitGenericMethod();
		wt.waitForVisibilityByType(driver, 25, "xpath", "//span[contains(text(),'Friends')]");
		
		return FriendsTxt.getText();
		
		

	}
	
	public void ispostInputFieldClick() {
		WaitGenericMethod wt = new WaitGenericMethod();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		wt.waitForclickableWebElement(driver, 25, "css", "div[class='xi81zsa x1lkfr7t xkjl1po x1mzt3pk xh8yej3 x13faqbe'] span[class='x1lliihq x6ikm8r x10wlt62 x1n2onr6']");
		postInputFieldClick.click();

	}
	
	public void postInputField() {
		WaitGenericMethod wt = new WaitGenericMethod();
		wt.waitForVisibilityWebElement(driver, 25, "css", ".x9f619.x1iyjqo2.xg7h5cd.x1pi30zi.x1swvt13.x1n2onr6.xh8yej3.x1ja2u2z.x1t1ogtf>div>div>div:first-child");
		postInputField.sendKeys("Hello word");
	}
	
	
	public void postBtn() {
		postBtn.click();
	}
	
	
}
