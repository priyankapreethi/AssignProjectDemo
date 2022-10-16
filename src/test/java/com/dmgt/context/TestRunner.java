package com.dmgt.context;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Features"},
        glue     = {"com.dmgt"},
        plugin = {"pretty", "html:target/test-reports/report.html"},
        dryRun = false)
public class TestRunner {

}
