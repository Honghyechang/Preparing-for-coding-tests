package 아이템줍기;

import java.util.LinkedList;
import java.util.Queue;

//import org.w3c.dom.Node;



public class Solution {
	class Node{
		int x,y,step;
		public Node(int x,int y, int step) {
			 this.x=x;
			 this.y=y;
			 this.step=step;
		}
  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		int n=s.solution(new int[][] {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}}, 1, 3, 7, 8);
System.out.println(n);
	}

	 public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
	       
	        int answer=bfs(rectangle,characterX,characterY,itemX,itemY);
	        return answer;
	 }
	 
	 public int bfs(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		 //map 크기는 5151
		 //x,y 좌표 (4 , 3)을 -> [x][y] 에 매칭한다 즉 [4][3]
		 int map[][]=new int[102][102];
		 boolean visit[][]=new boolean[102][102];
		 
		 
		 //map 을 초기화 시킬것인데, 현재는 모두 0으로 되어있지만 rectangle을 참고해서 범위에 해당하는 값들은 모두 1로 바꾼다.
		 for(int i=0; i<rectangle.length; i++) {
			 int startX=rectangle[i][0];
			 int startY=rectangle[i][1];
			 int endX=rectangle[i][2];
			 int endY=rectangle[i][3];
			 
			 for(int j=startX; j<=endX ; j++) {
				 for(int k=startY; k<=endY; k++) {
					 if(map[j][k]!=1) {
						 map[j][k]=1 ;
					 }
				 }
			 }
		 }
		 
//		 for(int i=0; i<51; i++) {
//			 for(int j=0; j<51; j++) {
//				
//					System.out.print(map[i][j] + " ");
//				 
//			 }
//			 System.out.println();
//		 }
		
		 //자 이제 경계값을 어떻게 아는지
		 //현재 사각형들이 겹치는 부분은 11111이고, 겹치지 않는 부부은 0000인데
		 //겹치지 않는 부분은 바깥테두리 와 안쪽 공간으로 구분할 수 있다.
		 //경계값을 찾기위에서는 0,0 부터 연결되는 0인 값들을 다 2로 바꾸면
		 // 0 : 안쪽공간 1: 겹치는 사각형 2 : 바깥쪽
		 // 이제 주어진 시작점부터 bfs를 하는데, 
		 // 좌 우 위 아래에 2인 지점 즉 바깥지점이라면 그 값을 queue에 넣을 수 있도록 한다!
		 
		 
		 Queue<Node> bloodQueue=new LinkedList<Node>();
		 Node zeroNode=new Node(0,0,0); //여기서 스텝은 굳이 사용하지 않는다.
		 bloodQueue.add(zeroNode);
		 
		 boolean zeroVisit[][]=new boolean[51][51];
		 zeroVisit[0][0]=true;
		 map[0][0]=2;
		 int dxs[]= {-1,1,0,0};
		 int dys[]= {0,0,1,-1};
		 
		 while(!bloodQueue.isEmpty()) {
			 Node node=bloodQueue.poll();
			 int nodeX=node.x;
			 int nodeY=node.y;
			 for(int i=0; i<4;i++) {
				 int dx=nodeX+dxs[i];
				 int dy=nodeY+dys[i];
				 
				 if (dx < 0 || dx >= 51 || dy < 0 || dy >= 51) continue;
				 if(map[dx][dy]==0 && !zeroVisit[dx][dy]) {
					 map[dx][dy]=2;
					 zeroVisit[dx][dy]=true;
					 Node z=new Node(dx,dy,0);
					 bloodQueue.add(z);
					 
				 }
			 }
		 }
		 
//		 System.out.println("블러드");
//		 for(int i=0; i<51; i++) {
//		 for(int j=0; j<51; j++) {
//			
//				System.out.print(map[i][j] + " ");
//			 
//		 }
//		 System.out.println();
//	 }
		 
		 
		 
		 int dxy[]= {-1,1,0};
		 
		 Node startNode=new Node(characterX,characterY,0);
		 Queue<Node> queue=new LinkedList<Node>();
		 
		 queue.add(startNode);
		 visit[startNode.x][startNode.y]=true;
	
		 while(!queue.isEmpty()) {
			 Node node=queue.poll();
			 int nodeX=node.x;
			 int nodeY=node.y;
			 int step=node.step;
			 
			 System.out.println("poll : "+ nodeX + " , "+ nodeY + "  step : "+step);
			 
			 
			 for(int i=0; i<4; i++) {
				 
				
				 int dx=nodeX+dxs[i];
				 int dy=nodeY+dys[i];
				 
				 
				 
				 if (dx < 0 || dx >= 51 || dy < 0 || dy >= 51) continue;
				 
				 if(map[dx][dy]==1 && !visit[dx][dy]) {
					 System.out.println("===dx : "+dx + " dy : "+dy+"일 때 검사 시작=== " + "i값 : "+i );
					 
					 boolean flag=false;
					 for(int k=0; k<3; k++) {
						 
						 for(int l=0; l<3; l++) {
							 int ddx=dx+dxy[k];
							 int ddy=dy+dxy[l];
							 
							 System.out.println("dx : "+ dx + "에서 "+dxy[k]+"만큼이동 결과 " +ddx);
							 System.out.println("dy : "+ dy + "에서 "+dxy[l]+"만큼이동 결과 " +ddy);
								
							 if (ddx < 0 || ddx >= 51 || ddy < 0 || ddy >= 51) continue;
							 if(map[ddx][ddy]==2) {
								 System.out.println("ddy : "+ddy+ " ddx : "+ddx +"일 때 2" );
								 flag=true;
								 break;
							 }
							 
						 }
						 if(flag)break;
						
					 }
					 System.out.println("flag  : "+flag );
					 if(flag) {
						 System.out.println("바깥 : " + dx + " , "+dy);
						 map[dx][dy]=3;
						//System.out.println(dx+","+dy+" step : "+(step+1));
						 queue.add(new Node(dx,dy,step+1));
						 visit[dx][dy]=true;
						 if(dx==itemX && dy==itemY) {
							 return step + 1;
						 }
					 }
					 
				 }
			 
			
		 }
		  
	 }
		 return -1;

	 
	 
}

}


