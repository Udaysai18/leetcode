
import java.util.*;

class Solution {

    static final long MOD1 = 1000000007;
    static final long MOD2 = 1000000009;

    static final long BASE1 = 100003;
    static final long BASE2 = 100019;

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        long[] p1 = new long[n + 1];
        long[] p2 = new long[n + 1];

        long[] h1 = new long[n + 1];
        long[] h2 = new long[n + 1];

        p1[0] = 1;
        p2[0] = 1;

        for (int i = 0; i < n; i++) {

            p1[i + 1] = (p1[i] * BASE1) % MOD1;
            p2[i + 1] = (p2[i] * BASE2) % MOD2;

            h1[i + 1] = (h1[i] * BASE1 + nums[i]) % MOD1;
            h2[i + 1] = (h2[i] * BASE2 + nums[i]) % MOD2;
        }

        int low = 1;
        int high = n;
        int ans = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            HashMap<Long, Integer> map = new HashMap<>();

            for (int i = 0; i + mid <= n; i++) {

                long hash1 = (h1[i + mid]
                        - h1[i] * p1[mid] % MOD1 + MOD1) % MOD1;

                long hash2 = (h2[i + mid]
                        - h2[i] * p2[mid] % MOD2 + MOD2) % MOD2;

                long key = (hash1 << 32) | hash2;

                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            boolean found = false;

            for (int count : map.values()) {

                if (count == 1) {
                    found = true;
                    break;
                }
            }

            if (found) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
