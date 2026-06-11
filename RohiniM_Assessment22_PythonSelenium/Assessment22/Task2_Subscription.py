from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait
import time

driver = webdriver.Chrome()
driver.maximize_window()
wait = WebDriverWait(driver, 10)


driver.get("https://automationexercise.com/")
homePage = driver.find_element(By.XPATH, value="//span[text()='Automation']")
if homePage.is_displayed():
    print("Home page is visibled")
else:
    print("Home page is not visible")


driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
print("Scrolled down")
time.sleep(2)

subscription = wait.until(EC.visibility_of_element_located((By.XPATH, "//h2[text()='Subscription']")))
if subscription.is_displayed():
    print("Subscription' is visible")

arrow_button = wait.until(EC.element_to_be_clickable((By.XPATH, "//i[@class='fa fa-angle-up']")))
arrow_button.click()
print("Scrolled up")
time.sleep(5)

top_text = wait.until(EC.visibility_of_element_located((By.XPATH, "//h2[text()='Full-Fledged practice website for Automation Engineers']")))
if top_text.is_displayed():
    print("Text displayed")

driver.quit()