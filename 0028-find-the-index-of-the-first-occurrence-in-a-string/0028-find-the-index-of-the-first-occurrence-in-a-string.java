class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();

        if (nLen > hLen) return -1;

        for (int i = 0; i <= hLen - nLen; i++) {
            int j;

            for (j = 0; j < nLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }

            if (j == nLen) return i;
        }

        return -1;
    }
}