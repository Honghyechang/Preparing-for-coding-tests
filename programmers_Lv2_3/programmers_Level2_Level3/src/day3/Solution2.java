package day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	
//	Solution2 s=new Solution2();
//	int n[]=s.solution(new int[] {5,0,2,7});
//	System.out.println(Arrays.toString(n));
//}
//	
	public int[] solution(int numbers[]) {

		collaboration(numbers,0,new int[2],0);
		List<Integer> answerList=new ArrayList<Integer>();
		for(int n : sets) {
			answerList.add(n);
		}
		
		int answer[]=answerList.stream()
						       .mapToInt(i->i.intValue())
						       .sorted()
						       .toArray();
		return answer;
		
		
	}
	Set<Integer> sets=new HashSet<Integer>();
	
	public void collaboration(int numbers[] , int selectIndex, int selectNumber[] , int start) {
		
		if(selectIndex==2) {
			sets.add(selectNumber[0]+selectNumber[1]);
			return;
		}
		
		for(int i=start; i<numbers.length; i++) {
			selectNumber[selectIndex]=numbers[i];
			collaboration(numbers,selectIndex+1,selectNumber,i+1);
		}
	}
}
