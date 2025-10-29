package 양궁대회_92342;

import java.util.Arrays;

public class Solution {

	int answer[]=null;
	int max=0;
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	Solution s=new Solution();
//	int answer[]=s.solution(5, new int[] {2,1,1,1,0,0,0,0,0,0,0});
//	System.out.println(Arrays.toString(answer));
//	answer=s.solution(9, new int[] {0,0,1,2,0,1,1,1,1,1,1});
//	System.out.println(Arrays.toString(answer));
	int answer[]=s.solution(10, new int[] {0,0,0,0,0,0,0,0,3,4,3});
	System.out.println(Arrays.toString(answer));

}

 public int[] solution(int n, int[] info) {
	 recursion(n,0,info,new int[11],0,0);
	 if(max==0) {
		 return new int[] {-1};
	 }
	// System.out.println(Arrays.toString(answer));
	 
	 int sum=Arrays.stream(answer)
			 	   .sum();
	 
	 int remain=n-sum;
	 answer[info.length-1]+=remain;//어차피 마지막은 0점 이기든 지금 상관없다
	 
	 
	 return answer;
 }
 
 
 public int[] compare(int a[],int b[]) {
	 for(int i=a.length-1; i>=0; i--) {
		 if(a[i]==b[i])continue;
		 if(a[i]>b[i]) {
			 return a;
		 }else {
			 return b;
		 }
	 }
	 return a;
 }
 
 public void recursion(int n,int depth,int info[],int lion[],int lionScore,int apeachScore) {
	 
	 if(depth==info.length) {
		 int win=lionScore-apeachScore;
		 if(win>=max) {
			 System.out.println(Arrays.toString(lion));
			 if(max<win) {
				 answer=lion.clone();
				 max=win;
				 return;
			 }else {
				 //같다면 비교해야한다.
				 answer=compare(answer, lion).clone();
				 max=win;
				 return;
			 }
			 
		 }
		 return;
	 }
	 
	 //라이언이 이기는경우
	 //n 화살이 어피치보다 무조건 많아야함 같으면 지기 때문에
	 int apeachN=info[depth];
	 
	 int k=0;
	 if(apeachN<n) {
		 //이길 수 있다.
		 k=(apeachN+1);
		 lion[depth]=k;
		 n=n-k;
		 lionScore+=(10-depth);
		 
		 recursion(n,depth+1,info,lion,lionScore,apeachScore);
		 
		 
		 n=n+k;
		 lion[depth]=0;
		 lionScore-=(10-depth);
	 }
	
	 
	 
	 
	 //라이언이 지는경우
	 lion[depth]=0;
	 if(info[depth]!=0) {
		 apeachScore+=(10-depth);
	 }
	 recursion(n,depth+1,info,lion,lionScore,apeachScore);
	 
	 
	 
 }
 
 
}
