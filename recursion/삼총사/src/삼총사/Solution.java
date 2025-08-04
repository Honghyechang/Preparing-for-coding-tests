package 삼총사;

public class Solution {
	static int sum=0;

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution s=new Solution();
//		int n=s.solution(new int[] {-3, -2, -1, 0, 1, 2, 3});
//		System.out.println(n);
//	}
	
	public int solution(int[] number) {
		recurison(number,0,0,0);
        return Solution.sum;
    }
	
	public void recurison(int number[],int deepth, int startIndex,  int cumulative) {
		if(deepth==3) {
			if(cumulative==0) {
				Solution.sum++;
				System.out.println("sum ++");
			}
			return;
		}
		
		for(int i=startIndex; i<number.length; i++) {
			recurison(number,deepth+1,i+1,cumulative+number[i]);
		}
		
	}

}
