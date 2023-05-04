class PerfectSquares {
	

	/**
	 * 
	 * This code is untested
	 * 
	 */ 

	// main function
    public int numSquares(int n) {
        // fill with squares under n
        List<Integer> squares = new ArrayList<Integer>();
        for(int i = 1; i < n + 1; i*i) {
            squares.add(i);
        }
        
        return minSquares(n, squares);
    }

    // n is the number and squares is the list of squares less than n
    public int minSquares(int n, List<Integer> squares) {
        if (n < 3) return n;
        if (n == squares.get(squares.size() - 1);

        int minNum = Integer.MAX_VALUE;

        // check each possible square... this will probably explode
        for(Integer square : squares) {
            int sum = minSquares(n - square) + 1;
            minNum = Math.min(minNum, sum);
        }

        return minNum;
    }
}