package 완전범죄_389480;

public class Solution {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	
//	Solution s=new Solution();
//	s.solution(new int[][] {{1, 2}, {2, 3}, {2, 1}}, 4, 4);
//
//}
	int amax;
	int bmax;
	int [][][]memo;
	int answer=Integer.MAX_VALUE;
    public int solution(int[][] info, int n, int m) {

    	amax=n;
    	bmax=m;
    	
    	//현재까지의 상황이 있다면 굳이 안해도 된다.
    	//현재 index , a의 누적합 , b누적합이 같은 상태에서 또 호출됐다면 그것은 memo를 이용하여 그만
    	memo=new int[info.length+1][121][121];
    	
    	int answer=dfs(info,0,0,0);
    	if(answer==-1) {
    		System.out.println("경로없음");
    		return -1;
    	}
    	System.out.println("최소값 : "+answer);
    	return answer;
    }
    
    public int dfs(int info[][],int asum,int bsum , int index) {
    	if(memo[index][asum][bsum]!=0) {
    		//System.out.println("방문한적있음");
    		return memo[index][asum][bsum];
    	}
    	
    	if(asum>=amax || bsum >= bmax) {
    		memo[index][asum][bsum]=-1;
    		return memo[index][asum][bsum];
    	}
    	
    	if(index==info.length) {
    		
    		memo[index][asum][bsum]=asum;
    		return memo[index][asum][bsum];
    	}
    	//a가 잡을경우
    	int adfs=dfs(info,asum+info[index][0],bsum,index+1);
    	//b가 잡을경우
    	int bdfs=dfs(info,asum,bsum+info[index][1],index+1);
    	
    	
    	if(adfs==-1 && bdfs==-1) {
    		memo[index][asum][bsum]=-1;
    	}
    	else if(adfs==-1 && bdfs!=-1) {
    		memo[index][asum][bsum]=bdfs;
    	}else if(adfs!=-1 && bdfs==-1) {
    		memo[index][asum][bsum]=adfs;
    	}else {
    		memo[index][asum][bsum]=Math.min(adfs, bdfs);
    	}
    	return memo[index][asum][bsum];
    	
    	
    	
    }
}
