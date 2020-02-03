package br.com.rsinet.piloto.screens;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HasOnScreenKeyboard;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class TelaLogin {

	private WebDriver driver;
	
	Wait<WebDriver> wait;

	public TelaLogin(WebDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofMillis(1000))
				.ignoring(NoSuchElementException.class, org.openqa.selenium.WebDriverException.class);
	}

	@iOSFindBy(id = "Don't have an account? SIGN UP TODAY")
	@AndroidFindBy(id = "com.Advantage.aShopping:id/textViewSingUpToday")
	private MobileElement signUpToday;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.Advantage.aShopping:id/AosEditTextLoginUserName']/android.widget.EditText")
	@iOSFindBy(accessibility = "userNameLabel")
	private MobileElement userNameField;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.Advantage.aShopping:id/AosEditTextLoginPassword']/android.widget.EditText")
	@iOSFindBy(accessibility = "passwordLabel")
	private MobileElement passwordField;

	@AndroidFindBy(id = "com.Advantage.aShopping:id/buttonLogin")
	@iOSFindBy(accessibility = "LOGIN")
	private MobileElement loggingButton;

	public MobileElement getSignUpToday() {
		return signUpToday;
	}

	public void clicarEmSignUpToday() {
		this.getSignUpToday().click();
	}

	public MobileElement getUserNameField() {
		return userNameField;
	}

	public void digitarNomeUsuario(String nomeUsuario) {
		getUserNameField().sendKeys(nomeUsuario);
		hideKeyboard();
	}

	public MobileElement getPasswordField() {
		return passwordField;
	}

	public void digitarSenha(String senha) {
		getPasswordField().sendKeys(senha);
		hideKeyboard();
	}

	public MobileElement getLoggingButton() {
		return loggingButton;
	}

	public void clicarEmLogin() {
		getLoggingButton().click();
	}

	private void hideKeyboard() {
		if ("android".equalsIgnoreCase(
				(String) ((AppiumDriver) this.driver).getCapabilities().getCapability("platformName"))) {
			if (((HasOnScreenKeyboard) (this.driver)).isKeyboardShown())
				((AppiumDriver) this.driver).hideKeyboard();
		} else
			try {
				//this.driver.findElement(By.xpath("//XCUIElementTypeApplication")).click();
				this.driver.findElement(By.id("This is a demo site. Do not use real data")).click();
				if (((HasOnScreenKeyboard) (this.driver)).isKeyboardShown()) {
					try {
						((AppiumDriver) this.driver).findElementByAccessibilityId("Seguinte").click();
					} catch (Exception e1) {
						try {
							((AppiumDriver) this.driver).findElementByAccessibilityId("Concluído").click();
						} catch (Exception e2) {
						}
					}
				}
			} catch (Exception e) {
				try {
					((AppiumDriver) this.driver).findElementByAccessibilityId("Seguinte").click();
				} catch (Exception e1) {
					try {
						((AppiumDriver) this.driver).findElementByAccessibilityId("Concluído").click();
					} catch (Exception e2) {
					}
				}
			}
	}
}
