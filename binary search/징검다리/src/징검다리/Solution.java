package 징검다리;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
	List<int[]> collaboration=new ArrayList<int[]>();

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution s=new Solution();
//		
//		s.solution(25,new int[] {2,14,11,21,17}, 2);
//	}
//	
	public int solution(int distance, int rocks[],int n) {
		
		int copy[]=Arrays.copyOf(rocks,rocks.length+1);
		copy[copy.length-1]=distance;
		
		
		Arrays.sort(copy);
		//System.out.println(Arrays.toString(copy));
		
		
		int start=1;
	    int end=distance;
	    int answer=-1;
	    
	    while(start<=end) {
	    	int mid=(start+end)/2;
	    	if(isValid(copy, mid, n)) {
	    		answer=mid;
	    		start=mid+1;
	    	}else {
	    		end=mid-1;
	    	}
	    }
	    return answer;
		
	}
	
	public boolean isValid(int arr[],int d,int n) {
		int c=0;
		int remove=0;
		for(int m : arr) {
			if(m-c<d) {
				remove++;
				continue;
			}
			c=m;
		}
		
		return remove<=n;
	}
	
	
	
}
