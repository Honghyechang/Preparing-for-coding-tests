package 다리를지나는트럭;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

	static int count=0;
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		Solution s=new Solution();
//		int n=s.solution(2, 10, new int[] {7,4,5,6});
//System.out.println(n);
//	}
	
    public int solution(int bridge_length, int weight, int[] truck_weights) {
    	
    	Queue<Integer> truckQueue=new LinkedList<Integer>();
    	Map<Integer, Integer> truckMap=new HashMap<Integer,Integer>();
    	
    	//최대 시간
    	int maxTime=Integer.MAX_VALUE;
    	
    	//트럭들 고유 인덱스
    	int index=0;
    	
    	for(int i=0; i<=maxTime; i++) {
    		//i는 초를 의미한다.
    		if(count==truck_weights.length) {
    			return i;
    		}
    		
    		//큐에 있는 트럭들을 +1 해서 bridge_length이면 큐에서 제외
    		mapExclude(truckMap,truckQueue,bridge_length);
    		
    		if( index<truck_weights.length&&!weightOver(truckQueue,truck_weights[index],weight)) {
    			truckQueue.add(truck_weights[index]);
    			truckMap.put(index, 0);
    			index++;
    		}
    	}
    	
        return -1;
    }
    
    public void mapExclude(Map<Integer, Integer> truckMap,Queue<Integer> truckQueue,int bridge_length) {
    	
    	
    	Set<Integer> set=truckMap.keySet();
    	Iterator<Integer> iterator=set.iterator();
    	
    	int update=-1;
    	
    	while(iterator.hasNext()) {
    		int key=iterator.next();
    		int value=truckMap.get(key);
    		
    		value++;
    		if(value==bridge_length) {

    			update=key;
    		}else {
    			truckMap.put(key, value);
    		}
    	}
    	if(update!=-1) {
    		truckMap.remove(update);
    		truckQueue.poll();
    		count++;
    		System.out.println(count);
    	}
		
    	
    }
    
    
    public boolean weightOver(Queue<Integer> truckQueue, int n , int weight) {
    	Queue<Integer> copy=new LinkedList<Integer>(truckQueue);
    	int sum=0;
    	while(!copy.isEmpty()) {
    		int m=copy.poll();
    		sum+=m;
    	}
    	
    	//true면 넘친다.
    	return n+sum > weight ? true : false;
    }

}
