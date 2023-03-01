package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utulities.Driver;

public class AmazonPage {
    /*
    Pages class lari surekli kullandıgımız locateleri tekrar tekrar locate etmek zorunda kalmaktan
    kurtulmak icin kullanılır
    Her pages class ı driver classında olusturulan driver ı kullanır.
    @FindBy notasyonunu driver classındaki webdriver ı kullaabilmesi icin
    bu class a tanıtmamız gerekiyor.

    BUNUN icin her page sayfası ilk olusturulduunda basina parametresiz bir constructor olusturup
    icerisinde driver ı bu classa tanıtıyoruz.


     */


   public AmazonPage(){
      PageFactory.initElements(Driver.getdriever(),this);
  }


    @FindBy(id="twotabsearchtextbox")
    public WebElement aramaKutusu;
  @FindBy(xpath = "//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")
    public WebElement aramaSonucElementi;
  @FindBy(xpath = "(//img[@class='s-image'])[1]")
    public WebElement ilkurun;
  @FindBy(xpath = "//span[@id='productTitle']")
    public WebElement ilkUrunIsimElementi;

}
