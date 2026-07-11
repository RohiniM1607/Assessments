
import { Browser, BrowserContext, Page } from "@playwright/test";
import { setWorldConstructor, World } from "@cucumber/cucumber";
import { HomePage } from "../../test/pages/HomePage";
import { LoginPage } from "../../test/pages/LoginPage";
import { RegisterPage } from './../../test/pages/RegisterPage';

export class cusWorld extends World {

    browser!: Browser;
    context!: BrowserContext;
    page!: Page;

    homepage!: HomePage;
    loginpage!: LoginPage;
    registerpage!: RegisterPage;
}

setWorldConstructor(cusWorld);