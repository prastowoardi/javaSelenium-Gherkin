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

        driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click();
        driver.findElement(By.xpath("//div[@class='panel wrapper']//li[1]//a[1]")).click();
        WebElement element = driver.findElement(By.xpath("//div[@class='box-content']//p"));
        String fullText = element.getText();

        // Memisahkan teks menjadi kata-kata
        String[] words = fullText.split("\\s+"); // Memisahkan berdasarkan spasi

        // Mengambil dua kata pertama untuk nama
        int numberOfWordsForName = Math.min(2, words.length);
        StringBuilder nameText = new StringBuilder();
        for (int i = 0; i < numberOfWordsForName; i++) {
            nameText.append(words[i]).append(" ");
        }

        // Mengambil sisa kata-kata sebagai email
        StringBuilder emailText = new StringBuilder();
        for (int i = numberOfWordsForName; i < words.length; i++) {
            emailText.append(words[i]).append(" ");
        }

        System.out.println("Login sebagai: " + nameText.toString().trim());
        System.out.println("Email: " + emailText.toString().trim());

        driver.quit();
    }
}

