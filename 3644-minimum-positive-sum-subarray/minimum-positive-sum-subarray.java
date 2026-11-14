class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int ans=Integer.MAX_VALUE;
        int n=nums.size();
        for (int i=0; i<n; i++) 
        {
            int sum=0;
            for (int j=i;j<n;j++) 
            {
                sum += nums.get(j);
                int len=j - i + 1;
                if (len>=l && len<=r && sum>0) 
                {
                    ans=Math.min(ans, sum);
                }
            }
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}