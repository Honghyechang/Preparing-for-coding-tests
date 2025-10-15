package 혼자놀기의달인_131130;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	int max=Integer.MIN_VALUE;
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution(new int[] {8,6,3,7,2,5,1,4});
//		
//	}
	
	 public int solution(int[] cards) {
	        int answer = 0;
	        
	        int group=1;
	        int visited[]=new int[cards.length];
	        
	        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
	        
	        
	        
	        for(int i=0; i<cards.length; i++) {
	        	if(visited[i]!=0) {
	        		continue;
	        	}
	        	
	        	visited[i]=group;
	        	int current=i; //current는 인덱스
	        	
	        	int count=1;
	        	while(true) {
	        		int value = cards[current] -1;
	        		//거기로 방문
	        		if(visited[value]==group) {
	        			break;
	        		}
	        		visited[value]=group;
	        		current=value;
	        		count++;
	        	}
	        	map.put(group, count);
	        	//System.out.println("group : "+group + " count :" +count);
	        	
	        	group++;
	        
	        }
	        
	        if(group==2) {
	        	return 0;
	        }else {
//	        int countA=0;
//	        int countB=0;
//	        for(int i=0; i<cards.length; i++) {
//	        	if(visited[i]==1) {
//	        		countA++;
//	        	}else if(visited[i]==2) {
//	        		countB++;
//	        	}
//	        }
//	        System.out.println(countA*countB);
//	        return countA*countB;
	        	
	        	//현재 그룹의 개수가 group개이다.
	        	group--;
	        	//System.out.println(group);
	        	getMax(map,group,0,0,new int[2]);
	        	
	        	System.out.println(max);
	        	return max;

	        }
	        
	 }
	 
	 
	 public void getMax(Map<Integer,Integer> map,int totalGroup, int depth , int start , int arr[]) {
		 if(depth==2) {
			 int n=arr[0] + 1;
			 int m=arr[1] +1;
			// System.out.println("그룹 조합 "+"("+n+","+m+")");
			 
			 int a=map.get(n);
			 int b=map.get(m);
			 if(a*b  > max) {
				 max =a*b;
			 }
			 return;
		 }
		 
		 
		 for(int i=start; i < totalGroup; i++) {
			 arr[depth]=i;
			 getMax(map,totalGroup,depth+1,i+1,arr);
		 }
	 }

}
