package com.luoExpress.map;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Code_04_UnionFind {

	public static class Node {
		// whatever you like
	}

	public static class UnionFindSet {
		//参数中，第一个node指当前的node，第二个指其父节点是谁 key：child，value：father
		public HashMap<Node, Node> fatherMap;
		//某一个节点，它所在的集合一共有多少个节点
		public HashMap<Node, Integer> sizeMap;

		public UnionFindSet(List<Node> nodes) {
			makeSets(nodes);
		}

		public void makeSets(List<Node> nodes) {
			fatherMap = new HashMap<Node, Node>();
			sizeMap = new HashMap<Node, Integer>();
			for (Node node : nodes) {
				fatherMap.put(node, node);//每个node自己形成一个集合 代表节点
				sizeMap.put(node, 1);
			}
		}

		private Node findHead(Node node) {
			Stack<Node> stack = new Stack<>();
			Node cur = node;
			Node parent = fatherMap.get(cur);
			while (cur!=parent){
				stack.push(cur);
				cur = parent;
				parent = fatherMap.get(cur);
			}
			while (!stack.isEmpty()){
				fatherMap.put(stack.pop(),parent);
			}

			return parent;
			/*
			Node father = fatherMap.get(node);
			if (father != node) {
				father = findHead(father);
			}
			fatherMap.put(node, father);
			return father;
		*/

		}
		
		public boolean isSameSet(Node a, Node b) {
			return findHead(a) == findHead(b);
		}

		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aHead = findHead(a);
			Node bHead = findHead(b);
			if (aHead != bHead) {
				int aSetSize= sizeMap.get(aHead);
				int bSetSize = sizeMap.get(bHead);
				if (aSetSize <= bSetSize) {
					fatherMap.put(aHead, bHead);
					sizeMap.put(bHead, aSetSize + bSetSize);
				} else {
					fatherMap.put(bHead, aHead);
					sizeMap.put(aHead, aSetSize + bSetSize);
				}
			}
		}

	}

	public static void main(String[] args) {

	}

}
