package 키패드누르기_67256;

import java.util.HashMap;
import java.util.Map;

public class Solution {

//	public static void main(String[] args) {
//	
//	
//	Solution s =new Solution();
//	s.solution(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right");
//}


public String solution(int[] numbers, String hand) {
	int number[]=new int[] {1,2,3,4,5,6,7,8,9,-1,0,-2};
	Map<Integer,Point> map=new HashMap<Integer,Point>();
	for(int i=0; i<number.length; i++) {
		int row=i/3;
		int col=i%3;
		int value=i+1;
		if(value==10||value==12)continue;
		
		if(value==11) {
			value=0;
		}
		
		map.put(value, new Point(row, col));
	}
	
	
	Point left=new Point(3, 0);
	Point right=new Point(3, 2);
	
	StringBuilder sb=new StringBuilder();
	for(int i=0; i<numbers.length; i++) {
		int n=numbers[i];
		Point move=map.get(n);
		
		if(n==1||n==4||n==7) {
			sb.append("L");
			left=move;
			continue;
		}else if(n==3||n==6||n==9) {
			sb.append("R");
			right=move;
			continue;
		}
		
		
		
		//왼쪽 오른쪽 비교
		int leftGap=Math.abs(move.x-left.x) +Math.abs(move.y-left.y); 
		int rightGap=Math.abs(move.x-right.x) +Math.abs(move.y-right.y);
		if(leftGap<rightGap) {
			sb.append("L");
			left=move;
		}else if(rightGap<leftGap) {
			sb.append("R");
			right=move;
		}else {
			if(hand.equals("right")) {
				sb.append("R");
				right=move;
			}else {
				sb.append("L");
				left=move;
			}
						
		}
		

	}

	
	
	System.out.println(sb.toString());
	return sb.toString();
	
}
	
class Point{
	int y;
	int x;
	public Point(int y,int x) {
	this.y=y;
	this.x=x;
	}
}

}
