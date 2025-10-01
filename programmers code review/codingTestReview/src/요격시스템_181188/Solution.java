package 요격시스템_181188;

import java.util.Arrays;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution s=new Solution();
//		s.solution(new int[][] {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}});
//
//	}

	public int solution(int[][] targets) {
		//end 정렬
		targets=Arrays.stream(targets)
				      .sorted((a,b)->{
				    	if(a[1]!=b[1]) {  
				    		return a[1]-b[1];
				    	}else {
				    		return a[0]-b[0];
				    	}
				    	  
				      })
				      .toArray(int[][]::new);
		
		
//		for(int i=0; i<targets.length; i++) {
//			for(int j=0; j<targets[i].length; j++) {
//				System.out.print(targets[i][j] + " ");
//			}
//			System.out.println();
//		}
        int answer = 0;
        double position=Integer.MIN_VALUE;
        for(int targer[]:targets) {
        	int start =targer[0];
        	int end=targer[1];
        	
        	if(start<position && end>position) {
        		//System.out.println("현재 postion : "+position+"으로"+start+","+end+"격파가능");
        		continue;
        	}
        	answer++;

    		//System.out.println("현재 postion : "+position+"으로"+start+","+end+"격파 불가능!!!!!!");
        	//System.out.println("positon update : "+(end-0.1));
        	position=end-0.1;
        }
        System.out.println(answer);
        
        return answer;
    }
}
