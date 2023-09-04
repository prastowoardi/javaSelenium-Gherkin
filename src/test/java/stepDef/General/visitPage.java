package stepDef.General;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class visitPage {
    private static WebDriver driver;

    public visitPage() {
        driver = bukaBrowser.getDriver(); // Inisialisasi driver
    }
    public static void openBaseUrl() {
        driver.get(baseUrl.getBaseUrl());
    }
    private String getExpectedPageUrl(String pageName) {
        Map<String, String> expectedURLs = new HashMap<>();
        expectedURLs.put("Home", baseUrl.getBaseUrl());
        expectedURLs.put("Women", baseUrl.getBaseUrl() + "women.html");
        expectedURLs.put("Men", baseUrl.getBaseUrl() + "men.html");
        expectedURLs.put("Gear", baseUrl.getBaseUrl() + "gear.html");
        expectedURLs.put("Training", baseUrl.getBaseUrl() + "training.html");
        expectedURLs.put("Sale", baseUrl.getBaseUrl() + "sale.html");
        expectedURLs.put("Women Jackets", baseUrl.getBaseUrl() + "women/tops-women/jackets-women.html");
        expectedURLs.put("Women Hoodie", baseUrl.getBaseUrl() + "women/tops-women/hoodies-and-sweatshirts-women.html");
        expectedURLs.put("Women Tees", baseUrl.getBaseUrl() + "women/tops-women/tees-women.html");
        expectedURLs.put("Women Bra", baseUrl.getBaseUrl() + "women/tops-women/tanks-women.html");
        expectedURLs.put("Women Pants", baseUrl.getBaseUrl() + "women/bottoms-women/pants-women.html");
        expectedURLs.put("Women Shorts", baseUrl.getBaseUrl() + "women/bottoms-women/shorts-women.html");
        expectedURLs.put("Men Jackets", baseUrl.getBaseUrl() + "men/tops-men/jackets-men.html");
        expectedURLs.put("Men Hoodie", baseUrl.getBaseUrl() + "men/tops-men/hoodies-and-sweatshirts-men.html");
        expectedURLs.put("Men Tees", baseUrl.getBaseUrl() + "men/tops-men/tees-men.html");
        expectedURLs.put("Men Tanks", baseUrl.getBaseUrl() + "men/tops-men/tanks-men.html");
        expectedURLs.put("Men Pants", baseUrl.getBaseUrl() + "men/bottoms-men/pants-men.html");
        expectedURLs.put("Men Shorts", baseUrl.getBaseUrl() + "men/bottoms-men/shorts-men.html");
        expectedURLs.put("Bags", baseUrl.getBaseUrl() + "gear/bags.html");
        expectedURLs.put("Fitness", baseUrl.getBaseUrl() + "gear/fitness-equipment.html");
        expectedURLs.put("Watches", baseUrl.getBaseUrl() + "gear/watches.html");
        expectedURLs.put("Video Download", baseUrl.getBaseUrl() + "training/training-video.html");
        expectedURLs.put("Whats New", baseUrl.getBaseUrl() + "what-is-new.html");
        expectedURLs.put("cart", baseUrl.getBaseUrl() + "checkout/cart/");
        expectedURLs.put("My Account", baseUrl.getBaseUrl() + "customer/account/");
        expectedURLs.put("Wishlist", baseUrl.getBaseUrl() + "wishlist/");
        expectedURLs.put("History Trx", baseUrl.getBaseUrl() + "sales/order/history/");
        expectedURLs.put("Address", baseUrl.getBaseUrl() + "customer/address/new/");
        expectedURLs.put("Review", baseUrl.getBaseUrl() + "review/customer/");
        expectedURLs.put("", baseUrl.getBaseUrl() + "");
        // Tambahkan halaman-halaman lainnya

        return expectedURLs.get(pageName);
    }
    @And("User menuju halaman {string}")
    public void visitPage(String pageName) {
        openBaseUrl();

        String expectedUrl = getExpectedPageUrl(pageName);
        driver.get(expectedUrl);
        String actualUrl = driver.getCurrentUrl();

//        System.out.println("Expected URL:" +expectedUrl);
//        System.out.println("Actual URL:" +actualUrl);

        if (expectedUrl != null) {
            if (expectedUrl.equals(actualUrl)) {
                System.out.println("User berada di halaman: " + pageName);
            } else {
                System.out.println("User tidak berada di halaman: " + pageName);
            }
        } else {
            System.out.println("Expected URL not found for page: " + pageName);
        }
    }
}