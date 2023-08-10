import java.util.*;
public class GasStations{

/*
	gas=	1  2  3  4  5  
	cost=	5  5  5  1  2

	traverse and see what the starting index could be
		- must not result in a negative tank of gas

	tank = 0 initially; start=0
	0: (0+1) - 3 = -2 X; start=1
	1: (0+2) - 4 = -2 X; start=2
	2: (0+3) - 5 = -2 X; start=3
	3: (0+4) - 1 = 3 GOOD START
	4: (3+5) - 1 = 7

	why don't we have to traverse again from 0 -> start to check if this is a good start?
	because we already determined that there is enough gas in the total network to do so!

	return start if you can else return -1

*/


	public static int gasStationJourney(int[] gas, int[] cost) {
		int totalCost = 0, totalGas = 0;
		for(int i = 0; i < gas.length; i++) {
			totalGas+=gas[i];
			totalCost+=cost[i];
		}
		if(totalCost > totalGas) return -1;


		int tank = 0;
		int start = 0;

		for(int i = 0; i < gas.length; i++) {
			tank += gas[i] - cost[i];

			if(tank < 0) {
				start = i + 1;
				tank = 0;
			}
		}


		return tank > -1 ? start : -1;
	}
}







































import java.util.*;
public class GasStations{
   public static int gasStationJourney(int[] gas, int[] cost) {
      int N = gas.length;

      // if total cost > total gas then no journey can finish
      int gasSum = 0, costSum = 0;
      for(int i = 0; i < N; i++) {
         gasSum += gas[i];
         costSum += cost[i];
      }

      if(costSum > gasSum) return -1;


      int tank = 0;
      int start = 0;

      for(int i = 0; i < N; i++) {
         
         tank += (gas[i] - cost[i]);

         if(tank < 0) {
            tank = 0;
            start = i + 1;
         } 

      }

      return start;
   }
}