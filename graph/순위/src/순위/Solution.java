package 순위;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		Solution s=new Solution();
//		int n=s.solution(5, new int[][] {
//			{4,3},{4,2},{3,2},{1,2},{2,5}
//		});
//		System.out.println(n);
//
//	}
	
	 public int solution(int n, int[][] results) {
		 
		 //1이 2를 이겼으면 [1-1][2-1]=1
		 //2는 1한테 진거니까[2-1][1-1]=-1;
		 
		 int graph[][]=new int[n][n];
		 
		 
		 //초기화
		 for(int i=0; i<results.length; i++) {
			 int winner=results[i][0];
			 int looser=results[i][1];
			 
			 graph[winner-1][looser-1]=1;
			 graph[looser-1][winner-1]=-1;
		 }
		 
		 boolean change=true;
		 
		 while(change) {
			 change=false;
			 System.out.println("change");
			 
			 //상대적인 정보로 채울 수 있는 것채우기
			 for(int i=0; i<n; i++)
			 {
				 for(int j=0; j<n; j++) {
					 if(graph[i][j]==0) {
						 continue;
					 }else if(graph[i][j]==1)
					 {
						 //i가 j 보다 강하다는 것!
						 //j보다 약한 k는 
						 //i > k가 된다.
						 //[i][k]=1
						 //[k][i]=-1
						 
						 // j 보다 약한 k를 찾기
						 //[j][k] = 1인값들을 찾기
						 for(int m=0; m<n; m++) {
							 if(graph[j][m]==1) {
								 
								 if(graph[i][m]==0 && graph[m][i]==0) { // 실제로 새로운 정보일 때만!
									    graph[i][m]=1;
									    graph[m][i]=-1;
									    change=true;
								}
		
							 }
						 }
						 
						 
						 
					 }else if(graph[i][j]==-1)
					 {
						 //i가 j보다 약하다는것
						 //j보다 센 k 보다는
						 //i < k 일것
						 //[i][k]=-1
						 //[k][i]=1
						 
						 //j보다 센 k를 찾기
						 //[k][j]=1
						 for(int m=0; m<n; m++) {
							 if(graph[m][j]==1) {
								 
								 if(graph[i][m]==0 && graph[m][i]==0) { // 실제로 새로운 정보일 때만!
									 graph[m][i]=1;
									 graph[i][m]=-1;
									 change=true;
								}
							
							 }
						 }
						 
					 }
						 
					}
			 }
			 
			 
		 }
		 
		
		 int answer = 0;
		 for(int i=0; i<n; i++) {
			 int count=0;
			 for(int j=0; j<n; j++) {
				 //count가 1개일경우 즉 나와 다른사람의 경기를 아는경우 확정
				 if(graph[i][j]==0) {
					 count++;
				 }
			 }
			 if(count==1) {
				 answer++;
			 }
		 }
		 
	       
	        return answer;
	    }

}
