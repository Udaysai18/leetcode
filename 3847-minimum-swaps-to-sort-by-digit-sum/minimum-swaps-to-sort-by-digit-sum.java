import java.util.*;
class Solution {
    public int minSwaps(int[] nums) 
    {
        int n = nums.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) 
        {
            arr[i][0] = digitSum(nums[i]);
            arr[i][1] = nums[i];
            arr[i][2] = i;
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int[] pos = new int[n];
        for (int i = 0; i < n; i++) 
        {
            pos[arr[i][2]] = i;
        }
        boolean[] vis = new boolean[n];
        int swaps = 0;
        for (int i = 0; i < n; i++) 
        {
            if (vis[i] || pos[i] == i) continue;
            int cycle = 0;
            int j = i;
            while (!vis[j]) 
            {
                vis[j] = true;
                j = pos[j];
                cycle++;
            }

            swaps += cycle - 1;
        }
        return swaps;
    }
    private int digitSum(int x) 
    {
        int sum = 0;
        while (x > 0) 
        {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}