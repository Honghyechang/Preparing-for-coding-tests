package 주식가격;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//Solution s=new Solution();
//s.solution(new int[] {1,2,3,2,3});
//	}
	
	 public int[] solution(int[] prices) {
	        int[] answer = new int[prices.length];
	        
	        
	        for(int i=0; i<prices.length; i++) {
	        	
	        	for(int j=i; j<prices.length; j++) {
	        		if(prices[i]>prices[j]) {
	        			//System.out.println("i : "+i +" 일 때, j :" +j);
	        			answer[i]=j-i;
	        			break;
	        		}
	        		
	        		if(j==prices.length-1) {
	        			answer[i]=j-i;
	        			//System.out.println("i : "+i +" 일 때, j :" +j);
	        		}
	        	}
	        }
	        return answer;
	    }

}
