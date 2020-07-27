package problems;

import java.util.Stack;

public class LargestRectangleArea {
    public static int solute(int[] heights) {
        int max = 0;
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0 ; i < n; i++) {
            int height = heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] >= height) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = 0;
            } else {
                left[i] = stack.peek()+1;
            }
            stack.push(i);
        }
        stack.clear();
        for (int j = n-1; j > 0; j--) {
            int height = heights[j];
            while(!stack.isEmpty() && heights[stack.peek()] >= height) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[j] = n-1;
            } else {
                right[j] = stack.peek()-1;
            }
            stack.push(j);
        }
        for (int k = 0 ; k < n; k++) {
            int area = (right[k]-left[k]+1) * heights[k];
            max = max > area ? max : area;
        }
        return max;
    }
}
