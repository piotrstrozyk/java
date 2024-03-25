public class Calculations {
    public static long calcPower(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++){
            result *= 2;
        }
        return result;
    }
    public static long calcSum(int a, int b) {
        int result = 0;
        for (int i = a; i <= b; i++){
            result += i;
        }
        return result;
    }
}
