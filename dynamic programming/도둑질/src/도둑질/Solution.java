package 도둑질;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int solution(int[] money) {
		 
		  	int dp1[]=new int[money.length];
		  	int dp2[]=new int[money.length];
		  	
		  	
		  	//dp[i]에서 i는 0~i번째 집만 고려했을때의 최적값을 의미한다.
		  	//그리고 그 최적값을 dp에 기록을 하며 이 저장된 값들을 재활용하여 효율적으로 계산한다.
		  	
		  	
		  	//첫번째를 터는 경우
		  	dp1[0]=money[0];
		  	dp1[1]=money[0]; // dp1[1]은 0 , 1 집을 고려했을때의 최대값을 의미하는데 첫	번째집을 턴다는 가정하에 두번째집은 털지못해서 money가 그대로 된다.
		  	
		  	//또다른 예제러 dp1[2]이라면 0 , 1, 2 만 참고한다는것이다. 
		  	
		  	//money.length-1 인유는 첫번째를 털고 마지막은 털지 않기 때문에 마지막의 경우는 구하지 않는것이다.
		  	for(int i=2; i<money.length-1; i++) {
		  		dp1[i]=Math.max(dp1[i-1], dp1[i-2]+money[i]);
		  	}
		  	
		  	
		  	
		  	dp2[0]=0;
		  	dp2[1]=money[1];// dp2[1] 은 0 , 1 집만 고려했을때 최대값인데 0을 털지 않기로 했으니까 money[1]이 터는 경우밖에없다.
		  	
		  	for(int i=2; i<money.length; i++) {
		  		dp2[i]=Math.max(dp2[i-1], dp2[i-2]+money[i]);
		  	}
		  	
		  	
		  	
		 	
		  	return Math.max(dp1[money.length-2],dp2[money.length-1]);
	 }
	 


}
