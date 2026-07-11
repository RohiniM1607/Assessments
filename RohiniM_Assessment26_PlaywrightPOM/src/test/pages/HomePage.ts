import { Locator, Page } from "@playwright/test";
import { BasePage } from "./BasePage";
import "../../resources/utils/env_reader";

export class HomePage extends BasePage {
    readonly page: Page;
    readonly homePageTitle: Locator;
    readonly registerBtn: Locator;
    readonly loginBtn: Locator;

    constructor(page: Page) {
        super(page);
        this.page = page;
        this.homePageTitle = this.page.getByAltText("Tricentis Demo Web Shop");
        this.registerBtn = this.page.getByRole("link", { name: "Register" });
        this.loginBtn = this.page.getByRole("link", { name: "Log in" });
    }

    async navigate() {
        await this.page.goto(process.env.BASE_URL!);
    }

    async clickRegister() {
        await this.clickElement(this.registerBtn);
    }

    async clickLogin() {
        await this.clickElement(this.loginBtn);
    }
}