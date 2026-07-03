import {test} from '../Fixtures/BaseFixture';
import loginData from '../TestData/LoginData.json';

test.describe("Login Test", ()=>{
    test.beforeEach(async({homepage})=>{
        await homepage.navigate(process.env.BASE_URL!);
    })
    test("Valid Login", { tag: "@Regression" }, async ({homepage, loginpage }) => {
        await homepage.clickLogin();
        await loginpage.verifyLoginTitle();
        console.log("Login page visible");
        await loginpage.enterCredentials(loginData.validUser.email, loginData.validUser.password);
        await loginpage.clickLoginButton();
        await loginpage.verifyLoginStatus();
        console.log("Logged In");
    })

    test("Invalid Email", { tag: "@Regression" }, async ({homepage, loginpage }) => {
        await homepage.clickLogin();
        await loginpage.verifyLoginTitle();
        console.log("Login page visible");
        await loginpage.enterCredentials(loginData.invalidEmail.email, loginData.invalidEmail.password);
        await loginpage.clickLoginButton();
        await loginpage.verifyErrorMessage();
        console.log("Error message displayed");
    })

    test("Invalid Password", { tag: "@Regression" }, async ({homepage, loginpage }) => {
        await homepage.clickLogin();
        await loginpage.verifyLoginTitle();
        console.log("Login page visible");
        await loginpage.enterCredentials(loginData.invalidPassword.email, loginData.invalidPassword.password);
        await loginpage.clickLoginButton();
        await loginpage.verifyErrorMessage();
        console.log("Error message displayed");
    })
})