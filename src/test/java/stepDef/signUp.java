package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

    @And("Buka halaman {string}")
    public void halaman(String page) {
        Map<String, By> xpathSelectors = new HashMap<>();
        xpathSelectors.put("sign up", By.xpath("//a[contains(.,'Create an Account')]"));
        xpathSelectors.put("login", By.xpath("//a[contains(.,'Sign In')]"));

        By xSelector = xpathSelectors.get(page);
        WebElement element = driver.findElement(xSelector);
        element.click();
//        driver.findElement(By.xpath("//a[contains(.,'Create an Account')]")).click();
    }
    String fn;
    @And("User memasukkan {string} dengan {string}")
    public void inputField(String fieldName, String fieldValue) {
        // Mapping elemen dan selector-nya
        Map<String, By> idSelectors = new HashMap<>();
        idSelectors.put("first name", By.id("firstname"));
        idSelectors.put("last name", By.id("lastname"));
        idSelectors.put("email", By.id("email_address"));
        idSelectors.put("password", By.id("password"));
        idSelectors.put("confirm password", By.id("password-confirmation"));
        idSelectors.put("emailLogin", By.id("email"));
        idSelectors.put("passLogin", By.id("pass"));

        By selector = idSelectors.get(fieldName);
        WebElement element = driver.findElement(selector);
        element.sendKeys(fieldValue);

        fn = String.valueOf(idSelectors.get(fieldValue));
    }

    @And("User klik tombol {string}")
    public void klikButton(String buttonName){
        Map<String, By> xpathSelectors = new HashMap<>();
        xpathSelectors.put("create an account", By.xpath("//form/div/div/button/span"));
        xpathSelectors.put("Sign In", By.xpath("//span[contains(.,'Sign In')]"));

        By selector = xpathSelectors.get(buttonName);
        driver.findElement(selector).click();
    }

    @Then("Lihat alert")
    public void lihatAlert() {
        if (fn == "Reka") {
            driver.findElement(By.cssSelector(".message-error > div"));
            System.out.println("There is already an account with this email address. If you are sure that it is your email address");
            driver.quit();
        } else {
            driver.findElement(By.cssSelector(".message-success > div"));
            System.out.println("Thank you for registering with Main Website Store.");
        }
    }
}