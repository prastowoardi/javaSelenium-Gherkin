package stepDef.General;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class cekHalaman {
    private static WebDriver driver;

    public cekHalaman() {
        this.driver = bukaBrowser.getDriver(); // Inisialisasi driver
    }

    @And("Cek apakah halaman benar {string}")
    public void cekHalaman(String pageName) {
        // Mendapatkan URL aktual dari driver
        String actualURL = driver.getCurrentUrl();

        // Map yang menyimpan pasangan kunci-nilai URL yang diharapkan
        Map<String, String> expectedURLs = new HashMap<>();
        expectedURLs.put("Women", "https://magento.softwaretestingboard.com/women.html");
        expectedURLs.put("Men", "https://magento.softwaretestingboard.com/men.html");
        expectedURLs.put("Gear", "https://magento.softwaretestingboard.com/gear.html");
        expectedURLs.put("Training", "https://magento.softwaretestingboard.com/training.html");
        expectedURLs.put("Sale", "https://magento.softwaretestingboard.com/sale.html");
        expectedURLs.put("Women Jackets", "https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html");
        expectedURLs.put("Women Hoodie", "https://magento.softwaretestingboard.com/women/tops-women/hoodies-and-sweatshirts-women.html");
        expectedURLs.put("Women Tees", "https://magento.softwaretestingboard.com/women/tops-women/tees-women.html");
        expectedURLs.put("Women Bra", "https://magento.softwaretestingboard.com/women/tops-women/tanks-women.html");
        expectedURLs.put("", "");

        // Memeriksa apakah URL aktual cocok dengan salah satu dari URL yang diharapkan
        String result = "";
        for (Map.Entry<String, String> entry : expectedURLs.entrySet()) {
            if (actualURL.equals(entry.getValue())) {
                // Menampilkan Keyword dari feature
                result = "Anda berada di halaman: " + entry.getKey() + " (" + entry.getValue() + ")";

                // Menampilkan url saja
                //result = "Anda berada di halaman: " + entry.getValue();
                break;
            }
        }

        // Mencetak hasil
        System.out.println(result);
        driver.quit();
    }
}