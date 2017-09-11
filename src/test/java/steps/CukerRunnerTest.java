package steps;


import cucumber.api.CucumberOptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;
//import org.junit.runner.RunWith;
//@RunWith(Cucumber.class)


//import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(
        features={"src/test/java/features"},
        plugin = {"pretty"}
)

public class CukerRunnerTest extends AbstractTestNGCucumberTests {}

