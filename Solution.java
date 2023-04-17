import java.util.HashSet;
import java.util.Set;

class temp {

    public String fun(String s) {

        Set<Character> unique = new HashSet<>();
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (!unique.contains(s.charAt(i))) {
                int l = unique.size() + 1;
                unique.add(s.charAt(i));

                if (l > result.length()) {
                    result = s.substring(i - unique.size(), i);
                }
            } else {
                for (int j = i - unique.size(); j < i; j++) {
                    if (s.charAt(j) == s.charAt(i)) {
                        unique.remove(s.charAt(j));
                        break;
                    } else {
                        unique.remove(s.charAt(j));
                    }
                }
            }
        }
        return result;
    }
}
