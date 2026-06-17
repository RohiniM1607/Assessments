class login_page():
    myaccount_menu = "(//li[@class='dropdown']/child::a)[1]"
    login_menu = "//ul[@class='dropdown-menu dropdown-menu-right']/child::li[2]/child::a"

    email = "//input[@id='input-email']"
    password = "//input[@id='input-password']"
    login_btn = "//input[@type='submit']"

    my_account = "//h2[text()='My Account']"
    error_msg = "//div[contains(@class,'alert-danger')]"