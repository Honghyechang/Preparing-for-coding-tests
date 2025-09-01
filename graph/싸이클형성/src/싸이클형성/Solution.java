package 싸이클형성;

import java.util.HashMap;
import java.util.Map;

//사이클의 개수
public class Solution {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Solution s=new Solution();
int answer=s.solution(new int[] {1, 3, 5, 6, 3, 2, 1});
System.out.println(answer);
	}

	
	int solution(int arrows[]) {
	    int count = 0;
	    
	    Map<Integer,Integer> visitIndexMap=new HashMap<Integer,Integer>();
	    
	
	    
	    //중요한것은 싸이클이 형성되면 그 싸이클 형성된것은 지워야한다!라는것
	    
	    
	    for(int i=0; i<arrows.length; i++) {
	    	int visit=arrows[i];
	    	if(visitIndexMap.containsKey(visit)) {
	    		
	    			//사이클이 형성됐네?
	    			//visitIndexMap에서 visit의 인덱스를 찾고 현재 i-1까지 다 지워버려
	    			
	    			int index=visitIndexMap.get(visit);
	    			for(int j=index; j<i; j++) {
	    			
	    				int key=arrows[j];
	    				System.out.println("삭제 : "+key);
	    				visitIndexMap.remove(key);
	    			}
	    			
	    			count++;
	    			visitIndexMap.put(visit,i);
	    		
	    	}else {
	    		visitIndexMap.put(visit,i);
	    		
	    	}
	    }
	    
	    
	    return count;
	}

	
	public void fromFalse(Map<Integer,Boolean> visitMap , int currentIndex) {
		boolean flag=false;
		
	}
	

	

}
