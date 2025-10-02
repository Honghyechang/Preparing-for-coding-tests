package hIndex_42747;

import java.util.Arrays;

public class Solution {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	Solution s=new Solution();
//	int m=s.solution(new int[]{3,0,6,1,5});
//	System.out.println(m);
//}

public int solution(int citations[]) {
	
	Arrays.sort(citations);
	int h_max=-1;
	for(int h=0; h<=citations.length; h++) {
		
		//h는 0,1,2,3,4,5
		//값이 h보다크거나 같은것
		int max=Integer.MIN_VALUE;
		for(int i=0; i<citations.length; i++) {
			
			int n=citations[i];
			if(n>=h) {
				max=citations.length-i;
				break;
			}
		}
		int remain=citations.length-max;
		
		//값이 h
		if(max>=h && remain <=h) {
			h_max=h;
		}
		
	}
	System.out.println(h_max);
	
	return h_max;
	
}

}
