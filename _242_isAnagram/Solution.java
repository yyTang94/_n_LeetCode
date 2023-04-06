package _242_isAnagram;
import java.util.HashMap;
import java.util.Map;

class Solution { // 有效的字母异位词
    public boolean isAnagram(String s, String t) {
        /*
         * 2022-10-06 22:00:15 -> 2022-10-06 22:37:18
         * 16 ms (11.78%)
         * 41.9 MB (23.20%)
         */
        Map<Character, Integer> sM = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sM.put(s.charAt(i), sM.getOrDefault(s.charAt(i), 0) + 1);
        }

        Map<Character, Integer> tM = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tM.put(t.charAt(i), tM.getOrDefault(t.charAt(i), 0) + 1);
        }

        if (sM.size() != tM.size()) {
            return false;
        }

        for (Character c : sM.keySet()) {
            if (!sM.getOrDefault(c, 0).equals(tM.getOrDefault(c, 0))) {
                return false;
            }
        }

        for (Character c : tM.keySet()) {
            if (!sM.getOrDefault(c, 0).equals(tM.getOrDefault(c, 0))) {
                return false;
            }
        }

        return true;
    }
}
