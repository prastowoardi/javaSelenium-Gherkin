package stepDef;

import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    WebDriver driver;

    @Before
    public void setup() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @When("Cek apakah user sudah login")
    public void cekLogin() {
        driver.findElement(By.className("panel-header"));
        System.out.println("testing");
        driver.quit();
    }
}

