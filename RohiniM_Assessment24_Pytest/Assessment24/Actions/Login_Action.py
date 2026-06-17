from Actions.Base_Action import base_actions
from Pages.Login_page import login_page

class login_actions():
    def __init__(self, driver):
        self.base = base_actions(driver)
        self.page = login_page
        self.driver = driver

    def click_myaccounts(self):
        self.base.click_element(self.page.myaccount_menu)

    def click_login(self):
        self.base.click_element(self.page.login_menu)

    def enter_credentials(self, emailinput, passwordinput):
        self.base.enter_text(self.page.email, emailinput)
        self.base.enter_text(self.page.password, passwordinput)

    def click_submit(self):
        self.base.click_element(self.page.login_btn)

    def verify_successful_login(self):
        if self.base.is_element_present(self.page.my_account):
            self.driver.save_screenshot("Reports/Login_Success.png")
            return True
        return False


    def verify_error_msg(self):
        if self.base.is_element_present(self.page.error_msg):
            self.driver.save_screenshot("Reports/Login_Failed.png")
            return True
        return False