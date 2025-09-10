package 단속카메라;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution s=new Solution();
//		int n=s.solution(new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}});
//System.out.println(n);
//	}
//	
	
	public int solution(int[][] routes) {
		
		  List<Route> routeList=new ArrayList<Solution.Route>();
		  
		  for(int i=0; i<routes.length; i++) {
			  Route route=new Route(routes[i][0],routes[i][1]);
			  routeList.add(route);
		  }
		  
		  Collections.sort(routeList,(a,b)->a.end-b.end);
		  
		  
		  int camera=1;
		  int point=routeList.get(0).end;
		  
		  for(int i=1; i<routeList.size(); i++) {
			  Route route=routeList.get(i);
			  if(route.start > point) {
				  camera++;
				  point=route.end;
			  }
			  
		  }
		  
		
		return camera;
	}
	
//	  public int solution(int[][] routes) {
//		  
//		  int answer=0;
//		  
//		  List<Route> routeList=new ArrayList<Solution.Route>();
//		  
//		  for(int i=0; i<routes.length; i++) {
//			  Route route=new Route(routes[i][0],routes[i][1]);
//			  routeList.add(route);
//		  }
//		  
//		  Collections.sort(routeList,(a,b)->a.start-b.start);
//		  
//		  for(int i=0; i<routeList.size(); i++) {
//			  Map<Integer,Integer> maxDup =new HashMap<Integer,Integer>(); //가장 중복되는 경로
//			  Route route=routeList.get(i);
//			  
//			  if(route.visit) continue;
//			 
//			  for(int j=i; j<routeList.size(); j++) {
//				  Route compareRoute=routeList.get(j);
//				  if(compareRoute.visit) continue;
//				  duplicateCheck(route,compareRoute,maxDup);
//
//			  }
//			  
//			  //가장 maxDup에서 큰값을, 가장 겹치는 값을 가지고,
//			  //그 값을 경로로 가지고 있는 애들을 true로 바꿔준다.
//			  seekMaxAndVisit( maxDup, routeList);
//			  answer++;
//		  }
//		  
//	       //System.out.println(answer);
//	        return answer;
//	  }
//	  
//	  public void seekMaxAndVisit(Map<Integer,Integer> maxDup, List<Route> routeList) {
//		  
//		  int max=Integer.MIN_VALUE;
//		  int maxKey=Integer.MAX_VALUE;
//		  Set<Integer> sets=maxDup.keySet();
//		  Iterator<Integer> iterator=sets.iterator();
//		  
//		  while(iterator.hasNext()) {
//			  int key=iterator.next();
//			  int value=maxDup.get(key);
//			  
//			  if(value>=max) {
//				  //System.out.println("가장 많이 겹치는 포인트 : "+key);
//				  if(maxKey > key) {
//					  max=value;
//					  maxKey=key;
//					 // System.out.println("그중 가장 key가 작은 포인트 : "+key);
//				  }
//			  }
//		  }
//		  
//		  //System.out.println("max 포인트  : "+maxKey);
//		  
//		  for(int i=0; i<routeList.size(); i++) {
//			  Route r=routeList.get(i);
//			  if(maxKey>=r.start && maxKey <= r.end) {
//				  r.visit=true;
//				 // System.out.println(r.start + " , " + r.end +" 인 것 visit -> ture");
//			  }
//		  }
//		  
//	  }
//	  
//	  public void duplicateCheck(Route a, Route b, Map<Integer,Integer> maxDup) {
//		  for(int i=a.start; i<=a.end; i++) {
//			  if(i>=b.start && i<=b.end) {
//				  if(maxDup.containsKey(i)) {
//					  maxDup.put(i, maxDup.get(i)+1);
//				  }else {
//					  maxDup.put(i, 1);
//				  }
//				 
//			  }
//		  }
//	  }
//
	  class Route{
		  int start;
		  int end;
//		  boolean visit;
		  public Route(int start, int end) {
			  this.start=start;
			  this.end=end;
			  //visit=false;
		  }
	  }
}
