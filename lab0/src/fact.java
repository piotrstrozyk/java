package lab0.src;

import java.math.BigInteger;
import java.util.Scanner;

public class fact {
    public static void main (String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n;
        Scanner menu = new Scanner(System.in);
        int m = 1;
        while (m == 1) {
            System.out.println("Choose: 0-Exit   1-calculating factorial for n   2-calculate 2 to nth power");
            m = menu.nextInt();
            switch(m){
                case 0:
                    break;
                case 1:
                    System.out.println("Enter a number: ");
                    n = reader.nextInt();
                    if(n >= 0){
                        
                        BigInteger silnia = BigInteger.valueOf(calcFactorial(n));
                        System.out.println("Factorial of " + n + " is " + silnia);
                    }
                case 2:
                    System.out.println("Enter a number: ");
                    n = reader.nextInt();
                    if(n >= 0){
                        long power = calcPower(n);
                        System.out.println("2 to the power of " + n + " is " + power);
                    }
                    
            }

        }
        reader.close();
        menu.close();
}
    public static long calcFactorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static long calcPower(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= 2;
        }
        return result;
    }
}

//Run:  java lab0.src.fact
//Compile: javac fact.java