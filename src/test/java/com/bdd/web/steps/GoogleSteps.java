package com.bdd.web.steps;

import com.bdd.web.page.GooglePage.GoogleMainPage;
import com.bdd.web.page.GooglePage.GoogleResultPage;
import com.bdd.web.page.GooglePage.WikipediaPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class GoogleSteps {
    WebDriver driver;
    private GoogleMainPage GoogleMainPage(){return new GoogleMainPage(driver);};
    private GoogleResultPage GoogleResultPage(){return new GoogleResultPage(driver);};
    private WikipediaPage WikipediaPage(){ return new WikipediaPage(driver);};

    public void openPage(String url) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void search(String busqueda) throws InterruptedException {
        //TimeUnit.SECONDS.sleep(2);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        GoogleMainPage().getInputBusqueda().sendKeys(busqueda+"\n");

    }

    public void clickFirstResult() {
        GoogleResultPage().getFirstResult().click();
    }

    public void validarFueraDeGoogle() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        //Validar a través del url
        String url = driver.getCurrentUrl();
        Assert.assertFalse(url.contains("google"));
    }

    public void validarPermanecerEnGoogle() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("google"));
    }
}
