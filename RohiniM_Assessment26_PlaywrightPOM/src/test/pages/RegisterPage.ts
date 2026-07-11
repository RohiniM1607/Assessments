import { expect, Locator, Page } from "@playwright/test";
import { BasePage } from "./BasePage";

export class RegisterPage extends BasePage {

    readonly page: Page;
    readonly registerPageTitle: Locator;

    readonly gender_male: Locator;
    readonly gender_female: Locator;
    readonly firstname: Locator;
    readonly lastname: Locator;
    readonly email: Locator;

    readonly password: Locator;
    readonly confirmPassword: Locator;

    readonly registerBtn: Locator;
    readonly registerSuccess: Locator;

    constructor(page: Page) {
        super(page);
        this.page = page;
        this.registerPageTitle = page.getByRole("heading", { name: "Register" });
        this.gender_male = page.locator("#gender-male");
        this.gender_female = page.locator("#gender-female");
        this.firstname = page.locator("#FirstName");
        this.lastname = page.locator("#LastName");
        this.email = page.locator("#Email");
        this.password = page.locator("#Password");
        this.confirmPassword = page.locator("#ConfirmPassword");
        this.registerBtn = page.locator("#register-button");
        this.registerSuccess = page.locator(".result");
    }

    async verifyRegisterPage() {
        await expect(this.registerPageTitle).toBeVisible({timeout: 10000});
    }

    async enterPersonalDetails(gender: string,fname: string,lname: string,email: string) {
        if (gender.toLowerCase() === "male") {
            await this.gender_male.check();
        } 
        else {
            await this.gender_female.check();
        }

        await this.fillElement(this.firstname, fname);
        await this.fillElement(this.lastname, lname);
        await this.fillElement(this.email, email);
    }

    async enterPasswordDetails(password: string, confirmPassword: string) {
        await this.fillElement(this.password, password);
        await this.fillElement(this.confirmPassword, confirmPassword);
    }

    async submitRegistration() {
        await this.clickElement(this.registerBtn);
    }

    async verifyRegistration() {
        await expect(this.registerSuccess).toContainText("Your registration completed");
    }

}