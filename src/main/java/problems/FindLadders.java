package problems;

import javafx.util.Pair;

import java.util.*;

public class FindLadders {
    private static int n;
    private static int min = Integer.MAX_VALUE;
    public static List<List<String>> solute(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> dict = new HashMap<>();
        n = beginWord.length();
        for (String word: wordList) {
            for (int i=0; i<n; i++) {
                String curWord = word.substring(0, i) + "*" + word.substring(i+1);
                List<String> words = dict.get(curWord);
                if (words == null) {
                    words = new ArrayList<>();
                    dict.put(curWord, words);
                }
                words.add(word);
            }
        }

        Queue<Pair<String, List<String>>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, Arrays.asList(beginWord)));

        while(!queue.isEmpty()) {
            Pair<String, List<String>> word = queue.poll();
            String curWord = word.getKey();
            List<String> curPath = word.getValue();
            if (min != Integer.MAX_VALUE && curPath.size()+1>min) {
                break;
            }
            for (int i=0; i<n; i++) {
                String patternWord = curWord.substring(0, i) + "*" + curWord.substring(i+1);
                List<String> likelyWords = dict.getOrDefault(patternWord, new ArrayList<String>());
                for (String likelyWord: likelyWords) {
                    if (curPath.contains(likelyWord)) {
                        continue;
                    }
                    List<String> newPath = new ArrayList<>(curPath);
                    newPath.add(likelyWord);
                    if (likelyWord.equals(endWord)) {

                        int pathLength = newPath.size();
                        if (pathLength <= min) {
                            ans.add(newPath);
                            min = pathLength;
                        }
                    } else {
                        queue.add(new Pair<>(likelyWord, newPath));
                    }

                }

            }
        }

        return ans;
    }

}
