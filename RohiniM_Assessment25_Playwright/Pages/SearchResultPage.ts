import {Page, Locator} from '@playwright/test';

export class SearchResultPage{
    readonly page: Page;
    readonly product: Locator;
    readonly productNames: Locator;

    constructor(page: Page){
        this.page = page;
        this.product = page.locator("//div[@class='product-thumb']");
        this.productNames = page.locator("//div[@class='caption']/h4");
    }

    async getProductList():Promise<string[]> {
        return await this.productNames.allTextContents();
    }
}