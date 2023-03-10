package com.juaracoding.post24;

import com.juaracoding.post24.drivers.DriverSingleton;
import com.juaracoding.post24.modules.LoginModules;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class TestLogin {
    public static WebDriver driver;
    public static LoginModules lm;

    @BeforeAll
    public static void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        lm = new LoginModules();
    }

    //Scenario 1: User successful login into web HRM
    @Given("^User open browser and url$")
    public void user_open_browser_and_url(){

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("User open browser and url");
    }

    @When("^User enter valid username$")
    public void user_enter_valid_username(){

        lm.enterUsername("Admin");

        System.out.println("User enter valid username");
    }

    @And("^User enter valid password$")
    public void user_enter_valid_password() {

        lm.enterPassword("admin123");

        System.out.println("User enter valid password");
    }

    @And("^User click button login$")
    public void user_click_button_login(){

        lm.buttonLoginClick();

        System.out.println("User click button login");
    }

    @Then("^User go to page Dashboard$")
    public void user_go_to_page_dashboard(){

        Assert.assertEquals(lm.getTxtDashboard(),"Dashboard");
        System.out.println("User go to page Dashboard");
    }
    // End of Scenario 1

    //Scenario 2: User use valid username and invalid password
    @When("^User click button logout$")
    public void user_click_button_logout(){

        lm.logout();
        System.out.println("User click button logout");
    }

    @And("^User enter invalid password$")
    public void user_enter_invalid_password() {

        lm.enterPassword("blablabla");
        System.out.println("User enter invalid password");
    }

    @Then("^User get message invalid credentials$")
    public void user_get_message_invalid_credentials(){
        Assert.assertEquals(lm.getTxtInvalidCredentials(),"Invalid credentials");
        System.out.println("User get invalid credentials message");
    }
    //End of Scenario 2

    //Scenario 3: User use invalid username and valid password
    @When("^User enter invalid username$")
    public void user_enter_invalid_username(){

        lm.enterUsername("MoonMoon");
        System.out.println("User enter invalid username");
    }
    //End of Scenario 3

    //Scenario 4: User use invalid username and password
    @When("^User enter invalid username and password$")
    public void user_enter_invalid_username_and_password(){

        lm.enterUsername("MisterAdmin");
        lm.enterPassword("SupaKicker123");
        System.out.println("User enter invalid username and password");
    }
    //End of Scenario 4

    //Scenario 5: Trying to login with empty username credentials
    @When("^Page is refreshed$")
    public void page_is_refreshed(){
        refreshPage();
    }

    @Then("^User get message required username credentials$")
    public void user_get_message_required_username_credentials(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(lm.getEmptyUsernameError(),"Required");
    }
    //End of Scenario 5

    //Scenario 6: Login with empty password credentials
    @Then("^User get message required password credentials$")
    public void user_get_message_required_password_credentials(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(lm.getEmptyPasswordError(),"Required");
    }
    //End of Scenario 6

    //Scenario 7: Login with empty credentials
    @Then("^User get message required both credentials$")
    public void user_get_message_required_both_credentials(){
        lm.buttonLoginClick();
        Assert.assertEquals(lm.getEmptyUsernameError(),"Required");
        Assert.assertEquals(lm.getEmptyPasswordError(),"Required");
    }
    //End of Scenario 7

    @AfterAll
    public static void quitBrowser(){
        delay(3);
        DriverSingleton.closeObjectInstance();
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }
    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
