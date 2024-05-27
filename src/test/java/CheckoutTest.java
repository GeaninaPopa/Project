
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Listeners(ExtentTestNGITestListener.class)
public class CheckoutTest extends Hooks {

    public CheckoutPage checkoutPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        checkoutPage = new CheckoutPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test(description = " Test the search functionality")
    public void searchTest() {

        checkoutPage.setSearchBar();
        checkoutPage.setSearchButton();
        checkoutPage.getFrozenMouse();
        checkoutPage.getPracticalMouse();
        checkoutPage.clickSearchButtonFail();

    }

    @Test
    public void sortProductsTest() throws InterruptedException {
        checkoutPage.selectOption(checkoutPage.getSortProductsDropDown(), "Sort by price (low to high)");
        Thread.sleep(4000);
    }

    @Test(description = "Calculating the price when changing quantity")
    public void quantityOfAProductTest() {
        checkoutPage.clickAddProductGraniteChipsToCartLink();
        checkoutPage.clickAddProductGraniteChipsToCartButton();
        checkoutPage.clickCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product is:" + checkoutPage.productPrice());
        double expectedTotal = checkoutPage.productPrice() * 2;
        checkoutPage.clickQuantity();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product after updating quantity to 2 is:" + checkoutPage.productPrice());
        assertEquals(checkoutPage.productPrice(), expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The prices match");
    }


    @Test(description = "Calculating the total price whith taxes")
    public void totalPricesWithTaxesTest() {
        checkoutPage.clickAddProductGraniteChipsToCartLink();
        checkoutPage.clickAddProductGraniteChipsToCartButton();
        checkoutPage.clickCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product is:" + checkoutPage.productPrice());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The tax price is:" + checkoutPage.taxPrice());
        double expectedTotal = checkoutPage.productPrice() + checkoutPage.taxPrice();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The total price should be" + expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The total price is" + checkoutPage.totalAmount());
        assertEquals(checkoutPage.totalAmount(), expectedTotal);
    }


    @Test(description = "add a product to cart")
    public void addAProductToCartTest() {
        checkoutPage.setAwesomeGranitChips();
        checkoutPage.clickAddProductGraniteChipsToCartButton();
    }

    @Test(description = "checkout ")
    public void addAOrderTest() {
        checkoutPage.setFirstNameField();
        checkoutPage.setLastNameField();
        checkoutPage.setAddressField();
        checkoutPage.setContinueCheckoutButton();
        checkoutPage.setCompleteYourOrderButton();
        assertEquals(checkoutPage.getThankYouMessage().getText(), "Thank you for your order!");
    }

    @Test(description = "negative checkout ")
    public void negativeAddAOrderTest() {
        checkoutPage.setFirstNameField();
        checkoutPage.setAddressField();
        checkoutPage.setContinueCheckoutButton();
        checkoutPage.setCompleteYourOrderButton();
        assertEquals(checkoutPage.getErrorMessage().getText(), "Last Name is required");

    }

    @Test(description = "negative checkout2")
    public void checkoutWithoutFirstNameTest() {
        checkoutPage.setLastNameField();
        checkoutPage.setAddressField();
        checkoutPage.setContinueCheckoutButton();
        checkoutPage.setCompleteYourOrderButton();
        assertEquals(checkoutPage.getErrorMessage().getText(), "First Name is required");
    }

    @Test(description = "testing checkout without address ")
    public void checkoutWithoutAddress() {
        checkoutPage.setFirstNameField();
        checkoutPage.setLastNameField();
        checkoutPage.setContinueCheckoutButton();
        checkoutPage.setCompleteYourOrderButton();
        assertEquals(checkoutPage.getErrorMessage().getText(), "Address is required");
    }

    @Test
    public void sortProductsTest2() throws InterruptedException {
        checkoutPage.selectOption(checkoutPage.getSortProductsDropDown(), "Sort by name (A to Z)");
        Thread.sleep(4000);
    }

    @Test
    public void sortProductsTest3() throws InterruptedException {
        checkoutPage.selectOption(checkoutPage.getSortProductsDropDown(), "Sort by name (Z to A)");
        Thread.sleep(4000);
    }
    @Test( description = "adding a product to wishlist")
    public void addProductToWishlistTest() throws InterruptedException{
        checkoutPage.getGorgeousSoftPizza();
        checkoutPage.getWishlistButton();
        checkoutPage.getWishlistProduct();
        Thread.sleep(4000);

    }
}