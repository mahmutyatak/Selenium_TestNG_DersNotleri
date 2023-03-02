package tests.day11_POM_assertion;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utulities.ConfigReader;
import utulities.Driver;

public class C05_softAssert {

    @Test(groups = {"mr1","mr2"})
    public void amazonTesti(){
        // genelde dogrulayın(verify) derlerse softAssert test edin derse HardAssert kullanılır
        //amazon anasayfaya gidip,dogru syfaya gittigimizi dogrulayin(verify)

        Driver.getdriever().get(ConfigReader.getProperty("amazonUrl"));
        String expectedIcerik="amazon";
        String actualUrl=Driver.getdriever().getCurrentUrl();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actualUrl.contains(expectedIcerik));
        //nutella icin arama yapıp sonucalrın nutelalla icerdigini dogrulayın
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakkelime")+ Keys.ENTER);
        expectedIcerik="Kutella";
        String actualAramaSonucYazisi=amazonPage.aramaSonucElementi.getText();
        softAssert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik),"ARAMA SONUCU NUTELLA ICERMİYOR");
        // ilk urune tıklayıp urun isminde nutella gectigini dogrulayın
        amazonPage.ilkurun.click();
        expectedIcerik="Nutella";
        String actualilkUrunIsim=amazonPage.ilkUrunIsimElementi.getText();
        softAssert.assertTrue(actualilkUrunIsim.contains(expectedIcerik));

        softAssert.assertAll();
        Driver.closeDriver();
        /*
        testler failed oldugunda assertall satirina kadar calisyor orda hata veriyor.
        fakat softAssert in kotu yani hataları söylüyor ama hangi satırda oldugunu belirtmiyor.
        o yüzden yanına acıklama yapmak gerekebilir.
        O SATIRDA HATA VERDİGİ İCİN DRİVER.CLOSE U CALİSTİRMADİ.
         */
    }
}
