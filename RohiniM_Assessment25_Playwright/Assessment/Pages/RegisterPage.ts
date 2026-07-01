import {Page, Locator, expect} from '@playwright/test';

export class RegisterPage{
    readonly page: Page;
    readonly registerPageTitle: Locator;
    readonly firstName: Locator;
    readonly lastName: Locator;
    readonly email: Locator;
    readonly telephone: Locator;
    readonly password: Locator;
    readonly confirmPassword: Locator;
    readonly privacyPolicy: Locator;
    readonly continueButton: Locator;
    readonly accountCreated: Locator;

    constructor(page: Page){
        this.page = page;
        this.registerPageTitle = page.getByRole('heading', {name: 'Register Account'});
        this.firstName = page.locator("input#input-firstname");
        this.lastName = page.locator("input#input-lastname");
        this.email = page.getByPlaceholder("E-Mail");
        this.telephone = page.getByPlaceholder("Telephone");
        this.password = page.locator("input#input-password");
        this.confirmPassword = page.locator("input#input-confirm");
        this.privacyPolicy = page.locator("//input[@name='agree']");
        this.continueButton = page.locator("//input[@type='submit']");
        this.accountCreated = page.getByText('Your Account Has Been Created!')
    }

    async verifyRegisterPage(){
        await expect(this.registerPageTitle).toBeVisible();
    }

    async enterPersonalDetails(f_name: string, l_name: string, e_mail: string, tele: string,){
        await this.firstName.fill(f_name);
        await this.lastName.fill(l_name);
        await this.email.fill(e_mail);
        await this.telephone.fill(tele);
    }

    async enterPasswordDetails(pass: string, confirm_pass: string){
        await this.password.fill(pass);
        await this.confirmPassword.fill(confirm_pass);
    }

    async agreePolicy(){
        await this.privacyPolicy.check();
    }

    async clickContinueButton(){
        await this.continueButton.click()
    }

    async verifyAccountCreation(){
        await expect(this.accountCreated).toBeVisible({timeout: 50000});
    }
}