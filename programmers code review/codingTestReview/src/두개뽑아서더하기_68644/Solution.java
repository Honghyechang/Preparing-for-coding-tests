package 두개뽑아서더하기_68644;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	Set<Integer> sets=new HashSet<Integer>();
	

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	
//	Solution s=new Solution();
//	s.solution(new int[] {5,0,2,7});
//}
	
	public int[] solution(int numbers[]) {
		
		dfs(numbers,new int[2],0,0);
		int answer[]=sets.stream()
						 .mapToInt(i->i.intValue())
						 .sorted()
						 .toArray();
		System.out.println(Arrays.toString(answer));
		return answer;
		
	}
	
	public void dfs(int numbers[],int select[],int start,int depth) {
		int depthRemain=2-depth;
		int numberRemain=numbers.length-start;
		if(numberRemain < depthRemain)return;
		
		if(depth==2) {
			sets.add(select[0]+select[1]);
			return;
		}
		for(int i=start; i<numbers.length; i++) {
			select[depth]=numbers[i];
			dfs(numbers,select,i+1,depth+1);
		}
		
	}

}
