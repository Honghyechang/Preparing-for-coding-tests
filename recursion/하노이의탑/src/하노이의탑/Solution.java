package 하노이의탑;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	static List<int[]> list =new ArrayList<int[]>();//배열은 객체
	

//	public static void main(String[] args) {
//		Solution s=new Solution();
//		s.solution(2);
//
//	}
//	
	public int[][] solution(int n){
	
		hanoi(n,1,3);
		
		int result[][]=new int[Solution.list.size()][];
		
		for(int i=0; i<Solution.list.size();i++) {
			result[i]=Solution.list.get(i);
			System.out.println(result[i][0]+","+result[i][1]);
			
		}
		return result;
		
	}
	
	public void hanoi(int n,int from, int to) {
		if(n==1) {
			Solution.list.add(new int[] {from,to});// [ [2,4] , [1.3] ... 	]
		}
		else {
			int empty=6-from-to;
			hanoi(n-1,from,empty);
			hanoi(1,from,to);
			hanoi(n-1,empty,to);
		}
	}

}
