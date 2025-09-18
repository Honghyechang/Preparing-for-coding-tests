package 체육대회;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	int sportCount;
	int studentCount;
	int max=Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s=new Solution();
		s.solution(new int[][] {{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}});
	}
    public int solution(int[][] ability) {
    	
    	 sportCount=ability[0].length;
    	 studentCount=ability.length;
    	
    	 dfs(ability,0,0,new ArrayList<Integer>());
        System.out.println(max);
        return max;
    }
    
    public void dfs(int[][] ability, int sum , int depth,List<Integer> visited) {
    	
    	if(depth==sportCount) {
    		if(max<sum) {
    			max=sum;
    		}
    		return;
    	}
    	
    	for(int i=0; i<studentCount; i++) {
    		
    		if(visited.contains(i))continue;
    		
    		List<Integer> newList=new ArrayList<Integer>(visited);
    		newList.add(i);
    		dfs(ability,sum+ability[i][depth],depth+1,newList);
    	}
    	
    }

}
