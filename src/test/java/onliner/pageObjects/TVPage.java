package onliner.pageObjects;

import framework.base.BasePage;
import framework.elements.Checkbox;
import framework.elements.TextBox;
import org.openqa.selenium.By;


public class TVPage extends BasePage {

    public static final String CHECKBOX_LOCATOR = "//li/label[contains(@class, 'schema-filter__checkbox-item')]/span[contains(text(), '%s')]";
    public static final String MAX_PRICE_LOCATOR = "//input[contains(@class, 'schema-filter-control__item schema-filter__number-input schema-filter__number-input_price')][@placeholder='до']";
    public static final String PRODUCT_TITLE = "//div[@class='schema-product__title']";

    public TVPage(){
        super(By.xpath("//div[contains(@class, 'b-top-logo')]"), "TV Page");
    }

    public void selectCheckbox(String checkboxName){
        Checkbox checkbox = new Checkbox(By.xpath(String.format(CHECKBOX_LOCATOR, checkboxName)), checkboxName);
        checkbox.scrollToElement();
        checkbox.clickAndWait();
    }

    public void setPrice(String price){
        TextBox txtPrice = new TextBox(By.xpath(String.format(MAX_PRICE_LOCATOR, price)), price);
        txtPrice.scrollToElement();
        txtPrice.sendValue(price);
    }
}
