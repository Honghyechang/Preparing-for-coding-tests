package day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {

//	public static void main(String[] args) {
//	  Solution2 solution = new Solution2();  // 인스턴스 생성
//	  
//	  // 테스트 케이스
//	  String places[][]=
//	  	{		{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
//	  			{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
//	  			{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, 
//	  			{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
//	  			{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
//	  	};
//	  int[] result = solution.solution(places);  // 인스턴스 메소드 호출
//	  System.out.println(Arrays.toString(result));
//	}
		
public int[] solution(String places[][]) {
	
	//잘지키고 있으면 1 , 어기면 0
	int answer[]=new int[places.length];
	for(int i=0; i<places.length;i++) {
		String[] checkString=places[i];
		List<Position> positionList=new ArrayList<Position>();
		for(int j=0; j<checkString.length;j++) {
			for(int k=0; k<checkString[j].length(); k++) {
				if(checkString[j].charAt(k)=='P') {
					positionList.add(new Position(j,k));
				}
				
			}
		}
		
		if(positionList.size()==0) {
			answer[i]=1;
		}else {
			answer[i]=checkRight(checkString,positionList,0)? 1:0;
		}

		System.out.println(answer[i]);
		
	}
	System.out.println(Arrays.toString(answer));
	return answer;
}

public boolean checkRight(String checkString[],List<Position> positionList,int index) {
	if(index==positionList.size()-1)return true;
	
	Position first=positionList.get(index);
	for(int i=index+1; i<positionList.size(); i++) {
		Position second=positionList.get(i);
		int distance=Math.abs(first.y-second.y) + Math.abs(first.x-second.x);
		if(distance<=1) {
			return false;
		}
		else if(distance==2) {
			//확인이 필요해
			//y이동만있는경우, x이동만있는경우 , 대각선인경우
			if(Math.abs(first.y-second.y)==2) {
				if(first.y-second.y>0) {
					if(checkString[first.y-1].charAt(first.x)!='X')return false;
				}else {
					if(checkString[first.y+1].charAt(first.x)!='X')return false;
				}
			}
			
			
			else if(Math.abs(first.x-second.x)==2) {
				if(first.x-second.x>0) {
					if(checkString[first.y].charAt(first.x-1)!='X')return false;
				}else {
					if(checkString[first.y].charAt(first.x+1)!='X')return false;
				}
			}
			
			else {
				if(first.y-second.y>0) {
					if(checkString[first.y-1].charAt(first.x)!='X')return false;
				}else {
					if(checkString[first.y+1].charAt(first.x)!='X')return false;
				}
				
				
				if(first.x-second.x>0) {
					if(checkString[first.y].charAt(first.x-1)!='X')return false;
				}else {
					if(checkString[first.y].charAt(first.x+1)!='X')return false;
				}
				
			}
			
			
			
		}
	}
	
	return checkRight(checkString,positionList,index+1);
	
	
	
	
	
}

class Position{
	int y;
	int x;
	public Position(int y,int x) {
		this.y=y;
		this.x=x;
	}
}

}
