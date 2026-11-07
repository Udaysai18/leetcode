import java.util.*;
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];
        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) -> a[0] != b[0]
                ? Integer.compare(a[0], b[0])
                : Integer.compare(a[1], b[1])
        );
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        for (int i = 0; i < n; i++) 
        {
            available.offer(new int[]{servers[i], i});
        }
        long time = 0;
        for (int i = 0; i < m; i++) 
        {
            time = Math.max(time, i);
            if (available.isEmpty()) 
            {
                time = Math.max(time, busy.peek()[0]);
            }
            while (!busy.isEmpty() && busy.peek()[0] <= time) 
            {
                int[] s = busy.poll();
                available.offer(new int[]{s[1], s[2]});
            }
            int[] server = available.poll();
            ans[i] = server[1];
            busy.offer(new int[]{
                (int)(time + tasks[i]),
                server[0],
                server[1]
            });
        }
        return ans;
    }
}
