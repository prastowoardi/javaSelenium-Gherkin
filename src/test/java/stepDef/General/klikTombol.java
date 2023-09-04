package stepDef.General;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class klikTombol {
    private static WebDriver driver;

    public klikTombol() {
        this.driver = bukaBrowser.getDriver(); // Inisialisasi driver
    }

    @And("User klik tombol {string}")
    public void klikButton(String buttonName){
        Map<String, By> xpathSelectors = new HashMap<>();
        xpathSelectors.put("create an account", By.xpath("//form/div/div/button/span"));
        xpathSelectors.put("Sign In", By.xpath("//span[contains(.,'Sign In')]"));
        //xpathSelectors.put("", By.xpath(""));
        //xpathSelectors.put("", By.xpath(""));

        By selector = xpathSelectors.get(buttonName);
        driver.findElement(selector).click();
    }
}