import java.util.HashSet;
import java.util.Set;

class _3_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {

        /*
         * time: 5 ms (60.20%)
         * memory: 41.9 MB (17.89%)
         */

        int maxLength = 0;

        int start = 0;
        int length = 0;

        Set<Character> window = new HashSet<>();

        while ((start + length) < s.length()) {
            if (!window.contains(s.charAt(start + length))) {
                window.add(s.charAt(start + length));
                length++;
            } else {
                if (length == 0) {
                    start++;
                } else {
                    window.remove(s.charAt(start));
                    start++;
                    length--;

                }
            }
            if (length > maxLength) {
                maxLength = length;
            }
        }

        return maxLength;

    }
}
