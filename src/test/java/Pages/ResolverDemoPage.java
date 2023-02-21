package Pages;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResolverDemoPage {
    public ResolverDemoPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Test1 email log in
    @FindBy(xpath = "//input[@id='inputEmail']")
    public WebElement emailAddresInputBox;

    @FindBy(xpath = "//input[@id='inputPassword']")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;


    // Test2 list of items
    @FindBy(xpath = "//*[@id='test-2-div']/ul/li[2]/span/ancestor:: li")
    public WebElement secondListItem;

    @FindBy(xpath = "(//div[@id='test-2-div']//descendant::li)[2]//span")
    public WebElement seconListBadgeValue;

    public List<WebElement> listItems() {
        return Driver.getDriver().findElements(By.xpath("//div[@id='test-2-div']//descendant::li"));
    }


    //Test 3 element
    @FindBy(xpath = "//button[@id='dropdownMenuButton']")
    public WebElement dropdownBtn;

    public List<WebElement> dropdownListValues() {
        return Driver.getDriver().findElements(By.xpath("//a[@class='dropdown-item']"));
    }


    //Test 4 elements
    @FindBy(xpath = "//div[@id='test-4-div']//button[@class='btn btn-lg btn-primary']")
    public WebElement test4Btn1;

    @FindBy(xpath = "//div[@id='test-4-div']//button[@class='btn btn-lg btn-secondary']")
    public WebElement test4Btn2;


    //Test 5 elements
    @FindBy(xpath = "//button[@id ='test5-button']")
    public WebElement test5Btn;


    @FindBy(xpath = "//div[@id='test5-alert']")
    public WebElement successMessage;



    //Test six

    public static WebElement cellData(int rowNum, int columnNum) {

        WebElement columnData = Driver.getDriver().findElement(By.xpath("//*[@id='test-6-div']/div/table/tbody/tr[" + (rowNum + 1) + "]/td[" + (columnNum + 1) + "]"));

        return columnData;
    }
}
