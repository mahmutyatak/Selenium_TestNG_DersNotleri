package utulities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    //daha fazla kontrol imkanı ve extends kullnamdan driver a ulasmak icin
    //webdriver objesini Driver classındaki static bir method ile olusturacgız
    /*
    ancak get driver methodu her kullnaıldıgında yeni bir driver olusturuyor. bunu engellemek ve kodumuzun duzgun
    calismasını sağlamak icin ilk kulanımda driver=new chromeDriver calissin diger kullanımlrda
    calismasın diye bir yöntem gelistirmeliyiz.

     */

    public static WebDriver driver;
    public static WebDriver getdriever(){
        WebDriverManager.chromedriver().setup();
        if (driver==null){
            driver=new ChromeDriver();
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
    public static void closeDriver(){
        if (driver!=null){
            driver.close();
            driver=null;
        }

    }
    public static void quitDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }

    }
}
