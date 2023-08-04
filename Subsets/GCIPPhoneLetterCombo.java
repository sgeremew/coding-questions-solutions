import java.util.*;

public class Main{
    /*

mapping= {2:abc, 3:def, 4:ghi, 5:jkl, 6:mno, 7:pqrs, 8:tuv, 9:wxyz}

num=23
result= ad ae af bd be bf cd ce

abc def ghi

    adg
        adh
            adi
    aeg
        aeh
            aei
    afg
        afh
            afi
    bdg
        bdh
            bdi


    fix len-1 nodes and loop node[len-1] to get permutations
    move len-2 over one and loop node[len-1] to get permuatiotns

    */

    // phone number mappings
    Map<Integer, String> phoneLetters = new HashMap<>();


    public List<String> letterCombinations(String digits){
        //initialize phone number mappings
        phoneLetters.put(2, "abc");
        phoneLetters.put(3, "def");
        phoneLetters.put(4, "ghi");
        phoneLetters.put(5, "jkl");
        phoneLetters.put(6, "mno");
        phoneLetters.put(7, "pqrs");
        phoneLetters.put(8, "tuv");
        phoneLetters.put(9, "wxyz");


        List<String> combos = new ArrayList<>();

        String firstNum = phoneLetters.get(digits.charAt(0));
        for(int i = 0; i < firstNum.length(); i++) {
            combos.add(firstNum.charAt(i) + "");
        }
        // [ a , b , c ]


        return new ArrayList<>();
    }

    public void backtrack() {

        for(int i = 0; i < digits.length(); i++) {

            backtrack(i, digits, permutations);
        }

    }
}