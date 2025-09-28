package 하노이탑_12946;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	List<int[]> lists=new ArrayList<int[]>();
	

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//Solution s=new Solution();
//s.solution(2);
//	}
	
	public int[][] solution(int n){
		
		hanoitop(n,1,3);
		int answer[][]=new int[lists.size()][];
		for(int i=0; i<lists.size(); i++) {
			answer[i]=lists.get(i);
		}
		
		
		return answer;
	}
	
	public void hanoitop(int n,int from ,int to) {
		//from에서부터 to로 옮기는데,
		//맨 아래것을 제외한 나머지는 빈곳으로 옮기고,
		//맨 아래것을 from에서 to로 옮기고,
		//빈곳에서 -> to로 다 옮긴다.
		
		if(n==1) {
			//System.out.println(from+"->"+to);
			lists.add(new int[] {from,to});
			return;
		}
		
		
		int empty=6-from-to;
		
		hanoitop(n-1, from, empty);
		hanoitop(1, from, to);
		hanoitop(n-1, empty, to);
		
		
		
	}

}
