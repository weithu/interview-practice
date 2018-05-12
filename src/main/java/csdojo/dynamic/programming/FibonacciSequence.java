package csdojo.dynamic.programming;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

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
        Assert.assertEquals(fs.fib(1), 1);
    }
    @Test
    public void testFib2(){
        Assert.assertEquals(fs.fib(2), 1);
    }
    @Test
    public void testFib3(){
        Assert.assertEquals(fs.fib(3), 2);
    }
    @Test
    public void testFib4(){
        Assert.assertEquals(fs.fib(4), 3);
    }
    @Test
    public void testFib10(){
        Assert.assertEquals(fs.fib(10), 55);
    }
    @Test
    public void testFib20(){
        Assert.assertEquals(fs.fib(20), 6765);
    }
}
