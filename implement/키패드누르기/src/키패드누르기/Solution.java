package 키패드누르기;

import java.util.HashMap;
import java.util.Map;

public class Solution {

//	public static void main(String[] args) {
//		
//		
//		Solution s =new Solution();
//		s.solution(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right");
//	}

	
	public String solution(int[] numbers, String hand) {
		
		Map<Integer , Point> phoneMap=new HashMap<Integer, Solution.Point>();
		
		
		for(int i=0; i<12; i++) {
			if(i==9 || i==11) {
				continue;
			}
			
			int x=i/3;
			int y=i%3;
			System.out.println(x+","+y);
			Point p=new Point(x, y);
			
			if(i==10) {
				phoneMap.put(0, p);
				System.out.println("key : 0"+x+","+y);
				
			}else{
				phoneMap.put(i+1, p);
				System.out.println("key : "+(i+1)+" "+x+","+y);
				
			}
			
			
		}
		
		StringBuilder sb=new StringBuilder();
		
		Point left=new Point(3, 0);
		Point right=new Point(3, 2);
		
		
		for(int i=0; i<numbers.length; i++) {
			int n=numbers[i];
			Point p=phoneMap.get(n);
//			System.out.println(n);
//			System.out.println("p.x : "+p.x+","+"p.y : "+p.y);
			if(n==1 || n==4|| n==7) {
				sb.append("L");
				left=p;
			}else if(n==3|| n==6|| n==9) {
				sb.append("R");
				right=p;
			}else {
				double leftLength=cal(left.x,left.y,p.x,p.y);
				double rightLength=cal(right.x,right.y,p.x,p.y);
				if(leftLength-rightLength > 0) {
					right=p;
					sb.append("R");
				}else if(leftLength-rightLength < 0) {
				 left=p;	
				 sb.append("L");
				}else {
					if(hand.equals("right")) {
						right=p;
						sb.append("R");
					}else {
						left=p;
						sb.append("L");
					}
					
				}
			}
		}
		System.out.println(sb.toString());
        return sb.toString();
    }
	
	class Point {
		int x,y;
		public Point(int x,int y) {
			this.x=x;
			this.y=y;

		}
	}
	
	public double cal(int x, int y, int a, int b) {
		return Math.abs(x-a)+Math.abs(y-b);
	}
}
