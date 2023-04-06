package _66_plusOne;
class Solution { // 加一
    public int[] plusOne(int[] digits) {

        /*
         * 2022-10-03 16:27:50
         * 0 ms (100.00%)
         * 40.2 MB (11.69%)
         */

        boolean overflow = true;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                overflow = false;
                break;
            }
        }

        if (overflow) {
            int[] rslt = new int[digits.length + 1];
            for (int i = 0; i < rslt.length; i++) {
                rslt[i] = 0;
            }
            rslt[0] = 1;

            return rslt;
        } else {
            int[] rslt = new int[digits.length];

            boolean carry = true;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (carry) {
                    if (digits[i] == 9) {
                        rslt[i] = 0;
                        carry = true;
                    } else {
                        rslt[i] = digits[i] + 1;
                        carry = false;
                    }
                } else {
                    rslt[i] = digits[i];
                }
            }
            return rslt;
        }
    }
}
