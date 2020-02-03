package br.com.rsinet.piloto.screens.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSFindBy;

@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Advantage Shopping\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypePicker/XCUIElementTypePickerWheel")
public class IOSList extends AbstractList {

	public IOSList(WebElement element) {
		super(element);
	}

	@iOSFindBy(accessibility = "countryPickerDone")
	private MobileElement doneButton;

	@Override
	public void chooseItem(String item) {
		// this.getWrappedElement().sendKeys(item);
		new Select(this.getWrappedElement()).selectByValue(item);
		this.doneButton.click();
	}
}
