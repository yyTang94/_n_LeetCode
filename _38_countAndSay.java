class _38_countAndSay {
    public String countAndSay(int n) {
        String toSay = "1";
        int order = 2;
        while (order <= n) {
            StringBuilder sb = new StringBuilder();

            int slow = 0;
            int fast = slow;
            while (slow < toSay.length()) {
                while (fast < toSay.length() && toSay.charAt(fast) == toSay.charAt(slow)) {
                    fast++;
                }

                sb.append(String.valueOf(fast - slow));
                sb.append(String.valueOf(toSay.charAt(slow)));

                slow = fast;
            }

            toSay = sb.toString();
            order++;
        }

        return toSay;
    }

    public static void main(String[] args) {
        System.out.println("solution result: " + new _38_countAndSay().countAndSay(20));
    }
}
