package Onliner.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import framework.Browser;
import org.openqa.selenium.interactions.Actions;


public class CataloguePage extends BasePage{
    private final String catalogMenu = "//span[text()='%s']";
    private final String catalogSubMenu = "//div[contains(@class, 'catalog-navigation-list__aside-title') and contains(text(), '%s')]";
    private final String catalogDropDown = "//span[contains(@class, 'catalog-navigation-list__dropdown-title') and contains(text(), '%s')]";

    public CataloguePage(Browser browser){
        super(browser);
    }

    public void selectCatMenu(String category){
        navigateTo((String.format(catalogMenu, category))).click();
    }

    public void selectCatSubMenu(String subCategory) {
        navigateTo(String.format(catalogSubMenu, subCategory));
    }

    public void selectDropDownItem(String dropDownItem){
        browser.getActions().click(navigateTo(String.format(catalogDropDown, dropDownItem))).build().perform();

    }
}




