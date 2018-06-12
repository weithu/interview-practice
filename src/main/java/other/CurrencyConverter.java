package other;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class CurrencyConverter {

    /**
     * Warmup problem from SD JS Meetup 2018/04/25
     * Convert the given num into a currency with decimal places and commas
     * 123456 would convert to 1,234.56
     */
    public String convert(int num){
        Stack<String> s = new Stack<>();

        int currentNum = num;
        if(num < 0) currentNum *= -1;

        if(currentNum < 100){
            if(currentNum < 10){
                return "0.0" + String.valueOf(num);
            }else {
                return "0." + String.valueOf(num);
            }
        }
        int cents = currentNum%100;
        s.push("."+cents);
        currentNum /= 100;
        while(currentNum > 0){
            int block = currentNum%1000;
            if(currentNum >= 1000) {
                if (block < 10) {
                    s.push(",00" + block);
                }else if (block < 100){
                    s.push(",0" + block);
                }else{
                    s.push(","+block);
                }
            } else {
                s.push(String.valueOf(block));
            }
            currentNum /= 1000;


        }
        if(num < 0) s.push("-");
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pop());
        }

        return sb.toString();
    }

    private CurrencyConverter cc;

    @Before
    public void before(){
        cc = new CurrencyConverter();
    }

    @Test
    public void testSingleDigitCase(){
        assertEquals(this.cc.convert(9), "0.09");
    }

    @Test
    public void testTwoDigitCase(){
        assertEquals(this.cc.convert(99), "0.99");
    }

    @Test
    public void testBaseCase(){
        assertEquals(this.cc.convert(123456), "1,234.56");
    }

    @Test
    public void testBaseCaseNeg(){
        assertEquals(this.cc.convert(-123456), "-1,234.56");
    }

    @Test
    public void testLarger(){
        assertEquals(this.cc.convert(123456789), "1,234,567.89");
    }

    @Test
    public void testLargerZeroPadding(){
        assertEquals(this.cc.convert(102400789), "1,024,007.89");
    }
}
