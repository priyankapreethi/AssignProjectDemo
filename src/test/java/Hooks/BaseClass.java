package Hooks;

import PageObjects.SportMenu;
import org.openqa.selenium.WebDriver;

public class BaseClass {
    WebDriver driver;

    SportMenu spmenu;

    public WebDriver getDriver() {
        return driver;
    }

    public SportMenu getSpmenu() {
        return spmenu;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setSpmenu(SportMenu spmenu) {
        this.spmenu = spmenu;
    }


    public void initialize(WebDriver driver){

       // dateandtime = new  DateAndTime(driver);
        spmenu = new SportMenu(driver);

    }
}
