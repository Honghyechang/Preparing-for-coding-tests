package 징검다리_43236;

import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Objects;

public class Solution {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	Solution s=new Solution();
//	
//	s.solution(25,new int[] {2,14,11,21,17}, 2);
//}

	public int solution(int distance, int rocks[],int n) {
		
		
	
		Arrays.sort(rocks);
		//서로 거리
		int rockPlus[]=new int[rocks.length+2];
		for(int i=0; i<rockPlus.length; i++) {
			if(i==0) {
				rockPlus[i]=0;
			}else if(i==rockPlus.length-1) {
				rockPlus[i]=distance;
			}else {
				rockPlus[i]=rocks[i-1];
			}
		}
		
		//System.out.println(Arrays.toString(rockPlus));
//		int pointToPointDistance[]=new int[rockPlus.length-1];
//		
//		for(int i=1; i<rockPlus.length; i++) {
//			int ppd=rockPlus[i]-rockPlus[i-1];
//			pointToPointDistance[i-1]=ppd;
//		}
//		System.out.println(Arrays.toString(pointToPointDistance));
		
		
		int s=0;
		int e=distance+1;
		int mid;
		//가능한 것중 최대값 s를 옮기기
		while(s+1<e) {
			mid=(s+e)/2;
			//조건에 만족하면
			if(minDistanceAble(mid,rockPlus,n)){
				s=mid;
			}else {
				e=mid;
			}
		}
		
		System.out.println(s);
		
		return s;
	}
	
	//최소 이거리를 만들려면 돌 몇개를 지워야해? 그때 n개보다 그 돌이 같야아해!
	//즉, 모든 거리가 d이상 되게 만들려면 바위 몇개 없애야해?
	public boolean minDistanceAble(int d,int rock[],int n) {
	
		int rockRemoveCount=0;
		
		//처음은 무조건 0
		int last=rock[0];
		for(int i=1; i<rock.length; i++) {
			int current=rock[i];
			if(current-last<d) {
//				if(i==rock.length-1) {
//					return false;
//				}
				rockRemoveCount++;
				continue;
			}
			last=current;
		}
		
		return rockRemoveCount <=n;
	}
	
	

}
