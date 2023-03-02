package utulities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ReusableMethodsE {

    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {

        }
    }

    public static List<String> StringListecevir(List<WebElement> webElementList){

        List<String> stringLsitesi=new ArrayList<>();
        for (WebElement each:webElementList
             ) {
            stringLsitesi.add(each.getText());
        }

        return stringLsitesi;

    }




}
