import {test} from '../Fixtures/BaseFixture';
import {registerData, RegisterUser} from '../Utils/CSVReader'

const users: RegisterUser[] = registerData();
console.log('CSV data: ', users);
const validUser = users.find(user=>user.type==='valid');

test.beforeEach(async({homepage})=>{
    homepage.navigate(process.env.BASE_URL!);
})
test('New User Registration @Smoke', async({homepage, registerpage})=>{
    if(!validUser){
        throw new Error('Valid user not found in loginData.csv');
    }
    await homepage.clickRegister();
    await registerpage.verifyRegisterPage();
    console.log("Register Page Verified")
    await registerpage.enterPersonalDetails(validUser.firstname, validUser.lastname, validUser.email, validUser.telephone);
    await registerpage.enterPasswordDetails(validUser.password, validUser.confirmpassword);
    await registerpage.agreePolicy();
    await registerpage.clickContinueButton();
    await registerpage.verifyAccountCreation();
    console.log("Account creation verified");
})   
