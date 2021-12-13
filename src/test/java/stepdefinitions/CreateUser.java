package stepdefinitions;

import Utils.EmailUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.SignUpPage;
import pages.SubscribeConfirmationPage;

public class CreateUser {

    @Managed
    WebDriver driver;
    @Steps
    SignUpPage signUpPage;
    @Steps
    SubscribeConfirmationPage subscribeConfirmationPage;

    private String userType;

    @When("User selects account type as {string}")
    public void user_selects_account_type_as(String type) {
        switch (type) {
            case "Education":
                signUpPage.selectEducationType();
                break;
            case  "Individual":
                signUpPage.selectIndividualType();
                break;
        }
        this.userType = type;
    }

    @When("Selects country {string}")
    public void selects_country(String country) {
       signUpPage.selectCountry(country);
    }



    @Then("Inputs in field {string} {string}")
    public void inputs_in_filed(String field, String value) {
        switch (field) {
            case "First Name":
                signUpPage.enterFirstName(value);
                break;
            case  "Last Name":
                signUpPage.enterLasttName(value);
                break;
            case  "Email address":
                signUpPage.enterEmail(EmailUtils.generateTestEmail(value));
                break;
        }
    }

    @Then("Selects mobile phone country as {string}")
    public void selects_mobile_phone_country_as(String value) {
        signUpPage.selectMobilePhoneCode(value);
    }

    @Then("Enter mobile phone number {string}")
    public void enter_mobile_phone_number(String value) {
        signUpPage.enterMobilePhoneNumber(value);
    }

    @Then("Agrees with therms of Use and Privacy policy")
    public void agress_with_therms_of_use_and_privacy_poloicy() throws InterruptedException {
        signUpPage.agreeWithTermsOfUse();
    }

    @Then("Enters the captch result")
    public void enters_the_captch_result() {
        String capchaResult = signUpPage.calculcateCapthaElements();
        signUpPage.enterCapchaResult(capchaResult);

    }

    @Then("Selects button Open my free account")
    public void selects_button_open_my_free_account() {
        signUpPage.clickOpenMyFreeAccountButton();
    }

    @Then("Message \"Check your mail\" is displayed")
    public void message_check_your_mail_is_displayed() {
        Assert.assertEquals("Check your mail", subscribeConfirmationPage.getConfirmationMEssageFromRowOne());
    }

    @Then("ToolTip with message {string} is displayed")
    public void tool_tip_with_message_is_displayed(String value) {
            WebElement toolTip = driver.findElement(By.xpath("//*[text()='"+ value+"']"));
            Assert.assertTrue(toolTip.isDisplayed());
           Assert.assertTrue(signUpPage.isToolTipDisplayed(value));

       }

    @Then("All required fields have red border color")
    public void all_required_fields_have_red_border_color() {
        Assert.assertTrue(signUpPage.isMobilePhoneInputWithError());
        Assert.assertTrue(signUpPage.isFirstNameInputWithError());
        Assert.assertTrue(signUpPage.isLastNameInputWithError());
        Assert.assertTrue(signUpPage.isEmailInputWithError());
    }

    @Then("Correct {string} for the given type is displayed")
    public void correct_for_the_given_type_is_displayed(String message) {
        switch (this.userType) {
            case "Education":
                System.out.println(signUpPage.getEducationLabelText());
                Assert.assertEquals(message,signUpPage.getEducationLabelText());
                break;
            case  "Individual":
                System.out.println(signUpPage.getEducationLabelText());
                Assert.assertEquals(message,signUpPage.getIndividualLabelText());
                break;
        }
    }

}
