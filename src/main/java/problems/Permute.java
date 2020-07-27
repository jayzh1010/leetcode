package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permute {
    public static List<List<Integer>> solute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        List<Integer> numList = new ArrayList<>();
        for (int num: nums) {
            numList.add(num);
        }
        backtrack(ans, numList, n, new HashSet<>());
        return ans;
    }

    private static void backtrack(List<List<Integer>> ans, List<Integer> nums, int n, Set<Integer> used) {
        if (used.size() == n) {
            ans.add(new ArrayList(used));
            return;
        }

        for (int i=0; i<nums.size(); i++) {
            Integer target = nums.get(i);
            nums.remove(i);
            used.add(target);
            backtrack(ans, nums, n, used);
            used.remove(used.size()-1);
            nums.add(i, target);
        }
    }
}
