from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

driver = webdriver.Chrome()
driver.maximize_window()
wait = WebDriverWait(driver, 10)

driver.get(" https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC")
driver.find_element(By.XPATH, "//a[text()='Register']").click()
driver.find_element(By.ID, "customer.firstName").send_keys("Admin")
driver.find_element(By.ID, "customer.lastName").send_keys("1")
driver.find_element(By.ID, "customer.address.street").send_keys("R.S Puram")
driver.find_element(By.ID, "customer.address.city").send_keys("Coimbatore")
driver.find_element(By.ID, "customer.address.state").send_keys("Tamil Nadu")
driver.find_element(By.ID, "customer.address.zipCode").send_keys("658 675")
driver.find_element(By.ID, "customer.phoneNumber").send_keys("9876543210")
driver.find_element(By.ID, "customer.ssn").send_keys("Ad001")

driver.find_element(By.ID, "customer.username").send_keys("Admin")
driver.find_element(By.ID, "customer.password").send_keys("Admin@123")
driver.find_element(By.ID, "repeatedPassword").send_keys("Admin@123")

driver.find_element(By.XPATH, "//input[@value='Register']").click()

home_page = driver.find_element(By.XPATH, "//h1[@class='title']")
assert home_page.is_displayed(), "Not logged-in"

wait.until(EC.visibility_of_element_located(By.XPATH, "//div[@id='leftPanel']/child::ul/child::li[4]")).click()

driver.find_element(By.NAME, "payee.name").send_keys("Admin1")
driver.find_element(By.NAME, "payee.address.street").send_keys("R.S Puram")
driver.find_element(By.NAME, "payee.address.city").send_keys("Coimbatore")
driver.find_element(By.NAME, "payee.address.state").send_keys("Tamil Nadu")
driver.find_element(By.NAME, "payee.address.zipCode").send_keys("658 675")
driver.find_element(By.NAME, "payee.phoneNumber").send_keys("9876543210")
driver.find_element(By.NAME, "payee.accountNumber").send_keys("3907893657")
driver.find_element(By.NAME, "verifyAccount").send_keys("3907893657")
driver.find_element(By.NAME, "amount").send_keys("50")
driver.find_element(By.XPATH, "//input[@value='Send Payment']").click()

driver.find_element(By.XPATH, "//a[text()='Accounts Overview']").click()
balance = driver.find_element(By.XPATH, "//b[text()='$5150.50']").text
assert balance == "$5150.50"
print("Balance Verified")