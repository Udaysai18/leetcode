class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        String a = "";
        int b = 0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i) == '(')
            {
                if(b>0)
                {
                    a = a + "(";
                }
                b++;
            }
            else
            {
                b--;
                if(b>0)
                {
                    a = a+")";
                }
            }
        }
        return a;
    }
}