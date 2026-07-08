import { BeforeAll, Before, After, AfterAll } from "@cucumber/cucumber";
import { chromium, Browser } from "@playwright/test";
import { cusWorld } from "../../resources/world/customworld";
import "../../resources/utils/env_reader";
import { HomePage } from "../../test/pages/HomePage";
import { LoginPage } from "../pages/LoginPage";
import { RegisterPage } from "../pages/RegisterPage";

let browser: Browser;

BeforeAll(async function () {
    browser = await chromium.launch({headless: false, timeout: 12000, slowMo: 1000});
});

Before(async function (this: cusWorld) {
    this.browser = browser;
    this.context = await browser.newContext();
    this.page = await this.context.newPage();

    this.homepage = new HomePage(this.page);
    this.loginpage = new LoginPage(this.page);
    this.registerpage = new RegisterPage(this.page);
});

After(async function (this: cusWorld, scenario) {
    const screenshot = await this.page.screenshot({
        path: `reports/screenshots/${scenario.pickle.name}.png`,
        type: "png"
    });

    await this.attach(screenshot, "image/png");
    await this.context.close();

});

AfterAll(async function () {
    await browser.close();

});