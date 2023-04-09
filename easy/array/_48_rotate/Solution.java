package easy.array._48_rotate;
class Solution { // 旋转图像
    public void rotate(int[][] matrix) {

        /*
         * 2022-10-03 18:18:36
         * 0 ms (100.00%)
         * 40 MB (83.18%)
         */

        int nN = matrix.length;

        for (int layer = 0; layer < nN / 2; layer++) {
            int layer_row_min = layer;
            int layer_row_max = nN - layer - 1;

            int layer_col_min = layer;
            int layer_col_max = nN - layer - 1;

            for (int order = 0; order < nN - 1 - 2 * layer; order++) {
                int upRow = layer_row_min;
                int upCol = layer_col_min + order;

                int rightRow = layer_row_min + order;
                int rightCol = layer_col_max;

                int bottomRow = layer_row_max;
                int bottomCol = layer_col_max - order;

                int leftRow = layer_row_max - order;
                int leftCol = layer_col_min;

                int a = matrix[upRow][upCol];

                int b = matrix[rightRow][rightCol];
                matrix[rightRow][rightCol] = a;
                a = b;

                b = matrix[bottomRow][bottomCol];
                matrix[bottomRow][bottomCol] = a;
                a = b;

                b = matrix[leftRow][leftCol];
                matrix[leftRow][leftCol] = a;
                a = b;

                b = matrix[upRow][upCol];
                matrix[upRow][upCol] = a;
                a = b;

            }
        }

    }
}
