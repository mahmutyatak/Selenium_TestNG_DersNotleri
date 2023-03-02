package tests.day12_Driver_xmlFiles;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utulities.Driver;
import utulities.ReusableMethods;

public class C02_ReusableMethodsSwitchingWindow {
    @Test
    public void switchWindowsTesti(){
        //● Tests package’inda yeni bir class olusturun: WindowHandle2
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getdriever().get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        //● Click Here butonuna basın.
        Driver.getdriever().findElement(By.linkText("Click Here")).click();
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        ReusableMethods.switchToWindow("New Window");
        System.out.println(Driver.getdriever().getTitle());



        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        Driver.quitDriver();
    }
}
