package 서버증설횟수_389479;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	int life;

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//
//	Solution s=new Solution();
//	s.solution(new int[] {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5}, 3, 5);
//}


 public int solution(int[] players, int m, int k) {
	 life=k;
	 
	 List<Server> serverList=new ArrayList<Solution.Server>();
	 int createCount=0;
	 for(int i=0; i<players.length; i++) {
		 //현재 i에서 서버 생명끝난거 우선 없애기
		 serverList=removeServer(serverList,i);
		 
		 
		 //현재 필요한 서버 개수
		 int requireServerCount=players[i]/m;
		 
		 int currentServerCount=serverList.size();
		 
		 int create=requireServerCount-currentServerCount;
		 
		 
		 for(int j=0; j<create; j++) {
			 Server server=new Server(i);
			 serverList.add(server);
			 createCount++;
		 }
		 
		 
		 
		 
	 }
	 
	 System.out.println(createCount);
	 
	 return createCount;
	 
 }
 
 public List<Server>  removeServer(List<Server> serverList, int currentTime) {
	 
	 List<Server> update=new ArrayList<Solution.Server>();
	 for(Server server : serverList) {
		 if(!server.isRemove(currentTime)) {
			 update.add(server);
		 }
	 }
	 return update;
 }
 
 class Server{
	 int createTime;
	 public Server(int createTime) {
		 this.createTime=createTime;
	 }
	 public boolean isRemove(int time) {
		 return createTime+life==time;
	 }
 }

}
