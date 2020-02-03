package br.com.rsinet.piloto.screens;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class TelaPrincipal {

	private WebDriver driver;

	Wait<WebDriver> wait;

	public TelaPrincipal(WebDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofMillis(1000))
				.ignoring(NoSuchElementException.class, org.openqa.selenium.WebDriverException.class);
	}

	@iOSFindBy(accessibility = "Menu")
	@AndroidFindBy(id = "com.Advantage.aShopping:id/imageViewMenu")
	private MobileElement menu;

	@AndroidFindBy(id = "com.Advantage.aShopping:id/textViewMenuUser")
	@iOSFindBy(xpath = "//XCUIElementTypeCell[XCUIElementTypeButton[@name='User settings']]/XCUIElementTypeStaticText[1]")
	private MobileElement menuLoginItem;

	//@iOSFindBy(xpath = "//XCUIElementTypeSearchField[@name='Search']")
	@iOSXCUITFindBy(iOSNsPredicate="type=='XCUIElementTypeSearchField'")
	@AndroidFindBy(id = "com.Advantage.aShopping:id/editTextSearch")
	private MobileElement txtPesquisaProduto;

	//@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Search']")
	@iOSXCUITFindBy(iOSNsPredicate="name=='Search' AND type=='XCUIElementTypeButton'")
	@AndroidFindBy(id = "com.Advantage.aShopping:id/imageViewSearch")
	private MobileElement btnPesquisaProduto;

	@AndroidFindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/recyclerViewCategories']/android.widget.RelativeLayout/android.widget.TextView")
	@iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText")
	private List<MobileElement> categorias;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"SIGN OUT\")")
	@iOSXCUITFindBy(iOSNsPredicate="name=='SIGN OUT'")
	private MobileElement lnkLogout;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"YES\")")
	@iOSXCUITFindBy(iOSNsPredicate="name=='Yes'")
	private MobileElement logoutOK;
	
	public MobileElement getMenu() {
		return menu;
	}

	public MobileElement getMenuLoginItem() {
		return menuLoginItem;
	}

	public void clicarNoMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(getMenu()));
		this.menu.click();
	}

	public void clicarNoItemLogin() {
		getMenuLoginItem().click();
	}

	public void validarTelaInicial() {
		wait.until(ExpectedConditions.elementToBeClickable(getMenu()));
		Assert.assertTrue(getMenu().isDisplayed());
	}

	public void digitarProduto(String produto) {
		wait.until(ExpectedConditions.elementToBeClickable(this.txtPesquisaProduto));
		this.txtPesquisaProduto.sendKeys(produto);
		//hideKeyboard();
	}

	public void clicarPesquisaProduto() {
		this.btnPesquisaProduto.click();
	}
	
	public void fazerLogout() {
		this.lnkLogout.click();
		this.logoutOK.click();
	}

	public void clicarNaCategoria(String nomeCategoria) {
		for (WebElement categoria : categorias) {
			if (categoria.getText().equalsIgnoreCase(nomeCategoria)) {
				categoria.click();
				return;
			}
		}
		Assert.assertTrue(String.format("Categoria %s não encontrada", nomeCategoria), false);
	}

	public void validarUsuarioLogado(String usuario, String nomeUsuario) {
		wait.until(ExpectedConditions.visibilityOf(this.menuLoginItem));
		String user = this.menuLoginItem.getText();
		if (!user.equals(usuario.trim()) & !user.equals(nomeUsuario.trim())) {
			Assert.assertTrue(String.format("Usuário '%s' não está logado", nomeUsuario), false);
		}
		fazerLogout();
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
