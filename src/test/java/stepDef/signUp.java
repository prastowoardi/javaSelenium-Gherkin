package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class signUp {
    WebDriver driver;

    @Given("Buka browser")
    public void bukaBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver");
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
        String errorMessage = getMessage(driver, ".message-error > div");
        String successMessage = getMessage(driver, ".message-success > div");

        if (errorMessage != null) {
            System.out.println("Error Message: " + errorMessage);
            driver.quit();
        } else if (successMessage != null) {
            System.out.println("Success Message: " + successMessage);
            driver.quit();
        } else {
            System.out.println("No message found.");
        }
    }

    // Function untuk ambil text dari message yang muncul
    public static String getMessage(WebDriver driver, String selector) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
            return messageElement.getText();
        } catch (Exception e) {
            return null;
        }
    }
}