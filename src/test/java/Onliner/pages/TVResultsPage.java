package Onliner.pages;

import framework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TVResultsPage extends BasePage {

    public TVResultsPage(WebDriver driver){
        super(driver);
    }

    public List<WebElement> titleResult = driver.findElements(By.xpath("//div[@class='schema-product__title']"));
    public List<WebElement> descriptionResult = driver.findElements(By.xpath("//div[@class='schema-product__description']"));
    public List<WebElement> priceResult = driver.findElements(By.xpath("//a[@class='schema-product__price-value schema-product__price-value_primary']/span"));

    public void checkSearchList(List<WebElement> searchList, String string){
        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < searchList.size(); i++){
            softAssert.assertTrue(searchList.get(i).getText().contains(string));
        }
    }

    public void checkDiagonal(List<WebElement> searchList, String DiagonalMin, String DiagonalMax){
        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < searchList.size(); i++){
            int diag = Integer.parseInt(searchList.get(i).getText().substring(0,2));
            if (diag < Integer.parseInt(DiagonalMax.substring(0, DiagonalMax.length()-1)) | diag > Integer.parseInt(DiagonalMin.substring(0, DiagonalMin.length()-1))){
                softAssert.assertTrue(true, "Correct Screen Diagonal");
            }
        }
    }

    public void checkPrice(List<WebElement> searchList, String Price){
        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < searchList.size(); i++){
            softAssert.assertTrue(Double.parseDouble(searchList.get(i).getText().replace(" р.", "").replace(',', '.')) <= Double.parseDouble(Price));
        }
    }
}
