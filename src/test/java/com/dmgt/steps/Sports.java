package com.dmgt.steps;

import com.dmgt.context.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import pages.MailOnline;

public class Sports {
@Autowired
MailOnline mailOnline;
@Autowired
Base base;

    @Given("the Mail Online home page")
    public void theMailOnlineHomePage() {
        mailOnline.homePage().acceptCookies();
    }

    @And("the Sports page")
    public void theSportsPage() {
        mailOnline.homePage().navigateToSports();
    }

    @And("the Football page")
    public void theFootballPage() {
        mailOnline.SportsPage().clickOnFootBall();
    }

    @Then("user should see the Football page")
    public void userShouldSeeTheFootballPage() {
        Assert.assertTrue(mailOnline.SportsPage().getUrl().endsWith("sport/football/index.html"));
    }

    @When("user click on the first article")
    public void userClickOnTheFirstArticle() {
        mailOnline.SportsPage().clickOnFirstFootBallArticle();
    }

    @When("user click on gallery icon")
    public void userClickOnGalleryIcon() {
        mailOnline.SportsPage().clickOnViewGallery();
    }

    @And("user should be able to move Next gallery images")
    public void userShouldBeAbleToMoveNextGalleryImages() {
           mailOnline.SportsPage().clickNextButtonInGallery();
    }

    @And("user should be able to move Previous gallery images")
    public void userShouldBeAbleToMovePreviousGalleryImages() {
        mailOnline.SportsPage().clickPreviousButtonInGallery();
    }

    @And("user should be able to resize the video")
    public void userShouldBeAbleToResizeTheVideo() {
        mailOnline.SportsPage().enlargeVideo();
    }

    @And("user click on the Facebook share icon")
    public void userClickOnTheFacebookShareIcon() {
        mailOnline.SportsPage().clickFaceBook();
    }
    @Then("user should be able to see the facebook portal")
    public void userShouldBeAbleToSeeTheFacebookPortal() {
      Assert.assertTrue(base.isWindowSwitched("www.facebook.com"));
    }

    @Then("user should see the highlighted color as {string}")
    public void userShouldSeeTheHighlightedColorAs(String arg0) {
        Assert.assertTrue(mailOnline.SportsPage().getBackgroundColor().equalsIgnoreCase(arg0));
    }
}
