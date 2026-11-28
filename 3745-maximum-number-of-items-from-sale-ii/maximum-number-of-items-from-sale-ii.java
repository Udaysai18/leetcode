import java.util.Arrays;
class Solution {
    public int maximumSaleItems(int[][] items, int budget) 
    {

        int n=items.length;
        int[] freq=new int[n+1];
        for (int i=0;i<n;i++) 
        {
            freq[items[i][0]]++;
        }
        int[] gain=new int[n + 1];
        for (int i=1;i<=n;i++) 
        {
            for (int j=i;j<=n;j+=i) 
            {
                gain[i]+=freq[j];
            }
            gain[i]--;
        }
        Arrays.sort(items,(a,b) ->
            Integer.compare(a[1],b[1])
        );
        int minPrice=items[0][1];
        long remaining=budget;
        long count=0;
        for (int i=0;i<n;i++) 
        {
            int factor=items[i][0];
            int price=items[i][1];
            if (price>2L*minPrice) 
            {
                break;
            }
            long buy=Math.min(
                remaining/price,
                gain[factor]
            );
            remaining-=buy*price;
            count+=buy*2;
        }
        count+=remaining / minPrice;
        return (int) count;
    }
}
