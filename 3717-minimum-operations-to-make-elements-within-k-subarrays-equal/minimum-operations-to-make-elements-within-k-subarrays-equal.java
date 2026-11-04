import java.util.*;
class Solution {
    TreeMap<Integer, Integer> left = new TreeMap<>();
    TreeMap<Integer, Integer> right = new TreeMap<>();
    int leftSize = 0, rightSize = 0;
    long leftSum = 0, rightSum = 0;
    void add(int num) {
        if (left.isEmpty() || num <= left.lastKey()) 
        {
            left.put(num, left.getOrDefault(num, 0) + 1);
            leftSize++;
            leftSum += num;
        } 
        else 
        {
            right.put(num, right.getOrDefault(num, 0) + 1);
            rightSize++;
            rightSum += num;
        }
        balance();
    }
    void remove(int num) {
        if (left.containsKey(num)) 
        {
            removeValue(left, num);
            leftSize--;
            leftSum -= num;
        } 
        else 
        {
            removeValue(right, num);
            rightSize--;
            rightSum -= num;
        }
        balance();
    }
    void removeValue(TreeMap<Integer, Integer> map, int num) 
    {
        int count = map.get(num);
        if (count == 1) 
        {
            map.remove(num);
        } 
        else 
        {
            map.put(num, count - 1);
        }
    }
    void balance() 
    {
        int total = leftSize + rightSize;
        int target = (total + 1) / 2;
        while (leftSize > target) 
        {
            int val = left.lastKey();
            removeValue(left, val);
            leftSize--;
            leftSum -= val;
            right.put(val, right.getOrDefault(val, 0) + 1);
            rightSize++;
            rightSum += val;
        }
        while (leftSize < target) 
        {
            int val = right.firstKey();
            removeValue(right, val);
            rightSize--;
            rightSum -= val;
            left.put(val, left.getOrDefault(val, 0) + 1);
            leftSize++;
            leftSum += val;
        }
    }
    long getCost() 
    {
        long median = left.lastKey();
        return median * leftSize - leftSum
             + rightSum - median * rightSize;
    }
    public long minOperations(int[] nums, int x, int k) 
    {
        int n = nums.length;
        int m = n - x + 1;
        long[] cost = new long[m];
        for (int i = 0; i < x; i++) 
        {
            add(nums[i]);
        }
        cost[0] = getCost();
        for (int i = x; i < n; i++) 
        {
            remove(nums[i - x]);
            add(nums[i]);
            cost[i - x + 1] = getCost();
        }
        long INF = Long.MAX_VALUE / 2;
        long[][] dp = new long[k + 1][n + 1];
        for (int i = 0; i <= k; i++) 
        {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j <= k; j++) 
            {
                if (dp[j][i] == INF) 
                {
                    continue;
                }
                dp[j][i + 1] = Math.min(dp[j][i + 1],dp[j][i]);
                if (j < k && i + x <= n) 
                {
                    dp[j + 1][i + x] = Math.min(dp[j + 1][i + x],dp[j][i] + cost[i]);
                }
            }
        }
        return dp[k][n];
    }
}
