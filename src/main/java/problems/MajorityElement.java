package problems;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int solute(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int size = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            Integer count = map.get(n);
            if (count == null) {
                count = 0;
            }
            if (count+1 > size/2) {
                return n;
            }
            map.put(n, count+1);

        }
        return 0;
    }
}
