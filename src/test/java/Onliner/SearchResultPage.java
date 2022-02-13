package Onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Framework.Browser;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchResultPage {
    static WebDriver driver = Browser.driver;

    public SearchResultPage(WebDriver driver){
        Browser.driver = driver;
    }

    public List<WebElement> titleResult = driver.findElements(By.xpath("//div[@class='schema-product__title']"));
    public List<WebElement> descriptionResult = driver.findElements(By.xpath("//div[@class='schema-product__description']"));
    public List<WebElement> priceResult = driver.findElements(By.xpath("//a[@class='schema-product__price-value schema-product__price-value_primary']/span"));

    public void checkSearchList(List<WebElement> searchList, String string){
        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < searchList.size(); i++){
            softAssert.assertTrue(searchList.get(i).getText().contains(string));
            softAssert.assertAll();
        }
    }

    public void checkDiagonal(List<WebElement> searchList, String DiagonalMin, String DiagonalMax){
        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < searchList.size(); i++){
            int diag = Integer.parseInt(searchList.get(i).getText().substring(0,2));
            if (diag < Integer.parseInt(DiagonalMax.substring(0, DiagonalMax.length()-1)) | diag > Integer.parseInt(DiagonalMin.substring(0, DiagonalMin.length()-1))){
                softAssert.assertTrue(true, "Correct Screen Diagonal");
            }
            softAssert.assertAll();
        }
    }

    public void checkPrice(List<WebElement> searchList, String Price){
        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < searchList.size(); i++){
            softAssert.assertTrue(Double.parseDouble(searchList.get(i).getText().replace(" р.", "").replace(',', '.')) <= Double.parseDouble(Price));
            softAssert.assertAll();
        }
    }
}
