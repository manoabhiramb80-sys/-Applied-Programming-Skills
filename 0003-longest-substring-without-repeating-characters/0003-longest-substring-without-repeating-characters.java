class Solution {
    public int lengthOfLongestSubstring(String s) {
        // time : O(n), n = number of elements to loop through
        // space: O(n), n = number of elements to store in HashSet

        // 0 1 2 3 4 5 6 7
        // i   j
        // a b c a b c b b

        // set - {a b c}
        // set - {}

        //       i   j     
        //       a b c b b

        // set - {a b c}
        // set - {}

        //             i j
        //             b b

        HashSet<Character> set = new HashSet<>();

        int i = 0;
        int max = 0;

        for(int j = 0; j < s.length(); j++) {
            while(set.contains(s.charAt(j))){
            set.remove(s.charAt(i));
            i++;
        }

            set.add(s.charAt(j));
            int diff = j - i;
            max = Math.max(max, diff + 1);
        }

        return max;
    }
}