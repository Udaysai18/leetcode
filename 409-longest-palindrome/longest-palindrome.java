
class Solution {
    public int longestPalindrome(String s) {
        String LPS = "";
        int[] freq = new int[128];
        for (int i = 0; i < s.length(); i++) 
        {
            freq[s.charAt(i)]++;
        }
        for (int i = 0; i < 128; i++) 
        {
            while (freq[i] >= 2) 
            {
                LPS += (char)i;
                freq[i] -= 2;
            }
        }
        int ans = LPS.length() * 2;
        for (int i = 0; i < 128; i++) 
        {
            if (freq[i] > 0) 
            {
                ans++;
                break;
            }
        }
        return ans;
    }
}
