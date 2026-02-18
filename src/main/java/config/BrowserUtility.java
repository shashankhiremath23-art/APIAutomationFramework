package config;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtility {



    public void initiateBrowser(String browser) {
        switch (browser) {
            case "chrome":
                new ChromeDriver();
                break;
            case "edge":
                new EdgeDriver();
                break;
            case "firefox":
                new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException();

        }

    }

}
