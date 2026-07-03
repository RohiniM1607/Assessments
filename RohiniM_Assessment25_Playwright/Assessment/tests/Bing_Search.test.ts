import { test, expect } from "@playwright/test";

test("Bing Search test", async ({ page }) => {
    await page.goto("https://www.bing.com/");
    const title = await page.title();
    console.log("Title:",title);
    const currentUrl = page.url();
    console.log("URL: ",currentUrl);
    await expect(page).toHaveTitle(/Microsoft Bing/);
    await expect(page).toHaveURL("https://www.bing.com/");
    const text = await page.getByRole("link", { name: "Shopping" }).innerText();
    console.log("Inner text: ",text);
    const searchBox = page.locator("#sb_form_q");
    console.log("Id: "+await searchBox.getAttribute("id"));
    console.log("Type: "+await searchBox.getAttribute("type"));
    console.log("Placeholder: "+await searchBox.getAttribute("placeholder"));
    console.log("Class: "+await searchBox.getAttribute("class"));
    await searchBox.fill("playwright");
    await page.keyboard.press("Enter");
    const firstResult = page.locator("//li[@class='b_algo']//h2/a").first();
    await expect(firstResult).toBeVisible();
    await firstResult.click();
    await expect(page).toHaveTitle(/Playwright/i);
    console.log("Final Page Title:", await page.title());
    console.log("Final URL:", page.url());
});