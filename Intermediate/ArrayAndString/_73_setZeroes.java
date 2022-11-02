class _73_setZeroes {
    public void setZeroes(int[][] matrix) {
        // pre check
        if (matrix == null) {
            return;
        }

        // first line
        boolean firstLineHasZero = false;
        for (int n : matrix[0]) {
            if (n == 0) {
                firstLineHasZero = true;
                break;
            }
        }

        //
        for (int i = 0; i < matrix.length; i++) {
            
        }

        return;

    }
}