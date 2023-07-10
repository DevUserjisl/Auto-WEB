package com.bdd.runner;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {},
        features = {"src/test/resources/features"},
        stepNotifications = true,
        glue = {"com/bdd/web/stepdefinitions"},
        tags = "@PruebaJSExec"
)

public class RunnerTest {
    @BeforeClass
    public static void beforeExecution(){
    }

    @AfterClass
    public static void afterExecution(){
    }

}
