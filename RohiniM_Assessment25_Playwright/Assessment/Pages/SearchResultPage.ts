import {Page, Locator, expect} from '@playwright/test';

export class SearchResultPage{
    readonly page: Page;
    readonly product: Locator;

    constructor(page: Page){
        this.page = page;
        this.product = page.locator("//div[@class='product-thumb']");
    }

    async productCount(){
        return this.product.count();
    }
}