import {test as base, expect} from '@playwright/test';
import { HomePage } from '../Pages/HomePage';
import { RegisterPage } from '../Pages/RegisterPage';
import { LoginPage } from '../Pages/LoginPage';
import { ProductPage } from '../Pages/ProductPage';
import { SearchResultPage } from '../Pages/SearchResultPage';

type Fixtures={
    homepage: HomePage;
    registerpage: RegisterPage;
    loginpage: LoginPage;
    productpage: ProductPage;
    searchresultpage: SearchResultPage;
};

export const test = base.extend<Fixtures>({
    homepage: async({page}, use)=>{
        await use(new HomePage(page));
    },
    registerpage: async({page}, user)=>{
        await user(new RegisterPage(page));
    },
    loginpage: async({page}, user)=>{
        await user(new LoginPage(page));
    },
    productpage: async({page}, user)=>{
        await user(new ProductPage(page));
    },
    searchresultpage: async({page}, user)=>{
        await user(new SearchResultPage(page));
    }

})

export{expect};