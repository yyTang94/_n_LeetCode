package _278_firstBadVersion;
class VersionControl {
    boolean isBadVersion(int version) {
        return false;
    }
}

public class Solution extends VersionControl {
    /*
     * 2022-10-26 22:03:08 ->
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (true) {
            int mid = (left - 1) + (right - left + 1) / 2 + 1;
            int peer = mid - 1;

            boolean midFlag = isBadVersion(mid);
            boolean peerFlag = isBadVersion(peer);

            if (midFlag && !peerFlag) {
                return mid;
            } else {
                if (midFlag && peerFlag) {
                    right = peer;
                } else if (!midFlag && !peerFlag) {
                    left = mid;
                }
            }
        }
    }
}
