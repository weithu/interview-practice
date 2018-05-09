package leet.articles.stackqueue;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class StackQueue {
    /**
     * Implement the following operations of a queue using stacks.

     push(x) -- Push element x to the back of queue.
     pop() -- Removes the element from in front of queue.
     peek() -- Get the front element.
     empty() -- Return whether the queue is empty.
     Notes:
     You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
     Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
     You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

     */

    private int front;
    private Stack<Integer> s;
    private Stack<Integer> s0;
    public StackQueue(){
        front = -1;
        s = new Stack<Integer>();
        s0 = new Stack<Integer>();
    }

    public void push(int x){
        if(s.isEmpty()){
            s.push(x);
            front = x;
        }else{
            //first pop all from stack
            s0 = new Stack<Integer>();
            while(!s.isEmpty()){
                s0.push(s.pop());
            }

            //push the new element
            s.push(x);

            //push all back to the stack
            while(!s0.isEmpty()){
                s.push(s0.pop());
            }
        }
    }
    public int pop(){
        front = s.peek();
        return s.pop();
    }
    public int peek(){
        return s.peek();
    }

    public boolean isEmpty(){
        return s.isEmpty();
    }

    @Test
    public void testFIFO(){
        StackQueue sq = new StackQueue();
        sq.push(1);
        sq.push(2);
        sq.push(3);
        Assert.assertEquals(sq.pop(), 1);
        Assert.assertEquals(sq.pop(), 2);
        Assert.assertEquals(sq.pop(), 3);
    }

    @Test
    public void testPeek(){
        StackQueue sq = new StackQueue();
        sq.push(1);
        sq.push(2);
        sq.push(3);
        Assert.assertEquals(sq.peek(), 1);
        Assert.assertEquals(sq.pop(), 1);
        Assert.assertEquals(sq.peek(), 2);

        sq.push(7);
        Assert.assertEquals(sq.peek(), 2);
    }

    @Test
    public void testEmpty(){
        StackQueue sq = new StackQueue();
        Assert.assertTrue(sq.isEmpty());
        sq.push(1);
        sq.push(2);
        sq.push(3);
        Assert.assertFalse(sq.isEmpty());
        sq.pop();
        sq.pop();
        sq.pop();
        Assert.assertTrue(sq.isEmpty());
    }
}
