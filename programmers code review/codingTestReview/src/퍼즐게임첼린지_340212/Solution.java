package 퍼즐게임첼린지_340212;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution(new int[] {1, 328, 467, 209, 54}, new int[] {2, 7, 1, 4, 3}, 1723);
//	}

	 public int solution(int[] diffs, int[] times, long limit) {
		 //가능한 값중 가장 작은값
		 //큰것부터 축소해서 내려오기
		 
		 int start=1;
		 int end=100001;
		 
		 //start , end는 level을 의미한다.
		 
		 
		 int mid=-1;
		 while(start<end) {
			 mid=(start+end)/2;
			 if(rightLevel(mid,limit,diffs,times)) {
				 end=mid;
			 }else {
				 start=mid+1;
			 }
		 }
		 
		 System.out.println(start);
		 return start;
	}
	 
	 public boolean rightLevel(int level, long limit, int[] diffs, int[] times) {
		 
		 long totalTime=0;
		// diffs[0] = 1  처음은 무조건 1로 성공할것이다.
		 
		 int time_pre=-1;
		 for(int i=0; i<diffs.length; i++) {
			 
			 
			 int diff=diffs[i];
			 int time=times[i];
					 
			 if(level>=diff) {
				 totalTime+=(long)time;
			 }else if(level < diff) {
				 int count=diff-level;
				 totalTime+=(long)count * (time+time_pre);
				 totalTime+=time;
			 }
			time_pre=time; 
		 }
		 
		 if(totalTime<=limit) {
			 return true;
		 }
		 return false;
		 
		 
		 
		 
	 }
}
