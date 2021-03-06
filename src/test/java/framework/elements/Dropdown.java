package framework.elements;

import framework.base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Dropdown extends BaseElement {
    public Dropdown(By locator, String name) {
        super(locator, name);
    }

    public void select(String value){
        Select select = new Select(getElement());
        select.selectByValue(value);
    }
}
