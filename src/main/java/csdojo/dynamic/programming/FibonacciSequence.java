package csdojo.dynamic.programming;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciSequence {
    public int fib(int n){
        if(n==1 || n==2) return 1;
        else return fib(n-1)+ fib(n-2);
    }

    private FibonacciSequence fs;
    @Before
    public void setUp(){
        fs = new FibonacciSequence();
    }

    @Test
    public void testFib1(){
        assertEquals(fs.fib(1), 1);
    }
    @Test
    public void testFib2(){
        assertEquals(fs.fib(2), 1);
    }
    @Test
    public void testFib3(){
        assertEquals(fs.fib(3), 2);
    }
    @Test
    public void testFib4(){
        assertEquals(fs.fib(4), 3);
    }
    @Test
    public void testFib10(){
        assertEquals(fs.fib(10), 55);
    }
    @Test
    public void testFib20(){
        assertEquals(fs.fib(20), 6765);
    }
}
