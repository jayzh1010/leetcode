package problems;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;
import java.util.concurrent.*;

public class Main {
    static class Person {
        private String name;
        private Integer id;

        public Person(String name, Integer id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(id, person.id);
        }

        @Override
        public int hashCode() {
            //return Objects.hash(id);
            return id;
        }
    }

    public static void main(String[] args) {

        MaxProduct.solute(new int[]{2,3,-2,4});
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        MinimumTotal.solute(triangle);
        ClimbStairs.solute(2);
        LongCommonSubsequence.solute("abcde", "ace");
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        UniquePathsWithObstacles.solute(new int[][]{{1,0}});
        //int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,50}};
        int[][] matrix = {{1,3}};
        SearchMatrix.solute(matrix, 3);
        SearchRotateArray.solute(new int[]{4,5,6,7,0,1,2}, 0);
        IsPerfectSquare.solute(16);
        MySqrt.solute(2147395599);
        CoinChange.solute(new int[]{470,18,66,301,403,112,360}, 8235);
        List<List<String>> ans = FindLadders.solute("cet", "ism", Arrays.asList("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"));
        System.out.println(ans);
        MinMutation.solute("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"});
        String a = "a";
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        sb.toString();
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        for (Map.Entry<Integer, String> entry: map.entrySet()) {
            Integer key = entry.getKey();
            String val = entry.getValue();
        }


        //TwoSum.solute(new int[]{2,7,11,15}, 9);
        MajorityElement.solute(new int[]{4,5,4});
        double res = MyPow.solute(2.00000, -2147483648);
        PermuteUnique.solute(new int[]{1,1,2});
        Permute.solute(new int[]{1,2,3});
        LinkedList<Integer> linkedList = new LinkedList<>();
        char[] chars = "abc".toCharArray();

        //double res = FindMedianSortedArrays.soluteQuick(new int[]{1,3}, new int[]{2});

        LargestRectangleArea.solute(new int[]{1, 1});

        LargestRectangleArea.solute(new int[]{2,1,5,6,2,3});

        // String res = LongestPalindrome.solute2("");
        Parentheses.solute("]");
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        Vector<Integer> vector = new Vector<>();
        List<List<Integer>> ans1 = ThreeSum.solute(new int[]{-1, 0, 1, 2, -1, -4});

        ReverseNodeInKGroup.ListNode n5 = new ReverseNodeInKGroup.ListNode(5);
        ReverseNodeInKGroup.ListNode n4 = new ReverseNodeInKGroup.ListNode(4);
        ReverseNodeInKGroup.ListNode n3 = new ReverseNodeInKGroup.ListNode(3);
        ReverseNodeInKGroup.ListNode n2 = new ReverseNodeInKGroup.ListNode(2);
        ReverseNodeInKGroup.ListNode n1 = new ReverseNodeInKGroup.ListNode(1);
        n4.setNext(n5);
        n3.setNext(n4);
        n2.setNext(n3);
        n1.setNext(n2);

        ReverseNodeInKGroup.solute(n1, 3);

        System.out.println(ans);

    }
}
