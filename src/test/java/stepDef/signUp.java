package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDef.General.bukaBrowser;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class signUp {
    private static WebDriver driver;
    public signUp() {
        this.driver = bukaBrowser.getDriver();
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
    public String getMessage(WebDriver driver, String selector) {
        try {
            long waitTimeInSeconds = 10; // Waktu tunggu dalam detik
            Duration timeoutDuration = Duration.ofSeconds(waitTimeInSeconds); // Konversi ke Duration

            WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);

            WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
            return messageElement.getText();
        } catch (Exception e) {
            return null;
        }
    }

}