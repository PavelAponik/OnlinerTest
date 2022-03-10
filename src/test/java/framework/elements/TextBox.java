package framework.elements;

import framework.base.BaseElement;
import org.openqa.selenium.By;

public class TextBox extends BaseElement {
    public TextBox(By locator, String name) {
        super(locator, name);
    }

    public void sendValue(String value){
        getElement().sendKeys(value);
    }
}
