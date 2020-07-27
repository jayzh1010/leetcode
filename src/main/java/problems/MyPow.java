package problems;

public class MyPow {
    public static double solute(double x, int n) {
        long nn = n;
        if ( n < 0) {
            return 1.0/pow(x, -1*nn);
        } else {
            return pow(x, nn);
        }
    }

    private static double pow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        double sub = pow(x, n/2);
        if (n%2 == 1) {
            return sub*sub*x;
        } else {
            return sub*sub;
        }
    }
}
