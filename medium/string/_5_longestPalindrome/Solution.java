package medium.string._5_longestPalindrome;

class Solution {
    public String longestPalindrome(String s) {
        // pre check
        if (s == null) {
            return null;
        }

        if (s.isEmpty()) {
            return "";
        }

        //
        String result = "";

        // centerLeft, centerRight
        int centerLeft = 0;
        int centerRight = 0;

        int radius = 0;

        while (true) {
            int pioneerLeft = centerLeft - radius;
            int pioneerRight = centerRight + radius;

            if (pioneerLeft < 0 || pioneerRight >= s.length() || s.charAt(pioneerLeft) != s.charAt(pioneerRight)) {
                int l = (radius - 1) * 2 + (centerLeft == centerRight ? 1 : 2);
                if (l > result.length()) {
                    result = s.substring(centerLeft - radius + 1, centerRight + radius);
                }

                // update
                if (centerLeft == centerRight) {
                    if (centerRight + 1 <= s.length() - 1) {
                        centerRight++;
                    } else {
                        break;
                    }
                } else {
                    centerLeft = centerRight;
                }

                radius = 0;
            } else {
                radius++;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.longestPalindrome("cbbd"));
    }
}
