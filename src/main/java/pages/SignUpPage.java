package pages;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;


public class SignUpPage extends HomePage {

    final String  errorIdentificator= "aria-invalid";

    @FindBy(id = "register_account_type_individual_input_cell")
    private WebElementFacade individual;

    @FindBy(id = "register_account_type_education_input_cell")
    private WebElementFacade education;

    @FindBy(id = "country")
    private WebElementFacade country;

    @FindBy(id = "first_name")
    private WebElementFacade firstName;

    @FindBy(id = "last_name")
    private WebElementFacade lastName;

    @FindBy(id = "email")
    private WebElementFacade email;

    @FindBy(id = "__pin_mobile_number_mobile_phone")
    private WebElementFacade mobileNumber;

    @FindBy(id = "__pin_mobile_number_international_dialing_code")
    private WebElementFacade mobileNumberCodeDropDown;

    @FindBy (id = "register_terms_of_use_agree_form_input")
    private WebElementFacade termsOfUse;

    @FindBy (className = "calc_captcha_question")
    private WebElementFacade captchaContainer;

    @FindBy (id = "__calc_captcha_text")
    private WebElementFacade captchaResultInput;

    @FindBy (id = "button_subscribe")
    private WebElementFacade openMyFreeAccountButton;

    @FindBy (id = "register___calc_captcha_text_error")
    private WebElementFacade errorTooltip;

    @FindBy (xpath = "//*[@id='custom_label_field___label_education_linked']/p")
    private WebElementFacade educationLabel;

    @FindBy (xpath = "//*[@id='register_individual_warning_label_form_text_paragraph']/div/p")
    private WebElementFacade individualLabel;

    public void selectCountry(String countryName){

        country.selectByVisibleText(countryName);
    }

    public String calculcateCapthaElements(){
        DoubleEvaluator eval = new DoubleEvaluator();
        Double result = eval.evaluate(captchaContainer.getText().replace("=",""));
        return String.format("%.0f", result);
    }

    public void enterCapchaResult(String value){
        captchaResultInput.sendKeys(value);
    }

    public void selectEducationType(){
        education.click();
    }

    public void selectIndividualType(){
        individual.click();
    }

    public void enterFirstName(String value){
        firstName.sendKeys(value);
    }

    public void enterLasttName(String value){
        lastName.sendKeys(value);
    }

    public void enterEmail(String value){
        email.sendKeys(value);
    }

    public void enterMobilePhoneNumber(String value){
        mobileNumber.sendKeys(value);
    }

    public void selectMobilePhoneCode(String value){
       mobileNumberCodeDropDown.selectByVisibleText(value);
    }

    public void agreeWithTermsOfUse(){
       termsOfUse.waitUntilClickable();
       termsOfUse.click();
    }

    public void clickOpenMyFreeAccountButton(){
        openMyFreeAccountButton.submit();
    }

    public boolean isToolTipDisplayed(String value){
        return errorTooltip.isDisplayed() && errorTooltip.getText().equals(value);
    }

    public String getMobilePhoneInputBorderColor(){
        return mobileNumber.getCssValue("border-top-color");
    }

    public boolean isMobilePhoneInputWithError(){
        return mobileNumber.getAttribute(errorIdentificator).equals("true");
    }

    public boolean isEmailInputWithError(){
        return email.getAttribute(errorIdentificator).equals("true");
    }

    public boolean isFirstNameInputWithError(){
        return firstName.getAttribute(errorIdentificator).equals("true");
    }

    public boolean isLastNameInputWithError(){
        return firstName.getAttribute(errorIdentificator).equals("true");
    }

    public boolean isEducationInputWithError(){
        return education.getAttribute(errorIdentificator).equals("true");
    }

    public String getEducationLabelText(){
        return educationLabel.getText();
    }

    public String getIndividualLabelText(){
        return individualLabel.getText();
    }
}
