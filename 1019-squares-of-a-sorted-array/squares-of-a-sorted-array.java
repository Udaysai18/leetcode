class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            result[i]= nums[i]*nums[i];
        }
        int head = 0;
        int tail = nums.length-1;
        for(int pos=nums.length-1;pos>=0;pos--)
        {
            if(Math.abs(nums[head])>Math.abs(nums[tail]))
            {
                result[pos] = nums[head]*nums[head];
                head++;
            }
            else
            {
                result[pos] = nums[tail]*nums[tail];
                tail--;
            }
        }
        return result;
    }
}