import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int n : nums1) 
        {
            set1.add(n);
        }
        Set<Integer> resultSet = new HashSet<>();
        for (int n : nums2) 
        {
            if (set1.contains(n)) 
            {
                resultSet.add(n);
            }
        }
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int n : resultSet)
        {
            result[i++] = n;
        }
        return result;
    }
}
