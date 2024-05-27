import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckoutPage extends BasePage {

    public WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 30);
    }


    @FindBy(id = "input-search")
    private WebElement searchBar;

    public void setSearchBar() {
        searchBar.sendKeys("mouse");
    }

    @FindBy(css = ".btn.btn-light.btn-sm")
    private WebElement searchButton;

    public void setSearchButton() {
        searchButton.click();

    }

    @FindBy(linkText = "Refined Frozen Mouse")
    private WebElement frozenMouse;

    public WebElement getFrozenMouse() {
        return frozenMouse;
    }

    @FindBy(linkText = "Practical Metal Mouse")
    private WebElement practicalMouse;

    public WebElement getPracticalMouse() {
        return practicalMouse;
    }

    @FindBy(css = ".btn.btn-light.btn-sm")
    private WebElement searchButtonFail;

    public void clickSearchButtonFail() {
        searchButtonFail.click();
    }

    @FindBy(css = ".sort-products-select.form-control.form-control-sm")
    private WebElement sortProductsDropDown;

    public WebElement getSortProductsDropDown() {
        return sortProductsDropDown;
    }

    public void selectOption(WebElement element, String option) {
        Select optionSelect = new Select(element);
        optionSelect.selectByVisibleText(option);
    }

    @FindBy(linkText = "Awesome Granite Chips")
    private WebElement addProductGraniteChipsToCartLink;

    public void clickAddProductGraniteChipsToCartLink() {
        addProductGraniteChipsToCartLink.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-3x")
    private WebElement addProductGraniteChipsToCartButton;

    public void clickAddProductGraniteChipsToCartButton() {
        addProductGraniteChipsToCartButton.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18")
    private WebElement cartButton;

    public void clickCartButton() {
        cartButton.click();
    }

    @FindBy(xpath = "(//td[@class='amount'])[1]")
    private WebElement itemsTotal;

    public WebElement getItemsTotal() {
        return itemsTotal;
    }

    public double productPrice() {
        String amountValue = itemsTotal.getText();
        String cleanAmountValue = amountValue.replace("$", "");
        return Double.parseDouble(cleanAmountValue);

    }

    @FindBy(css = ".svg-inline--fa.fa-plus-circle.fa-w-16")
    private WebElement plusQuantity;

    public void clickQuantity() {
        plusQuantity.click();

    }

    @FindBy(xpath = "(//td[@class='amount'])[2]")
    private WebElement taxAmount;

    public double taxPrice() {
        String taxValue = taxAmount.getText();
        String cleanTaxValue = taxValue.replace("$", "");
        return Double.parseDouble(cleanTaxValue);
    }


    @FindBy(xpath = "(//td[@class='amount'])[3]")
    private WebElement totalAmount;

    public double totalAmount() {
        String totalValue = totalAmount.getText();
        String cleanTotalValue = totalValue.replace("$", "");
        return Double.parseDouble(cleanTotalValue);
    }

    @FindBy(css = ".card-link")
    private WebElement awesomeGranitChips;

    public void setAwesomeGranitChips() {
        awesomeGranitChips.click();
    }

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    public void setFirstNameField() {
        firstNameField.sendKeys("");
    }

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    public void setLastNameField() {
        lastNameField.sendKeys("");
    }

    @FindBy(id = "address")
    private WebElement addressField;

    public void setAddressField() {
        addressField.sendKeys();
    }

    @FindBy(css = ".btn.btn-success")
    private WebElement continueCheckoutButton;

    public void setContinueCheckoutButton() {
        continueCheckoutButton.click();
    }

    @FindBy(css = ".btn.btn-success")
    private WebElement completeYourOrderButton;

    public void setCompleteYourOrderButton() {
        completeYourOrderButton.click();
    }

    @FindBy(linkText = "Thank you for your order!")
    private WebElement thankYouMessage;

    public WebElement getThankYouMessage() {
        return thankYouMessage;
    }

    @FindBy(css = ".error")
    private WebElement errorMessage;

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    @FindBy(linkText = "Gorgeous Soft Pizza")
    private WebElement gorgeousSoftPizza;

    public WebElement getGorgeousSoftPizza() {
        return gorgeousSoftPizza;

    }

    @FindBy(css = ".svg-inline--fa fa-heart-broken fa-w-16 fa-2x ")
    private WebElement wishlistButton;

    public WebElement getWishlistButton() {
        return wishlistButton;
    }

    @FindBy(css = ".shopping-cart-icon fa-layers fa-fw ")
    private WebElement wishlistProduct;

    public WebElement getWishlistProduct() {
        return wishlistProduct;
    }
}