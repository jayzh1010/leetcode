package problems;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 *  
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 */
public class FindMedianSortedArrays {
    public static double solute(int[] nums1, int[] nums2) {

        double res = 0;
        int[] all = new int[nums1.length + nums2.length];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < nums1.length || j < nums2.length) {
            if (j>=nums2.length || (i<nums1.length && nums1[i] <= nums2[j])) {
                all[k] = nums1[i];
                i++;
            } else if (i>=nums1.length || (j<nums2.length && nums2[j] <= nums1[i])) {
                all[k] = nums2[j];
                j++;
            }
            k++;
        }
        int n = all.length;
        if (n%2 == 0) {
            res = (all[n/2] + all[n/2-1])/2.0;
        } else {
            res = all[n/2];
        }

        return res;
    }

    public static double soluteQuick(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (n + m + 1)/2;
        int right = (n + m + 2)/2;
        double res;
        if ((m+n) % 2 == 0) {
            res = (getKth(nums1, 0, m-1, nums2, 0, n-1, left) + getKth(nums1, 0, m-1, nums2, 0, n-1, right))*0.5;
        } else {
            res = getKth(nums1, 0, m-1, nums2, 0, n-1, left);
        }
        return res;
    }

    public static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }

        if (k == 1) {
            return nums1[start1] < nums2[start2] ? nums1[start1] : nums2[start2];
        }

        int i = start1 + (len1 > k/2 ? k/2 : len1) - 1;
        int j = start2 + (len2 > k/2 ? k/2 : len2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j+1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i+1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }

    }
}
