package br.com.rsinet.piloto.screens;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HasOnScreenKeyboard;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class TelaOffline {

	private WebDriver driver;

	private Wait<WebDriver> wait;

	public TelaOffline(WebDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofMillis(1000))
				.ignoring(NoSuchElementException.class, org.openqa.selenium.WebDriverException.class);
	}

	//@AndroidFindBy(xpath = "//android.widget.TextView[@text='You are not connected to the internet']")
	@AndroidFindBy(uiAutomator = "textContains(\"You are not connected to the internet\")")
	//@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='You are not connected to the internet']")
	@iOSXCUITFindBy(iOSNsPredicate="name=='You are not connected to the internet'")
	private MobileElement alertOfflineMode;

	//@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	@AndroidFindBy(uiAutomator = "textContains(\"OK\")")
	@iOSFindBy(accessibility = "Ok")
	private MobileElement alertConfirmButton;

	@AndroidFindBy(id = "com.Advantage.aShopping:id/editTextServer")
	//@iOSFindBy(xpath = "//XCUIElementTypeTextField")
	@iOSXCUITFindBy(iOSNsPredicate="type=='XCUIElementTypeTextField'")
	private MobileElement serverField;

	@AndroidFindBy(id = "com.Advantage.aShopping:id/buttonConnect")
	@iOSFindBy(accessibility = "APPLY")
	private MobileElement btnApply;

	//@AndroidFindBy(xpath = "//android.widget.TextView[@text='You are working in offline mode. Data is not retained for future use']")
	@AndroidFindBy(uiAutomator = "textContains(\"You are working in offline mode. Data is not retained for future use\")")
	@iOSFindBy(accessibility = "You are working in offline mode. Data is not retained for future use")
	private MobileElement confirmMessageOfflineAlert;

	//@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	@AndroidFindBy(uiAutomator = "textContains(\"OK\")")
	//@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
	@iOSXCUITFindBy(iOSNsPredicate="type=='XCUIElementTypeButton' AND name=='Ok'")
	private MobileElement confirmButtonOfflineAlert;

	public void validarModoOffline() {
		this.wait.until(ExpectedConditions.visibilityOf(alertOfflineMode));
		this.alertConfirmButton.click();
		try {
			Thread.sleep(2000);

			try {
				if (this.alertConfirmButton.isDisplayed()) {
					this.alertConfirmButton.click();
				}
			} catch (Exception e) {

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void digitarValorServer(String server) {
		// this.wait.until(ExpectedConditions.visibilityOf(serverField));
		// this.serverField.sendKeys(server);
		this.serverField.clear();
		this.serverField.setValue(server);
		hideKeyboard();
	}

	public void clicarNoBotaoApply() {
		this.btnApply.click();
	}

	public void confirmarEscolhaModoOffline() {
		this.wait.until(ExpectedConditions.visibilityOf(confirmMessageOfflineAlert));
		this.confirmButtonOfflineAlert.click();
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