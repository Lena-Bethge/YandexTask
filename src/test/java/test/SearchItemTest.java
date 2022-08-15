package test;

import model.Item;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItemTest extends TestBase {

    @Test
    public void searchItemTest() {
        app.selectMarket();
        app.switchToNextTab(1);
        app.selectDepartment("Экспресс");
        app.acceptCookies();
        app.selectCatalog("elektronika/23282330");
        app.selectCategoryType("smartfony-i-aksessuary/23282379");

        app.filterItem(new Item().setPriceFrom("20000")
                .setPriceTo("35000")
                .setBrand("Apple"));
        app.pause(20000);
        String itemName = app.getItemNameFromListByNumber(3);

        System.out.println(itemName);
        app.typeInSearchInputField(itemName);
        app.pause(20000);
        String foundItemName = app.getItemNameFromListByNumber(2);
        System.out.println(foundItemName);
        Assert.assertEquals(foundItemName,itemName);
    }


}



