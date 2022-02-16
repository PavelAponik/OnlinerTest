package Onliner.pages;

import framework.Browser;

public class HomePage extends BasePage {
    public static final String category = "//h2//a[contains(text(), '%s')]";

    public HomePage(Browser browser) {
        super(browser);
    }



}
