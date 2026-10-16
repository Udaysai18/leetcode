class Solution {
    static final int MOD = 1_000_000_007;
    class SegmentTree 
    {
        long[] sum;
        long[] sqSum;
        long[] lazy;
        int n;
        SegmentTree(int n) 
        {
            this.n = n;
            sum = new long[4 * n];
            sqSum = new long[4 * n];
            lazy = new long[4 * n];
        }
        void apply(int idx, int l, int r, long v) 
        {
            int len = r - l + 1;
            sqSum[idx] = (sqSum[idx]
                    + 2L * v % MOD * sum[idx] % MOD
                    + v * v % MOD * len) % MOD;
            sum[idx] = (sum[idx] + v * len) % MOD;
            lazy[idx] = (lazy[idx] + v) % MOD;
        }
        void push(int idx, int l, int r) 
        {
            if (lazy[idx] == 0) return;
            int mid = (l + r) >> 1;
            apply(idx * 2, l, mid, lazy[idx]);
            apply(idx * 2 + 1, mid + 1, r, lazy[idx]);
            lazy[idx] = 0;
        }
        void update(int idx, int l, int r, int ql, int qr) 
        {
            if (ql > r || qr < l)
            {
                return;
            }
            if (ql <= l && r <= qr) 
            {
                apply(idx, l, r, 1);
                return;
            }
            push(idx, l, r);
            int mid = (l + r) >> 1;
            update(idx * 2, l, mid, ql, qr);
            update(idx * 2 + 1, mid + 1, r, ql, qr);
            sum[idx] = (sum[idx * 2] + sum[idx * 2 + 1]) % MOD;
            sqSum[idx] = (sqSum[idx * 2] + sqSum[idx * 2 + 1]) % MOD;
        }
        void update(int l, int r) 
        {
            update(1, 0, n - 1, l, r);
        }
        long getSqSum() {
            return sqSum[1];
        }
    }
    public int sumCounts(int[] nums) 
    {
        int n = nums.length;
        SegmentTree st = new SegmentTree(n);
        Map<Integer, Integer> last = new HashMap<>();
        long ans = 0;
        for (int r = 0; r < n; r++) 
        {
            int l = last.getOrDefault(nums[r], -1) + 1;
            st.update(l, r);
            last.put(nums[r], r);
            ans = (ans + st.getSqSum()) % MOD;
        }
        return (int) ans;
    }
}