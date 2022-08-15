package fw;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager extends HelperBase{

    public void stop() {
        wd.quit();
    }

    public void init() {
        wd = new ChromeDriver();
        wd.get("https://yandex.ru/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

}
