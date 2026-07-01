from Actions.Base_Action import base_actions
from Pages.Search_Page import search_page
import time

class search_actions():

    def __init__(self, driver):
        self.base = base_actions(driver)
        self.page = search_page
        self.driver = driver

    def search_product(self, product_name):
        self.base.enter_text(self.page.search_box, product_name)
        self.base.click_element(self.page.search_btn)

    def get_products(self):
        elements = self.base.get_elements(self.page.product_list)
        return [element.text for element in elements]

    def verify_product_present(self, product_name):
        products = self.get_products()
        for product in products:
            if product_name.lower() in product.lower():
                return True

        return False