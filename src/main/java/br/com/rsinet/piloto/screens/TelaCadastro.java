package br.com.rsinet.piloto.screens;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.piloto.screens.elements.AbstractList;
import br.com.rsinet.piloto.screens.elements.AndroidList;
import br.com.rsinet.piloto.screens.elements.IOSList;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HasOnScreenKeyboard;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.OverrideWidget;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TelaCadastro {

	private WebDriver driver;

	public TelaCadastro(WebDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}

	@iOSFindBy(accessibility = "userNameTextFieldID")
	@AndroidFindBy(uiAutomator = "textContains(\"USER NAME\").fromParent(new UiSelector().className(\"android.widget.EditText\"))")
	private MobileElement userNameField;

	@iOSFindBy(accessibility = "emailTextFieldID")
	@AndroidFindBy(uiAutomator = "textContains(\"EMAIL\").fromParent(new UiSelector().className(\"android.widget.EditText\"))")
	private MobileElement emailField;

	@iOSFindBy(accessibility = "passwordTextFieldID")
	@AndroidFindBy(uiAutomator = "textContains(\"PASSWORD\").fromParent(new UiSelector().className(\"android.widget.EditText\"))")
	private MobileElement passwordField;

	@iOSFindBy(accessibility = "confirmPasswordTextFielD")
	@AndroidFindBy(uiAutomator = "textContains(\"CONFIRM PASSWORD\").fromParent(new UiSelector().className(\"android.widget.EditText\"))")
	private MobileElement passwordConfirmField;

	@iOSFindBy(accessibility = "firstNameTextFieldLabel")
	@AndroidFindBy(uiAutomator = "textContains(\"FIRST NAME\").fromParent(new UiSelector().className(\"android.widget.EditText\"))")
	private MobileElement firstNameField;

	@iOSFindBy(accessibility = "lastNameTextFieldLabel")
	@AndroidFindBy(uiAutomator = "textContains(\"LAST NAME\").fromParent(new UiSelector().className(\"android.widget.EditText\"))")
	private MobileElement lastNameField;

	@iOSFindBy(accessibility = "phoneNumberTextFieldID")
	@AndroidFindBy(uiAutomator = "textContains(\"PHONE NUMBER\").fromParent(new UiSelector().className(\"android.widget.EditText\"))")
	private MobileElement phoneNumberField;

	@AndroidFindBy(id = "com.Advantage.aShopping:id/textViewCountries")
	@iOSFindBy(accessibility = "Country")
	private MobileElement countryListField;

	@OverrideWidget(androidUIAutomator = AndroidList.class, iOSUIAutomation = IOSList.class)
	private AbstractList countriesList;

	@iOSFindBy(accessibility = "stateTextFieldID")
	@AndroidFindBy(uiAutomator = "textContains(\"STATE\").fromParent(new UiSelector().className(\"android.widget.EditText\"))")
	private MobileElement stateField;

	@iOSFindBy(accessibility = "streetTextFieldID")
	@AndroidFindBy(uiAutomator = "textContains(\"ADDRESS\").index(1).fromParent(new UiSelector().className(\"android.widget.EditText\"))")
	private MobileElement addressField;

	@iOSFindBy(accessibility = "cityTextFieldID")
	@AndroidFindBy(uiAutomator = "textContains(\"CITY\").fromParent(new UiSelector().className(\"android.widget.EditText\"))")
	private MobileElement cityField;

	@iOSFindBy(accessibility = "zipTextFieldID")
	@AndroidFindBy(uiAutomator = "textContains(\"ZIP\").fromParent(new UiSelector().className(\"android.widget.EditText\"))")
	private MobileElement zipField;

	@iOSFindBy(accessibility = "REGISTER")
	@AndroidFindBy(id = "com.Advantage.aShopping:id/buttonRegister")
	private MobileElement registerButton;

	public MobileElement getUserNameField() {
		return userNameField;
	}

	public void digitarNomeUsuario(String nomeUsuario) {
		this.getUserNameField().click();
		this.getUserNameField().sendKeys(nomeUsuario);
		hideKeyboard();
	}

	public MobileElement getEmailField() {
		return emailField;
	}

	public void digitarEmail(String email) {
		getEmailField().click();
		getEmailField().sendKeys(email);
		hideKeyboard();
	}

	public MobileElement getPasswordField() {
		return passwordField;
	}

	public void digitarSenha(String senha) {
		getPasswordField().click();
		getPasswordField().sendKeys(senha);
		hideKeyboard();
	}

	public MobileElement getPasswordConfirmField() {
		return passwordConfirmField;
	}

	public void digitarSenhaNovamente(String senha) {
		getPasswordConfirmField().click();
		getPasswordConfirmField().sendKeys(senha);
		hideKeyboard();
	}

	public MobileElement getFirstNameField() {
		return firstNameField;
	}

	public void digitarPrimeiroNome(String primeiroNome) {
		getFirstNameField().click();
		getFirstNameField().sendKeys(primeiroNome);
		hideKeyboard();
		verticalSwipeDown();
		verticalSwipeDown();
		verticalSwipeUp();
	}

	private void hideKeyboard() {
		if ("android".equalsIgnoreCase(
				(String) ((AppiumDriver) this.driver).getCapabilities().getCapability("platformName"))) {
			if (((HasOnScreenKeyboard) (this.driver)).isKeyboardShown())
				((AppiumDriver) this.driver).hideKeyboard();
		} else
			try {
				// this.driver.findElement(By.xpath("//XCUIElementTypeApplication")).click();
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

	public MobileElement getLastNameField() {
		return lastNameField;
	}

	public void digitarUltimoNome(String ultimoNome) {
		getLastNameField().click();
		getLastNameField().sendKeys(ultimoNome);
		hideKeyboard();
	}

	public MobileElement getPhoneNumberField() {
		return phoneNumberField;
	}

	public void digitarNumeroTelefone(String numeroTelefone) {
		getPhoneNumberField().click();
		getPhoneNumberField().sendKeys(numeroTelefone);
		hideKeyboard();
	}

	public AbstractList getCountriesList() {
		return countriesList;
	}

	public MobileElement getStateField() {
		return stateField;
	}

	public void digitarEstado(String estado) {
		getStateField().click();
		getStateField().sendKeys(estado);
		hideKeyboard();
	}

	public MobileElement getAddressField() {
		return addressField;
	}

	public void digitarEndereco(String endereco) {
		verticalSwipeUp();
		getAddressField().click();
		getAddressField().sendKeys(endereco);
		hideKeyboard();
	}

	public MobileElement getCityField() {
		return cityField;
	}

	public void digitarCidade(String cidade) {
		getCityField().click();
		getCityField().sendKeys(cidade);
		hideKeyboard();
		verticalSwipeUp();
	}

	public MobileElement getZipField() {
		return zipField;
	}

	public void digitarCEP(String cep) {
		getZipField().click();
		getZipField().sendKeys(cep);
		hideKeyboard();
	}

	public MobileElement getRegisterButton() {
		return registerButton;
	}

	public void clicarEmRegistrar() {
		getRegisterButton().click();
	}

	public void selecionarPais(String pais) {
		// this.countriesList.click();
		// this.driver.findElement(By.xpath(String.format("//*[@resource-id='com.Advantage.aShopping:id/select_dialog_listview']/",
		// country)));
		/*
		 * try {
		 * getCountriesList().findElement(By.xpath(String.format("//*[@text='%s']",
		 * pais))); } catch (NoSuchElementException e) {
		 * 
		 * }
		 */
		this.countryListField.click();
		this.countriesList.chooseItem(pais);
	}

	public void verticalSwipeUp() {
		double startPercentage = 0.55;
		double endPercentage = 0.15;
		double anchorPercentage = 0.50;
		Dimension size = driver.manage().window().getSize();
		int middleX = (int) (size.width * 0.5);
		int middleY = (int) (size.height * 0.5);
		int anchor = (int) (size.width * anchorPercentage);
		int startPoint = (int) (size.height * startPercentage);
		int endPoint = (int) (size.height * endPercentage);

		new TouchAction((AppiumDriver) driver).press(PointOption.point(anchor, startPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500)))
				.moveTo(PointOption.point(anchor, endPoint)).release().perform();
	}

	public void verticalSwipeDown() {
		double endPercentage = 0.75;
		double startPercentage = 0.15;
		double anchorPercentage = 0.50;
		Dimension size = driver.manage().window().getSize();
		int middleX = (int) (size.width * 0.5);
		int middleY = (int) (size.height * 0.5);
		int anchor = (int) (size.width * anchorPercentage);
		int startPoint = (int) (size.height * startPercentage);
		int endPoint = (int) (size.height * endPercentage);

		new TouchAction((AppiumDriver) driver).press(PointOption.point(anchor, startPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500)))
				.moveTo(PointOption.point(anchor, endPoint)).release().perform();
	}
}
