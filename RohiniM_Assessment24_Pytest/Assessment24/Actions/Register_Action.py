from Actions.Base_Action import base_actions
from Pages.Register_Page import register_page

class register_actions():
    def __init__(self, driver):
        self.base = base_actions(driver)
        self.page = register_page()
        self.driver = driver

    def click_myaccounts(self):
        self.base.click_element(self.page.myaccount_menu)

    def click_register(self):
        self.base.click_element(self.page.register_menu)

    def enter_details(self, firstname, lastname, email, telephone, password, confirmpassword):
        self.base.enter_text(self.page.first_name, firstname)
        self.base.enter_text(self.page.last_name, lastname)
        self.base.enter_text(self.page.email, email)
        self.base.enter_text(self.page.telephone, telephone)
        self.base.enter_text(self.page.password, password)
        self.base.enter_text(self.page.confirm_password, confirmpassword)
        self.base.click_element(self.page.privacy_policy)

    def submit_registration(self):
        self.base.click_element(self.page.submit)

    def verify_success_msg(self):
        if self.base.is_element_present(self.page.success_msg):
            self.driver.save_screenshot("Reports/Registration_Passed.png")
            return True
        return False
    
    def verify_error_msg(self):
        if self.base.is_element_present(self.page.error_msg):
            self.driver.save_screenshot("Reports/Registration_Failed.png")
            return True
        return False
    
    

