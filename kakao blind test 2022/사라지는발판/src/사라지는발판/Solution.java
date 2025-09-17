package 사라지는발판;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution {

	static int[][]moveMap;
	List<Result> results=new ArrayList<Solution.Result>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution s=new Solution();
		s.solution(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, new int[] {1,0}, new int[]{1,2});

	}

	 public int solution(int[][] board, int[] aloc, int[] bloc) {
		 moveMap=board;
		 Position a=new Position(aloc[0], aloc[1], null);
		 Position b=new Position(bloc[0], bloc[1], null);
		 List<Position> visitedA = new ArrayList<Solution.Position>();
		 visitedA.add(a);
		 
		 List<Position> visitedB = new ArrayList<Solution.Position>();
		 visitedB.add(b);
		 
		 dfs(a,b,visitedA,visitedB,true,0);
		 
		 for(Result result : results) {
			 System.out.println(result.toString());
		 }
		 
	        return 1;
	    }
	 
	
	 
	 public void dfs(Position A, Position B , List<Position> visitedA, List<Position> visitedB,boolean Amove,int moveCount) {
		 System.out.println("===="+Amove+"====");
		 //A가 visitedA에 이미 포함된 상태!
		 //B 또한 visitedB에 포함된 상태
		 System.out.println("A postion : "+A.y+","+A.x);
		 System.out.println("B postion : "+B.y+","+B.x);
		 
		 System.out.println("A 방문 경로 : ");
			for(Position p : visitedA) {
				System.out.print("("+p.y+","+p.x+") -> ");
			}
			
		System.out.println();
		System.out.println("B 방문 경로 : ");
		for(Position p : visitedB) {
					System.out.print("("+p.y+","+p.x+") -> ");
		}
		System.out.println();
		
		List<Position> totalVisited=new ArrayList<Solution.Position>();
		totalVisited.addAll(visitedA);
		totalVisited.addAll(visitedB);
		
		//상대방의 현재 포지션도 갈 수 있으니 상대방의 위치 빼주기
		if(Amove) {
			totalVisited.remove(B);
		}else {
			totalVisited.remove(A);
		}
		System.out.println("totalVisited 경로 (상대 포지션을 제외한 실제 접근 불가능한 경로)");
		for(Position p : totalVisited) {
			System.out.print("("+p.y+","+p.x+"),");
		}
		System.out.println();
		
		List<Position> moveablePosition=moveablePositionTotal(Amove? A : B, totalVisited);
		
		System.out.println("moveablePosition ");
		
		
		if(moveablePosition.size()==0) {
			
			System.out.print(Amove?"A" : "B");
			System.out.println("가 더 이상 이동할 수 없어서 졌음.");
			// !Amove a기준으로 a가 졌다!
			Result result=new Result(A, B, visitedA, visitedB, !Amove,moveCount);
			results.add(result);
			return;
		}else if(A.equals(B)){
			System.out.print(Amove?"A" : "B");
			System.out.print("가 이동하여 , 같은 자리에 있던, ");
			System.out.println(Amove? "B" : "A"+"가 졌다.");
			

			Result result=new Result(A, B, visitedA, visitedB, Amove,moveCount);
			results.add(result);
			
			return;
		}
		
		
		for(Position p : moveablePosition) {
			System.out.print("("+p.y+","+p.x+"),");
		}
		System.out.println("\n\n");
		
		for(Position p : moveablePosition) {
			System.out.println(p.y+","+p.x+" 선택");
			List<Position> visitedUpdate=new ArrayList<Solution.Position>(Amove? visitedA :visitedB );
			visitedUpdate.add(p);
			if(Amove) {
				dfs(p,B,visitedUpdate,visitedB,!Amove,moveCount+1);
			}else {
				dfs(A,p,visitedA,visitedUpdate,!Amove,moveCount+1);
			}
		}
		
		
	 }
	 
	 public List<Position> moveablePositionTotal(Position p,List<Position> visited){
		 
		 int dxs[]= {0,0,1,-1};
		 int dys[]= {1,-1,0,0};
		 
		 int x=p.x;
		 int y=p.y;
		 
		 List<Position> moveableList=new ArrayList<Solution.Position>();
		 for(int i=0; i<4; i++) {
			 int dx=x+ dxs[i];
			 int dy=y+dys[i];
			 //y는 행
			 //x는 열
			 if(dx >= moveMap[0].length || dx < 0 || dy >= moveMap.length || dy < 0 )continue;
			 Position np=new Position(dy,dx,p);
			 if(moveMap[dy][dx]==1 && !visited.contains(np)) {
				 moveableList.add(np);
			 }
		 }
		 return moveableList;
		 
	 }

	 
	 
	 //visit의 기준이 지나간경우! 즉 현재 본인의 위치는 visit이 아니고 이후에 이동을 해야해야 visit이 된다
	 //즉 A의 시작이 1,0 이라면 그때의 VISIT은 NULL이 되는것이다.	 
// public void dfs(Position A, Position B , List<Position> visitedA, List<Position> visitedB,boolean Amove,int moveCount) {
//		 
//		
//		 
//		 
//		 //이동을 하면 이전 자리를 불가능한 영역으로 바꾼다.
//		 //이때 다른 상대방이 이전 자리에 있다면 현재 그사람이 승리!
//		 List<Position> newVisitedA=visitedA;
//		 List<Position> newVisitedB=visitedB;
//		 if(Amove) {
//			 //A가 이동할 차례다!
//			 
//			 if(A.beforeBPosition!=null) {
//				 newVisitedA=new ArrayList<Position>(visitedA);
//				 newVisitedA.add(A.beforeBPosition);
//				 if(A.beforeBPosition.equals(B)) {
//					 //A가 이긴것
//					 Result result=new Result(A, B, newVisitedA, visitedB, true);
//					 results.add(result);
//					 System.out.println("A승리");
//					 return;
//				 }
//			 }
//			
//		 }else {
//			 if(B.beforeBPosition!=null) {
//				 newVisitedB=new ArrayList<Position>(visitedB);
//				 newVisitedB.add(B.beforeBPosition);
//				 
//				 if(B.beforeBPosition.equals(A)) {
//					 //B가 이긴것
//
//					 Result result=new Result(A, B, visitedA, newVisitedB, false);
//					 results.add(result);
//					 System.out.println("B승리");
//					 return;
//				 }
//			 }
//			 
//		 }
//		 
//		 
//		 //예를들어서 visitedA 가 { (1,1) , (2,2) } 이고 현재  A가 (2,2)
//		 //visitedB 가 { (1,2) , (1,3) } 이고 현재  B가 (1,3)
//		 //근데 중요한 것은 이동 후! 그 자리에 갈 수 없게 되는게 포인트
//		 //visitedB에 현재 B가 포함되어 있지만 A는 B지점에 갈 수 있다!라는 것
//		 
//		 List<Position> moveablePosition=null;
//		
//		 if(Amove) {
//			 moveablePosition=moveablePosition(A,newVisitedA,newVisitedB);
//			 if(moveablePosition.size()==0) {
//				 Result result=new Result(A, B, newVisitedA, visitedB, false);
//				 results.add(result);
//			 		System.out.println("B 승리");
//			 		return;
//			 }
//		 }else {
//			 moveablePosition=moveablePosition(B,newVisitedB,newVisitedA);
//			 if(moveablePosition.size()==0) {
//				 Result result=new Result(A, B, visitedA, newVisitedB, true);
//				 results.add(result);
//			 		System.out.println("A 승리");
//			 return;
//			 }
//		 }
//		 
//			 System.out.println("========"+Amove+"======= move : "+moveCount);
//			 System.out.println("A postion : "+A.y+","+A.x);
//			 System.out.println("B postion : "+B.y+","+B.x);
//			 
//			 System.out.println("A 방문 경로 : ");
//				for(Position p : newVisitedA) {
//					System.out.print("("+p.y+","+p.x+") -> ");
//				}
//				
//			System.out.println();
//			System.out.println("B 방문 경로 : ");
//			for(Position p : newVisitedB) {
//						System.out.print("("+p.y+","+p.x+") -> ");
//			}
//			System.out.println();
//			 
//		
//		 
//		 
//		 if(Amove) {
//			 for(Position moveA : moveablePosition) {
//				 	
//				 dfs(moveA,B,newVisitedA,newVisitedB,false,moveCount+1);
//			 
//		 }
//		 }else {
//			 for(Position moveB : moveablePosition) {
//
//				 dfs(A,moveB,newVisitedA,newVisitedB,true,moveCount+1);
//			 
//			 }
//		 }
//		 
//		
//	 }
	 
	 public class Result{
		 boolean aWin;
		 Position a,b;
		 List<Position> visitedA,visitedB;
		 int moveCount;
		 public Result(Position a,Position b,List<Position> visitedA,List<Position> visitedB,boolean aWin,int moveCount) {
			 this.aWin=aWin;
			 this.a=a;
			 this.b=b;
			 this.visitedA=visitedA;
			 this.visitedB=visitedB;
			 this.moveCount=moveCount;
		 }
		 
		 @Override
		public String toString() {
			
			StringBuilder sb=new StringBuilder();
			sb.append(" A 승리여부 : "+aWin+"\n");
			sb.append(" A postion : ("+a.x+","+a.y+")\n");
			sb.append(" B postion : ("+b.x+","+b.y+")\n");
			sb.append(" moveCount : "+moveCount);
			
//			sb.append(" A 방문 경로 : ");
//			for(Position p : visitedA) {
//				sb.append("("+p.y+","+p.x+") -> ");
//			}
//			sb.append("\n");
//			
//			sb.append(" B 방문 경로 : ");
//			for(Position p : visitedB) {
//				sb.append("("+p.y+","+p.x+") -> ");
//			}
			sb.append("\n");
			
			return sb.toString();
		}
	 }
	 
	 public List<Position> moveablePosition(Position p,List<Position> visited, List<Position> visitedB){
	 
		 int dxs[]= {0,0,1,-1};
		 int dys[]= {1,-1,0,0};
		 
		 int x=p.x;
		 int y=p.y;
		 
		 List<Position> moveableList=new ArrayList<Solution.Position>();
		 for(int i=0; i<4; i++) {
			 int dx=x+ dxs[i];
			 int dy=y+dys[i];
			 //y는 행
			 //x는 열
			 if(dx >= moveMap[0].length || dx < 0 || dy >= moveMap.length || dy < 0 )continue;
			 Position np=new Position(dy,dx,p);
			 if(moveMap[dy][dx]==1 && !visited.contains(np) && !visitedB.contains(np)) {
				 moveableList.add(np);
			 }
		 }
		 return moveableList;
		 
	 }


	 class Position{
		 int y;
		 int x; // [y,x]로 배열을 의미한다.
		 
		 Position beforeBPosition;
		 public Position(int y, int x,Position beforeBPosition) {
			 this.x=x;
			 this.y=y;
			 this.beforeBPosition=beforeBPosition;
		 }
		 
		 @Override
		public boolean equals(Object obj) {
			 Position p=(Position)obj;
			// TODO Auto-generated method stub
			return this.x==p.x && this.y==p.y; 
		}
		
		 @Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return Objects.hash(x,y);
		}
	 }
}
