import {Page, Locator, expect} from '@playwright/test';

export class LoginPage{
    readonly page: Page;
    readonly loginPageTitle: Locator;
    readonly email: Locator;
    readonly password: Locator;
    readonly loginButton: Locator;
    readonly loggedIn: Locator;
    readonly invalidCredential: Locator;

    constructor(page: Page){
        this.page = page;
        this.loginPageTitle = page.getByRole('heading', {name: 'Returning Customer'});
        this.email = page.locator("input#input-email");
        this.password = page.locator("input#input-password");
        this.loginButton = page.locator("//input[@type='submit']");
        this.loggedIn = page.locator("//h2[text()='My Account']");
        this.invalidCredential = page.locator("//div[@class='alert alert-danger alert-dismissible']");
    }

    async verifyLoginTitle(){
        await expect(this.loginPageTitle).toBeVisible();
    }

    async enterCredentials(E_Mail: string, Password: string){
        await this.email.fill(E_Mail);
        await this.password.fill(Password);
    }

    async clickLoginButton(){
        await this.loginButton.click();
    }

    async verifyLoginStatus(){
        await expect(this.loggedIn).toBeVisible({timeout: 50000});
    }

    async verifyErrorMessage(){
        await expect(this.invalidCredential).toBeVisible();
    }
}