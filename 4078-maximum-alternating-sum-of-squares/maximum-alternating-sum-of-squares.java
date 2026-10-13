class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squaredNums = new long[n];
        for(int i=0;i<n;i++)
        {
            squaredNums[i] = (long) nums[i] * nums[i];
        }     
        Arrays.sort(squaredNums);
        long sum = 0;
        int mid = n/2;
        for(int i=0;i<mid;i++)
        {
            sum -= squaredNums[i];
        }  
        for(int i=mid;i<n;i++)
        {
            sum += squaredNums[i];
        } 
        return sum;
    }
}