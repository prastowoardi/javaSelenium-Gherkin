package stepDef.General;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class baseUrl {
    private static WebDriver driver;
    private static String base_url = "https://magento.softwaretestingboard.com/";

    @Given("Buka web Luma")
    public static void openLumaWeb() {
        driver = bukaBrowser.getDriver(); // Inisialisasi driver
        driver.get(base_url);
    }

    public static String getBaseUrl() {
        return base_url;
    }
}