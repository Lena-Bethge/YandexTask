package fw;

import model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ApplicationManager extends HelperBase{

    WebDriver wd;

    public void stop() {
        wd.quit();
    }

    public void init() {
        wd = new ChromeDriver();
        wd.get("https://yandex.ru/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void typeInSearchInputField(String itemName) {
        type(By.id("header-search"), itemName);
        click(By.cssSelector("[data-r='search-button']"));
    }

    public String getItemNameFromListByNumber(int number) {
        return wd.findElement(By.cssSelector("div:nth-child(" + number + ") ._2UHry")).getText();
    }

    public void filterItem(Item item) {
        jumpDown();
        type(By.cssSelector("._1heDd:nth-child(1) ._3qxDp"), item.getPriceFrom());
        type(By.cssSelector("._1heDd:nth-child(2) ._3qxDp"), item.getPriceTo());
        click(By.xpath("//span[text()='" + item.getBrand() + "']"));
    }

    public void jumpDown(){
        Actions actions = new Actions(wd);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void type(By locator, String text) {
        click(locator);
        if (text != null) {
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }



    public void selectCategoryType (String type){
            click(By.cssSelector("[href='/catalog--" + type + "?how=dpop&glfilter=&cvredirect=3&filter-express-delivery=1&searchContext=express&track=srch_ddl']"));
        }

    public void selectCatalog (String category){
            click(By.cssSelector("[href='/catalog--" + category + "/list?filter-express-delivery=1&searchContext=express']"));
        }

    public void selectDepartment (String department){
            click(By.xpath("//span[text()='" + department + "']"));
        }

    public void selectMarket () {
            click(By.cssSelector("[data-id='market']"));
        }

    public void click (By locator){
            wd.findElement(locator).click();
        }

    public void acceptCookies () {
            click(By.cssSelector("[data-id='button-all']"));
        }

    public void switchToNextTab (int number){
            List<String> availableWindows = new ArrayList<>(wd.getWindowHandles());
            if (!availableWindows.isEmpty()) {
                wd.switchTo().window(availableWindows.get(number));
            }
        }
}
