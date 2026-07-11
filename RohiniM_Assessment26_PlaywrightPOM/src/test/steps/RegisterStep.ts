import { Given, When, Then } from "@cucumber/cucumber";
import { readCSV } from "../../resources/utils/csv_reader";

import { HomePage } from "../pages/HomePage";
import { RegisterPage } from "../pages/RegisterPage";

let homePage: HomePage;
let registerPage: RegisterPage;

const users = readCSV();
const validUser = users.find(user => user.type === "valid");

Given("The user launched the DemoWebShop Application", async function () {
    homePage = new HomePage(this.page);
    registerPage = new RegisterPage(this.page);

    await homePage.navigate();
});

When("The user navigated to the registration page", async function () {
    await homePage.clickRegister();
    await registerPage.verifyRegisterPage();
});

When("The user enters the valid personal details", async function () {
    if (!validUser)
        throw new Error("Valid user not found.");

    await registerPage.enterPersonalDetails(validUser.gender,validUser.firstname,validUser.lastname,validUser.email);

});

When("The user enters the valid password details", async function () {
    if (!validUser)
        throw new Error("Valid user not found.");

    await registerPage.enterPasswordDetails(validUser.password,validUser.confirmpassword);
});

When("The user clicks the Register button", async function () {
    await registerPage.submitRegistration();

});

Then("The user successfully created the account", async function () {
    await registerPage.verifyRegistration();

});