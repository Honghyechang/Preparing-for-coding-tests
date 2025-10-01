package 단속카메라_42884;

import java.util.Arrays;

public class Solution {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	Solution s=new Solution();
//	int n=s.solution(new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}});
//	System.out.println(n);
//}

	
	public int solution(int[][] routes) {
//		for(int i=0; i<routes.length; i++) {
//			for(int j=0; j<routes[i].length; j++) {
//				System.out.print(routes[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		
		routes=Arrays.stream(routes)
		      .sorted((a,b)->a[1]-b[1])
		      .toArray(int[][]::new);
		
		
		Car cars[]=new Car[routes.length];
		
		for(int i=0; i<routes.length; i++) {
			cars[i]=new Car(routes[i][0],routes[i][1]);
		}
		int count=1;
		
		int cameraPositon=cars[0].end;
		for(int i=1; i<cars.length; i++) {
			Car car=cars[i];
			if(car.start<=cameraPositon && car.end>=cameraPositon) continue;
			cameraPositon=car.end;
			count++;
			
		}
	//	System.out.println(count);
		
		
		
		return count;
	}

	class Car{
		int start;
		int end;
		boolean isVisit=false;
		public Car(int start, int end) {
			this.start=start;
			this.end=end;
		}
		public void visit() {
			this.isVisit=true;
		}
		
		//범위에 속해있는지
		public boolean containRoute(Car car) {
			if(this.end >=car.start) {
				return true;
			}
			return false;
		}
	}
}
