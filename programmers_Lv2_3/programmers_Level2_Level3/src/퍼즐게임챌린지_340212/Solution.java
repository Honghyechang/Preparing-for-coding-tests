package 퍼즐게임챌린지_340212;

public class Solution {
//
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//
//	Solution s=new Solution();
//	s.solution(new int[] {1,328, 467, 209, 54}, new int[] {2, 7, 1, 4, 3}, 1723);
//}

 public int solution(int[] diffs, int[] times, long limit) {

	 //조건에 맞는 것중 옳다면 작아지기
	 //큰거부터 -> 작은거로 줄이기
	 //숙련도의 최소값
	 int start=1;
	 int end=100001;
	 int mid=-1;
//	 
//	 //조건에 맞는 최대값 찾기
//	 //즉 작은것부터 큰것까지 이동
//	 while(start+1<end) {
//		  mid=(start+end)/2;
//		 if(isPossible(mid,diffs,times,limit)) {
//			 start=mid;
//		 }else {
//			 end=mid;
//		 }
//		 
//	 }
	 
	 	//조건에 맞는 최솟값찾기
		 //즉 큰것부터 작은거
		 while(start<end) {
			 
			  mid=(start+end)/2;
			 if(isPossible(mid,diffs,times,limit)) {
				 end=mid;
			 }else {
				 start=mid+1;
			 }
			 
		 }
	 System.out.println(start);
	 return start;
 }
 
 public boolean isPossible(int ability,int[] diffs, int[] times, long limit) {
	 
	 long time=0;
	 int task=0;
	 while(task<diffs.length) {
		 
		 if(ability>=diffs[task]) {
			 time+=times[task];
		 }else {
			 int fail=diffs[task]-ability;
			 time+= (fail*(times[task]+times[task-1]));
			
			 time+=times[task];
		 }
		 
		 
		 if(time>limit){
			 return false;
		 }
		 task++;
	 }
	 
	 
	 return true;
 }
}
