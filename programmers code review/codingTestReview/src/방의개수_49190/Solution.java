package 방의개수_49190;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Solution {
	
	int x, y=0;

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	Solution s=new Solution();
//	int n=s.solution(new int[] {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0});
//	System.out.println(n+"정답");
//	}

	int solution(int arrows[]) {
	
		Vertex beforeVertex=new Vertex(x, y);
		Map<String,Vertex> visited=new HashMap<String,Vertex>();
		
		visited.put(beforeVertex.id,beforeVertex);
		
		int answer=0;
		

		
		for(int type :arrows){
			//대각선을 위해 그냥 총 2번씩이동한다고 생각
			for(int i=0; i<2;i++) {
				move(type);

				
				//방문했는지 확인
//				
				String id=Vertex.createId(x, y);
				if(!visited.containsKey(id)) {
					Vertex moveVertex=new Vertex(x, y);
					visited.put(moveVertex.id,moveVertex);
					
				}else {
					if(!beforeVertex.knowVertexs.contains(id)) {
						answer++;
					}

				}
				Vertex moveVertex=visited.get(id);
				beforeVertex.know(moveVertex.id);
				moveVertex.know(beforeVertex.id);
				
				beforeVertex=moveVertex;
				
//				beforeVertex.know(moveVertex);
//				moveVertex.know(beforeVertex);
//				visited.add(moveVertex.id);
//				beforeVertex=moveVertex;
				
			}
		}
		
		System.out.println(answer);
		return answer;
		
	}
	
	public void move(int type) {
		
		if(type==0) {
			x=x;
			y=y+1;
		}else if(type==1) {
			x=x+1;
			y=y+1;
		}else if(type==2) {
			x=x+1;
			y=y;
		}else if(type==3) {
			x=x+1;
			y=y-1;
		}else if(type==4) {
			x=x;
			y=y-1;
		}else if(type==5) {
			x=x-1;
			y=y-1;
		}else if(type==6) {
			x=x-1;
			y=y;
		}else if(type==7) {
			x=x-1;
			y=y+1;
		}
		
		}

	class Vertex{
		int x;
		int y; //x,y는 좌표
		Set<String> knowVertexs;
		String id;
		public Vertex(int x, int y ) {
			this.x=x;
			this.y=y;
			id=createId(x, y);
			knowVertexs=new HashSet<String>();
		}
		
		public static String createId(int x, int y) {
			return x+","+y;
		}
		
		public void know(String id) {
			this.knowVertexs.add(id);
		}
		
		
		
	}
}
