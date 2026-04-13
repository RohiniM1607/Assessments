CREATE DATABASE HRScheme;
USE HRScheme;

CREATE TABLE LOCATIONS(
	Location_Id INT PRIMARY KEY,
    Country_Id VARCHAR(5) NOT NULL,
    City VARCHAR(20) NOT NULL
);

INSERT INTO LOCATIONS VALUE 
(1, 'IN', 'Salem'), (2, 'IN', 'Coimbatore'), (3, 'KA', 'Banglore'), (4, 'IN', 'Mysore'), 
(5, 'IN', 'Madurai'), (6, 'AP', 'Kunthur'), (7, 'KE', 'Munnar'), (8, 'KE', 'Wayannad');

SELECT Country_Id, COUNT(City) AS No_of_cities FROM LOCATIONS GROUP BY Country_Id;

CREATE TABLE EMPLOYEE(
	Emp_id INT PRIMARY KEY,
    First_name VARCHAR(30),
    Last_name VARCHAR(30),
    Year_of_experience INT,
    Salary INT,
    Commission INT,
    Dept INT,
    Job_id VARCHAR(20)
);
TRUNCATE TABLE EMPLOYEE;

INSERT INTO EMPLOYEE (Emp_id, First_name, Last_name, Year_of_experience, Salary, Commission, Dept, Job_id)
VALUES
(101, 'Priya', 'K', 3, 110000, NULL, 10, 'IT_Dev'),
(102, 'Reena', 'R', 5, 4000, 10, 80, 'IT_Tes'),
(103, 'Lavanya', 'D', 1, 7000, NULL, 30, 'Supp'),
(104, 'Meenu', 'M', 4, 15500, NULL, 60, 'Management'),
(105, 'Ramya', 'S', 2, 9000, 5, 50, 'IT_Dev');

INSERT INTO EMPLOYEE (Emp_id, First_name, Last_name, Year_of_experience, Salary, Commission, Dept, Job_id)
VALUES
(106, 'Rani', 'K', 37, 110000, NULL, 10, 'IT_Dev');

SELECT * FROM EMPLOYEE;

-- 2. to Identify the employees whose salaries exceed 10000 after receiving a 25% salary increase and return complete information about them
SELECT * FROM EMPLOYEE WHERE Salary*0.25>10000;

-- 3. to identify employees with more than 27 years of experience and return the first name, last name and years of experience about the employees
SELECT First_name, Last_Name, Year_of_experience FROM EMPLOYEE WHERE Year_of_experience>27;

-- 4. to display the details of the employees where, commission percentage is null and salary in the range 5000 to 10000 and department is not 50 or 80
SELECT * FROM EMPLOYEE
WHERE Commission IS NULL AND Salary BETWEEN 5000 AND 10000 AND Dept NOT IN (50, 80);
  
-- 5. to display job ID for jobs with average salary more than 10000
SELECT Job_id FROM EMPLOYEE GROUP BY Job_id HAVING AVG(Salary) > 10000;