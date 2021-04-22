package pages;

import cores.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class ContactInfoPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[@class=\"button-bar\"]/a")
    private WebElement newContactInfoBtn;

    @FindBy(how = How.NAME, using = "preContactMechTypeId")
    private WebElement preContactMechTypeId;

    @FindBy(how = How.ID, using = "field_id__2")
    private WebElement createBtn;

    @FindBy(how = How.XPATH, using = "//label[@for=\"field_id__1\"]")
    private WebElement contactPurposesLabel;

    @FindBy(how = How.ID, using = "field_id__1")
    private WebElement contactPurposes;

    @FindBy(how = How.XPATH, using = "//label[@for=\"field_id__2\"]")
    private WebElement toNameLabel;

    @FindBy(how = How.ID, using = "field_id__2")
    private WebElement toName;

    @FindBy(how = How.XPATH, using = "//label[@for=\"field_id__3\"]")
    private WebElement attentionNameLabel;

    @FindBy(how = How.ID, using = "field_id__3")
    private WebElement attentionName;

    @FindBy(how = How.XPATH, using = "//label[@for=\"field_id__4\"]")
    private WebElement addressLine1Label;

    @FindBy(how = How.ID, using = "field_id__4")
    private WebElement addressLine1;

    @FindBy(how = How.XPATH, using = "//label[@for=\"field_id__5\"]")
    private WebElement addressLine2Label;

    @FindBy(how = How.ID, using = "field_id__5")
    private WebElement addressLine2;

    @FindBy(how = How.XPATH, using = "//label[@for=\"field_id__6\"]")
    private WebElement cityLabel;

    @FindBy(how = How.ID, using = "field_id__6")
    private WebElement city;

    @FindBy(how = How.XPATH, using = "//label[@for=\"editcontactmechform_stateProvinceGeoId\"]")
    private WebElement stateProvinceLabel;

    @FindBy(how = How.ID, using = "editcontactmechform_stateProvinceGeoId")
    private WebElement stateProvince;

    @FindBy(how = How.XPATH, using = "//label[@for=\"field_id__8\"]")
    private WebElement zipPostalCodeLabel;

    @FindBy(how = How.ID, using = "field_id__8")
    private WebElement zipPostalCode;

    @FindBy(how = How.XPATH, using = "//label[@for=\"editcontactmechform_countryGeoId\"]")
    private WebElement countryLabel;

    @FindBy(how = How.ID, using = "editcontactmechform_countryGeoId")
    private WebElement country;

    @FindBy(how = How.ID, using = "field_id__10")
    private WebElement saveBtn;

    @FindBy(how = How.XPATH, using = "//div[@class=\"alert alert-info\"]//li")
    private WebElement messageCreate;

    public ContactInfoPage(RemoteWebDriver driver) {
        super(driver);
    }


    public void clickCreateNew() {
        newContactInfoBtn.click();
    }

    public void selectTypeContact(String typeContact) {
        Select select = new Select(preContactMechTypeId);
        select.selectByVisibleText(typeContact);
    }

    public void clickCreateBtn() {
        createBtn.click();
    }

    public boolean verifyAfterClickNew() {
        return preContactMechTypeId.isDisplayed() &&
                createBtn.isDisplayed();
    }

    public boolean verifyAfterClickCreate(String contactPurposesLbl, String toNameLbl, String attentionNameLbl,
                                          String addressLine1Lbl, String addressLine2Lbl, String cityLbl,
                                          String stateLbl, String zipCodeLbl, String countryLbl) {
        return contactPurposesLbl.equals(contactPurposesLabel.getText().trim()) &&
                toNameLbl.equals(toNameLabel.getText().trim()) &&
                attentionNameLbl.equals(attentionNameLabel.getText().trim()) &&
                addressLine1Lbl.equals(addressLine1Label.getText().trim()) &&
                addressLine2Lbl.equals(addressLine2Label.getText().trim()) &&
                cityLbl.equals(cityLabel.getText().trim()) &&
                stateLbl.equals(stateProvinceLabel.getText().trim()) &&
                zipCodeLbl.equals(zipPostalCodeLabel.getText().trim()) &&
                countryLbl.equals(countryLabel.getText().trim());
    }

    public void createNewContactInfo(String contactPurposesInp, String toNameInp, String attentionNameInp,
                                     String addressLine1Inp, String addressLine2Inp, String cityInp,
                                     String stateInp, String zipCodeInp, String countryInp) {
        Select select = new Select(contactPurposes);
        select.selectByVisibleText(contactPurposesInp);
        toName.sendKeys(toNameInp);
        attentionName.sendKeys(attentionNameInp);
        addressLine1.sendKeys(addressLine1Inp);
        addressLine2.sendKeys(addressLine2Inp);
        city.sendKeys(cityInp);

        select = new Select(country);
        if (!"".equals(countryInp)) {
            select.selectByVisibleText(countryInp);
        }

        select = new Select(stateProvince);
        if (!"".equals(stateInp)) {
            select.selectByVisibleText(stateInp);
        }
        zipPostalCode.sendKeys(zipCodeInp);

        saveBtn.click();
    }

    public boolean verifyCreateSuccess() {
        return messageCreate.getText().contains("Contact Mechanism successfully created.");
    }
}
