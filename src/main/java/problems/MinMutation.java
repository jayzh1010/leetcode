package problems;

import java.util.HashSet;
import java.util.Set;

public class MinMutation {
    private static int minCount = Integer.MAX_VALUE;
    public static int solute(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String b: bank) {
            bankSet.add(b);
        }
        if (!bankSet.contains(end)) {
            return -1;
        }
        dfs(start, end, bank, 0, new HashSet<>());
        return minCount==Integer.MAX_VALUE ? -1 : minCount;
    }

    private static void dfs(String current, String end, String[] bank, int count, Set<String> visited) {
        if (count>minCount) {
            return;
        }
        if (current.equals(end)) {
            minCount = minCount < count ? minCount : count;
            return;
        }
        for (String b: bank) {
            if (!visited.contains(b) && diffOne(b, current)) {
                visited.add(b);
                dfs(b, end, bank, count+1, visited);
                visited.remove(b);
            }
        }
    }
    private static boolean diffOne(String a, String b) {
        int count = 0;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i)!=b.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}
