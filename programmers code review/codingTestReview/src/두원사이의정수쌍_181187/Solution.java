package 두원사이의정수쌍_181187;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution(2, 3);
//	}
//	
	
	  public long solution(int r1, int r2) {
		    
		  
		   double rTwo=Math.pow(r2, 2);
		   double rOne=Math.pow(r1, 2);
		   
		    //x축의 개수를 모두 구하기
		    long xSize=r2+1;
		    
		    long count=0;
		    //int zeroCount=0;
		    
		    for(int i=0; i<xSize; i++) {
		    	
		    	int maxRount=(int)Math.floor(Math.sqrt( rTwo - Math.pow(i,2) ));
		    	
		    	int minRount;
		    	if(i>=r1) {
		    		minRount=0;
		    	}else {
		    		minRount=(int)Math.ceil(Math.sqrt( rOne - Math.pow(i,2) ));
		    	}
		    	
		    	int pointCount=maxRount-minRount+1;
		    	
		    	count+=pointCount;
		    	
		    //	System.out.println("i가 " +i+"일 때 +"+pointCount+"가 되어 count : "+count);
//		    	if(minRount==0) {
//		    		zeroCount++;
//		    	}
//		    	
		    }
//		    System.out.println("count : "+count);
//		    System.out.println("zeroCount : "+zeroCount);
//		    System.out.println("count*4 - zeCount*4 : "+(count*4-zeroCount*4));
//		    
//		    
		    
		    
		    
		    return (count*4-((r2-r1+1)*4));
		    
		    
		   
	    }

}
