package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class SubscribeConfirmationPage extends HomePage {

    @FindBy (xpath = "//*[@classname='font-weight-normal mb-3']")
    private WebElement confirmationMessageFirstRow;

    public String getConfirmationMEssageFromRowOne(){
        return confirmationMessageFirstRow.getText();
    }
}
