package com.dmgt.context;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import pages.MailOnline;

import java.util.concurrent.TimeUnit;

@CucumberContextConfiguration
@ContextConfiguration(classes = {Env.class, Base.class, MailOnline.class})
public class Hooks {
    @Autowired
    Env env;
    @Autowired
    Base base;

    @Before("@ui")
    public void startUp(){
        if(env.getBrowser().equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            base.setDriver(new ChromeDriver()); }
        else if(env.getBrowser().equalsIgnoreCase("edge")){
              WebDriverManager.edgedriver().setup();
            base.setDriver(new EdgeDriver());}
            base.getDriver().get(env.getProdUrl());
            base.getDriver().manage().timeouts().implicitlyWait(env.getTimeout(), TimeUnit.SECONDS);
            base.getDriver().manage().window().maximize();
    }

    @After("@ui")
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            byte[] data =((TakesScreenshot) base.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", scenario.getName());}
       base.getDriver().close();
       base.getDriver().quit();
    }
}
