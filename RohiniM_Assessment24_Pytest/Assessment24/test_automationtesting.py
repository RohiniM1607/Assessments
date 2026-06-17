import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

driver = webdriver.Chrome()
driver.maximize_window()

class TestAutomationTestingShop:
    @pytest.mark.smoke
    def test_price_html5(self):
        driver.get("https://practice.automationtesting.in/shop/")
        driver.find_element(By.XPATH,"//h3[text()='JS Data Structures and Algorithm']").click()
        title = driver.find_element(By.XPATH,"//h1[@itemprop='name']").text

        assert title == "JS Data Structures and Algorithm"
        assert "learning-javascript-data-structures-and-algorithm" in driver.current_url

    @pytest.mark.smoke
    def test_validate_js_book(self):
        driver.get("https://practice.automationtesting.in/shop/")
        driver.find_element(By.XPATH,"//h3[text()='JS Data Structures and Algorithm']").click()
        title = driver.find_element(By.XPATH, "//h1[@itemprop='name']").text
        assert title == "JS Data Structures and Algorithm"
        assert "learning-javascript-data-structures-and-algorithm" in driver.current_url

    @pytest.mark.regression
    def test_book_count(self):
        driver.get("https://practice.automationtesting.in/shop/")
        driver.find_element(By.XPATH,"//a[contains(text(),'HTML')]").click()
        books = driver.find_elements(By.XPATH,"//ul[contains(@class,'products')]/li")
        assert len(books) == 3
    
    @pytest.mark.regression
    def test_sortbyprice(self):
        driver.get("https://practice.automationtesting.in/shop/")
        sortbtn= Select(driver.find_element(By.XPATH,"//select[@name='orderby']"))
        sortbtn.select_by_value("price")
        prices = driver.find_element(By.XPATH,"//span[@class='woocommerce-Price-amount amount']")
        price =  prices.replace("₹", "").strip()
        prices(price)
     
    
    def test_subscribe_btn(self):
        driver.get("https://practice.automationtesting.in/shop/")
        driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
        subscribe = driver.find_element(By.XPATH,"//input[@value='Subscribe']")
        assert subscribe.is_displayed()
    

