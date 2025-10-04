package 없는숫자더하기_86051;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public int solution(int numbers[]) {
		Set<Integer> sets=new HashSet<Integer>();
		
		for(int i=0; i<=9; i++) {
			sets.add(i);
		}
		
		for(int i=0; i<numbers.length; i++) {
			int n=numbers[i];
			sets.remove(Integer.valueOf(n));
		}
		int sum=0;
		for(int n : sets) {
			sum+=n;
		}
		return sum;
	}
}
