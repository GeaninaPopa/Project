
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
   assertEquals("Refined Frozen Mouse",checkoutPage.getFrozenMouse().getText());

    }

    @Test
    public void sortProductsTest() throws InterruptedException {
        checkoutPage.selectOption(checkoutPage.getSortProductsDropDown(), "Sort by price (low to high)");
      assertEquals(checkoutPage.getOptionLHO().getText(),"Sort by price (low to high)");
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
        checkoutPage.clickCartButton();

    }

    @Test(description = "checkout ")
    public void addAOrderTest() {
        checkoutPage.setAwesomeGranitChips();
        checkoutPage.clickAddProductGraniteChipsToCartButton();
        checkoutPage.clickCartButton();
        checkoutPage.setContinueCheckoutButton();
        checkoutPage.setFirstNameField();
        checkoutPage.setLastNameField();
        checkoutPage.setAddressField();
        checkoutPage.setContinueCheckoutButton();
        checkoutPage.setCompleteYourOrderButton();
        assertEquals(checkoutPage.getThankYouMessage().getText(), "Thank you for your order!");
    }

    @Test(description = "testing reset button")
    public void resetButtonTest() throws InterruptedException {
        checkoutPage.setAwesomeGranitChips();
        checkoutPage.getWishlistButton();
        checkoutPage.setResetButton();

    }
    @Test(description = "negative checkout ")
    public void negativeAddAOrderTest() {
        checkoutPage.setAwesomeGranitChips();
        checkoutPage.clickAddProductGraniteChipsToCartButton();
        checkoutPage.clickCartButton();
        checkoutPage.setContinueCheckoutButton();
        checkoutPage.setFirstNameField();
        checkoutPage.setAddressField();
        checkoutPage.setContinueCheckoutButton();
        checkoutPage.setCompleteYourOrderButton();
       assertEquals("Last Name is required", checkoutPage.getErrorMessage().getText());

    }

    @Test(description = "negative checkout2")
    public void checkoutWithoutFirstNameTest() {
        checkoutPage.setAwesomeGranitChips();
        checkoutPage.clickAddProductGraniteChipsToCartButton();
        checkoutPage.clickCartButton();
        checkoutPage.setContinueCheckoutButton();
        checkoutPage.setLastNameField();
        checkoutPage.setAddressField();
        checkoutPage.setContinueCheckoutButton();
        checkoutPage.setCompleteYourOrderButton();
        assertEquals(checkoutPage.getErrorMessage().getText(), "First Name is required");
    }

    @Test(description = "testing checkout without address ")
    public void checkoutWithoutAddress() {
        checkoutPage.setAwesomeGranitChips();
        checkoutPage.clickAddProductGraniteChipsToCartButton();
        checkoutPage.clickCartButton();
        checkoutPage.setContinueCheckoutButton();
        checkoutPage.setFirstNameField();
        checkoutPage.setLastNameField();
        checkoutPage.setContinueCheckoutButton();
        checkoutPage.setCompleteYourOrderButton();
        assertEquals(checkoutPage.getErrorMessage().getText(), "Address is required");
    }

    @Test
    public void sortProductsTest2() throws InterruptedException {
        checkoutPage.selectOption(checkoutPage.getSortProductsDropDown(), "Sort by name (A to Z)");
        assertEquals("Sort by name (A to Z)", checkoutPage.getOptionAZ().getText());
    }

    @Test
    public void sortProductsTest3() throws InterruptedException {
        checkoutPage.selectOption(checkoutPage.getSortProductsDropDown(), "Sort by name (Z to A)");
        assertEquals(checkoutPage.getOptionZA().getText(), "Sort by name (Z to A)");
    }

    @Test(description = "adding a product to wishlist")
    public void addProductToWishlistTest() throws InterruptedException {
        checkoutPage.getGorgeousSoftPizza();
        checkoutPage.getWishlistButton();
        checkoutPage.getWishlistProduct();

    }

    @Test(description = "delete a product to cart")
    public void deleteProductToCart() {
        checkoutPage.setAwesomeGranitChips();
        checkoutPage.clickAddProductGraniteChipsToCartButton();
        checkoutPage.clickCartButton();
        checkoutPage.getDeleteButton();
        assertEquals(checkoutPage.getCartMessage().getText(), "How about adding some products in your cart?");

    }
    @Test(description = "testing checkout without completing any fields ")
    public void checkoutIncompleteTest() {
        checkoutPage.setAwesomeGranitChips();
        checkoutPage.clickAddProductGraniteChipsToCartButton();
        checkoutPage.clickCartButton();
        checkoutPage.setContinueCheckoutButton();
        checkoutPage.setContinueCheckoutButton();
        checkoutPage.setCompleteYourOrderButton();
        assertEquals(checkoutPage.getErrorMessage().getText(), "First Name is required");
    }


}