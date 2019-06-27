package com.luoExpress.greedyAndTrieTree;



public class Code_01_TrieTree {

	public static class TrieNode {
		public int path;//有多少条路径到达过这个节点
		public int end;//有多少个字符串以这个节点为终点
		public TrieNode[] nexts;//可走的路

		public TrieNode() {
			path = 0;
			end = 0;
			nexts = new TrieNode[26];//强行规定小写字母a～z
		}
	}

	public static class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}


		public void insert(String word) {
			if (word == null) {
				return;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {//当前node有没有走向当前字母的路
					node.nexts[index] = new TrieNode();
				}
				node = node.nexts[index];
				node.path++;
			}
			node.end++;
		}

		public void delete(String word) {
			if (search(word) != 0) {
				char[] chs = word.toCharArray();
				TrieNode node = root;
				int index = 0;
				for (int i = 0; i < chs.length; i++) {
					index = chs[i] - 'a';
					if (--node.nexts[index].path == 0) {//当遇到0之后不需要继续向下遍历，直接删除之后的所有
						node.nexts[index] = null;
						return;
					}
					node = node.nexts[index];
				}
				node.end--;
			}
		}

		public int search(String word) {//查询某一个word出现了几次
			if (word == null) {
				return 0;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.end;
		}

		public int prefixNumber(String pre) {
			if (pre == null) {
				return 0;
			}
			char[] chs = pre.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.path;
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println(trie.search("dal"));
		trie.insert("dal");
		System.out.println(trie.search("dal"));
		trie.delete("dal");
		System.out.println(trie.search("dal"));
		trie.insert("dal");
		trie.insert("dal");
		trie.delete("dal");
		System.out.println(trie.search("dal"));
		trie.delete("dal");
		System.out.println(trie.search("dal"));
		trie.insert("dala");
		trie.insert("dalac");
		trie.insert("dalab");
		trie.insert("dalad");
		trie.delete("dala");
		System.out.println(trie.search("dala"));
		System.out.println(trie.prefixNumber("dal"));

	}

}
