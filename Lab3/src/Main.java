import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        GradeList grades = new GradeList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Program keeps track of grades");
        int m = 1;
        while (m != 0) {
            System.out.println("Choose: 0-Exit   1-Add new grade   2-Calculate average   " +
                    "3-Get highest grade   4-Get lowest grade");
            m = sc.nextInt();
            switch(m){
                case 0 -> System.out.println("Finished");
                case 1 -> newGrade(grades, sc);
                case 2 -> calcAverage(grades);
                case 3 -> highGrade(grades);
                case 4 -> lowGrade(grades);
            }
        }
    }
    public static void newGrade(GradeList grades, Scanner sc) {
        System.out.println("Enter new grade: ");
        double grade = sc.nextDouble();
        grades.addGrade(grade);
        System.out.println("Grades updated successfully");
    }
    public static void calcAverage(GradeList grades) {
        double mean = grades.getMean();
        if (grades.returnStatus()) System.out.println("Grade list empty");
        else System.out.println("Average grade:   " + mean);
    }
    public static void highGrade(GradeList grades){
        double high = grades.highestGrade();
        if (grades.returnStatus()) System.out.println("Grade list empty");
        else System.out.println("Highest grade:   " + high);    }
    public static void lowGrade(GradeList grades){
        double low = grades.lowestGrade();
        if (grades.returnStatus()) System.out.println("Grade list empty");
        else System.out.println("Lowest grade:   " + low);    }
}
