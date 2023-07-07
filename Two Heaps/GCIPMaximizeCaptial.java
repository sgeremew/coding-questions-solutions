import java.util.*;


/*

The goal is to maximize their cumulative capital by selecting a maximum of k distinct 
projects to invest in.

The investor’s current capital must be greater than or equal to the capital requirement 
of all selected projects.

The program should help the investor to make informed investment decisions by picking a 
list of a maximum of k distinct projects to maximize the final profit while mitigating 
the risk.



PSEUDO
min-heap: stores capital req per project with index
max-heap: stores profits per project

find project can afford with current capital

traverse capitals and add everything you can afford to min-heap and stop when you can't 
afford the project. add projfts to max-heap aswell as you go.

pick project with max profits

clear heaps

update max capital

repeat


*/


public class MaximizeCapital{
    public static int maximumCapital(int c, int k, int[] capitals, int[] profits) {
        int n = capitals.length;
        int currentCapital = c;
        PriorityQueue<int[]> CapitalminHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; ++i) {
            CapitalminHeap.offer(new int[] {capitals[i], i});
        }
        PriorityQueue<int[]> ProfitsmaxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int i = 0;
        while (i < k) {
            while (!CapitalminHeap.isEmpty() && CapitalminHeap.peek()[0] <= currentCapital) {
                int[] j = CapitalminHeap.poll();
                ProfitsmaxHeap.offer(new int[]{profits[j[1]], j[1]});
            }
            if (ProfitsmaxHeap.isEmpty()) {
                break;
            }
            int x = ProfitsmaxHeap.poll()[0];
            currentCapital += x;
            i++;
        }
        return currentCapital;
    }
}


