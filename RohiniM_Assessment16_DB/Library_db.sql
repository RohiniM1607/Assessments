CREATE DATABASE Library;
USE Library;

CREATE TABLE Members(
	Member_id INT PRIMARY KEY, 
    First_name VARCHAR(100) NOT NULL,
	Last_name VARCHAR(100) NOT NULL, 
    Dob DATE, 
    Email VARCHAR(255) NOT NULL UNIQUE,
	Phone VARCHAR(20), 
    Street VARCHAR(255), 
    City VARCHAR(100), 
    State VARCHAR(50) DEFAULT 'Tamil Nadu', 
	Zip_code VARCHAR(100), 
    Membership_type VARCHAR(20) NOT NULL CHECK(Membership_type IN ('Basic', 'Premium', 'VIP'))
);
ALTER TABLE Members MODIFY State VARCHAR(50) DEFAULT 'Tamil Nadu';
CREATE TABLe Categories(
	Category_id INT PRIMARY KEY,
    Category_name VARCHAR(150) NOT NULL UNIQUE,
    Description VARCHAR(500)
);

CREATE TABLE Books(
	Book_id INT PRIMARY KEY,
    Title VARCHAR(255) NOT NULL,
    Author VARCHAR(200) NOT NULL,
    ISBN VARCHAR(20) NOT NULL UNIQUE,
    Publisher VARCHAR(200),
    Pub_year INTEGER,
    Price DECIMAL(2) NOT NULL,
    Total_copies INT NOT NULL DEFAULT 1,
    Category_id INT NOT NULL,
    FOREIGN KEY(Category_id) REFERENCES Categories(Category_id)
);

CREATE TABLE BORROWS(
	Borrow_id INT PRIMARY KEY,
    Member_id INT NOT NULL,
    FOREIGN KEY(Member_id) REFERENCES Members(Member_id),
    Book_id INT NOT NULL,
    FOREIGN KEY(Book_id) REFERENCES Books(Book_id),
    Borrow_date DATE NOT NULL,
    Due_date DATE NOT NULL,
    Return_date DATE,
    Status VARCHAR(20) NOT NULL CHECK(Status IN('Borrowed', 'Returned', 'Overdue'))
);

CREATE TABLE Fines(
	Fine_id INT PRIMARY KEY,
    Borrow_id INT NOT NULL,
    FOREIGN KEY(Borrow_id) REFERENCES Borrows(Borrow_id),
    Member_id INT NOT NULL,
    FOREIGN KEY(Member_id) REFERENCES Members(Member_id),
    Fine_amount DECIMAL(2) NOT NULL,
    Paid_amount DECIMAL(2) DEFAULT 0,
    Fine_date DATE NOT NULL,
    Payment_status VARCHAR(20) NOT NULL CHECK(Payment_status IN('Paid', 'Unpaid', 'Waived'))
);
DESC Members;
DESC Categories;
DESC Books;
DESC Borrows;
DESC Fines;

-- Members
INSERT INTO Members (Member_id, First_name, Last_name, Dob, Email, Phone, Street, City, Zip_code, Membership_type) VALUES
(101, 'Kavya', 'M', '2003-05-14', 'kavya14@example.com', '9876543210', '12 Anna Nagar', 'Chennai', '600040', 'Premium'),
(102, 'Pooja', 'Kumar', '1999-11-20', 'pooja@example.com', '9876501234', '45 Gandhi Street', 'Coimbatore', '641001', 'Basic'),
(103, 'Divya', 'S', '2001-02-10', 'divya@example.com', '9876512345', '78 Lake View', 'Madurai', '625001', 'VIP');

-- Categories
INSERT INTO Categories VALUES
(1, 'Fiction', 'Novels and story books'),
(2, 'Technology', 'Front-end Web Technologies'),
(3, 'Science', 'Research');

ALTER TABLE Books MODIFY Price DECIMAL(10,2) NOT NULL;

-- Books
INSERT INTO Books VALUES
(201, 'The Cat in the Hat', 'Dr. Seuss', 'ISBN1001', 'Random House', 1957, 499.99, 5, 1),
(202, 'Front-End Web Development', 'Chris Minnick', 'ISBN1002', 'Wiley', 2020, 200.50, 3, 2),
(203, 'Physics Basics', 'H.C. Verma', 'ISBN1003', 'Bharati Bhavan', 2015, 650.00, 4, 3);

-- Borrows
INSERT INTO Borrows VALUES
(301, 101, 201, '2026-03-01', '2026-03-15', '2026-03-12', 'Returned'),
(302, 102, 202, '2026-03-10', '2026-03-24', NULL, 'Borrowed'),
(303, 103, 203, '2026-02-20', '2026-03-05', NULL, 'Overdue');

ALTER TABLE Fines MODIFY Fine_amount DECIMAL(10,2) NOT NULL;
ALTER TABLE Fines MODIFY Paid_amount DECIMAL(10,2) NOT NULL;

-- Fines
INSERT INTO Fines VALUES
(401, 303, 103, 150.00, 0.00, '2026-03-06', 'Unpaid'),
(402, 301, 101, 50.00, 50.00, '2026-03-12', 'Paid'),
(403, 302, 102, 75.00, 0.00, '2026-03-25', 'Waived');

SELECT * FROM Members;
SELECT * FROM Categories;
SELECT * FROM Books;
SELECT * FROM Borrows;
SELECT * FROM Fines;