package 체육대회_121684;

public class Solution {
	
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//
//	Solution s=new Solution();
//	s.solution(new int[][] {{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}});
//}
public int solution(int[][] ability) {
	getMax(ability,new boolean[ability.length],0,0,ability[0].length);
	System.out.println(max);
	return max;
}

int max=Integer.MIN_VALUE;
public void getMax(int [][] ability, boolean used[], int sum , int depth , int target) {
	
	if(depth==target) {
		if(max<sum) {
			max=sum;
		}
		return;
	}
	
	for(int i=0; i<ability.length; i++) {
		
		if(!used[i]) {
			int select[]=ability[i];
			used[i]=true;
			getMax(ability,used,sum+select[depth],depth+1,target);
			used[i]=false;
		}
	}
	
}

}
