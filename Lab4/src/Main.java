import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyCalendar cal = new MyCalendar();
        testing(cal);
        System.out.println("Program schedules meetings in a calendar");
        int m = 1;
        while (m != 0) {
            System.out.println("""
                    Choose:\s
                    0-Exit
                    1-Add new meeting
                    2-Remove meeting
                    3-Display all meetings for day
                    4-Display all meetings of given priority for day
                    5-Display all meetings starting past given time for day""");
            m = sc.nextInt();
            switch(m){
                case 0 -> System.out.println("Finished");
                case 1 -> addMeeting(cal, sc);
                case 2 -> removeMeeting(cal, sc);
                case 3 -> displayMeetings(cal, sc);
                case 4 -> displayMeetingsOfPriority(cal, sc);
                case 5 -> displayMeetingsPastTime(cal, sc);

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
        cal.addMeeting(day, description, LocalTime.parse(startTime), LocalTime.parse(endTime), priority);
    }
    public static void displayMeetings(MyCalendar cal, Scanner sc){
        System.out.println("Enter day number (1-7)");
        int day = sc.nextInt();
        ArrayList<Meeting> meetings = cal.getMeetingsForDay(day + 1);
        for(int i = 0; i < meetings.size(); i++){
            System.out.println("ID:" + i +
                    "  Description: " + '"' + meetings.get(i).getDescription() + '"' +
                    "  Start time: " + meetings.get(i).getStartTime() +
                    "  End Time: " + meetings.get(i).getEndTime() +
                    "  Priority: " + meetings.get(i).getPriority());
            }
    }
    public static void displayMeetings(MyCalendar cal, int day){
        System.out.println("Enter day number (1-7)");
        ArrayList<Meeting> meetings = cal.getMeetingsForDay(day + 1);
        for(int i = 0; i < meetings.size(); i++){
            System.out.println("ID:" + i +
                    "  Description: " + '"' + meetings.get(i).getDescription() + '"' +
                    "  Start time: " + meetings.get(i).getStartTime() +
                    "  End Time: " + meetings.get(i).getEndTime() +
                    "  Priority: " + meetings.get(i).getPriority());
        }
    }
    public static void removeMeeting(MyCalendar cal, Scanner sc){
        System.out.println("Enter day number (1-7)");
        int day = sc.nextInt();
        displayMeetings(cal, day);
        System.out.println("Enter meeting index");

        int index = sc.nextInt();
        cal.deleteMeeting(day + 1, index);
    }
    public static void displayMeetingsOfPriority(MyCalendar cal, Scanner sc){
        System.out.println("Enter day number (1-7)");
        int day = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter priority (normal, high, highest)");
        String priority = sc.nextLine();
        ArrayList<Meeting> meetings = cal.getMeetingsOfPriority(day + 1, priority);
        for(int i = 0; i < meetings.size(); i++){
            System.out.println("ID:" + i +
                    "  Description: " + '"' + meetings.get(i).getDescription() + '"' +
                    "  Start time: " + meetings.get(i).getStartTime() +
                    "  End Time: " + meetings.get(i).getEndTime() +
                    "  Priority: " + meetings.get(i).getPriority());
        }
    }
    public static void displayMeetingsPastTime(MyCalendar cal, Scanner sc){
        System.out.println("Enter day number (1-7)");
        int day = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter time (HH:MM:SS)");
        LocalTime time = LocalTime.parse(sc.nextLine());
        ArrayList<Meeting> meetings = cal.getMeetingsPastTime(day + 1, time);
        for(int i = 0; i < meetings.size(); i++){
            System.out.println("ID:" + i +
                    "  Description: " + '"' + meetings.get(i).getDescription() + '"' +
                    "  Start time: " + meetings.get(i).getStartTime() +
                    "  End Time: " + meetings.get(i).getEndTime() +
                    "  Priority: " + meetings.get(i).getPriority());
        }
    }
    public static void testing(MyCalendar cal){
        cal.addMeeting(1, "first", LocalTime.parse("07:00"),  LocalTime.parse("08:00"), "high");
        cal.addMeeting(1, "second", LocalTime.parse("07:00"),  LocalTime.parse("08:00"), "high");
        cal.addMeeting(1, "third", LocalTime.parse("07:00"),  LocalTime.parse("08:00"), "highest");
        cal.addMeeting(1, "fourth", LocalTime.parse("07:00"),  LocalTime.parse("08:00"), "high");
        cal.addMeeting(1, "fifth", LocalTime.parse("07:00"),  LocalTime.parse("08:00"), "normal");
        cal.addMeeting(1, "sixth", LocalTime.parse("07:00"),  LocalTime.parse("08:00"), "high");
        cal.addMeeting(1, "seventh", LocalTime.parse("10:00"),  LocalTime.parse("11:00"), "highest");
        cal.addMeeting(1, "eight", LocalTime.parse("10:00"),  LocalTime.parse("12:00"), "high");
        cal.addMeeting(1, "ninth", LocalTime.parse("10:00"),  LocalTime.parse("13:00"), "normal");
        cal.addMeeting(1, "tenth", LocalTime.parse("07:00"),  LocalTime.parse("08:00"), "high");
    }
}
