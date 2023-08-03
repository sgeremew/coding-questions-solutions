import java.util.*;

public class SortColors {
    public static int[] sortColors (int[] colors) {

        // Replace this placeholder return statement with your code
        int low = 0, high = 1;
        int length = colors.length;

        while(low < length && colors[low] == 0) low++;
        while(high > -1 && colors[high] == 2) high--;

        int mid = low + 1;

        while (mid < high) {
            int color = colors[mid];

            if (color == 0) {
                swap(colors, mid, low);
                mid++;
                low++;
            } else if (color == 2) {
                swap(colors, mid, high);
                mid++;
                high--;
            }

            if (color == 1) c++;
        }
        return colors;
    }

    // swap elements at a and b
    public static void swap (int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }
}

/**

0s 1s and 2s

2  2
a  cb
======

0  1  0
   a  cb


=====
1  2  0  2  0  1  1  2  0  0
a  c                       b

1  0  0  2  0  1  1  2  0  2
a  c                       b

0  0  1  2  0  1  1  2  0  2
   a     c                 b

======
2  2  0  2  0  0  0  2  2  0
a  c                       b

2  0  0  2  0  0  0  2  2  2
a  c                       b

2  0  0  2  0  0  0  2  2  2
a  c                       b

0  2  0  2  0  0  0  2  2  2
a  c              b

if(list[c] == 0) {
    while(list[a] == 0) a++;
    int temp = list[a];
    list[a] = list[c];
    list[c] = temp;
} else if (list[c] == 2) {
    while(list[b] == 2) b--;
    int temp = list[b];
    list[b] = list[c];
    list[c] = temp;
}

if (lsit[c] == 1)
    c++;



*/