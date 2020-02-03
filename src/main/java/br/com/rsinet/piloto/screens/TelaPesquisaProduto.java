package br.com.rsinet.piloto.screens;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class TelaPesquisaProduto {

	private WebDriver driver;

	Wait<WebDriver> wait;

	public TelaPesquisaProduto(WebDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofMillis(1000))
				.ignoring(NoSuchElementException.class, org.openqa.selenium.WebDriverException.class);
	}

	@AndroidFindBy(xpath = "//android.widget.GridView[@resource-id='com.Advantage.aShopping:id/gridViewProducts']")
	//@iOSFindBy(xpath = "//XCUIElementTypeCollectionView")
	@iOSXCUITFindBy(iOSNsPredicate="type=='XCUIElementTypeCollectionView' ")
	MobileElement viewProduto;

	@AndroidFindBy(xpath = "//android.widget.GridView[@resource-id='com.Advantage.aShopping:id/gridViewProducts']/android.widget.RelativeLayout/android.widget.TextView[@resource-id='com.Advantage.aShopping:id/textViewProductName']")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[1]")
	List<MobileElement> produtos;

	public void clicarNoProduto(String produto) {
		this.wait.until(ExpectedConditions.visibilityOf(this.viewProduto));
		for (MobileElement webElement : produtos) {
			if (webElement.getText().equalsIgnoreCase(produto.trim())) {
				webElement.click();
				return;
			}
		}
	}
}
