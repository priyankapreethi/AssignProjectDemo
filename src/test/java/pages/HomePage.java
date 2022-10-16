package pages;

import com.dmgt.context.Base;
import org.openqa.selenium.By;

public class HomePage {

    Base base;
    public HomePage(Base base){
        this.base=base;
    }

    private By linkSportMenu = By.xpath("//div[contains(@class,'page-header')]//a[text()='Sport']");
    private By btnAcceptCookies = By.xpath("//button[text()='Got it']");


    public void acceptCookies(){
        base.waitForElementToClickable(btnAcceptCookies);
        base.click(btnAcceptCookies);
    }

    public SportsPage navigateToSports(){
        base.waitForElementToClickable(linkSportMenu);
        base.getDriver().findElement(linkSportMenu).click();
        return new SportsPage(base);
    }


}
