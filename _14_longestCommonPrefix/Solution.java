package _14_longestCommonPrefix;

class Solution { // 最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        // pre-check
        if (strs == null || strs.length == 0) {
            return "";
        }

        // pick any string as
        String targetStr = strs[0];

        // same to which index in target string
        int sameTo = 0;
        while (sameTo < targetStr.length()) {
            // check each line in string array
            int checkLine = 0;
            while (checkLine < strs.length) {
                if (sameTo < strs[checkLine].length() && strs[checkLine].charAt(sameTo) == targetStr.charAt(sameTo)) {
                    checkLine++;
                } else {
                    break;
                }
            }

            // if ckeck all line successfully in string array, checkLine must be equal to
            // strs.length
            if (checkLine < strs.length) {
                break;
            } else {
                sameTo++;
            }
        }

        return sameTo == 0 ? "" : targetStr.substring(0, sameTo);
    }

    public static void main(String[] args) {
        String[] inp = { "abcd", "abef" };
        System.out.println("solution result: " + new Solution().longestCommonPrefix(inp));
    }
}