import { expect, Locator, Page } from "@playwright/test";
import { BasePage } from "./BasePage";

export class LoginPage extends BasePage {
    readonly email: Locator;
    readonly password: Locator;
    readonly loginBtn: Locator;
    readonly logoutLink: Locator;
    readonly errorMessage: Locator;

    constructor(page: Page) {
        super(page);
        this.email = page.locator("#Email");
        this.password = page.locator("#Password");
        this.loginBtn = page.locator("//input[@value='Log in']");
        this.logoutLink = page.getByRole("link", { name: "Log out" });
        this.errorMessage = page.locator(".validation-summary-errors");
    }

    async enterLoginDetails(email: string, password: string) {
        await this.fillElement(this.email, email);
        await this.fillElement(this.password, password);
    }

    async clickLoginButton() {
        await this.clickElement(this.loginBtn);
    }

    async verifySuccessfulLogin() {
        await expect(this.logoutLink).toBeVisible();
    }

    async verifyFailedLogin() {
        await expect(this.errorMessage).toContainText("Login was unsuccessful");
    }
}