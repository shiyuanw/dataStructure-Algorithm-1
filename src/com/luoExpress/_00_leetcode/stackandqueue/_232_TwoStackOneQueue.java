package com.luoExpress._00_leetcode.stackandqueue;

import java.util.Stack;

public class _232_TwoStackOneQueue {
	private Stack<Integer> inStack;
	private Stack<Integer> outStack;

    /** Initialize your data structure here. */
    public _232_TwoStackOneQueue() {
    	inStack = new Stack<>();
    	outStack = new Stack<>();
    }
    
    /** 入队 offer */
    public void push(int x) {
        inStack.push(x);
    }
    
    /** 出队 poll*/
    public int pop() {
    	checkOutStack();
    	return outStack.pop();
    }
    
    /** 获取队头元素  font*/
    public int peek() {
    	checkOutStack();
    	return outStack.peek();
    }
    
    /** 是否为空 */
    public boolean empty() {
    	return inStack.isEmpty() && outStack.isEmpty();
    }
    
    private void checkOutStack() {
    	if (outStack.isEmpty()) {
        	while (!inStack.isEmpty()) {
        		outStack.push(inStack.pop());
        	}
        }
    }
}
