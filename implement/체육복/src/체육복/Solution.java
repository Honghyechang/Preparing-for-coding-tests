package 체육복;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

//	public static void main(String[] args) {
//		Solution s=new Solution();
//		int n=s.solution(5,new int[] {2,4}, new int[] {3});
//System.out.println(n);
//	}
//	
	 public int solution(int n, int[] lost, int[] reserve) {
		    boolean clothes[] =new boolean[n];
		    Arrays.fill(clothes, true);
		    
		    List<Integer> reserveList=Arrays.stream(reserve)
		    								.boxed()
		    								.collect(Collectors.toList());
		    
		    Collections.sort(reserveList,(a ,b)->a-b);
		    
		    //잃어버린 애중에 여벌이 있다면 true로 유지하고, 여벌옷을 없애버린다.
		    for(int i=0; i<lost.length; i++) {
		    	
		    	int number=lost[i]-1;
		    	if(reserveList.contains(lost[i])) {
		    		reserveList.remove(Integer.valueOf(lost[i]));
		    	}else {
		    		clothes[lost[i]-1]=false;
		    	}
		    	
		    }
		    
		    for(int i=0; i<reserveList.size(); i++){
		    	
		    	int number=reserveList.get(i)-1;
		    	
		    	int before=number-1;
		    	int after=number+1;
		    	
		    	if(before<0) {
		    		//뒷사람만 확인
		    		if(clothes[after]==false) {
		    			clothes[after]=true;
		    		}
		    		
		    	}else if(after>=n) {
		    		if(clothes[before]==false) {
		    			clothes[before]=true;
		    		}
		    	}else {
		    		
		    	if(!clothes[before]&&!clothes[after]) {
		    		clothes[before]=true;
		    	}else {
		    		if(clothes[after]==false) {
		    			clothes[after]=true;
		    		}else if(clothes[before]==false) {
		    			clothes[before]=true;
		    		}
		    	}
		    		
		    	}
		    }

	        int answer = 0;
		    for(int i=0; i<n; i++) {
		    if(clothes[i]==true) {
		    	answer++;
		    }
		    }
		 
	        return answer;
	    }

}
