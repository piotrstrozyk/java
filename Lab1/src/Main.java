import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Calculations calc = new Calculations();
        Scanner sc = new Scanner(System.in);
        System.out.println("Program calculates 2 to the nth power or sums array from given range.");
        int m = 1;

        while (m == 1) {
            System.out.println("Choose: 0-Exit   1-Calculate 2 to nth power    2-Calculate sum of range");
            m = sc.nextInt();
            switch(m){
                case 0 ->
                    System.out.println("Finished");
                case 1 -> {
                    System.out.println("Enter a number: ");
                    int n = sc.nextInt();
                    long power = calc.calcPower(n);
                    System.out.println("2 to the power of " + n + " is " + power);
                }

                case 2 -> {
                    System.out.println("Enter 2 numbers: ");
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    long sum = calc.calcSum(a, b);
                    System.out.println("Sum of numbers in range " + a + " to " + b + " equals " + sum);
                }
            }
        }
    }
}