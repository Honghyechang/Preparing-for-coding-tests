package 택배상자꺼내기_389478;

import java.util.ArrayList;
import java.util.List;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution(22, 6, 8);
//	}

	 public int solution(int n, int w, int num) {
		  
		 List[] lists=new List[10];
		 for(int i=0; i<lists.length; i++) {
			 lists[i]=new ArrayList<Integer>();
		 }
		 
		 boolean direction=false; //오 -> 왼
		 
		 for(int i=0; i<n; i++) {
			 int pick=i%w;
			 if(pick==0) {
				 direction=!direction;
			 }
			 
			 if(!direction) {
				 pick=  (w-1)-pick;
			 }
			 
			 List<Integer> list=lists[pick];
			 list.add(i);
			 
		 }
		 
		 num=num-1;
		 for(int i=0; i<lists.length; i++) {
			 List<Integer> list=lists[i];
			 if(list.contains(num)) {
				 for(int j=0; j<list.size(); j++) {
					 if(list.get(j)==num) {
						 System.out.println(list.size()-j);
						 return list.size()-j;
					 }
				 }
				 
			 }
		 }
		 
		 
	        return 0;
	 }
}
