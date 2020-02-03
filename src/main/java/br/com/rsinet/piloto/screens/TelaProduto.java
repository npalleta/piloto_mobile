package br.com.rsinet.piloto.screens;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class TelaProduto {

	private WebDriver driver;

	Wait<WebDriver> wait;

	public TelaProduto(WebDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofMillis(1000))
				.ignoring(NoSuchElementException.class, org.openqa.selenium.WebDriverException.class);
	}

	@AndroidFindBy(id = "com.Advantage.aShopping:id/textViewProductName")
	@iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
	private MobileElement nomeProduto;

	@AndroidFindBy(id = "com.Advantage.aShopping:id/buttonProductAddToCart")
	@iOSFindBy(accessibility = "ADD TO CART")
	private MobileElement botaoAdicionarCarrinho;

	@AndroidFindBy(id = "com.Advantage.aShopping:id/imageViewCart")
	@iOSFindBy(accessibility = "cartItem")
	private MobileElement carrinho;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.Advantage.aShopping:id/textViewCartProductName']")
	@iOSFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[3]")
	private List<MobileElement> itensCarrinho;

	public void validarNomeProduto(String nomeProduto) {
		this.wait.until(ExpectedConditions.visibilityOf(this.nomeProduto));
		Assert.assertTrue(this.nomeProduto.getText().equalsIgnoreCase(nomeProduto.trim()));
	}

	public void adicionarProdutoCarrinho() {
		this.botaoAdicionarCarrinho.click();
	}

	public void validarProdutoCarrinho(String nomeProduto) {
		this.wait.until(ExpectedConditions.elementToBeClickable(this.carrinho));
		this.carrinho.click();
		for (MobileElement itemCarrinho : this.itensCarrinho) {
			if (itemCarrinho.getText().equalsIgnoreCase(nomeProduto.trim())) {
				return;
			}
		}
		Assert.assertTrue(String.format("Produto %s não consta no carrinho", nomeProduto), false);
	}
}
