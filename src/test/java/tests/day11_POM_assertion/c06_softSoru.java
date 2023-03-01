package tests.day11_POM_assertion;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.WebappsecurityPage;
import utulities.ConfigReader;
import utulities.Driver;
import utulities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class c06_softSoru {
    @Test
    public void webappTesti(){
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getdriever().get(ConfigReader.getProperty("webappUrl"));
        // 2. Sign in butonuna basin
        WebappsecurityPage webappsecurityPage=new WebappsecurityPage();
        webappsecurityPage.ilksingButonu.click();
        // 3. Login kutusuna “username” yazin
        webappsecurityPage.username.sendKeys(ConfigReader.getProperty("username"));
        // 4. Password kutusuna “password” yazin
        webappsecurityPage.password.sendKeys(ConfigReader.getProperty("password"));
        // 5. Sign in tusuna basin
        webappsecurityPage.girissignButton.click();
        Driver.getdriever().navigate().back();
        // 6. Online banking menusu icinde Pay Bills sayfasina gidin
        webappsecurityPage.onlineBanking.click();
        webappsecurityPage.payyBills.click();
        // 7. “Purchase Foreign Currency” tusuna basin
        webappsecurityPage.pucrhaseButton.click();
        // 8. “Currency” drop down menusunden Eurozone’u secin
        Select select=new Select(webappsecurityPage.dropdown);
        select.selectByVisibleText("Eurozone (euro)");
        // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        String actualYazi=select.getFirstSelectedOption().getText();//son secili olan seyin yazısını getiriyor.
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! unutma!!!!!!!!!!!!!!!
        String expectedSecim="Eurozone (euro)";

        softAssert.assertEquals(actualYazi,expectedSecim,"DROPDOWN DA EUROZE SECİLİ DEGİL");
        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)",
        // "Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
         //"Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
        List<WebElement> ddmoptions=select.getOptions();
        // bir method yaptik webelementleri gonderecegiz string olarak gelecek.

        List<String> actualoptionStringList= ReusableMethods.StringListecevir(ddmoptions);
        String [] expectedArr={"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)",
                "Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
                "Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"};
        List<String> expectedOptionListesi=new ArrayList<>();
        for (String each:expectedArr
             ) {
            expectedOptionListesi.add(each);
        }

        softAssert.assertEquals(actualoptionStringList,expectedOptionListesi);
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
