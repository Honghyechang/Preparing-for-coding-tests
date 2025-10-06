package 유사칸토얼_148652;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//Solution s=new Solution();
//s.solution(2, 4, 17);
//	}
	
	public int solution(int n, long l, long r) {
	        int answer = 0;
	        
	        for(long i=l ; i<=r; i++) {
	        	long k=i-1;
	        	int result=bfs(n,k);
	        	if(result==1) {
	        		answer++;
	        	//	System.out.println(k+"번째에서 1");
	        		
	        	}
	        	
	        }
	      //  System.out.println(answer);
	        return answer;
	}
	
	public int bfs(int level, long n) {
		
		if(level==0) {
			return 1;
		}
		//level에서 n을 찾기
		//한그룹의 개수
		long lengthByGroup=(long)Math.pow(5, level-1);
		int group=(int)(n/lengthByGroup);
		long groupSequent=n%lengthByGroup;
		if(group==2) {
			return 0;
		}
		return bfs(level-1,groupSequent);
		
	}

}
