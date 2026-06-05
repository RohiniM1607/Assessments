students = {}
n=int(input("Enter number of students: "))
for i in range(n):
    usn=input("Enter USN: ")
    marks=int(input("Enter Marks: "))
    students[usn]=marks
maximum=max(students.values())
minimum=min(students.values())
for i in students:
    if students[i]==maximum:
        print("Maximum:",maximum,"-",i)
for i in students:
    if students[i]==minimum:
        print("Minimum:",minimum,"-",i)
dist = []
merit = []
passed = []
fail = []
for i in students:
    marks=students[i]
    if marks>=86:
        dist.append(i)
    elif marks>=75:
        merit.append(i)
    elif marks>=60:
        passed.append(i)
    else:
        fail.append(i)
print("Distinction:",len(dist),"-",dist)
print("Merit:",len(merit),"-",merit)
print("Pass:",len(passed))
print("Fail:",len(fail))
total = 0
for i in students:
    total=total+students[i]
average = total/n

print("Class Average:",average)
below_average = []
for usn in students:
    if students[usn] < average:
        below_average.append(usn)
print("Below Average:", below_average)
print("\n--- Leaderboard ---")
sorted_students = sorted(students.items(), reverse=True, key=lambda x: x[1])
for usn, marks in sorted_students:
    print(usn, ":", marks)