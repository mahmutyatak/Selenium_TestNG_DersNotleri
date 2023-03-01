package tests.day11_POM_assertion;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utulities.ConfigReader;
import utulities.Driver;

public class C01_configReaderKullanimi {

    @Test
    public void test01(){
        //amazon ana sayfaya gidelim.
        Driver.getdriever().get(ConfigReader.getProperty("amazonUrl"));


        // test datasi olarak verilen kelime  icin arama yapalım
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakkelime")+ Keys.ENTER);

        // arama sonuclarinin arattigimiz test datasi icerdigini test edelim
        String actual=amazonPage.aramaSonucElementi.getText();
        String expectedIcerik=ConfigReader.getProperty("amazonAranacakkelime");

        Assert.assertTrue(actual.contains(expectedIcerik));
        Driver.closeDriver();

        // aranacak kelimeyi nutella yerine java yaptık bize kolayık sağlıyor dinamiklik oluyor.

    }
}
