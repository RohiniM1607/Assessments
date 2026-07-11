import {Page, Locator} from '@playwright/test';

export class ProductPage{
    readonly page: Page;
    readonly searchBox: Locator;
    readonly searchBtn: Locator;

    constructor(page: Page){
        this.page = page;
        this.searchBox = page.getByPlaceholder("Search");
        this.searchBtn = page.locator("button.btn.btn-default.btn-lg");
    }

    async enterProduct(product: string){
        await this.searchBox.fill(product);
    }

    async clickSearchButton(){
        await this.searchBtn.click();
    }
}