package 교점에별만들기_87377;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		s.solution(new int[][]{
			{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}
		});

	}

	 public String[] solution(int[][] line) {
		 
		 Set<Point> points=new HashSet<Point>();
		 getPoints(line,points);
		 
		 for(Point p : points) {
			 System.out.println(p.x+","+p.y);
		 }
		 
		 
		 int maxAndMinArr[]=maxAndMin(points);
		 System.out.println(Arrays.toString(maxAndMinArr));
		 
		 int width=Math.abs(maxAndMinArr[0]-maxAndMinArr[1]) +1;
		 int height=Math.abs(maxAndMinArr[2]-maxAndMinArr[3])+1;
		 
		 char[][] chars=new char[height][width];
		 for(int i=0; i<chars.length; i++) {
			 Arrays.fill(chars[i],'.');
			 
		 }
	
		 for(Point p : points) {
			 System.out.println(p.x+","+p.y); //좌표를 배열로 바꾸는 공식
			 int x=p.x-maxAndMinArr[1];
			 int y=maxAndMinArr[2]-p.y;
			 System.out.println(x+","+y);
			 
			 chars[y][x]='*';
		 }
		 
		 String answer[]=new String[height];
		 for(int i=0; i<chars.length; i++) {
			 StringBuilder sb=new StringBuilder();
			 for(int j=0; j<chars[i].length; j++)
			 {
				// System.out.print(chars[i][j]);
				 sb.append(chars[i][j]);
			 }
			// System.out.println();
			 answer[i]=sb.toString();
		}
		 
		// System.out.println(width+","+height);
		 
		 
		 
		 return answer;
	 }
	 
	 public int[] maxAndMin(Set<Point> points) {
		 
		 //int a=[x최대,x최소 , y최대 ,y최소]
		 int maxAndMinArr[]=new int[4];
		 int maxX=Integer.MIN_VALUE;
		 int maxY=Integer.MIN_VALUE;
		 int minX=Integer.MAX_VALUE;
		 int minY=Integer.MAX_VALUE;
		 
		 for(Point p : points) {
			 if(p.x>maxX) {
				 maxX=p.x;
			 }
			 if(p.x<minX) {
				 minX=p.x;
			 }
			 if(p.y>maxY) {
				 maxY=p.y;
			 }
			 if(p.y<minY) {
				 minY=p.y;
			 }
		 }
		 
		 maxAndMinArr[0]=maxX;
		 maxAndMinArr[1]=minX;
		 maxAndMinArr[2]=maxY;
		 maxAndMinArr[3]=minY;
		 return maxAndMinArr;
		 
		 
	 }
	 
	 public void getPoints(int[][]lines, Set<Point> points) {
		 
		 //ax +by +c=0
		 //dx +ey +f=0 일경우
		 
		 //1)겹치거나 평행한지 확인하는법
		 //ae-bd=0이면 평행 또는 일치 ->겹치는 부분이 없다.
		 
		 //2)겹치는 교점 찾기
		 //x=(bf-ce)/(ae-bd)
		 //y=(cd-af)/(ae-bd)
		 
		 for(int i=0; i<lines.length; i++) {
			 
			 int a=lines[i][0];
			 int b=lines[i][1];
			 int c=lines[i][2];
			 for(int j=i+1; j<lines.length; j++) {
				 
				 int d=lines[j][0];
				 int e=lines[j][1];
				 int f=lines[j][2];
				 
				 double parlCheck=(a*e) - (b*d);
				 if(parlCheck!=0) {
					 //교점이 존재한다.
					 double x=(double)(b*f-c*e)/(a*e-b*d);
					 double y=(double)(c*d-a*f)/(a*e-b*d);

					 //System.out.println(i+"와"+j+"교점이 존재한다. ->"+x+","+y);
					 //정수인지 확인
					 if(x%1!=0 || y%1!=0) {
						 continue;
					 }
					// System.out.println(x+","+y);
					 Point p=new Point((int)x,(int)y);
					 points.add(p);
					 
				 }
				 
			 }
		 }
	 }
	 
	 class Point
	 {
		 int x,y;
		 public Point(int x, int y) {
			 this.x=x;
			 this.y=y;
		 }
		 
		 @Override
		public boolean equals(Object obj) {
			Point p=(Point)obj;
			
			return p.x==this.x && p.y==this.y? true : false;
		}
		 
		 @Override
		public int hashCode() {
			return Objects.hash(x,y);
		}
	 }
}
