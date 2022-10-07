package DemoStepDefinitions;

import Hooks.BaseClass;
import PageObjects.SportMenu;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SportFunction {

    WebDriver driver;
    BaseClass baseClass;

    SportMenu sport;

    public SportFunction(BaseClass baseClass) {
        this.baseClass = baseClass;

    }

    @Given("the Mail Online home page")
    public void the_mail_online_home_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("1");
        /*String expectedTitle = "Homepage";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println("print home page");*/
    }
    @When("user click on the sport menu")
    public void user_click_on_the_sport_menu() {
        // Write code here that turns the phrase above into concrete actions
        sport = new SportMenu(driver);
        sport.gotItButtonClick.click();
        //sport.sportMethod();
        System.out.println("enter gotit");
        WebElement sportwebElement= sport.sportMenu;
        WebDriverWait wait1 = new WebDriverWait(baseClass.getDriver(),50);
        wait1.until(ExpectedConditions.elementToBeClickable(sportwebElement));
        sportwebElement.click();
        //sport.getSportMenu().click();
    }
    @When("user should see the sports page")
    public void user_should_see_the_sports_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("13");
        /*String expectedTitle = "Sportspage";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println("print sports page");*/

    }
    @When("user click on gallery icon")
    public void user_click_on_gallery_icon() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("14");
    }
    @Then("user should see the multiple gallery images")
    public void user_should_see_the_multiple_gallery_images() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
        System.out.println("15");
    }
}
