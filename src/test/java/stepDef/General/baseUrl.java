package stepDef.General;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class baseUrl {
    private static WebDriver driver;
    public baseUrl(){
        this.driver = bukaBrowser.getDriver();
    }

    @Given("Buka web Luma")
    public static void bukaLuma() {
        driver = bukaBrowser.getDriver(); // Inisialisasi driver

        driver.get("https://magento.softwaretestingboard.com/");
    }
}