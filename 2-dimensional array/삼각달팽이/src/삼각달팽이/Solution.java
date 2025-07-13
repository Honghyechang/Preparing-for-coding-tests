package 삼각달팽이;

public class Solution {



	 public int[] solution(int n) {
		 
		 
		 //n 개 입력시 
		 // n 개의 배열을 만들고 [ [1] , .. [n개]] //0으로 초기화 된다.
		 int[][] arr = new int [n][n];
		 
//		 for(int i=0; i<n; i++) {
//			 for(int j=0; j<n; j++) {
//				System.out.print(arr[i][j]);
//			 }
//			 System.out.println();
//		 }

		 
		 //중심이 0,0 -> 2,1 -> 4,2 등등 y축으로는 2만큼, x축으로는 1만큼 중심이 바뀌고, 
		 //중심이 바뀔때마다 일정한 패턴을 갖는데
		 //1)아래쪽으로 
		 //2)오른쪽으로
		 //3)대각선으로 숫자를 1씩 증가하면서 채워나간다.
		 
		 int initial_x=0;
		 int initial_y=0;
		 int x=0;
		 int y=0;
		 int number=0;
		 while(y<n) {// y<n일 동안 y는 2씩 x는 1씩 늘어난다 중심점이 바뀐다.
			 
//			 x=initial_x;
//			 y=initial_y;
			 
			 //1)아래로 늘려갈것인데, 0이 나오지 않거나 or 배열 범위가 넘어갈경우 스탑!
			 while(true) {
				 if(y>=n) {
					 y--;
					 break;
				 }
				 if(arr[y][x]!=0) {
					 y--;
					 break;
				 }
				 
				 arr[y][x]=++number;
				 y++;
			 }
//			 System.out.println("1)");
//			 for(int i=0; i<n; i++) {
//				 for(int j=0; j<n; j++) {
//					System.out.print(arr[i][j]);
//				 }
//				 System.out.println();
//			 }
//			 
			 //2)오른쪽으로 x배열이 넘어가거나, 또는 0이 아닐떄까지
			 while(true) {
				 x++;
				 if(x>=n) {
					 x--;
					 break;
				 }
				 if(arr[y][x]!=0) {
					 x--;
					 break;
				 }
				 
				 arr[y][x]=++number;
			
				 
			 } 
//			 System.out.println("2) y값" + y);
//			 for(int i=0; i<n; i++) {
//				 for(int j=0; j<n; j++) {
//					System.out.print(arr[i][j]);
//				 }
//				 System.out.println();
//			 }
			 
			 //3)대각선
			 while(true) {
				 x--;
				 y--;
				 if(arr[y][x]!=0) {
					 break;
				 }
				 
				 arr[y][x]=++number;
			 }
//			 System.out.println("3)");
//			 for(int i=0; i<n; i++) {
//				 for(int j=0; j<n; j++) {
//					System.out.print(arr[i][j]);
//				 }
//				 System.out.println();
//			 }
			 //중심점 바꾸기
			 initial_y+=2;
			 initial_x+=1;
			 
			 y=initial_y;
			 x=initial_x;
			 
		 }
		 
//		 for(int i=0; i<n; i++) {
//			 for(int j=0; j<n; j++) {
//				System.out.print(arr[i][j]);
//			 }
//			 System.out.println();
//		 }
//		 
		 int size=0;
		 for(int i=0; i<n; i++) {
			 for(int j=0; j<n; j++) {
				 if(arr[i][j]!=0) {
					 size++;
				 }
			 }
		 }
		 
		 int result[]=new int[size];
		 
		 int count=0;
		 for(int i=0; i<n; i++) {
			 for(int j=0; j<n; j++) {
				 if(arr[i][j]!=0) {
					result[count++]=arr[i][j];
					
				 }
			 }
		 }
		 

		 
		 
		 return result;
		 
	 }
	 
	
	 
}
