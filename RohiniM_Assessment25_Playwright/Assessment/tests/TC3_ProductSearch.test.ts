import {test, expect} from '../Fixtures/BaseFixture';

test.beforeEach(async({homepage})=>{
    await homepage.navigate(process.env.BASE_URL!);
})

test("Product Search @Smoke", async({productpage, searchresultpage})=>{
    await productpage.enterProduct("MacBook");
    await productpage.clickSearchButton();
    const productList = await searchresultpage.getProductList();
    console.log("Total product count: ", productList.length);
    console.log(productList);
    expect(productList).toContain("MacBook");
})