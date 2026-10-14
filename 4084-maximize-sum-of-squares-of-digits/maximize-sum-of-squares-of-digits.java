class Solution {
    public String maxSumOfSquares(int num, int sum) 
    {
        if (sum > 9 * num) 
        {
            return "";
        }
        int q = sum / 9;
        int r = sum % 9;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) 
        {
            sb.append('9');
        }
        if (r > 0) 
        {
            sb.append(r);
        }
        while (sb.length() < num) 
        {
            sb.append('0');
        }
        return sb.toString();
    }
}