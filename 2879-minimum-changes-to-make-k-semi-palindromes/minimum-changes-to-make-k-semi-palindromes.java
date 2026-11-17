class Solution {
    public int minimumChanges(String s, int k) {
        int n=s.length();
        int[][] cost=new int[n][n];
        for (int i=0;i<n;i++) 
        {
            for (int j = i + 1; j < n; j++) 
            {
                int len=j-i+1;
                int min=n;
                for (int d=1;d<len;d++) 
                {
                    if (len%d==0) 
                    {
                        int changes = 0;
                        for (int x = 0; x < d; x++) 
                        {
                            int left=i+x;
                            int right=j-d+1+x;
                            while (left < right) 
                            {
                                if (s.charAt(left)!=s.charAt(right)) 
                                {
                                    changes++;
                                }
                                left+=d;
                                right-=d;
                            }
                        }
                        min= Math.min(min, changes);
                    }
                }

                cost[i][j]=min;
            }
        }
        int[][] dp=new int[n+1][k+1];

        for (int i=0; i<=n;i++) 
        {
            java.util.Arrays.fill(dp[i], 1000);
        }
        dp[n][0]=0;
        for (int i=n-1;i>=0;i--) 
        {
            for (int j=1;j<=k;j++) 
            {
                for (int l=i+1;l<n;l++) 
                {
                    dp[i][j] = Math.min(
                        dp[i][j],
                        cost[i][l]+dp[l + 1][j - 1]
                    );
                }
            }
        }
        return dp[0][k];
    }
}
