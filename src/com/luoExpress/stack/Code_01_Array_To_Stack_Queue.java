package com.luoExpress.stack;

import java.util.Stack;

public class Code_01_Array_To_Stack_Queue {

	public static class ArrayStack {
		private Integer[] arr;
		private Integer size;

		public ArrayStack(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			size = 0;
		}

		public Integer peek() {
			if (size == 0) {
				return null;
			}
			return arr[size - 1];
		}

		public void push(int obj) {
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The stack is full");
			}
			arr[size++] = obj;
		}

		public Integer pop() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			return arr[--size];
		}
	}

	public static class ArrayQueue {
		private Integer[] arr;
		private Integer size;
		private Integer start;//需要拿去一个数，是把什么位置上的数拿取给用户
		private Integer end;//新添加一个变量，放到什么位置

		public ArrayQueue(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			size = 0;
			start = 0;
			end = 0;
		}

		public Integer peek() {
			if (size == 0) {
				return null;
			}
			return arr[start];
		}

		public void push(int obj) {
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			size++;
			arr[end] = obj;
			end = end == arr.length - 1 ? 0 : end + 1;
		}

		public Integer poll() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			size--;
			int tmp = start;
			start = start == arr.length - 1 ? 0 : start + 1;
			return arr[tmp];
		}
	}

	public static void main(String[] args) {

	}

}
