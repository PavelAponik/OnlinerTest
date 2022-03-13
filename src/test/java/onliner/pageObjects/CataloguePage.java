package onliner.pageObjects;

import framework.base.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;


public class CataloguePage extends BasePage {
    public static final String CATALOGUE_MENU = "//span[text()='%s']";
    public static final String CATALOGUE_SUB_MENU = "//div[contains(@class, 'catalog-navigation-list__aside-title') and contains(text(), '%s')]";
    public static final String CATALOGUE_DROP_DOWN = "//span[contains(@class, 'catalog-navigation-list__dropdown-title') and contains(text(), '%s')]";
    static SoftAssert softAssert = new SoftAssert();


    public CataloguePage(){
        super(By.xpath("//div[contains(@class, 'b-top-logo')]"), "Catalogue Page");
    }

    public void navigateToCatalogueMenu(String menu, String subMenu){
        Button btnMenu = new Button(By.xpath(String.format(CATALOGUE_MENU, menu)), menu);
        Button btnSubMenu = new Button(By.xpath(String.format(CATALOGUE_SUB_MENU, subMenu)), subMenu);
        btnMenu.clickAndWait();
        btnSubMenu.clickAndWait();
    }

    public void navigateToDropdownItem(String item){
        Button btnItem = new Button(By.xpath(String.format(CATALOGUE_DROP_DOWN, item)), item);
        btnItem.clickAndWait();
    }

    @Override
    public void isRightPageOpened(String title) {
        softAssert.assertEquals(getTitle(), title);
    }
}




