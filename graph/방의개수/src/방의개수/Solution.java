package 방의개수;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
	
	
	class Vertex{
		String id;
		Set<String> knowVertexs=new HashSet<String>();
		
		public Vertex(String id) {
			this.id=id;
		}
	}
	
	int x, y=0;
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution s=new Solution();
//		int n=s.solution(new int[] {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0});
//		System.out.println(n+"정답");
//	}

	int solution(int arrows[]) {
	    int answer = 0;
	    
	    
	    Vertex v=new Vertex(x+","+y);
	    
	    
	    Map<String,Vertex> vertexs=new HashMap<String,Vertex>();
	    vertexs.put(x+","+y, v);
	    
	    for(int n : arrows) {
	    	
	    	for(int i=0; i<2; i++) {
	    		move(n);
		    	String id=x+","+y;
		    	//System.out.println(id);
		    	Vertex newVertex=new Vertex(id);
		    	
		    	if(!vertexs.containsKey(id)) {
		    		vertexs.put(id, newVertex);
		    	}
		    	else if(!v.knowVertexs.contains(id))
		    	{
		    		//System.out.println("방생성");
		    		answer++;
		    	}
		    	
//		    	newVertex.knowVertexs.add(v.id);
//		    	v.knowVertexs.add(id);
//		    	v=newVertex;
//		    	
		    	Vertex u = vertexs.get(id);
		    	v.knowVertexs.add(u.id);
		    	u.knowVertexs.add(v.id);
		    	v=vertexs.get(id);
	    	}
	    	
	    	
	    	
	    	
	    }
	    
	    
	  
	    
	    
	    return answer;
	}
	public void move(int n) {
		switch(n) {
		case 0 :
			y++;
			break;
		case 1 :
			x++;
			y++;
			break;
		case 2 :
			x++;
			break;
		case 3 :
			x++;
			y--;
			break;
		case 4 :
			y--;
			break;
		case 5 :
			x--;
			y--;
			break;
		case 6 :
			x--;
			break;
		case 7 :
			x--;
			y++;
			break;
		}
	}
	
}
