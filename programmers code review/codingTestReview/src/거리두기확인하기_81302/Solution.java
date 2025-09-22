package 거리두기확인하기_81302;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

//			public static void main(String[] args) {
//		  Solution solution = new Solution();  // 인스턴스 생성
//		  
//		  // 테스트 케이스
//		  String places[][]=
//		  	{		{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
//		  			{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
//		  			{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, 
//		  			{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
//		  			{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
//		  	};
//		  int[] result = solution.solution(places);  // 인스턴스 메소드 호출
//		  System.out.println(Arrays.toString(result));
//		}
			
	public int[] solution(String places[][]) {
		
		int answer[]=new int[places.length];
		
		char map[][][]=new char[5][5][5];
		for(int i=0; i<places.length; i++) {
			
			char createMap[][]=new char[5][5];
			
			for(int j=0; j<places[i].length; j++) {
				
				String str=places[i][j];
				
				for(int k=0; k<str.length(); k++) {
					char ch=str.charAt(k);
					createMap[j][k]=ch;
				}
				
			}
			
			map[i]=createMap;	
		}
		
		for(int i=0; i<map.length; i++) {
			
			char checkMap[][]=map[i];
			answer[i]=distanceCheck(checkMap)? 1 : 0;
			
			
		}
		
		System.out.println(Arrays.toString(answer));
		
		
		return answer;
	}
	
	//true라면 안전, false라면 비안전
	public boolean distanceCheck(char checkMap[][]) {
		List<Point> points=getPoints(checkMap);
		if(points.size()==0) {
			return true;
		}
		
		
		//points 끼리 비교
		for(int i=0; i<points.size(); i++) {
			for(int j=i+1; j<points.size(); j++) {
				
				Point a=points.get(i);
				Point b=points.get(j);
				
				//이때 a는 b보다 y가 작거나 같다.
				
				int distance=Math.abs(a.x-b.x) +Math.abs(a.y-b.y);
				if(distance>2) {
					continue;
				}
				else if(distance<=1) {
					return false;
				}else {
					//2라면 확인을 해봐야해 그 사이에 있는지
					
					//PXP
					if(Math.abs(a.y-b.y)==0) {
						if(a.x < b.x) {
							//a가 더 왼쪽에 있다면
							if(checkMap[a.y][a.x+1]!='X') {
								//무조건 아웃
								return false;
							}
						}else {
							if(checkMap[a.y][b.x+1]!='X') {
								//무조건 아웃
								return false;
							}
						}
						
					}
					
					
					//PX
					//XP
					if(Math.abs(a.y-b.y)==1 && Math.abs(a.x-b.x)==1) {
						
						//이경우 b는 a보다 항상 y가 크거나 같다. 즉, a의 왼쪽 위 오른쪽 위는 신경 x
						//a 좌측하단 , b 우측하단만 신경쓰면된다.
						if(a.x > b.x) {
							if(checkMap[a.y][a.x-1]!='X' ||checkMap[a.y+1][a.x]!='X' ) {
								return false;
							}
						}
						else if(a.x < b.x) {
							if(checkMap[a.y][a.x+1]!='X' ||checkMap[a.y+1][a.x]!='X' ) {
								return false;
							}
						}
						
						
					}
					
					//P
					//X
					//P
					if(Math.abs(a.x-b.x)==0) {
						if(checkMap[a.y+1][a.x]!='X') {
							return false;
						}
					}
					
					
				}
				
				
			}
		}
		
		
		return true;
		
	}
	
	public List<Point> getPoints(char checkMap[][]){
		
		List<Point> points=new ArrayList<Solution.Point>();
		for(int i=0; i<checkMap.length; i++) {
			for(int j=0; j<checkMap[i].length;j++) {
				if(checkMap[i][j]=='P') {
					Point p=new Point(i, j); // i는 y j는 x
					points.add(p);
				}
			}
		}
		return points;
	}

	class Point{
		int x,y;
		public Point(int y,int x) {
			this.x=x;
			this.y=y;
		}
	}
}










