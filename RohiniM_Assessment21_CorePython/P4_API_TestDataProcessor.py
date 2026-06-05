import data_validator
import data_processor

n = int(input("Enter records: "))
records = []

for i in range(n):

    print(f"\nEnter data for record {i+1}")

    usn = input("USN: ")
    name = input("Name: ")
    email = input("Email: ")
    phone = input("Phone: ")

    try:
        data_validator.validate_usn(usn)
        data_validator.validate_email(email)
        data_validator.validate_phone(phone)

        records.append((usn, name, email, phone))

    except data_validator.InvalidFieldError as e:
        print("Error:", e)