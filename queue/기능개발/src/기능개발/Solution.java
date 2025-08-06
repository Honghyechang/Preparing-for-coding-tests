package 기능개발;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//Solution s=new Solution();
//int n[]=s.solution(new int[] {95,90,99,99,80,99}, new int[] {1,1,1,1,1,1});
//System.out.println(Arrays.toString(n));
//	}
	
	  public int[] solution(int[] progresses, int[] speeds) {
		  
		    int arr[]=new int[progresses.length];
		    
		    
		    for(int i=0; i<progresses.length; i++) {
		    	double n=(100-progresses[i])/(double)speeds[i]; 
		    	arr[i]=(int)Math.ceil(n);
		    	System.out.println(arr[i]);
		    }
		    
		    int count=0;

		    List<Integer> list=new ArrayList<Integer>();
		    
		    for(int i=0; i<arr.length; i++) {
		    	int n=arr[i];
		    	
		    	if(n<=0) {
		    		count++;
		    		continue;
		    	}
		    	else if(i!=0){
		    		list.add(count);
			    	count=0;
			    	
		    	}
		    	
		    
		    	while(arr[i]>0) {
		    		for(int j=0; j<arr.length; j++) {
		    			arr[j]=arr[j]-1;
		    		}
		    	}
		    	count++;
		    }
		    list.add(count);
		    
		    System.out.println(list.toString());
		    
		  
	        return list.stream().mapToInt(i->Integer.valueOf(i)).toArray();
	    }
	  
	  

}
