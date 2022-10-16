package pages;

import com.dmgt.context.Base;
import org.openqa.selenium.By;

public class SportsPage {
    Base base;
    public SportsPage(Base base){
        this.base=base;
    }
    private By linkFootBallSubMenu= By.xpath("//a[text()='Football']");
    private By firstArticleInFootBall= By.xpath("(//h2[@class='linkro-darkred']//a)[2]");
    private By viewGallery= By.xpath("(//button//div[text()='View gallery'])[1]");
    private By videoEnlarge= By.xpath("(//div[contains(@class,'fullscreen')])[1]");
    private By facebook= By.xpath("//ul/li[@data-social-scope='facebook']");
    private By shareIcon= By.xpath("(//ul[contains(@class,'linksHolder')])[1]");
    private By nextGalleryButton=By.xpath("//button[@aria-label='Next']");
    private By previousGalleryButton=By.xpath("//button[@aria-label='Previous']");
    private By linkSportMenu = By.xpath("//div[contains(@class,'page-header')]//a[text()='Sport']");

    public String getBackgroundColor(){
        return this.base.getAttribute(linkSportMenu,"background-color");
    }

    public String getUrl(){
         return base.getDriver().getCurrentUrl();
    }

    public void clickOnFootBall(){
        base.waitForElementToClickable(linkFootBallSubMenu);
        base.click(linkFootBallSubMenu);
    }

    public void clickOnFirstFootBallArticle(){
        base.waitForElementToClickable(firstArticleInFootBall);
        base.click(firstArticleInFootBall);
    }
    public void clickOnViewGallery(){
        base.scrollToView(viewGallery);
        base.waitForElementToClickable(viewGallery);
        base.hover(viewGallery);
        base.click(viewGallery);
    }

    public void enlargeVideo(){
        base.waitForElementToClickable(videoEnlarge);
        base.jsClick(videoEnlarge);
    }

    public void clickFaceBook(){
        base.waitForElementToClickable(shareIcon);
        base.click(shareIcon);
        base.waitForElementToClickable(facebook);
        base.click(facebook);
    }

    public void clickNextButtonInGallery(){
        base.click(nextGalleryButton);
    }
    public void clickPreviousButtonInGallery(){
        base.click(nextGalleryButton);
    }
}
