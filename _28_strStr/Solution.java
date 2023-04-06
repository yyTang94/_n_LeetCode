package _28_strStr;
class Solution { // 找出字符串中第一个匹配项的下标
    public int strStr(String haystack, String needle) {

        /*
         * 2022-10-07 18:46:45 -> 2022-10-08 13:12:52
         * 1 ms (40.39%)
         * 39.8 MB (10.02%)
         */

        int globalIndex = 0;
        int localIndex = 0;

        while (globalIndex < haystack.length()) {
            while (localIndex < needle.length()) {
                if (globalIndex + localIndex < haystack.length()
                        && haystack.charAt(globalIndex + localIndex) == needle.charAt(localIndex)) {
                    localIndex++;
                } else {
                    break;
                }
            }

            if (localIndex == needle.length()) {
                return globalIndex;
            } else {
                globalIndex++;
                localIndex = 0;
            }
        }

        return -1;
    }
}
