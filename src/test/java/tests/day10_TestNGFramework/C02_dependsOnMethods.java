package tests.day10_TestNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utulities.Driver;

public class C02_dependsOnMethods {
    /*
    PRİORİTY oncelik belirler ama testleri birbirine baglamaz
    Eger bir test methodunun calimasi baska bir test metoduna bagli ise dependsOnMethod kullanmak
    daha guzel olur.

    DependsOnMethod ile baska bir methoda bagli olan methodu bagimsiz calistirmak istersek
    once bagli oldugu methodu calistirir. Sonra kendisi calisir.
    Ancak bu 2 method icin gecerlidir 3 method calistirmaz.

      DependsOnMethod bir siralama yöntemi degildir.
      sira bagli olan bir methoda geldiginde oncelikle bagli oldugu
      methodun calismasini ve passed olmasini bekler.
        Eger bagli olunan method failed olursa bagli olan method calistirilmaz.
        ignore edilir.
     */

    //3 test methodu olusutun
    //1. amazona gidip amazona gittigini test edin
    //2. de nutella aratıp sonucun nutella icerdigini test edin
    //3. il urune click yapıp urun isminin nutella icerdigini test edin
    AmazonPage amazonPage=new AmazonPage();//amazon page sayfasındakiler ulasmak icin
    @Test
    public void zamazonTesti(){
        Driver.getdriever().get("https://www.amazon.com");
        String expectedIcerik="amazon";
        String actualUrl=Driver.getdriever().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));

    }
    @Test(dependsOnMethods = "zamazonTesti")
    public void nutellaTesti(){

        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        String expectedIcerik="Nutella";
        String actualSonucYazisi=amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

    }
    @Test(dependsOnMethods = "nutellaTesti")
    public void ilkurunTesti(){
        amazonPage.ilkurun.click();
        String expectedIcerik="Nutella";
        String actualUrunIsmi=amazonPage.ilkUrunIsimElementi.getText();
        Assert.assertTrue(actualUrunIsmi.contains(expectedIcerik));
        Driver.closeDriver();
    }
}
