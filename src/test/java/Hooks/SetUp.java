package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SetUp {
    public WebDriver driver;
    BaseClass baseClass;

    private Properties prop;


    public SetUp(BaseClass baseClass) {

        this.baseClass = baseClass;
    }



    @Before
    public void runBefore() throws InterruptedException, IOException {
        System.out.println("Before");
        // driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        WebDriverManager.chromedriver().setup();
        //Thread.sleep(3000);
        driver = new ChromeDriver();
        // Thread.sleep(4000);
        /*prop = new Properties();
        FileInputStream file = new FileInputStream("src/main/resources/bundle.properties");
        prop.load(file);*/
        //baseClass.getDriver().get(prop.getProperty("url"));

        /*driver.get("https://www.dailymail.co.uk/home/index.html");
        driver.manage().window().maximize();*/
        // baseClass.getDriver().manage().getCookieNamed("//button[@class='button_127GD primary_2xk2l']");
        baseClass.setDriver(driver);
        baseClass.initialize(driver);
        baseClass.getDriver().get("https://www.dailymail.co.uk/home/index.html");
        baseClass.getDriver().manage().window().maximize();

    }
    @After
    public void runAfter(){
        System.out.println("After");
        baseClass.getDriver().close();
        baseClass.getDriver().quit();

    }
}
