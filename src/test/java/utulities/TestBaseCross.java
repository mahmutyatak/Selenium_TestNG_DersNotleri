package utulities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utulities.DriverCross;

import java.time.Duration;
public class TestBaseCross {
    protected WebDriver driver;
    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional String browser){
        driver= DriverCross.getdriever(browser);

    }
    @AfterTest
    public void tearDown(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
