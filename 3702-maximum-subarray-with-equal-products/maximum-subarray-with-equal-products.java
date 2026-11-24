class Solution {
    public int maxLength(int[] nums) {
        int n=nums.length;
        int ans=0;
        for (int i=0;i<n;i++) {
            long product=1;
            long gcd=0;
            long lcm=1;
            for (int j=i; j<n;j++) {
                product*=nums[j];
                gcd=findGCD(gcd, nums[j]);
                lcm=(lcm*nums[j])/findGCD(lcm, nums[j]);
                if (product==gcd*lcm) 
                {
                    ans=Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
    public long findGCD(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
