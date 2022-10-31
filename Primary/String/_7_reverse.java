class _7_reverse { // 整数反转
    private int[] int2seq(int x) {
        boolean isNegative;
        if (x < 0) {
            isNegative = true;
        } else {
            isNegative = false;
        }

        int length = 0;
        int y = x;
        while (y != 0) {
            length++;
            y = y / 10;
        }

        int[] seq = new int[length];
        int z = x;
        int i = length - 1;
        while (i >= 0) {
            seq[i] = z % 10;
            if (isNegative) {
                seq[i] = -seq[i];
            }
            z = z / 10;
            i--;
        }

        return seq;

    }

    public int reverse(int x) {
        /*
         * 2022-10-06 17:33:05
         * 1 ms (41.10%)
         * 38.7 MB (67.31%)
         */
        boolean isNegative;
        if (x < 0) {
            isNegative = true;
        } else {
            isNegative = false;
        }

        int[] seq = int2seq(x);

        for (int i = 0; i < seq.length / 2; i++) {
            int buf = seq[i];
            seq[i] = seq[seq.length - 1 - i];
            seq[seq.length - 1 - i] = buf;
        }

        int maxNum = -1;
        for (int k = 0; k < 31; k++) {
            maxNum = maxNum * 2;
        }

        int[] maxSeq;
        if (isNegative) {
            maxSeq = int2seq(maxNum);
        } else {
            maxNum++;
            maxNum = -maxNum;
            maxSeq = int2seq(maxNum);
        }

        boolean isOverflow = false;
        if (seq.length == maxSeq.length) {
            for (int i = 0; i < seq.length; i++) {
                if (seq[i] > maxSeq[i]) {
                    isOverflow = true;
                    break;
                } else if (seq[i] < maxSeq[i]) {
                    isOverflow = false;
                    break;
                }
            }
        }

        if (isOverflow) {
            return 0;
        } else {
            int rslt = 0;

            int i = seq.length - 1;
            int base = 1;
            while (i >= 0) {
                rslt += seq[i] * base;

                i--;
                base *= 10;
            }

            if (isNegative) {
                return -rslt;
            } else {
                return rslt;
            }

        }

    }

    public static void main(String[] args) {
        System.out.println("Hello World" + new _7_reverse().reverse(-2147483412));
    }
}
