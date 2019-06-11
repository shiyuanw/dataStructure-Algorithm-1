package com.luoExpress.listandTree;

public class Code_08_CompleteTreeNodeNumber {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static int nodeNum(Node head) {
		if (head == null) {
			return 0;
		}
		return bs(head, 1, mostLeftLevel(head, 1));
	}

	/**
	 *
	 * @param node 当前节点
	 * @param level 表示层数
	 * @param h 表示树的深度
	 * @return 以node为头节点的子树一共有多少个节点 常量
	 */
	public static int bs(Node node, int level, int h) {
		if (level == h) {
			return 1;
		}
		if (mostLeftLevel(node.right, level + 1) == h) {//右子树的左边界到了哪一层
			//2^(h - level) 左树的节点个数+当前节点之后的所有节点个数
			//当我的右子树的左边界碰到底了
			return (1 << (h - level)) + bs(node.right, level + 1, h);
		} else {//右子树的左边界没有到底 右树的高度比左树高度少1
			return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
		}
	}

	public static int mostLeftLevel(Node node, int level) {
		while (node != null) {
			level++;
			node = node.left;
		}
		return level - 1;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		System.out.println(nodeNum(head));

	}

}
