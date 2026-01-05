package day2;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
Solution2 s=new Solution2();
s.solution(3);
}
	List<int[]> answerList=new ArrayList<int[]>();
	
	//맨바닥을 목표에다 옮기고,
	//나머지를 나머지에다 옮긴다?
	//나머지를 빈곳에도 옮기고, 1개를 목적지에다 옮기고, 나머지를 목적지에다 옮긴다.
	public int[][] solution(int n){
		hanoi(n,1,3);
		int answer[][]=new int[answerList.size()][];
		for(int i=0; i<answerList.size(); i++) {
			answer[i]=answerList.get(i);
		}
		return answer;
	}
	
	public void hanoi(int n, int start , int end) {
		
		if(n==1) {
			System.out.println(start+"->"+end);
			answerList.add(new int[] {start,end});
			return;
		}
		//출발지 1, 2, 3
		//처음 start -> end가 주어지면 ,나머지를 6-start-end로 구할 수 있다.
		int remain=6-start-end;
		
		hanoi(n-1, start, remain);
		


		hanoi(1, start, end);
		


		hanoi(n-1, remain, end);
	}
}
