import{Locator, Page} from "@playwright/test"

export class BasePage{
    constructor(protected page:Page){}

    async clickElement(locator:Locator) {
        await locator.click();
    }

    async fillElement(locator:Locator, value:string) {
        await locator.fill(value);
    }
}