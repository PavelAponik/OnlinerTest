package Onliner.pages;

import Onliner.base.BasePage;
import org.openqa.selenium.WebDriver;


public class TVPage extends BasePage {

    public static final String checkboxLocator = "//li/label[@class='schema-filter__checkbox-item']/span[text()='%s']";
    public static final String maxPriceLocator = "//input[contains(@class, 'schema-filter-control__item schema-filter__number-input schema-filter__number-input_price')][@placeholder='до']";
    public static final String  productTitle = "//div[@class='schema-product__title']";

    public TVPage(WebDriver driver){
        super(driver);
    }
}
