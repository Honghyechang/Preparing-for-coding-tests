package 서버증설회수;

import java.util.ArrayList;
import java.util.List;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution(new int[] {0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1}, 1, 1);
//	}
//
//	
	 public int solution(int[] players, int m, int k) {
		 
		   List<Server> servers=new ArrayList<Server>();
		   int answer = 0;
		    for(int i=0; i<players.length; i++) {
		    	List<Server> removeServers=new ArrayList<Solution.Server>();
		    	for(Server s : servers) {
		    		if(!s.reduce()) {
		    			removeServers.add(s);
		    		}
		    	}
		    	
		    	for(Server s : removeServers) {
		    		servers.remove(s);
		    	}
		    	
		    	//서버 시간을 다 줄이기
		    	int player=players[i]; //i는 i~i+1시간을 의미
		    	int requireServer=(int)((double)player/m);
		    	
		    	int createServer=requireServer-servers.size();
		    	
		    	if(createServer>0) {
		    		
		    		for(int j=0; j<createServer; j++) {
		    			Server server=new Server(k);
		    			answer++;
		    			servers.add(server);
		    		}
		    		
		    	}
		    	
		    }
		 System.out.println(answer);
		 
	       
	        return answer;
	 }
	 
	 class Server{
		 int life;
		 public Server(int life) {
			 this.life=life;
		 }
		 public boolean reduce() {
			 life--;
			 //false가 되면 삭제해야한다.
			 return life==0 ? false : true;
		 }
		 
	 }
}
