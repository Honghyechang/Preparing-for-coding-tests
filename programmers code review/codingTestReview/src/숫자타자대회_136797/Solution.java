package 숫자타자대회_136797;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	int max=Integer.MIN_VALUE;
	int resultMemos[][][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Solution s= new Solution();
s.solution("1756");
	}
	
	public int solution(String numbers) {
		
		
		resultMemos=new int[numbers.length()][10][10];
		for (int[][] m2d : resultMemos) {
		    for (int[] m1d : m2d) {
		        // -1로 초기화하여 '계산 안 됨' 상태를 명확히 구분
		        Arrays.fill(m1d, -1); 
		    }
		}
		
		
		List<Point> points=new ArrayList<Solution.Point>();
		for(int i=0; i<12; i++) {
			int n=i+1;
			int y= i / 3;
			int x= i % 3;
			if(i==9 || i==11 )continue;
			if(i==10) {
				n=0;
			}
		//	System.out.println(n + " : " + y+","+x);
			Point p=new Point(n, y, x);
			points.add(p);
			
		}
		
		
		int memos[][]=new int[10][10]; // [0][1] 0->1을 의미한다.
		for(int m[] : memos) {
			Arrays.fill(m, -1);
		}
		
		for(int i=0; i<points.size(); i++) {
			Point start=points.get(i);
			for(int j=0; j<points.size(); j++) {
				Point end=points.get(j);
				if(start.number == end.number) {
					memos[start.number][end.number]=1;
				}else {
					//최소 경로를 구해보자
					int ymove=Math.abs(start.y-end.y);
					int xmove=Math.abs(start.x-end.x);
					
					//대각선
					int diagonal=Math.min(ymove, xmove);
					int straight=Math.abs(xmove-ymove);
					
					int weight=diagonal*3 + straight*2;
					
					memos[start.number][end.number]=weight;
					
				}
			}
		}
		
		int answer=recursion(memos,4,6,0,numbers.toCharArray());
		
        System.out.println(answer);
        return answer;
    }
	
	
	public int recursion(int memos[][], int left, int right, int depth, char commands[]) {
		
		if(commands.length == depth) {
			return 0;
		}
		
		
		if(resultMemos[depth][left][right]!=-1) {
			
			//System.out.println(depth + " : " + left + " , " + right + " 중복!!");
			return resultMemos[depth][left][right];
		}
		
		
		//왼쪽과 오른쪽의 최소값
		int target=commands[depth]-'0';
		
		if(left==target) {
			//왼손으로만
			int leftScore=memos[left][target];
			int leftSum= leftScore+recursion(memos,target,right, depth+1,commands);
			
			resultMemos[depth][left][right]=leftSum;
			
			return leftSum;
			
		}else if(right==target) {
			int rightScore=memos[right][target];
			int rightSum=rightScore + recursion(memos,left,target, depth+1,commands);
					
			resultMemos[depth][left][right]=rightSum;
			
			return rightSum;
			
		}else {
			//왼손으로 가는경우
			int leftScore=memos[left][target];
			int leftSum= leftScore+recursion(memos,target,right, depth+1,commands);
			
			
			//오른으로 가는경우
			int rightScore=memos[right][target];
			int rightSum=rightScore + recursion(memos,left,target, depth+1,commands);
					
			
			int minSum=Math.min(leftSum, rightSum);
			
			resultMemos[depth][left][right]=minSum;
			
			return minSum;
		}
		
		
		
		
		
	}
	
	class Point{
		int number;
		int y;
		int x;
		public Point(int number,int y,int x) {
			this.number=number;
			this.y=y;
			this.x=x;
		}
	}
	
	
	

}
