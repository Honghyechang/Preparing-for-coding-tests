package 완전범죄;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	boolean minExist=false;
	int minA=Integer.MAX_VALUE;
	int an;
	int bm;
	Set<String> sets=new HashSet<String>();

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		Solution s=new Solution();
//		s.solution(new int[][] {{1, 2}, {2, 3}, {2, 1}}, 4, 4);
//
//	}
//	
	    public int solution(int[][] info, int n, int m) {
	    	an=n;
	    	bm=m;
	    	dfs(info,0,0,0);
	    	System.out.println(minA);
	    	
	    	return minExist?  minA : -1 ;
	    }
	    
	    // n 은 a누적 m 는 b누적
	    public void dfs(int[][] info,int depth,int n, int m) {
	    	
	    	if(sets.contains(depth+","+n+","+m))return;
	    	else {
	    			sets.add(depth+","+n+","+m);
	    	}
	    	if(n>=an || m >=bm)return;
	    	if(minExist && n>minA) return;
	    	
	    	if(depth==info.length) {
	    		if(minA > n) {
	    			minExist=true;
	    			minA=n;
	    		}
	    		return;
	    	}
	    	
	    	//a가 훔친경우 
	    	dfs(info,depth+1,n+info[depth][0],m);
	    	//b가 훔친경우
	    	dfs(info,depth+1,n,m+info[depth][1]);
	    }
	

}
