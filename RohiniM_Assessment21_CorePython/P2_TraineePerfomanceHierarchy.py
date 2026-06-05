class Person:
    def __init__(self, name, age, email):
        self.name = name
        self.age = age
        self.email = email

    def display_info(self):
        print(f"Name: {self.name}")
        print(f"Age: {self.age}")
        print(f"email: {self.email}")
    

class Trainee(Person):
    def __init__(self, name, age, email, batch_id, marks, num_projects, num_publications):
        super().__init__(name, age, email)
        self.batch_id = batch_id
        self.marks = marks
        self.num_projects = num_projects
        self.num_publications = num_publications

    def display_info(self):
        super().display_info()
        print(f"Batch: {self.batch_id}")
        print(f"Marks: {self.marks}")
        print(f"Projects: {self.num_projects}")
        print(f"Publications: {self.num_publications}")


class SDETTrainee(Trainee):
    def __init__(self, name, age, email, batch_id, marks, num_projects, num_publications, tool_proficiency):
        super().__init__(name, age, email, batch_id,marks, num_projects, num_publications)
        self.tool_proficiency = tool_proficiency

    def compute_avg(self):
        avg_marks = sum(self.marks) / len(self.marks)
        return avg_marks
    
    def compute_aggregate(self):
        
        aggregate = (self.compute_avg() * 0.6 + self.num_projects * 5 + self.num_publications * 3)
        return round(aggregate, 2)

    def display_info(self):
        super().display_info()
        print("Avg: ", self.compute_avg())
        print(f"Tool: {self.tool_proficiency}")
        print(f"Aggregate Score: {self.compute_aggregate()}")

    
 
t1 = SDETTrainee("Arun Kumar", 24, "arun@gmail.com","B2025",[78, 85, 90, 72, 88],3, 1,"Selenium")
t2 = SDETTrainee("Rohit", 25, "rohit@gmail.com","B2025",[90, 92, 88, 95, 91],2, 2,"Playwright")
t1.display_info()
print()
t2.display_info()