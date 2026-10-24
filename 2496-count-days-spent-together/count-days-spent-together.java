class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {
        int aStart = dayOfYear(arriveAlice);
        int aEnd = dayOfYear(leaveAlice);
        int bStart = dayOfYear(arriveBob);
        int bEnd = dayOfYear(leaveBob);
        int start = Math.max(aStart, bStart);
        int end = Math.min(aEnd, bEnd);
        return Math.max(0, end - start + 1);
    }
    private int dayOfYear(String date) 
    {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        int total = day;
        for (int i = 0; i < month - 1; i++) 
        {
            total += days[i];
        }
        return total;
    }
}