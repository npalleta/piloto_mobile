package br.com.rsinet.piloto.screens.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.pagefactory.AndroidFindBy;

@AndroidFindBy(id = "com.Advantage.aShopping:id/select_dialog_listview")
public class AndroidList extends AbstractList {

	public AndroidList(WebElement element) {
		super(element);
	}

	@Override
	public void chooseItem(String item) {
		new Select(this.getWrappedElement()).selectByValue(item);
	}
}