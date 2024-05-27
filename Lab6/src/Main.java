import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyCalendar cal = new MyCalendar();
        testing(cal);
        taskTesting(cal);
        System.out.println("Program schedules meetings in a calendar");
        int m = 1;
        while (m != 0) {
            System.out.println("""
                    Choose:\s
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
                    10-Display all tasks of given status ending before given time for day""");
            m = sc.nextInt();
            switch(m){
                case 0 -> System.out.println("Finished");
                case 1 -> addMeeting(cal, sc);
                case 2 -> addTask(cal, sc);
                case 3 -> removeMeeting(cal, sc);
                case 4 -> removeTask(cal, sc);
                case 5 -> displayMeetings(cal, sc);
                case 6 -> displayTasks(cal, sc);
                case 7 -> displayMeetingsOfPriority(cal, sc);
                case 8 -> displayTasksOfStatus(cal, sc);
                case 9 -> displayMeetingsOfPriorityPast(cal, sc);
                case 10 -> displayTasksOfStatusUntil(cal, sc);
                default -> System.out.println("Incorrect input");

            }
        }
    }
    public static void addMeeting(MyCalendar cal, Scanner sc){
        System.out.println("Enter day number (1-7)");
        int day = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter meeting description");
        String description = sc.nextLine();
        System.out.println("Enter meeting start time (HH:MM:SS)");
        String startTime = sc.nextLine();
        while (LocalTime.parse(startTime).isBefore(Meeting.MIN_TIME)){
            System.out.println("Incorrect time, meeting can't start before 6'. Enter again.");
            startTime = sc.nextLine();
        }
        System.out.println("Enter meeting end time");
        String endTime = sc.nextLine();
        System.out.println("Enter priority (normal, high, highest)");
        String priority = sc.nextLine();
        cal.addEvent(day, new Meeting(description, LocalTime.parse(startTime), LocalTime.parse(endTime), priority));
    }
    public static void addTask(MyCalendar cal, Scanner sc){
        System.out.println("Enter day number (1-7)");
        int day = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter task description");
        String description = sc.nextLine();
        System.out.println("Enter task start time (HH:MM:SS)");
        String startTime = sc.nextLine();
        while (LocalTime.parse(startTime).isBefore(Task.MIN_TIME)){
            System.out.println("Incorrect time, task can't start before 6'. Enter again.");
            startTime = sc.nextLine();
        }
        System.out.println("Enter task end time");
        String endTime = sc.nextLine();
        System.out.println("Enter status (planned, confirmed, inProgress, completed)");
        String status = sc.nextLine();
        cal.addEvent(day, new Task(description, LocalTime.parse(startTime), LocalTime.parse(endTime), status));
    }
    public static void displayMeetings(MyCalendar cal, Scanner sc){
        System.out.println("Enter day number (1-7)");
        int day = sc.nextInt();
        ArrayList<Event> meetings = cal.filterEvents(day + 1, s -> s instanceof Meeting);
        for(int i = 0; i < meetings.size(); i++){
            System.out.println("ID:" + i +
                    "  Description: " + '"' + meetings.get(i).getDescription() + '"' +
                    "  Start time: " + meetings.get(i).getStartTime() +
                    "  End Time: " + meetings.get(i).getEndTime() +
                    "  Priority: " + meetings.get(i).getPriority());
        }
    }
    public static void displayTasks(MyCalendar cal, Scanner sc){
        System.out.println("Enter day number (1-7)");
        int day = sc.nextInt();
        ArrayList<Event> tasks = cal.filterEvents(day + 1, s -> s instanceof Task);
        for(int i = 0; i < tasks.size(); i++){
            Task task = (Task) tasks.get(i);
            System.out.println("ID:" + i +
                    "  Description: " + '"' + task.getDescription() + '"' +
                    "  Start time: " + task.getStartTime() +
                    "  End Time: " + task.getEndTime() +
                    "  Status: " + task.getStatus());
        }
    }
    public static void displayMeetings(MyCalendar cal, int day){
        System.out.println("Enter day number (1-7)");
        ArrayList<Event> meetings = cal.filterEvents(day + 1, s -> s instanceof Meeting);
        for(int i = 0; i < meetings.size(); i++){
            System.out.println("ID:" + i +
                    "  Description: " + '"' + meetings.get(i).getDescription() + '"' +
                    "  Start time: " + meetings.get(i).getStartTime() +
                    "  End Time: " + meetings.get(i).getEndTime() +
                    "  Priority: " + meetings.get(i).getPriority());
        }
    }
    public static void displayTasks(MyCalendar cal, int day){
        ArrayList<Event> tasks = cal.filterEvents(day + 1, s -> s instanceof Task);
        for(int i = 0; i < tasks.size(); i++){
            Task task = (Task) tasks.get(i);
            System.out.println("ID:" + i +
                    "  Description: " + '"' + task.getDescription() + '"' +
                    "  Start time: " + task.getStartTime() +
                    "  End Time: " + task.getEndTime() +
                    "  Status: " + task.getStatus());
        }
    }
    public static void removeMeeting(MyCalendar cal, Scanner sc){
        System.out.println("Enter day number (1-7)");
        int day = sc.nextInt();
        displayMeetings(cal, day);
        System.out.println("Enter meeting index");

        int index = sc.nextInt();
        cal.deleteEvent(day + 1, index, s -> s instanceof Meeting);
    }
    public static void removeTask(MyCalendar cal, Scanner sc){
        System.out.println("Enter day number (1-7)");
        int day = sc.nextInt();
        displayTasks(cal, day);
        System.out.println("Enter task index");

        int index = sc.nextInt();
        cal.deleteEvent(day + 1, index, s -> s instanceof Task);
    }
    public static void displayMeetingsOfPriority(MyCalendar cal, Scanner sc){
        System.out.println("Enter day number (1-7)");
        int day = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter priority (normal, high, highest)");
        String priority = sc.nextLine();
        ArrayList<Event> meetings = cal.filterEvents(day + 1, s -> priority.equals(s.getPriority()));
        for(int i = 0; i < meetings.size(); i++){
            System.out.println("ID:" + i +
                    "  Description: " + '"' + meetings.get(i).getDescription() + '"' +
                    "  Start time: " + meetings.get(i).getStartTime() +
                    "  End Time: " + meetings.get(i).getEndTime() +
                    "  Priority: " + meetings.get(i).getPriority());
        }
    }
    public static void displayTasksOfStatus(MyCalendar cal, Scanner sc){
        System.out.println("Enter day number (1-7)");
        int day = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter status (planned, confirmed, inProgress, completed)");
        String status = sc.nextLine();
        ArrayList<Event> tasks = cal.filterEvents(day + 1, s -> s instanceof Task && status.equals(((Task) s).getStatus().name()));
        for(int i = 0; i < tasks.size(); i++){
            Task task = (Task) tasks.get(i);
            System.out.println("ID:" + i +
                    "  Description: " + '"' + task.getDescription() + '"' +
                    "  Start time: " + task.getStartTime() +
                    "  End Time: " + task.getEndTime() +
                    "  Status: " + task.getStatus());
        }
    }
    public static void displayMeetingsOfPriorityPast(MyCalendar cal, Scanner sc){
        System.out.println("Enter day number (1-7)");
        int day = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter time (HH:MM:SS)");
        LocalTime time = LocalTime.parse(sc.nextLine());
        System.out.println("Enter priority (normal, high, highest)");
        String priority = sc.nextLine();
        ArrayList<Event> meetings = cal.filterEvents(day + 1, s -> (s.getStartTime().isAfter(time) || s.getStartTime().equals(time)) && priority.equals(s.getPriority()));
        printResult(meetings);
    }
    public static void displayTasksOfStatusUntil(MyCalendar cal, Scanner sc){
        System.out.println("Enter day number (1-7)");
        int day = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter time (HH:MM:SS)");
        LocalTime time = LocalTime.parse(sc.nextLine());
        System.out.println("Enter status (planned, confirmed, inProgress, completed)");
        String status = sc.nextLine();
        ArrayList<Event> tasks = cal.filterEvents(day + 1, s -> s instanceof Task && !s.getEndTime().isAfter(time) && status.equals(((Task) s).getStatus().name()));
        printResult(tasks);
    }
    public static void printResult(ArrayList<Event> elems){
        for (Event events : elems){
            System.out.println(events.toString());
        }
    }
    public static void testing(MyCalendar cal){
        cal.addEvent(1, new Meeting("first", LocalTime.parse("07:00"),  LocalTime.parse("08:00"), "high"));
        cal.addEvent(1, new Meeting("second", LocalTime.parse("07:00"),  LocalTime.parse("08:00"), "high"));
        cal.addEvent(1, new Meeting("third", LocalTime.parse("07:00"),  LocalTime.parse("08:00"), "highest"));
        cal.addEvent(1, new Meeting("fourth", LocalTime.parse("07:00"),  LocalTime.parse("08:00"), "high"));
        cal.addEvent(1, new Meeting("fifth", LocalTime.parse("07:00"),  LocalTime.parse("08:00"), "normal"));
        cal.addEvent(1, new Meeting("sixth", LocalTime.parse("07:00"),  LocalTime.parse("08:00"), "high"));
        cal.addEvent(1, new Meeting("seventh", LocalTime.parse("10:00"),  LocalTime.parse("11:00"), "highest"));
        cal.addEvent(1, new Meeting("eight", LocalTime.parse("10:00"),  LocalTime.parse("12:00"), "high"));
        cal.addEvent(1, new Meeting("ninth", LocalTime.parse("10:00"),  LocalTime.parse("13:00"), "normal"));
        cal.addEvent(1, new Meeting("tenth", LocalTime.parse("07:00"),  LocalTime.parse("08:00"), "high"));
    }
    public static void taskTesting(MyCalendar cal){
        cal.addEvent(1, new Task("task1", LocalTime.parse("07:00"),  LocalTime.parse("08:00"), "planned"));
        cal.addEvent(1, new Task("task2", LocalTime.parse("07:00"),  LocalTime.parse("08:00"), "confirmed"));
        cal.addEvent(1, new Task("task3", LocalTime.parse("07:00"),  LocalTime.parse("08:00"), "inProgress"));
        cal.addEvent(1, new Task("task4", LocalTime.parse("07:00"),  LocalTime.parse("08:00"), "completed"));
        cal.addEvent(1, new Task("task5", LocalTime.parse("07:00"),  LocalTime.parse("08:00"), "planned"));
        cal.addEvent(1, new Task("task6", LocalTime.parse("07:00"),  LocalTime.parse("08:00"), "confirmed"));
        cal.addEvent(1, new Task("task7", LocalTime.parse("10:00"),  LocalTime.parse("11:00"), "inProgress"));
        cal.addEvent(1, new Task("task8", LocalTime.parse("10:00"),  LocalTime.parse("12:00"), "completed"));
        cal.addEvent(1, new Task("task9", LocalTime.parse("10:00"),  LocalTime.parse("13:00"), "planned"));
        cal.addEvent(1, new Task("task10", LocalTime.parse("07:00"),  LocalTime.parse("08:00"), "confirmed"));
    }

}
