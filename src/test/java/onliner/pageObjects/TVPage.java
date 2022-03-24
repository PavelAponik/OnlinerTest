package onliner.pageObjects;

import framework.base.BasePage;
import framework.elements.Checkbox;
import framework.elements.TextBox;
import org.openqa.selenium.By;


public class TVPage extends BasePage {

    public static final String CHECKBOX_LOCATOR = "//li/label[contains(@class, 'schema-filter__checkbox-item')]/span[contains(text(), '%s')]";
    public final TextBox txbMaxPrice = new TextBox(By.xpath("//input[contains(@class, 'schema-filter-control__item schema-filter__number-input schema-filter__number-input_price')][@placeholder='до']"),"Max Price");

    public TVPage(){
        super(By.xpath("//div[contains(@class, 'b-top-logo')]"), "TV Page");
    }

    public void selectCheckbox(String checkboxName){
        Checkbox chbCheckbox = new Checkbox(By.xpath(String.format(CHECKBOX_LOCATOR, checkboxName)), checkboxName);
        chbCheckbox.scrollToElement();
        chbCheckbox.clickAndWait();
    }

    public void setPrice(String price){
        txbMaxPrice.scrollToElement();
        txbMaxPrice.sendValue(price);
    }
}
