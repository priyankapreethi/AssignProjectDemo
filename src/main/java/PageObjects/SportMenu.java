package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SportMenu {

    public SportMenu(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    /*@FindBy(xpath="//a[@xpath = '1']")
    public WebElement sportMenu;*/

    /* //body/div[@id='top']/div[@id='page-container']/div[2]/ul[1]/li[4]/span[1]/a[1] */
    @FindBy(xpath="//span[@class='link-wocc linkro-wocc selected']")
    public WebElement sportMenu;

    @FindBy(xpath="//button[@class='button_127GD primary_2xk2l']")
    public WebElement gotItButtonClick;

    public WebElement getSportMenu() {
        return sportMenu;
    }

    public void setSportMenu(WebElement sportMenu) {
        this.sportMenu = sportMenu;
    }

    public WebElement getGotItButtonClick() {
        return gotItButtonClick;
    }

    public void setGotItButtonClick(WebElement gotItButtonClick) {
        this.gotItButtonClick = gotItButtonClick;
    }

    public void sportMethod(){

        gotItButtonClick.click();
        //sportMenu.click();
    }
}
