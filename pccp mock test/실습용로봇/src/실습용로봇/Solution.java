package 실습용로봇;

import java.util.Arrays;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution("GRGLGRG");
//	}
	 public int[] solution(String command) {
	        
	        Point p=new Point(0, 0);
	        for(int i=0; i<command.length(); i++) {
	        	char com=command.charAt(i);
	        	//System.out.println("("+p.x+","+p.y+")");
	        	
	        	if(com=='R') {
	        		p.rightTurn();
	        	}else if(com=='L') {
	        		p.leftTurn();
	        	}else if(com=='G') {
	        		p.moveGo();
	        	}else if(com=='B') {
	        		p.moveBack();
	        	}
	        	
	        }
	        
	        int[] answer = new int[] {p.x,p.y};
	        System.out.println(Arrays.toString(answer));
	        return answer;
	 }
	
	 enum Move{
		 TOP,BOTTOM,RIGHT,LEFT;
	 }
	 
	 class Point{
		 int x,y;
		 Move state=Move.TOP;
		 public Point(int x,int y) {
			 this.x=x;
			 this.y=y;
		 }
		 public void moveGo() {
		
			 
			 switch(this.state) {
			 case TOP:
				 this.y++;
				 return;
			 case BOTTOM:
				 this.y--;
				 return;
			 case RIGHT:
				 this.x++;
				 return;
			 case LEFT:
				 this.x--;
				 return;
				 
			 }
		 }
		 
		 public void rightTurn() {
			 switch(this.state) {
			 case TOP:
				 this.state=Move.RIGHT;
				 return;
			 case BOTTOM:
				 this.state=Move.LEFT;
				 return;
			 case RIGHT:
				 this.state=Move.BOTTOM;
				 return;
			 case LEFT:
				 this.state=Move.TOP;
				 return;
				 
			 }
		 }
		 
		 public void leftTurn() {
			 switch(this.state) {
			 case TOP:
				 this.state=Move.LEFT;
				 return;
			 case BOTTOM:
				 this.state=Move.RIGHT;
				 return;
			 case RIGHT:
				 this.state=Move.TOP;
				 return;
			 case LEFT:
				 this.state=Move.BOTTOM;
				 return;
				 
			 }
		 }
		 public void moveBack() {
		
			 
			 switch(this.state) {
			 case TOP:
				 this.y--;
				 return;
			 case BOTTOM:
				 this.y++;
				 return;
			 case RIGHT:
				 this.x--;
				 return;
			 case LEFT:
				 this.x++;
				 return;
				 
			 }
		 }
		 
	 }
}
