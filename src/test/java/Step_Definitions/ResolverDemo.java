package Step_Definitions;

import Pages.ResolverDemoPage;
import Utilities.BrowserUtil;
import Utilities.ConfigurationReader;
import Utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
public class ResolverDemo {


    ResolverDemoPage demoPage = new ResolverDemoPage();

    @Given("user open the demo url")
    public void user_open_the_demo_url() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }


    @Then("validate that log in fields  are displayed")
    public void validate_that_log_in_fields_are_displayed() {

        //validating the email input boxes are present
        Assert.assertTrue(demoPage.emailAddresInputBox.isDisplayed());
        Assert.assertEquals("Email address", demoPage.emailAddresInputBox.getAttribute("placeholder"));

        Assert.assertTrue(demoPage.passwordInputBox.isDisplayed());
        Assert.assertEquals("Password", demoPage.passwordInputBox.getAttribute("placeholder"));

        Assert.assertTrue(demoPage.signInButton.isDisplayed() && demoPage.signInButton.getText().equals("Sign in"));

    }

    @Then("Enter a value in the fields")
    public void enter_a_value_in_the_fields() {
        demoPage.emailAddresInputBox.sendKeys(ConfigurationReader.getProperty("email"));
        demoPage.passwordInputBox.sendKeys(ConfigurationReader.getProperty("password"));
        demoPage.signInButton.click();
        System.out.println("sign in button clicked successfully");
    }


    @Then("validate the list group items")
    public void validateTheListGroupItems() {

        System.out.println(demoPage.listItems().size());

        //Validating the number of values and the list values in the list group
        Assert.assertEquals(3, demoPage.listItems().size());

        Assert.assertTrue(demoPage.secondListItem.getText().contains("List Item 2"));
        Assert.assertTrue(demoPage.seconListBadgeValue.getText().equals("6"));


    }

    @Then("validates the default value of the dropdown")
    public void validatesTheDefaultValueOfTheDropdown() {
        System.out.println(demoPage.dropdownBtn.getText());
        Assert.assertEquals("Option 1", demoPage.dropdownBtn.getText());
    }

    @Then("Selects the {string} from the select list")
    public void selectsTheFromTheSelectList(String option) {

        demoPage.dropdownBtn.click();
        //selecting the Option 3 from the list
        List<WebElement> dropdownVal = demoPage.dropdownListValues();
        for (WebElement eachValue : dropdownVal) {
            if (eachValue.getText().equals(option)) {
                eachValue.click();
            }
        }
        System.out.println("element clicked ");
    }



    @Then("Validate the status of buttons")
    public void validateTheStatusOfButtons() {

        //validating the status of buttons
        Assert.assertTrue(demoPage.test4Btn1.isEnabled());
        Assert.assertFalse(demoPage.test4Btn2.isEnabled());
    }

    @Then("Validate that button is displayed")
    public void validateThatButtonIsDisplayed() {

        BrowserUtil.scrollDown();
        BrowserUtil.waitForVisibility(demoPage.test5Btn, 10);
        demoPage.test5Btn.click();

        //validating the button is displayed
        Assert.assertTrue(BrowserUtil.isDisplayed(demoPage.successMessage));
        Assert.assertEquals("You clicked a button!", demoPage.successMessage.getText());
        System.out.println("Test 5  successMessage: " + demoPage.successMessage.getText());

        //validating the button is disabled
        Assert.assertFalse(demoPage.test5Btn.isEnabled());

    }

    @Then("Validate the cell data")
    public void validateTheCellData() {

        BrowserUtil.scrollDown();

        System.out.println(demoPage.cellData(2, 2).getText());

        //validating the cell at coordinate 2,2 using the method cellData
        Assert.assertEquals("Ventosanzap", demoPage.cellData(2, 2).getText());

    }

}
