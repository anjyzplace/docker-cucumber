package steps;

import com.selenium.test.webtestsbase.WebDriverFactory;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class cheese implements En {
    public cheese() {
        Given("^I am on the Google search page$", () -> {
            // Write code here that turns the phrase above into concrete actions
            //System.out.println("When");
        });
        When("^I search for \"([^\"]*)\"$", (String arg0) -> {



            // Write code here that turns the phrase above into concrete actions
            //System.out.println("When");
        });
        Then("^the page title should start with \"([^\"]*)\"$", (String arg0) -> {
            String toSearch = "Selenium";
            WebDriverFactory.getDriver().get("http://www.youtube.com");
            WebElement searchString = WebDriverFactory.getDriver().findElement(By.cssSelector("#masthead-search-term"));
            searchString.sendKeys(toSearch);
            String searchStringText = searchString.getAttribute("value");
            assertTrue("Text from page(" + searchStringText + ") not equals to text from test(" + toSearch + ")",
                    searchStringText.equals(toSearch));
            // Write code here that turns the phrase above into concrete actions
            //System.out.println("When");
        });
    }

    @Before
    public void beforeScenario(){
        WebDriverFactory.startBrowser(true);
        System.out.println("This will run before the actual scenario");
    }

    @After
    public void afterScenario(){
        WebDriverFactory.finishBrowser();
        System.out.println("This will run after scneario is finished, even if it failed");
    }
}
