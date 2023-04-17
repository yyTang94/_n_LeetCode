package other.dynamic._647_countSubstrings;

class Solution {
    /*
     * iter from right-bottom
     */
    public int countFromRightBottom(String s) {
        boolean[][] bpTable = new boolean[s.length()][s.length()];

        int rowNum = s.length();
        int colNum = s.length();

        int count = 0;

        for (int i = rowNum - 1; i >= 0; i--) {
            for (int j = i; j < colNum; j++) {
                bpTable[i][j] = false; // initialize
                if (i == j) {
                    bpTable[i][j] = true;
                    count++;
                } else if (i + 1 == j) {
                    if (s.charAt(i) == s.charAt(j)) {
                        bpTable[i][j] = true;
                        count++;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && bpTable[i + 1][j - 1]) {
                        bpTable[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /*
     * iter by diagonal
     */
    public int countByDiagonal(String s) {
        boolean[][] bpTable = new boolean[s.length()][s.length()];

        int count = 0;

        for (int d = 0; d < s.length(); d++) {
            for (int i = 0; i < s.length() - d; i++) {
                int j = i + d;
                bpTable[i][j] = false; // initialize
                if (i == j) {
                    bpTable[i][j] = true;
                    count++;
                } else if (i + 1 == j) {
                    if (s.charAt(i) == s.charAt(j)) {
                        bpTable[i][j] = true;
                        count++;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && bpTable[i + 1][j - 1]) {
                        bpTable[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int countSubstrings(String s) {
        return countByDiagonal(s);
    }
}
