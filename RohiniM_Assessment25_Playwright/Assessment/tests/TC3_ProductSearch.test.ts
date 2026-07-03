import {test, expect} from '../Fixtures/BaseFixture';

test.beforeEach(async({homepage})=>{
    await homepage.navigate(process.env.BASE_URL!);
})

test("Product Search @Smoke", async({productpage, searchresultpage})=>{
    await productpage.enterProduct("MacBook");
    await productpage.clickSearchButton();
    console.log("Total product count: ", searchresultpage.productCount());
    const productList = await searchresultpage.getProductList();
    console.log(productList);
    expect(productList).toContain("MacBook");
})