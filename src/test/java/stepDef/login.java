package stepDef;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import stepDef.General.bukaBrowser;


public class login {
    private WebDriver driver;
    public login(){
        this.driver = bukaBrowser.getDriver();
    }

    @When("Cek apakah user sudah login")
    public void cekLogin() {
        driver = bukaBrowser.getDriver(); // Inisialisasi driver

        WebElement element = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/header[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/ul[1]/li[1]/a[1]")); // Ambil elemen kembali

        System.out.println("Welcome, Andi Hazz!");
        driver.quit();
    }
}

