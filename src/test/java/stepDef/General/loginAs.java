package stepDef.General;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class loginAs {
    private static WebDriver driver;

    public loginAs() {
        this.driver = bukaBrowser.getDriver(); // Inisialisasi driver
    }
    @And("User login sebagai {string}")
    public void loginas(String name) {
        driver = bukaBrowser.getDriver(); // Inisialisasi driver

        // Klik tombol Sign In
        driver.findElement(By.xpath("//a[contains(.,'Sign In')]")).click();

        Map<String, String> userCredentials = new HashMap<>();
        userCredentials.put("Andi", "hazz@mail.com:a1cab2f5@");
        userCredentials.put("Raki", "raki@mail.con:okP0219!a");
        // Tambahkan lebih banyak data sesuai kebutuhan

        String credentials = userCredentials.get(name);
        if (credentials != null) {
            String[] parts = credentials.split(":");
            String email = parts[0];
            String password = parts[1];

            driver.findElement(By.id("email")).sendKeys(email);
            driver.findElement(By.id("pass")).sendKeys(password);

            driver.findElement(By.xpath("//span[contains(.,'Sign In')]")).click();
        } else {
            System.out.println("User belum di mapping kan !");
        }
    }
}