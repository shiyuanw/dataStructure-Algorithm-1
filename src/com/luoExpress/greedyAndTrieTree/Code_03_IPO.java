package com.luoExpress.greedyAndTrieTree;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_03_IPO {

	public static class Node {
		public int p;
		public int c;

		public Node(int p, int c) {
			this.p = p;
			this.c = c;
		}
	}

	public static class MinCostComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			return o1.c - o2.c;
		}

	}

	public static class MaxProfitComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			return o2.p - o1.p;
		}

	}
	//把所有的项目准备好
	public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		Node[] nodes = new Node[Profits.length];
		for (int i = 0; i < Profits.length; i++) {
			nodes[i] = new Node(Profits[i], Capital[i]);
		}
		//按花费小的堆
		PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
		//按利润大的堆
		PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
		for (int i = 0; i < nodes.length; i++) {//把所有的项目都加到小根堆中
			minCostQ.add(nodes[i]);
		}
		for (int i = 0; i < k; i++) {
			while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {//小根堆的堆顶项目可以被解锁
				maxProfitQ.add(minCostQ.poll());//放进大根堆
			}
			if (maxProfitQ.isEmpty()) {
				return W;//最终返回的资金
			}
			W += maxProfitQ.poll().p;//做掉了一个项目后的资金
		}
		return W;
	}

}
