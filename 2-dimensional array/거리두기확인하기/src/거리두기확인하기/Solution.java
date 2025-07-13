package 거리두기확인하기;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	class Point{
		
		int y,x;
		public Point(int y, int x) {
			this.y=y;
			this.x=x;
			
		}
	}
	
	public static void main(String[] args) {
        Solution solution = new Solution();  // 인스턴스 생성
        
        // 테스트 케이스
        String places[][]=
        	{		{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
        			{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
        			{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, 
        			{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
        			{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        	};
        int[] result = solution.solution(places);  // 인스턴스 메소드 호출
        
        System.out.print("[");
        for(int i=0; i<result.length; i++) {
        	System.out.print(result[i]+" ");
        }
        
        System.out.println("]");
    }
	
	public int[] solution(String places[][]) {
		
		int result[]=new int[5];
		
		
		for(int i=0; i<5; i++) {
			//i는 방을 의미한다.
			String room[]=places[i];
			char strToChar[][]=new char[5][5];
			List<Point> pointsList=new ArrayList<Solution.Point>();
			
			
			
			for(int j=0; j<room[i].length(); j++) {
				strToChar[j]=room[j].toCharArray();	
			}
//			System.out.println(strToChar[0][0]+" " +strToChar[0][1]+strToChar[0][2]+strToChar[0][3]+strToChar[0][4] );
//			System.out.println(strToChar[4][0]+" " +strToChar[4][1]+strToChar[4][2]+strToChar[4][3]+strToChar[4][4] );
			
			for(int k=0; k<5; k++) {
				for(int w=0; w<5; w++) {
					if(strToChar[k][w]=='P') {
						pointsList.add(new Point(k,w));
					}
				}
			}
			
			Point[] points=pointsList.toArray(new Point[pointsList.size()]);
			System.out.println("i값이 "+i+"일 때 points");
			for(int p=0; p<points.length; p++) {
				System.out.print("("+points[p].y+ " , "+points[p].x+")	");
			}
			System.out.println();
			
			result[i]=placeCheck(strToChar,points);
		}
		
		return result;
	}
	
	public int placeCheck(char strToChar[][],Point[] points) {
		
		int check=1;//거리두기 지키고 있으면 1, 지키고 있지 않으면 0
		
		for(int i=0; i<points.length; i++) {
			for(int j=i+1; j<points.length; j++) {
				if(Math.abs(points[i].y-points[j].y) + Math.abs(points[i].x-points[j].x) <=2) {
					
					System.out.println("("+points[i].y+","+points[i].x+") 와 "+"("+points[j].y+","+points[j].x+")가 2 이하");
					
					//y방향 x방향 구하기
					//1)y방향
					int dy= points[i].y > points[j].y ? -1  : points[i].y == points[j].y ? 0 : 1 ;
					System.out.println("dy 방향이 "+dy);
					
					//2)x방향
					int dx= points[i].x > points[j].x ? -1 : points[i].x == points[j].x ? 0 : 1 ;
					System.out.println("dx 방향이 "+dx);
					
					if(dx!=0 && dy==0) {
						System.out.println("dx!=0 && dy==0 경우 " + strToChar[points[i].y][points[i].x+dx]);
						
						if(strToChar[points[i].y][points[i].x+dx]!='X') {
							
							check=0;
							break;
						}
						
					}else if(dx==0 && dy!=0) {
						System.out.println("dx==0 && dy!=0 경우 " + strToChar[points[i].y+dy][points[i].x]);
						
						if(strToChar[points[i].y+dy][points[i].x]!='X') {
							check=0;
							break;
						}
					}else if(dx!=0 &&  dy!=0) {
						System.out.println("dx!=0 &&  dy!=0 경우" +strToChar[points[i].y][points[i].x+dx] +strToChar[points[i].y+dy][points[i].x] );
						
						if(		!(strToChar[points[i].y][points[i].x+dx]=='X' && strToChar[points[i].y+dy][points[i].x]=='X')	) {
							check=0;
							break;
						}
					}
					
				
				}
			}
			if(check==0) {
				break;
			}
		}
		return check;
	}

}
