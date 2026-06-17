import pytest
from Utilities import ExcelReader
from Actions.Register_Action import register_actions
from Actions.Login_Action import login_actions
from Actions.Search_Action import search_actions

@pytest.mark.usefixtures("setup_and_teardown")
class Test_Register:
    @pytest.mark.smoke
    @pytest.mark.parametrize("firstname, lastname, email, telephone, password, confirmpassword",ExcelReader.get_data("TestData/TestData.xlsx", "Register"))
    def test_register(self, firstname, lastname, email, telephone, password, confirmpassword):
        action = register_actions(self.driver)
        action.click_myaccounts()
        action.click_register()
        action.enter_details(firstname, lastname, email, telephone, password, confirmpassword)
        action.submit_registration()
        if action.verify_success_msg():
            assert action.verify_success_msg(), "Success message not displayed"
        elif action.verify_error_msg():
            assert action.verify_error_msg(), "Error message not displayed"
        

    @pytest.mark.regression
    @pytest.mark.parametrize("filter_type,email,password", ExcelReader.get_data("TestData/TestData.xlsx", "Login"))
    def test_login(self, filter_type, email, password):
        action = login_actions(self.driver)
        action.click_myaccounts()
        action.click_login()
        action.enter_credentials(email, password)
        action.click_submit()
        if filter_type == "Valid":
            assert action.verify_successful_login(), "Login should be successful"

        else:
            assert action.verify_error_msg(), "Error message should be displayed"

    @pytest.mark.smoke
    def test_search_product(self):
        action = search_actions(self.driver)
        action.search_product("MacBook")
        assert action.verify_product_present("MacBook")