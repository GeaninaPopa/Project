
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

    @Test(description = "CHECKOUT TEST")
    public void checkoutTest() throws InterruptedException {

    }

    @Test(description = "searching keywords")
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
        ExtentTestNGITestListener.getTest().log(Status.INFO,"The total price is"+ checkoutPage.totalAmount());
        assertEquals(checkoutPage.totalAmount(), expectedTotal);
    }



}
