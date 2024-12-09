import java.util.*;

public class Sog {

    public static boolean rec(long mid, long a[], long t) {
        long ans = 0;
        for (long c : a) {
            ans += mid / c;
            if (ans >= t) {  // Early exit if we already have enough
                return true;
            }
        }
        return ans >= t;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long t = sc.nextLong();
        long a[] = new long[n];
        long minTime = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            minTime = Math.min(minTime, a[i]);
        }

        long lo = 1;
        long hi = t * minTime;  // Upper bound: the slowest time to meet the target

        long ans = 0;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (rec(mid, a, t)) {
                ans = mid;  // Update 'ans' when condition is met
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(ans);
    }
}
