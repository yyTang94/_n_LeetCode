package _70_climbStairs;
import java.util.concurrent.atomic.AtomicInteger;

class Solutioni {
    /*
     * 2022-10-27 21:11:53 -> 2022-10-27 21:46:22
     */
    private void climb(int n, AtomicInteger resultN, AtomicInteger resultN1) {

        // pre check
        if (n == 0) {
            resultN.set(0);
            resultN1.set(0);
            return;
        } else if (n == 1) {
            resultN.set(1);
            resultN1.set(0);
            return;
        } else if (n == 2) {
            resultN.set(2);
            resultN1.set(1);
            return;
        }

        AtomicInteger resultN2 = new AtomicInteger();
        climb(n - 1, resultN1, resultN2);

        resultN.set(resultN1.get() + resultN2.get());

    }

    public int climbStairs(int n) {

        AtomicInteger resultN = new AtomicInteger();
        AtomicInteger resultN1 = new AtomicInteger();
        climb(n, resultN, resultN1);

        return resultN.get();

    }
}
