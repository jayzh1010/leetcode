package problems;

public class IsPerfectSquare {
    public static boolean solute(int num) {
        int left = 0;
        int right = num;
        while (left <= right) {
            int mid = left + (right-left)/2;
            long res = (long) mid*mid;
            if (res == num) {
                return true;
            } else if (res < num) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return false;
    }
}
