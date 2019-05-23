package com.luoExpress.stackandQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code_03_StackAndQueueConvert {

	public static class TwoStacksQueue {
		private Stack<Integer> stackPush;
		private Stack<Integer> stackPop;

		public TwoStacksQueue() {
			stackPush = new Stack<Integer>();
			stackPop = new Stack<Integer>();
		}

		public void push(int pushInt) {
			stackPush.push(pushInt);
		}

		public int poll() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (stackPop.empty()) {//只有在pop栈中没有东西的情况下，push栈才可以往里倒元素
				while (!stackPush.empty()) {//保证pushstack中每次倒出元素的时候，要倒完
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.pop();
		}

		public int peek() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (stackPop.empty()) {
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.peek();
		}
	}

	public static class TwoQueuesStack {
		private Queue<Integer> data;
		private Queue<Integer> help;

		public TwoQueuesStack() {
			data = new LinkedList<Integer>();
			help = new LinkedList<Integer>();
		}
		//数据进永远只进data队列
		public void push(int pushInt) {
			data.add(pushInt);
		}

		public int peek() {
			if (data.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while (data.size() != 1) {
				help.add(data.poll());
			}
			int res = data.poll();
			help.add(res);
			swap();
			return res;
		}

		public int pop() {
			if (data.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while (data.size() > 1) {
				help.add(data.poll());
			}
			int res = data.poll();
			swap();
			return res;
		}
		//改变队列的引用
		private void swap() {
			Queue<Integer> tmp = help;
			help = data;
			data = tmp;
		}

	}

}
