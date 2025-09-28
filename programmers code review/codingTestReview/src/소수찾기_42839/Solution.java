package 소수찾기_42839;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	Set<Integer> sets=new HashSet<Integer>();
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution s=new Solution();
//		s.solution("011");
//		//System.out.println(s.isSosu(7));
//	}

	public int solution(String numbers) {
		char chars[]=numbers.toCharArray();
		dfs(chars,new char[chars.length],new boolean[chars.length],0);
		System.out.println(sets.size());
		for(int i :sets) {
			System.out.println(i);
		}
		return sets.size();
	}
	
	public void dfs(char chars[],char select[],boolean used[],int depth) {
		
		if(depth!=0) {
			StringBuilder sb=new StringBuilder();
			for(int i=0; i<depth; i++) {
				sb.append(select[i]);
			}
			
			int number=Integer.parseInt(sb.toString());
			if(isSosu(number)) {
				sets.add(number);
			}
			
			
			if(depth==chars.length)return;
		}
		
		
		for(int i=0; i<chars.length; i++) {
			if(!used[i]) {
				select[depth]=chars[i];
				used[i]=true;
				dfs(chars,select,used,depth+1);
				used[i]=false;
			}
		}
	}
	
	public boolean isSosu(int n) {
		boolean isFind=false;
		if(n<=1) return false;
		
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
		
		
	}
}
