## Lab1

#### Power and Sum Calculator
This Java program calculates 2 to the nth power or sums the numbers in a given range. Users can choose between these two operations through a command-line interface.

#### Features
- Calculate Power: Compute 2 raised to the power of a given number.
- Calculate Sum: Compute the sum of all numbers within a specified range.

#### Classes
- Calculations: Provides methods to calculate 2 to the nth power and the sum of a range of numbers.
- Main: Provides a command-line interface for interacting with the calculations.

#### Usage
Run the Main class to start the program. Follow the on-screen prompts to perform calculations.

```
Choose: 
0-Exit   
1-Calculate 2 to nth power   
2-Calculate sum of range
```

## Lab2

#### Cylinder Characteristics Calculator
This Java program calculates and displays the characteristics of a cylinder, such as its base area, lateral area, total area, and volume. Users can set and view the cylinder's parameters (height and radius).

#### Features
- Display Parameters: View the current height and radius of the cylinder.
- Set Parameters: Update the height and radius of the cylinder.
- Calculate Areas: Compute the base area, lateral area, and total area of the cylinder.
- Calculate Volume: Compute the volume of the cylinder.

#### Classes
- Cylinder: Represents a cylinder with methods to calculate its base area, lateral area, total area, and volume.
- Main: Provides a command-line interface for interacting with the cylinder.

#### Usage
Run the Main class to start the program. Follow the on-screen prompts to manage and calculate the characteristics of the cylinder.

```
Choose: 
0-Exit   
1-Display current parameters   
2-Set new parameters   
3-Calculate areas   
4-Calculate volume
```

## Lab3

#### Grade Tracker
This Java program keeps track of grades, allowing users to add new grades and calculate statistics such as the average, highest, and lowest grades.

#### Features
- Add Grades: Add a new grade to the list.
- Calculate Average: Compute the average of all grades.
- Get Highest Grade: Retrieve the highest grade from the list.
- Get Lowest Grade: Retrieve the lowest grade from the list.

#### Classes
- GradeList: Manages the list of grades and provides methods to calculate statistics.
- Main: Provides a command-line interface for interacting with the grade list.

#### Usage
Run the Main class to start the program. Follow the on-screen prompts to manage your grades.

```
Choose: 
0-Exit   
1-Add new grade   
2-Calculate average   
3-Get highest grade   
4-Get lowest grade
```

## Lab4

#### Meeting Scheduler
This Java program schedules and manages meetings in a weekly calendar. It allows users to add, remove, and filter meetings based on various criteria such as priority and time.

#### Features
- Add Meetings: Schedule a new meeting by specifying the day, description, start time, end time, and priority.
- Remove Meetings: Delete a meeting from the calendar by specifying the day and meeting index.
- Display Meetings: View all meetings scheduled for a specific day.
- Filter Meetings: Display meetings based on priority or start time.

#### Classes
- MyCalendar: Manages the weekly schedule of meetings.
- Meeting: Represents a meeting with a description, start time, end time, and priority.
- Main: Provides a command-line interface for interacting with the calendar.

#### Usage
Run the Main class to start the program. Follow the on-screen prompts to manage your meetings.

```
Choose: 
0-Exit
1-Add new meeting
2-Remove meeting
3-Display all meetings for day
4-Display all meetings of given priority for day
5-Display all meetings starting past given time
```


## Lab5

#### Meeting Scheduler
This Java program schedules and manages meetings in a weekly calendar. It allows users to add, remove, and filter meetings based on various criteria such as priority and time.

#### Features
- Add Meetings: Schedule a new meeting by specifying the day, description, start time, end time, and priority.
- Remove Meetings: Delete a meeting from the calendar by specifying the day and meeting index.
- Display Meetings: View all meetings scheduled for a specific day.
- Filter Meetings: Display meetings based on priority, start time, or a time range.

#### Classes
- MyCalendar: Manages the weekly schedule of meetings.
- Meeting: Represents a meeting with a description, start time, end time, and priority.
- Main: Provides a command-line interface for interacting with the calendar.

#### Usage
Run the Main class to start the program. Follow the on-screen prompts to manage your meetings.

```
Choose: 
0-Exit
1-Add new meeting
2-Remove meeting
3-Display all meetings for day
4-Display all meetings of given priority for day
5-Display all meetings starting past given time for day
6-Display all meetings taking place between given times for day
7-Display all meetings of given priority starting past given time
```

## Lab6

### Calendar Scheduling Program
This Java program allows users to schedule and manage meetings and tasks in a calendar. It provides functionality to add, remove, and display events based on various criteria.

#### Features
Add Meetings and Tasks: Users can add new meetings and tasks to specific days of the week.
Remove Meetings and Tasks: Users can remove meetings and tasks by specifying the day and index.
Display Events: Users can display all meetings or tasks for a specific day.
Filter Events: Users can filter and display meetings by priority and tasks by status.
Time Constraints: Meetings and tasks cannot start before 6:00 AM.

#### Classes
- Main: Contains the main method and user interface for interacting with the calendar.
- MyCalendar: Manages the events for each day of the week.
- Event: Abstract base class for events, extended by Meeting and Task.
- Meeting: Represents a meeting with a description, start time, end time, and priority.
- Task: Represents a task with a description, start time, end time, and status.

#### Usage
- Run the Program: Execute the Main class to start the program.
- Interact with the Menu: Use the menu options to add, remove, and display events.
- Follow Prompts: Enter the required information as prompted by the program.

```
Choose:
0-Exit
1-Add new meeting
2-Add new task
3-Remove meeting
4-Remove task
5-Display all meetings for day
6-Display all tasks for day
7-Display all meetings of given priority for day
8-Display all tasks of given status for day
9-Display all meetings of given priority starting past given time for day
10-Display all tasks of given status ending before given time for day
```

## Lab7

### Real Estate Offer Management Program
This Java program manages real estate offers for houses and apartments. It allows users to add new offers, display active offers, and filter offers based on specific criteria.

#### Usage
Run the Program: Execute the Main class to start the program.
Interact with the Menu: Follow the on-screen instructions to add new offers, display offers, or filter offers based on specific criteria.

```
Choose:
0-Exit
1-Add new house offer
2-Add new apartment offer
3-Display all active house offers
4-Display all active apartment offers
5-Display all active house offers in given city of area greater than given
6-Display all active apartment offers in given city, of price less than given and on given floor up
```
