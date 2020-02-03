package br.com.rsinet.piloto.screens.elements;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.Widget;
import io.appium.java_client.pagefactory.iOSFindBy;

public abstract class AbstractList extends Widget{

	protected AbstractList(WebElement element) {
		super(element);
	}
/*
	@AndroidFindBy(xpath="//android.widget.TextView")
	@iOSFindBy()
	private WebElement items;*/
	
	public abstract void chooseItem(String item);
}
