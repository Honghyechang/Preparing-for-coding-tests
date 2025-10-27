package 풍선터트리기_68646;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution(new int[] {9,-1,-5});
//	}

	
	public int solution(int[] a) {
		
		if(a.length==1) {
			return 1;
		}
        int answer = 0;
        //누적최소값 구하기
        
        int leftmin[] = new int[a.length];
        //leftmin[0]=인덱스0까지의 최소값
        //leftmin[1]= 인덱스1값 vs leftmin[0] 비교중 최소값
        leftmin[0]=a[0];
        for(int i=1; i<a.length; i++) {
        	leftmin[i]=Math.min(leftmin[i-1], a[i]);
        }
        
        
        int rightmin[] = new int[a.length];

        rightmin[a.length-1]=a[a.length-1];
        for(int i=a.length-2; i>=0; i--) {
        	rightmin[i]=Math.min(rightmin[i+1], a[i]);
        }
        
        

        for(int i=0; i<a.length; i++) {
        	int left;
        	int right;
        	int current = a[i];
        	if(i==0) {
        		left=1000000001;
        		right=rightmin[i+1];
        	}else if(i==a.length-1) {
        		right=1000000001;
        		left=leftmin[i-1];
        	}else {
        		left=leftmin[i-1];
        		right=rightmin[i+1];
        	}
        	
        	if( !(current > left && current > right)) {
        		answer++;
        	}
        	
        	
        	
        }
        System.out.println(answer);
        
        
        
        return answer;
    }
}
