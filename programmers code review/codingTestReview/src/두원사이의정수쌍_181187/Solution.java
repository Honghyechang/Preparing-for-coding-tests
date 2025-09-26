package 두원사이의정수쌍_181187;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution(2, 3);
//	}
	
	  public long solution(int r1, int r2) {
		    long arrSize=r2+1;
		    System.out.println("arrSize : "+arrSize);
		    //int arr[][]=new int[arrSize][arrSize];
		    
		    double distance=(double)r2-r1;
		    
		    int count=0;
		    int zero=0;
		    
		    
		    for(long i=0; i<arrSize;i++) {
		    	for(long j=0; j<arrSize; j++) {
		    		
		    		double distan=Math.sqrt( Math.pow(i-0, 2)+Math.pow(j-0, 2));
		    		if(distan>=r1 &&distan <=r2) {
		    			
		    			count++;
		    			
		    			if(i==0 || j==0) {
		    				zero++;
		    			}
		    		}
		    		
		    	}
		    }
		    
		    System.out.println("count : "+count+ " , zero : "+zero);
		    System.out.println("count*4 - (zero*2) = "+((count*4)-(zero*2)));
		    
		    long answer=((count*4)-(zero*2));
		    return answer;
		    
		   
	    }

}
