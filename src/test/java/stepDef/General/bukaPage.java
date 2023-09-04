package stepDef.General;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class bukaPage {
    private static WebDriver driver;

    public bukaPage() {
        this.driver = bukaBrowser.getDriver(); // Inisialisasi driver
    }
    @And("Buka halaman {string}")
    public void halaman(String page) {
        driver = bukaBrowser.getDriver(); // Inisialisasi driver

        Map<String, By> xpathSelectors = new HashMap<>();
        xpathSelectors.put("sign up", By.xpath("//a[contains(.,'Create an Account')]"));
        xpathSelectors.put("login", By.xpath("//a[contains(.,'Sign In')]"));

        By xSelector = xpathSelectors.get(page);
        WebElement element = driver.findElement(xSelector);
        element.click();
    }
}