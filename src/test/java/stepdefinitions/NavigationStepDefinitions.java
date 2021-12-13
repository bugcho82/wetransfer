package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.HomePage;

public class NavigationStepDefinitions {

    HomePage homePage;

    @Given("Sign up now page is loaded")
    public void sign_up_now_page_is_loaded() {
        homePage.open();
        homePage.acceptCookies();
        homePage.navigateToSignUpPAge();
    }
}
