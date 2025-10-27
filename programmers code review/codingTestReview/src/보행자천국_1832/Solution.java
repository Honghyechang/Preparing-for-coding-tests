package 보행자천국_1832;

import java.util.Arrays;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution(3, 6, new int[][] {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}});
//	}

	  int MOD = 20170805;
	  int memo[][][];
	  
	 public int solution(int m, int n, int[][] cityMap) {
	      
	      
	        
		 //방향까지 고려하기
	        //메모리제인션이용하기
	        memo=new int[cityMap.length][cityMap[0].length][2];
	        for(int me[][] : memo) {
	        	
	        	for(int dep[]:me) {
	        		Arrays.fill(dep, -1);
	        	}
	        }
	        
	        //0이면 가능
	        //1이면 아예못감
	        //2이면 좌회전 또는 우회전을 못함
	        //즉 2일때는 이전의 상태가 왼쪽에서 온건지 오른쪽에서 온건지 기억해두기
	        int answer=seekRoute(0,0,0,cityMap);
	        
	        System.out.println(answer);
	        return answer;
	 }
	 //diretion 오른쪽으로 이동 : 0 , 아래로 이동 1
	 public int seekRoute(int y, int x, int diretion,int [][]cityMap) {
		 
		 //System.out.println(y+" , "+x);
		 
		 //20170805로 나눈 나머지
		 if(memo[y][x][diretion]!=-1) {
			// System.out.println("존재");
			 return memo[y][x][diretion];
		 }
		 if(y==cityMap.length-1 && x==cityMap[0].length-1) {
			// System.out.println("도착.");
			 return 1;
		 }
		 
		 int type=cityMap[y][x];
		 if(type==0) {
			 //오른쪽 , 아래 모두 가능
			 int rightPoint=0;
			 int bottomPoint=0;
			 //오른쪽으로 가는 경우
			 int rightY=y;
			 int rightX=x+1;
			 
			 
			 if(rightX<cityMap[0].length) {
				 //범위에 넘지 않은경우에만 가능
				 rightPoint=seekRoute(rightY,rightX,0,cityMap);
			 }
			 
			 int bottomY=y+1;
			 int bottomX=x;
			 if(bottomY<cityMap.length) {
				 bottomPoint=seekRoute(bottomY, bottomX, 1, cityMap);
			 }
			 
			 memo[y][x][diretion]=(rightPoint+bottomPoint)%20170805;
			 return memo[y][x][diretion];
			 
		 }else if(type==1) {
			 memo[y][x][diretion]=0;
			 return memo[y][x][diretion];
			 
		 }else if(type==2) {
			
			//이전의 상태를 고려하여 직진만 가능
			 if(diretion==0) {
				 //이전에 왼쪽에서 온것으로 나는 오른쪽만 가능
				 int rightPoint=0;
				 int rightY=y;
				 int rightX=x+1;
				 
				 if(rightX<cityMap[0].length) {
					 //범위에 넘지 않은경우에만 가능
					 rightPoint=seekRoute(rightY,rightX,0,cityMap);
				 }
				 memo[y][x][diretion]=rightPoint%20170805;
				 return memo[y][x][diretion];
				 
			 }else {
				 //아래쪽만 가능
				 int bottomPoint=0;
				 int bottomY=y+1;
				 int bottomX=x;
				 if(bottomY<cityMap.length) {
					 bottomPoint=seekRoute(bottomY, bottomX, 1, cityMap);
				 }
				 memo[y][x][diretion]=bottomPoint%20170805;
				 return memo[y][x][diretion];
				 
			 }
			 
		 }
		 
		 return -1;
		 
	 }
	 
	 int result=0;
	 
// public void seekRouteTest(int y, int x, boolean diretion,int [][]cityMap) {
//		 
//		// System.out.println(y+" , "+x);
//		 
//		 //20170805로 나눈 나머지
////		 if(memo[y][x]!=-1) {
////			 System.out.println("존재");
////			 return memo[y][x];
////		 }
//		 if(y==cityMap.length-1 && x==cityMap[0].length-1) {
//		//	 System.out.println("도착");
//			 result=(result+1)%20170805;
//			// System.out.println(result + " result update");
//			 return;
//		 }
//		 
//		 int type=cityMap[y][x];
//		 if(type==0) {
//			 //오른쪽 , 아래 모두 가능
//			 int rightPoint=0;
//			 int bottomPoint=0;
//			 //오른쪽으로 가는 경우
//			 int rightY=y;
//			 int rightX=x+1;
//			 
//			 
//			 if(rightX<cityMap[0].length) {
//				 //범위에 넘지 않은경우에만 가능
//				 seekRouteTest(rightY,rightX,true,cityMap);
//			 }
//			 
//			 int bottomY=y+1;
//			 int bottomX=x;
//			 if(bottomY<cityMap.length) {
//				 seekRouteTest(bottomY, bottomX, false, cityMap);
//			 }
//			 
//		
//			 
//		 }else if(type==1) {
//			 return;
//			 
//		 }else if(type==2) {
//			
//			//이전의 상태를 고려하여 직진만 가능
//			 if(diretion==true) {
//				 //이전에 왼쪽에서 온것으로 나는 오른쪽만 가능
//				 int rightPoint=0;
//				 int rightY=y;
//				 int rightX=x+1;
//				 
//				 if(rightX<cityMap[0].length) {
//					 //범위에 넘지 않은경우에만 가능
//					 seekRouteTest(rightY,rightX,true,cityMap);
//				 }
//				
//				 
//			 }else {
//				 //아래쪽만 가능
//				 int bottomPoint=0;
//				 int bottomY=y+1;
//				 int bottomX=x;
//				 if(bottomY<cityMap.length) {
//					 seekRouteTest(bottomY, bottomX, false, cityMap);
//				 }
//				
//				 
//			 }
//			 
//		 }
//		
//		 
//	 }
}
