import {Page, Locator} from '@playwright/test';

export class HomePage{
    readonly page: Page;
    readonly myAccount: Locator;
    readonly register: Locator;
    readonly login: Locator;

    constructor(page: Page){
        this.page = page;
        this.myAccount = page.locator("a[title='My Account']");
        this.register = page.getByRole('link', {name: 'Register'});
        this.login = page.getByRole('link', {name: 'Login'});
    }

    async navigate(url: string){
        await this.page.goto(url);
    }
    
    async clickRegister(){
        await this.myAccount.click();
        await this.register.click();
    }

    async clickLogin(){
        await this.myAccount.click();
        await this.login.click();
    }
}