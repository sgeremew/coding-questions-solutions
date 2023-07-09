/*


variance is the largest difference between the number of occurrences of ANY 2 characters

given s return the largest variance possible among all substrings of s






s = aababbb

41-15 different substrings but some are duplicates

to calculate variance we need to know the count of every character that comes in or out
of the substring we are considering

sliding window that starts at first char
map that tracks char count

a  a  b  a  b  b  b
lr
map={a:1,}
subMax=1
subMin=1
var=subMax-subMin=0
maxVar=2

a  a  b  a  b  b  b
l  r
map={a:2,}
subMax=2
subMin=2
var=subMax-subMin=0
maxVar=2

a  a  b  a  b  b  b
l     r
map={a:2, b:1}
subMax=2
subMin=1
var=subMax-subMin=1
maxVar=2

a  a  b  a  b  b  b
l        r
map={a:3, b:1}
subMax=3
subMin=1
var=subMax-subMin=2
maxVar=2

// next step decreases variance so we slide window
// don't shrink window smaller than it needs to be
// var 2 is the current max and we need at least 4 chars for that
// so window will remain at least 4 chars
// so while window is > 4 shrink left side

a  a  b  a  b  b  b
   l        r
map={a:2, b:2}
subMax=2
subMin=2
var=subMax-subMin=0
maxVar=2

a  a  b  a  b  b  b
   l           r
map={a:2, b:3}
subMax=3
subMin=2
var=subMax-subMin=1
maxVar=2

a  a  b  a  b  b  b
   l              r
map={a:2, b:4}
subMax=4
subMin=2
var=subMax-subMin=2
maxVar=2

a  a  b  a  b  b  b
      l           r
map={a:1, b:4}
subMax=4
subMin=1
var=subMax-subMin=3
maxVar=3




*/


class Solution {
    public int largestVariance(String s) {


        
    }
}