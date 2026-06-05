import re

class InvalidFieldError(Exception):
    pass


def validate_email(email):
    pattern = r'^[a-zA-Z0-9.]+@[a-zA-Z]+\.+[a-z]{,3}$'

    if re.match(pattern, email):
        print("Email validation successful")
    else:
        raise InvalidFieldError("Invalid Email")


def validate_phone(phone):
    pattern = r'^[6-9]\d{9}$'

    if re.match(pattern, phone):
        print("Phone validation successful")
    else:
        raise InvalidFieldError("Invalid Phone Number")


def validate_usn(usn):
    pattern = r'^25MCA\d{3}$'

    if re.match(pattern, usn):
        print("USN validation successful")
    else:
        raise InvalidFieldError("Invalid USN")