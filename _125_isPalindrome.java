class _125_isPalindrome {
    public boolean isPalindrome(String s) {

        /*
         * 2 ms (96.48%)
         * 41.4 MB (70.12%)
         */
        int slow = 0;
        int fast = 0;
        char[] charArray = s.toLowerCase().toCharArray();

        while (fast < charArray.length) {
            if (('a' <= charArray[fast] && charArray[fast] <= 'z')
                    || ('0' <= charArray[fast] && charArray[fast] <= '9')) {
                charArray[slow] = charArray[fast];

                slow++;
                fast++;
            } else {
                fast++;
            }
        }

        int length = slow;
        for (int i = 0; i < length / 2; i++) {
            if (charArray[i] != charArray[length - 1 - i]) {
                return false;
            }
        }
        return true;

    }
}
