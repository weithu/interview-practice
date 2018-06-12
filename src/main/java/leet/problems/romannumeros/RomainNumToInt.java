package leet.problems.romannumeros;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RomainNumToInt {
    /**
     *
     * Given a roman numeral, convert it to an integer.
     *
     * Input is guaranteed to be within the range from 1 to 3999.
     *
     *
     * I - 1
     V - 5
     X - 10
     L - 50
     C - 100
     D - 500
     M - 1000
     */
    public int romanToInt(String s) {
        Map<Character, Integer> rVal = new HashMap<>();
        rVal.put('I', 1);
        rVal.put('V', 5);
        rVal.put('X', 10);
        rVal.put('L', 50);
        rVal.put('C', 100);
        rVal.put('D', 500);
        rVal.put('M', 1000);

        char[] c = s.toCharArray();
        int prevVal = -1;
        int total = 0;
        for(int i = c.length-1; i>=0; i--){
            //System.out.println("total="+total);

            int ci =  rVal.get(c[i]);
            System.out.print(ci);
            if(prevVal == -1){
                prevVal = ci;
                total = ci;
            }
            else{
                if(prevVal > ci){ //XIV = 14
                    System.out.print('-');
                    total -= ci;
                    prevVal = ci;
                }
                else if(prevVal <= ci){
                    System.out.print('+');
                    total += ci;
                    prevVal = ci;
                }
            }

        }
        return total;
    }

    @Test
    public void test1996(){

        RomainNumToInt r = new RomainNumToInt();
        assertEquals(r.romanToInt("MCMXCVI"), 1996);
    }

    @Test
    public void test30(){
        RomainNumToInt r = new RomainNumToInt();
        assertEquals(r.romanToInt("XXX"), 30);
    }

    @Test
    public void test4(){
        RomainNumToInt r = new RomainNumToInt();
        assertEquals(r.romanToInt("IV"), 4);
    }

}
