class register_page():
    myaccount_menu = "(//li[@class='dropdown']/child::a)[1]"
    register_menu = "//ul[@class='dropdown-menu dropdown-menu-right']/child::li[1]/child::a"
    
    first_name = "//input[@id='input-firstname']"
    last_name = "//input[@id='input-lastname']"
    email = "//input[@id='input-email']"
    telephone = "//input[@id='input-telephone']"
    password = "//input[@id='input-password']"
    confirm_password = "//input[@id='input-confirm']"
    privacy_policy = "//input[@name='agree']"
    submit = "//input[@value='Continue']"
    success_msg = "//h1[text()='Your Account Has Been Created!']"
    error_msg = "//div[@class='alert alert-danger alert-dismissible']"