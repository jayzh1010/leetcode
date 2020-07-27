package problems;

public class LongestPalindrome {
    public static String solute(String s) {
        String sub = "";
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n+1; j++) {
                String substring = s.substring(i, j);
                if (isPalindrome(substring) && substring.length()>maxLength) {
                    sub = substring;
                    maxLength = substring.length();
                }
            }
        }
        return sub;
    }

    public static boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        for (int i=0, j=n-1; i<=(n+1)/2 - 1; i++,j--) {
            if (charArray[i] != charArray[j]) {
                return false;
            }
        }
        return true;
    }

    public static String soluteDp(String s) {
        String sub = "";

        return sub;
    }

    public static String solute2(String s) {
        if (s == null || s.length() < 1) return "";

        int n = s.length();
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            int len1 = lengthOfPalindrome(s, i, i);
            int len2 = lengthOfPalindrome(s, i, i+1);
            int len = len1>len2 ? len1 : len2;
            if (len > (end-start+1)) {
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }

    public static int lengthOfPalindrome(String s, int left, int right) {

        int n = s.length();
        while (left>=0 && right<n && s.charAt(left)==s.charAt(right)) {
            left--;
            right++;
        }

        return right-left-1;
    }
}
