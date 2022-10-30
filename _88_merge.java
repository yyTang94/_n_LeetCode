class _88_merge {
    /*
     * 2022-10-26 21:16:35 -> 2022-10-26 21:57:00
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] merged = nums1;
        int mergeAt = m + n - 1;

        int pos1 = m - 1;
        int pos2 = n - 1;

        while (pos1 != -1 || pos2 != -1) {
            if (pos1 == -1) {
                while (pos2 != -1) {
                    merged[mergeAt] = nums2[pos2];
                    mergeAt--;
                    pos2--;
                }
            } else if (pos2 == -1) {
                while (pos1 != -1) {
                    merged[mergeAt] = nums1[pos1];
                    mergeAt--;
                    pos1--;
                }
            } else {
                if (nums1[pos1] > nums2[pos2]) {
                    merged[mergeAt] = nums1[pos1];
                    mergeAt--;
                    pos1--;
                } else {
                    merged[mergeAt] = nums2[pos2];
                    mergeAt--;
                    pos2--;
                }
            }
        }

    }
}
