import { Given, When, Then } from "@cucumber/cucumber";
import { HomePage } from "../pages/HomePage";
import { LoginPage } from "../pages/LoginPage";

let homePage: HomePage;
let loginPage: LoginPage;

Given("The user navigated to the Login page", async function () {
    homePage = new HomePage(this.page);
    loginPage = new LoginPage(this.page);
    await homePage.clickLogin();
});

When("The user enters {string} and {string}", async function (email: string, password: string) {
    await loginPage.enterLoginDetails(email, password);
});

When("The user clicks the Login button", async function () {
    await loginPage.clickLoginButton();
});

Then("The user should see {string}", async function (result: string) {
    if (result === "success") {
        await loginPage.verifySuccessfulLogin();
    } 
    else {
        await loginPage.verifyFailedLogin();
    }
});