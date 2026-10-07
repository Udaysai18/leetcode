class Solution {
    public int majorityElement(int[] nums) {
        int r = 0;
        int count = 0;
        for(int num : nums)
        {
            if(count==0)
            {
                r = num;
                count = 1;
            }
            else
            {
                if(num == r)
                {
                    count = count + 1;
                }
                else
                {
                    count = count - 1;
                }
            }
        }
        return r;
    }
}