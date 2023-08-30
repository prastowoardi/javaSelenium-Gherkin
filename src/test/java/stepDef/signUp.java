package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class signUp {
    WebDriver driver;

    @Given("Buka browser")
    public void bukaBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
        // Set ukuran layar browser
        Dimension screenSize = new Dimension(1440, 1024); // Ganti sesuai kebutuhan
        driver.manage().window().setSize(screenSize);
    }

    @And("Buka web Luma")
    public void bukaLuma() {
        driver.get("https://magento.softwaretestingboard.com/"); // Ganti dengan URL yang sesuai
    }

    @And("Buka halaman sign up")
    public void halamanSignup() {
        driver.findElement(By.cssSelector(".header > li:nth-child(4) > a")).click();
    }

    @And("User memasukkan {string} dengan {string}")
    public void inputField(String fieldName, String fieldValue) {
        // Mapping elemen dan selector-nya
        Map<String, By> idSelectors = new HashMap<>();
        idSelectors.put("first name", By.id("firstname"));
        idSelectors.put("last name", By.id("lastname"));
        idSelectors.put("email", By.id("email_address"));
        idSelectors.put("password", By.id("password"));
        idSelectors.put("confirm password", By.id("password-confirmation"));

        By selector = idSelectors.get(fieldName);
        WebElement element = driver.findElement(selector);
        element.sendKeys(fieldValue);
    }

    @And("User klik tombol {string}")
    public void klikButton(String buttonName){
        Map<String, By> xpathSelectors = new HashMap<>();
        xpathSelectors.put("create an account", By.xpath("//form/div/div/button/span"));

        By selector = xpathSelectors.get(buttonName);
        driver.findElement(selector).click();
    }
//    @Then("Url sesuai dengan yang dibuka")
//    public void urlSesuai() {
//        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/create/"; // Ganti dengan URL yang sesuai
//        String actualUrl = driver.getCurrentUrl();
//        if (actualUrl.equals(expectedUrl)) {
//            System.out.println("URL sesuai dengan yang diharapkan: " + actualUrl);
//        } else {
//            System.out.println("URL tidak sesuai. Diharapkan: " + expectedUrl + " Tetapi ditemukan: " + actualUrl);
//        }
//
////        driver.quit();
//    }
}