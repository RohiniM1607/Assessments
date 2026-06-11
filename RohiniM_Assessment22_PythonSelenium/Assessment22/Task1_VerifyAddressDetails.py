from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver import ActionChains

driver = webdriver.Chrome()
driver.maximize_window()
wait = WebDriverWait(driver, 10)
actions = ActionChains(driver)

driver.get("https://automationexercise.com/")
homePage = driver.find_element(By.XPATH, value="//span[text()='Automation']")
if homePage.is_displayed():
    print("Home page is visibled")
else:
    print("Home page is not visible")

driver.find_element(By.XPATH, value="//a[text()=' Signup / Login']").click()


newUser = wait.until(EC.visibility_of_element_located((By.XPATH, "//h2[text()='New User Signup!']")))
print("New User Sign-up is visible")

driver.find_element(By.XPATH, value="//input[@name='name']").send_keys("Demo")
driver.find_element(By.XPATH, value="(//input[@name='email'])[2]").send_keys("demo.1@gmail.com")
driver.find_element(By.XPATH, value="//button[@data-qa='signup-button']").click()

try:
    account_info = wait.until(EC.visibility_of_element_located((By.XPATH, "//b[text()='Enter Account Information']")))
    assert account_info.text == "ENTER ACCOUNT INFORMATION"
    print("Account Information page displayed")

except:
    email_exist = wait.until(EC.visibility_of_element_located((By.XPATH, "//p[text()='Email Address already exist!']")))
    assert email_exist.text == "Email Address already exist!"
    print("Email already exists")
    driver.quit()

title = "Mrs"
first_name = "Demo"
last_name = "1"
company = "SmartCliff"
address1 = "Thilagar Street"
address2 = "R.S Puram"
country = "India"
state = "Tamil Nadu"
city = "Coimbatore"
zipcode = "689 543"
mobile = "9876543210"

driver.find_element(By.XPATH, value="//input[@id='id_gender2']").click()
driver.find_element(By.XPATH, value="//input[@type='password']").send_keys("Demo123")


day = Select(driver.find_element(By.ID, "days"))
day.select_by_visible_text("3")
month = Select(driver.find_element(By.ID, "months"))
month.select_by_visible_text("April")
year = Select(driver.find_element(By.ID, "years"))
year.select_by_visible_text("2015")


driver.find_element(By.XPATH, value="(//input[@type='checkbox'])[1]").click()
driver.find_element(By.XPATH, value="(//input[@type='checkbox'])[2]").click()

driver.find_element(By.XPATH, value="//input[@id='first_name']").send_keys(first_name)
driver.find_element(By.XPATH, value="//input[@id='last_name']").send_keys(last_name)
driver.find_element(By.XPATH, value="//input[@id='company']").send_keys(company)
driver.find_element(By.XPATH, value="//input[@id='address1']").send_keys(address1)
driver.find_element(By.XPATH, value="//input[@id='address2']").send_keys(address2)
Select(driver.find_element(By.ID, "country")).select_by_visible_text(country)
driver.find_element(By.XPATH, value="//input[@id='state']").send_keys(state)
driver.find_element(By.XPATH, value="//input[@id='city']").send_keys(city)
driver.find_element(By.XPATH, value="//input[@id='zipcode']").send_keys(zipcode)
driver.find_element(By.XPATH, value="//input[@id='mobile_number']").send_keys(mobile)
driver.find_element(By.XPATH, value="(//button[@type='submit'])[1]").click()


account_created = wait.until(EC.visibility_of_element_located((By.XPATH, "//b[text()='Account Created!']")))
assert account_created.is_displayed()
print("Account created successfully")

driver.find_element(By.CLASS_NAME, "btn-primary").click()

User = wait.until(EC.visibility_of_element_located((By.CLASS_NAME, "fa-user")))
welcomeUser = driver.find_element(By.XPATH, "//a[contains(text(),'Logged in as')]").text
assert "Demo" in welcomeUser, "Incorrect user logged in"
print("User verified successfully")

product = driver.find_element(By.XPATH,"//a[text()=' Products']")
actions.click(product).perform()

product1 = driver.find_element(By.XPATH, "(//a[text()='Add to cart'])[3]")
actions.move_to_element(product1).perform()
print("Moved to the product")
actions.click(driver.find_element(By.XPATH, "(//a[text()='Add to cart'])[3]")).perform()
print("Clicked on add to cart")

cart_page = wait.until(EC.visibility_of_element_located(By.XPATH, "//li[@class='active']"))
assert cart_page == "Shopping cart"
print("Cart Page is visible")

driver.find_element(By.CLASS_NAME, "btn btn-default check_out").click()

delivery_name = driver.find_element(By.XPATH, "//ul[@id='address_delivery']/li[@class='address_firstname address_lastname']").text
delivery_company = driver.find_element(By.XPATH,"//ul[@id='address_delivery']/li[@class='address_address1 address_address2'][1]").text
delivery_address1 = driver.find_element(By.XPATH,"(//ul[@id='address_delivery']/li[@class='address_address1'])[2]").text
delivery_address2 = driver.find_element(By.XPATH,"(//ul[@id='address_delivery']/li[@class='address_address1'])[3]").text
delivery_country = driver.find_element(By.XPATH,"//ul[@id='address_delivery']/li[@class='address_country_name']").text
delivery_state_city_zip = driver.find_element(By.XPATH,"//ul[@id='address_delivery']/li[@class='address_city address_state_name address_postcode']").text
delivery_mobile = driver.find_element(By.XPATH,"//ul[@id='address_delivery']/li[@class='address_phone']").text

assert delivery_name == f"{title} {first_name} {last_name}"
assert delivery_company == company
assert delivery_address1 == address1
assert delivery_address2 == address2
assert delivery_country == country
assert state in delivery_state_city_zip
assert city in delivery_state_city_zip
assert zipcode in delivery_state_city_zip
assert delivery_mobile == mobile
print("Delivery address verified successfully")

billing_name = driver.find_element(By.XPATH, "//ul[@id='address_invoice']/li[@class='address_firstname address_lastname']").text
billing_company = driver.find_element(By.XPATH,"//ul[@id='address_invoice']/li[@class='address_address1 address_address2'][1]").text
billing_address1 = driver.find_element(By.XPATH,"(//ul[@id='address_invoice']/li[@class='address_address1'])[2]").text
billing_address2 = driver.find_element(By.XPATH,"(//ul[@id='address_invoice']/li[@class='address_address1'])[3]").text
billing_country = driver.find_element(By.XPATH,"//ul[@id='address_invoice']/li[@class='address_country_name']").text
billing_state_city_zip = driver.find_element(By.XPATH,"//ul[@id='address_invoice']/li[@class='address_city address_state_name address_postcode']").text
billing_mobile = driver.find_element(By.XPATH,"//ul[@id='address_invoice']/li[@class='address_phone']").text

assert billing_name == f"{title} {first_name} {last_name}"
assert billing_company == company
assert billing_address1 == address1
assert billing_address2 == address2
assert billing_country == country
assert state in billing_state_city_zip
assert city in billing_state_city_zip
assert zipcode in billing_state_city_zip
assert billing_mobile == mobile
print("Billing address verified successfully")

driver.find_element(By.XPATH, "//a[text()=' Delete Account']").click()
accountDeleted = wait.until(EC.visibility_of_element_located((By.XPATH, "//b[text()='Account Deleted!']")))
assert accountDeleted.is_displayed(), "Error in deleting the account"
print("User account deleted successfully")

driver.find_element(By.XPATH, "//a[text()='Continue']").click()

