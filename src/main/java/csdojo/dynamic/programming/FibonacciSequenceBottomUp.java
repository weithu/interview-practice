package csdojo.dynamic.programming;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FibonacciSequenceBottomUp {
    public int fib(int n){
        if(n <=2){
            return 1;
        }
        int[] cache = new int[n+1];
        cache[1]=1;
        cache[2]=1;
        for(int i=3; i<=n; i++){
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
    }

    private FibonacciSequenceBottomUp fs;
    @Before
    public void setUp(){
        fs = new FibonacciSequenceBottomUp();
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
