package problems;

public class SearchMatrix {

    public static boolean solute(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return searchBinaryRowAndCol(matrix, target);
    }

    private static boolean searchBinaryAll(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row*col - 1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            int res = matrix[mid/col][mid%col];
            if (res == target) {
                return true;
            } else if (res < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    private static boolean searchBinaryRowAndCol(int[][] matrix, int target) {
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        int left = 0;
        int right = m;
        int column = -1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (target >= matrix[mid][0] && target <= matrix[mid][n]) {
                column = mid;
                break;
            } else if (target < matrix[mid][0]) {
                right = mid - 1;
            } else if (target > matrix[mid][n]) {
                left = mid + 1;
            }
        }
        if (column == -1) {
            return false;
        }
        left = 0;
        right = n;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (target == matrix[column][mid]) {
                return true;
            } else if (target < matrix[column][mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
