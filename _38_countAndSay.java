class _38_countAndSay {
    public String countAndSay(int n) {
        // pre check
        if (n == 1) {
            return "1";
        }

        // initial state: i = 2, toSay = "1"
        // end state: i=n+1, toSay = ?
        String toSay = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();

            int slow = 0;
            while (slow < toSay.length()) {
                int fast = slow;
                while (fast < toSay.length() && toSay.charAt(fast) == toSay.charAt(slow)) {
                    fast++;
                }

                sb.append(String.valueOf(fast - slow));
                sb.append(String.valueOf(toSay.charAt(slow)));

                slow = fast;
            }

            toSay = sb.toString();
        }

        return toSay;
    }

    public static void main(String[] args) {
        System.out.println("solution result: " + new _38_countAndSay().countAndSay(5));
    }
}
