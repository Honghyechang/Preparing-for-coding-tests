package 단속카메라_42884_repeat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	Solution s=new Solution();
//	int n=s.solution(new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}});
//	System.out.println(n);
//}

	
	public int solution(int[][] routes) {
		
		List<Route> routesList=new ArrayList<Solution.Route>();
		for(int arr[]  : routes) {
			int start=arr[0];
			int end=arr[1];
			Route r=new Route(start, end);
			routesList.add(r);
		}
		
		Collections.sort(routesList,(a,b)->a.end - b.end);
		
		int cctvLocation=routesList.get(0).end;
		int answer=1;
		
		for(int i=1; i<routesList.size(); i++) {
			Route r=routesList.get(i);
			if(!r.isInclude(cctvLocation)) {
				answer++;
				cctvLocation=r.end;
			}
		}
		System.out.println(answer);
		return answer;
	}
	
	
	class Route{
		int start;
		int end;
		public Route(int start, int end) {
			this.start=start;
			this.end=end;
			
		}
		
		public boolean isInclude(int point) {
			return start<=point && point <=end;
		}
		
	}
}
