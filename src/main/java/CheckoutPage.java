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

    @FindBy(css = "option[value'lh']")
    private WebElement optionLH;

    public WebElement getOptionLH() {
        return optionLH;
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
        firstNameField.sendKeys("Geanina");
    }

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    public void setLastNameField() {
        lastNameField.sendKeys("Popa");
    }

    @FindBy(id = "address")
    private WebElement addressField;

    public void setAddressField() {
        addressField.sendKeys("");
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

    public void getGorgeousSoftPizza() {
       gorgeousSoftPizza.click();

    }

    @FindBy(css = ".btn.btn-link")
    private WebElement wishlistButton;

    public void getWishlistButton() {

        wishlistButton.click();
    }

    @FindBy(css = ".fade.modal.show")
    private WebElement wishlistProduct;

    public void getWishlistProduct() {
        wishlistProduct.click();
    }

    @FindBy(css = "option[value='az']")
    private WebElement optionAZ;

    public WebElement getOptionAZ() {
        return optionAZ;
    }

    @FindBy(css = ".text-muted")
    private WebElement yourCart;

    public WebElement getYourCart() {
        return yourCart;
    }

    @FindBy(css = "option[value='za']")
    private WebElement optionZA;

    public WebElement getOptionZA() {
        return optionZA;
    }

    @FindBy(css = ".svg-inline--fa.fa-trash.fa-w-14")
    private WebElement deleteButton;

    public void getDeleteButton() {
       deleteButton.click();
    }
    @FindBy(css = ".text-center.container")
    private WebElement cartMessage;

    public WebElement getCartMessage() {
        return cartMessage;
    }

    @FindBy(css = ".fa-layers-counter.shopping_cart_badge")
    private WebElement wishlistIcon;

    public void setWishlistIcon(){
        wishlistIcon.click();
    }
    @FindBy(css = ".fade.modal.show")
    private WebElement resetButton;

    public void setResetButton(){
        resetButton.click();
    }
    @FindBy(css = "option[value='liho']")
    private WebElement optionLHO;

    public WebElement getOptionLHO() {
        return optionLHO;
    }
}

