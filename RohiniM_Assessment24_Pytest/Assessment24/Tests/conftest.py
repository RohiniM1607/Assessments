import pytest
from selenium import webdriver
from Utilities.ReadConfig import get_config

@pytest.fixture()
def setup_and_teardown(request):
    browser = get_config("basic info", "browser")
    if browser == "chrome":
        driver = webdriver.Chrome()
    elif browser == "edge":
        driver = webdriver.Edge()
    elif browser == "firefox":
        driver = webdriver.Firefox()

    driver.maximize_window()
    url = get_config("basic info", "url")
    driver.get(url)
    request.cls.driver = driver

    yield driver
    driver.quit()
    