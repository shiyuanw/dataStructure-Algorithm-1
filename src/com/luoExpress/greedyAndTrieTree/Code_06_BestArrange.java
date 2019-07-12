package com.luoExpress.greedyAndTrieTree;

import java.util.Arrays;
import java.util.Comparator;

public class Code_06_BestArrange {

	public static class Program {
		public int start;
		public int end;

		public Program(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static class ProgramComparator implements Comparator<Program> {

		@Override
		public int compare(Program o1, Program o2) {//结束时间早的返回
			return o1.end - o2.end;
		}

	}

	public static int bestArrange(Program[] programs, int current) {//current当前时刻
		Arrays.sort(programs, new ProgramComparator());//按照结束时间早的排序所有的会议
		int result = 0;
		for (int i = 0; i < programs.length; i++) {
			if (current <= programs[i].start) {
				result++;
				current = programs[i].end;//不断推进当前时刻
			}
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
