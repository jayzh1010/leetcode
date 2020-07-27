package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
    public static List<List<Integer>> solute(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);


        List<Integer> sortedList = new ArrayList<>();
        for (int i: nums) {
            sortedList.add(i);
        }

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), sortedList.size(), sortedList);
        return ans;
    }

    private static void backtrack(List<List<Integer>> ans, List<Integer> path, int n, List<Integer> sortedList) {
        if (path.size() == n) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i=0; i<sortedList.size(); i++) {
            if (i<sortedList.size()-1 && sortedList.get(i)==sortedList.get(i+1)) {
                continue;
            }
            Integer target = sortedList.get(i);
            path.add(target);
            sortedList.remove(i);
            backtrack(ans, path, n, sortedList);
            path.remove(path.size() - 1);
            sortedList.add(i, target);

        }
    }
}
