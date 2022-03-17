package onliner.pageObjects;

import framework.base.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;


public class CataloguePage extends BasePage {
    public static final String CATALOGUE_MENU = "//span[text()='%s']";
    public static final String CATALOGUE_SUB_MENU = "//div[contains(@class, 'catalog-navigation-list__aside-title') and contains(text(), '%s')]";
    public static final String CATALOGUE_DROP_DOWN = "//span[contains(@class, 'catalog-navigation-list__dropdown-title') and contains(text(), '%s')]";
    Button btnMenu = new Button(By.xpath(String.format(CATALOGUE_MENU, menu)), menu);
    Button btnSubMenu = new Button(By.xpath(String.format(CATALOGUE_SUB_MENU, subMenu)), subMenu);
    Button btnItem = new Button(By.xpath(String.format(CATALOGUE_DROP_DOWN, item)), item);

    public CataloguePage(){
        super(By.xpath("//div[contains(@class, 'b-top-logo')]"), "Catalogue Page");
    }

    public void navigateToCatalogueMenu(String menu, String subMenu){
        btnMenu.clickAndWait();
        btnSubMenu.clickAndWait();
    }

    public void navigateToDropdownItem(String item){
        btnItem.clickAndWait();
    }
}




