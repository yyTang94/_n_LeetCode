class Solution {
    public int fun1(String s) {
        /*
         * 2022-10-06 21:35:51 -> 2022-10-06 21:51:40
         * 44 ms (5.19%)
         * 42.2 MB (10.25%)
         */

        for (int i = 0; i < s.length(); i++) {
            boolean isUnique = true;
            for (int j = 0; j < s.length(); j++) {
                if (i != j && s.charAt(j) == s.charAt(i)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                return i;
            }

        }

        return -1;
    }

    public int firstUniqChar(String s) {
        return fun1(s);
    }
}