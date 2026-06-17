from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
class base_actions():
    def __init__(self, driver):
        self.driver = driver
        self.wait = WebDriverWait(driver, 10)

    def click_element(self, locator):
        self.wait.until(EC.element_to_be_clickable((By.XPATH, locator))).click()

    def enter_text(self, locator, text):
        element = self.wait.until(EC.element_to_be_clickable((By.XPATH, locator)))
        element.clear()
        element.send_keys(text)

    def is_element_present(self, locator):
        try:
            self.wait.until(EC.presence_of_element_located((By.XPATH, locator)))
            return True
        except:
            return False
        
    def get_elements(self, locator):
        return self.wait.until(EC.presence_of_all_elements_located((By.XPATH, locator))
    )
