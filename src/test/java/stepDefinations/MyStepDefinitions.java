package stepDefinations;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObject.LoginPage;
import pageObject.landingPage;
import resources.base;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class MyStepDefinitions extends base {

    @Given("^Initalize the browser with chrome browser$")
    public void initalize_the_browser_with_chrome_browser() throws Throwable {
    	driver=initializedriver();
		
    }
    @And("^Navigate to \"([^\"]*)\" Site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
    	driver.get(strArg1);
    }

    @And("^click on Login link in home page$")
    public void click_on_login_link_in_home_page() throws Throwable {
landingPage pj=new landingPage(driver);
		
		pj.sign().click();
    }

    @When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
LoginPage lg=new LoginPage(driver);
		
		lg.email().sendKeys(username);
		lg.password().sendKeys(password);
		lg.login().click();
    }

    @Then("^Verify that user is successfully logged in$")
    public void verify_that_user_is_successfully_logged_in() throws Throwable {
    
    	System.out.println("Successfully Login");
    }
    @And("^close browser$")
    public void close_browser() throws Throwable {
    	driver.close();
    }

}