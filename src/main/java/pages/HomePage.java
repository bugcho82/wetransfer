package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://transfermate.io/")
public class HomePage extends PageObject{

    @Managed(driver = "chrome")
    public WebDriver driver;

    @FindBy (xpath = "//*[@class='btn btn-signup register-popup ml_28617 menu_signup']")
    private WebElement signUpButton;

    @FindBy (id = "cookies-read-more-link")
    private WebElement cookiesInfoButton;

    public void acceptCookies(){
       if (cookiesInfoButton.isDisplayed()) {
            cookiesInfoButton.click();
        }
    }

    public void navigateToSignUpPAge(){
        signUpButton.click();
    }
}
