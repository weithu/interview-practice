package csdojo.dynamic.programming;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciSequenceMem {

    public int fib(int n, int[] mem){

        if(mem[n] != 0){
            return mem[n];
        }

        int result;
        if(n<3){
            mem[n] = 1;
            result = 1;
        } else {
            result = fib(n-1, mem) + fib(n-2, mem);
            mem[n] = result;
        }
        return result;
    }
    private FibonacciSequenceMem fs;
    @Before
    public void setUp(){
        fs = new FibonacciSequenceMem();
    }

    @Test
    public void testFib1(){
        assertEquals(fs.fib(1, new int[26]), 1);
    }
    @Test
    public void testFib2(){
        assertEquals(fs.fib(2, new int[26]), 1);
    }
    @Test
    public void testFib3(){
        assertEquals(fs.fib(3, new int[26]), 2);
    }
    @Test
    public void testFib4(){
        assertEquals(fs.fib(4, new int[26]), 3);
    }
    @Test
    public void testFib10(){
        assertEquals(fs.fib(10, new int[26]), 55);
    }
    @Test
    public void testFib20(){
        assertEquals(fs.fib(20, new int[26]), 6765);
    }
}
