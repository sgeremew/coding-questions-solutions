// Palantir Interview
// 2022 and 2023
//
// Based on 2048 game
// swipeLeft method
// combine same numbers
// shift everything left
// 0's are empty

class SwipeLeft {
    //[2,2,2,2] --> [4,4,0,0]
    //[2,0,2,0] --> [4,0,0,0]
    //[4,0,0,4] --> [8,0,0,0]
    //[0,2,4,2] --> [2,4,2,0]
    
    static int[] swipeLeft(int[] row) {
        //s==e || row[e] == 0
        //  e++
        //row[s] == 0
        //  row[s] = row[e];
        //  row[e] = 0;
        //  e++
        //row[s] == row[e]
        //  row[s] += row[e]
        //  row[e] = 0;
        //  s++,e++
        //else
        //  s++

        int start = 0, end = 0;
        
        for(; end < row.length; end++) {
            // String arrStr = arrayToString(row);
            // System.out.printf("row: %s | start:%d end:%d\n", arrStr, start, end);
            if(start == end || row[end] == 0){
              continue;   
            }
            if(row[start] == 0) {
                // slide
                row[start] = row[end];
                row[end] = 0;
            } else if(row[start] == row[end]){
                // combine
                row[start] += row[end];
                row[end] = 0;
                start++;
            } else {
                start++;
                end--;
            }
        }
        return row;
    }
    
    static String arrayToString(int[] arr) {
        String str = "[";
        for(int i = 0; i < arr.length; i++) {
            if(i != arr.length - 1)
                str += arr[i] + ",";
            else
                str += arr[i];
        }
        str += "]";
        return str;
    }
    
    public static void main(String[] args) {
        //[2,2,2,2] --> [4,4,0,0]
        int[] test1 = new int[]{2,2,2,2};
        //[2,0,2,0] --> [4,0,0,0]
        int[] test2 = new int[]{2,0,2,0};
        //[4,0,0,4] --> [8,0,0,0]
        int[] test3 = new int[]{4,0,0,4};
        //[0,2,4,2] --> [2,4,2,0]
        int[] test4 = new int[]{0,2,4,2};
        
        System.out.println("test1\n" + arrayToString(swipeLeft(test1)));
        System.out.println("test2\n" + arrayToString(swipeLeft(test2)));
        System.out.println("test3\n" + arrayToString(swipeLeft(test3)));
        System.out.println("test4\n" + arrayToString(swipeLeft(test4)));
    }
}