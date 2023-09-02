package stepDef.General;

import io.cucumber.java.en.Given;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class bukaBrowser {
    private static WebDriver driver;

    @BeforeClass
    @Given("Buka browser")
    public void bukaBrowser() {
        final String dir = System.getProperty("user.dir");
//        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
        // Set ukuran layar browser
        Dimension screenSize = new Dimension(1440, 1024); // Ganti sesuai kebutuhan
        driver.manage().window().setSize(screenSize);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        } else {
            System.out.println("Ada yang salah Browser tidak tertutup !");
        }
    }
}