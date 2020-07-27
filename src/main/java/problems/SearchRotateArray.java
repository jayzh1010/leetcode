package problems;

public class SearchRotateArray {
    public static int solute(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int n = right;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (target == nums[mid]) {
                return mid;

            }
            // 在左侧直线
            if (nums[mid]>=nums[0]) {
                if ((target > nums[mid] || target<nums[0])) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                // 在右侧直线
            } else {
                if (target>=nums[0] || target<nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}
