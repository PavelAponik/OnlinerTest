package Onliner.pageObjects;

import framework.base.BasePage;
import framework.elements.Checkbox;
import framework.elements.Label;
import framework.elements.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TVPage extends BasePage {

    public static final String CHECKBOX_LOCATOR = "//li/label[@class='schema-filter__checkbox-item']/span[text()='%s']";
    public static final String MAX_PRICE_LOCATOR = "//input[contains(@class, 'schema-filter-control__item schema-filter__number-input schema-filter__number-input_price')][@placeholder='до']";
    public static final String PRODUCT_TITLE = "//div[@class='schema-product__title']";

    public TVPage(){
        super(By.xpath("//div[contains(@class, 'b-top-logo')]"), "TV Page");
    }

    public void selectBrand(String brand){
        //waitUntilElementAvailable(String.format(CHECKBOX_LOCATOR, brand));
        Checkbox checkboxBrand = new Checkbox(By.xpath(String.format(CHECKBOX_LOCATOR, brand)), brand);
        checkboxBrand.clickAndWait();
    }

    public void setPrice(String price){
        TextBox txtPrice = new TextBox(By.xpath(String.format(MAX_PRICE_LOCATOR, price)), price);
        txtPrice.sendValue(price);
    }

    public void selectResolution(String resolution){
        Checkbox checkboxResolution = new Checkbox(By.xpath(String.format(CHECKBOX_LOCATOR, resolution)), resolution);
        checkboxResolution.clickAndWait();
    }
}
