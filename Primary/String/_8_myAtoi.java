import java.util.Arrays;

class _8_myAtoi { // 字符串转换整数 (atoi)
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

    private int seq2Int(int[] seq, boolean isNegative) {
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

    private int compareSeq(int[] aSeq, int[] bSeq) {
        int maxLength = Math.max(aSeq.length, bSeq.length);
        if (aSeq.length != maxLength) {
            int[] temp = new int[maxLength];
            Arrays.fill(temp, 0);
            for (int i = 0; i < aSeq.length; i++) {
                temp[maxLength - aSeq.length + i] = aSeq[i];
            }

            aSeq = temp;
        }

        if (bSeq.length != maxLength) {
            int[] temp = new int[maxLength];
            Arrays.fill(temp, 0);
            for (int i = 0; i < bSeq.length; i++) {
                temp[maxLength - bSeq.length + i] = bSeq[i];
            }

            bSeq = temp;
        }

        for (int i = 0; i < aSeq.length; i++) {
            if (aSeq[i] > bSeq[i]) {
                return 1;
            } else if (aSeq[i] < bSeq[i]) {
                return -1;
            }
        }

        return 0;
    }

    private int min32int() {
        int n = -1;
        for (int k = 0; k < 31; k++) {
            n = n * 2;
        }

        return n;
    }

    private int max32int() {
        int n = min32int();
        n = -(n + 1);
        return n;
    }

    public int myAtoi(String s) {

        /*
         * 2022-10-07 16:02:56 -> 2022-10-07 17:14:06
         * 2 ms (28.31%)
         * 41.4 MB (53.33%)
         */

        // 1
        int idx = 0;
        for (idx = 0; idx < s.length(); idx++) {
            if (s.charAt(idx) == ' ') {
                continue;
            } else {
                break;
            }
        }

        // 2
        if (idx == s.length()) {
            return 0;
        }

        boolean isNegative;
        if (s.charAt(idx) == '-') {
            isNegative = true;
            idx++;
        } else if (s.charAt(idx) == '+') {
            isNegative = false;
            idx++;
        } else {
            isNegative = false;
        }

        // 3
        int[] seq = new int[s.length()];
        int seqIdx = 0;
        for (; idx < s.length(); idx++) {
            if ('0' <= s.charAt(idx) && s.charAt(idx) <= '9') {
                seq[seqIdx] = Character.getNumericValue(s.charAt(idx));
                seqIdx++;
            } else {
                break;
            }
        }

        // 4
        if (seqIdx <= 0) {
            return 0;
        }

        seq = Arrays.copyOfRange(seq, 0, seqIdx);

        if (isNegative) {
            if (compareSeq(seq, int2seq(min32int())) == 1) {
                seq = int2seq(min32int());
            }
        } else {
            if (compareSeq(seq, int2seq(max32int())) == 1) {
                seq = int2seq(max32int());
            }
        }

        return seq2Int(seq, isNegative);
    }
}