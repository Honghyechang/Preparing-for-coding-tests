package 광물캐기_172917;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution(new int[] {1, 3, 2}, new String[] {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"});
//	}

	
	  public int solution(int[] picks, String[] minerals) {
		  
		  
		    Map<String,Map<String,Integer>> maps=new HashMap<String, Map<String,Integer>>();
		    Map<String,Integer> diamap=new HashMap<String, Integer>();
		    diamap.put("diamond", 1);
		    diamap.put("iron", 1);
		    diamap.put("stone", 1);
		    maps.put("diamond", diamap);
		    
		    
		    Map<String,Integer> ironmap=new HashMap<String, Integer>();
		    ironmap.put("diamond", 5);
		    ironmap.put("iron", 1);
		    ironmap.put("stone", 1);
		    maps.put("iron", ironmap);
		    
		    Map<String,Integer> stoneMap=new HashMap<String, Integer>();
		    stoneMap.put("diamond", 25);
		    stoneMap.put("iron", 5);
		    stoneMap.put("stone", 1);
		    maps.put("stone", stoneMap);
		    
		   
		    
		    //5개씩 나누어서 개수를 세기
		    int sum=Arrays.stream(picks)
		    			  .sum();
		    
		    //pick -> String[]
		    String pickString[]=new String[sum];
		    int index=0;
		    for(int i=0; i<picks.length; i++) {
		    	int n=picks[i];
		    	for(int j=0; j<n; j++) {
		    		if(i==0) {
		    			pickString[index++]="diamond";
		    		}else if(i==1) {
		    			pickString[index++]="iron";
		    		}else if(i==2) {
		    			pickString[index++]="stone";
		    		}
		    		
		    	}
		    }
		    
		    
		    if(sum*5 <= minerals.length) {
		    	minerals=Arrays.copyOfRange(minerals, 0, sum*5);
		    }
		    
		    List<Type> types=new ArrayList<Solution.Type>();
		    int remain=0;
	    	
	    	
	    	
	    	//나머지 존재
	    	for(int i=0; i<minerals.length; i+=5) {
	    		if(i+5>=minerals.length) {
	    			remain=i;
	    			break;
	    		}
		    	String cut[]=Arrays.copyOfRange(minerals, i, i+5);
		    	int diaCount=0;
		    	int ironCount=0;
		    	int stoneCount=0;
		    	
		    	for(String type : cut) {
		    		if(type.equals("diamond")) {
		    			diaCount++;
		    		}else if(type.equals("iron")) {
		    			ironCount++;
		    		}else {
		    			stoneCount++;
		    		}
		    	}
		    	types.add(new Type(diaCount, ironCount, stoneCount));	
		    }
	    	
	    	//나머지 처리
	    	String cut[]=Arrays.copyOfRange(minerals, remain, minerals.length);
	    	int diaCount=0;
	    	int ironCount=0;
	    	int stoneCount=0;
	    	
	    	for(String type : cut) {
	    		if(type.equals("diamond")) {
	    			diaCount++;
	    		}else if(type.equals("iron")) {
	    			ironCount++;
	    		}else {
	    			stoneCount++;
	    		}
	    	}
	    	types.add(new Type(diaCount, ironCount, stoneCount));
	    	
	    	
	    	
	    	Collections.sort(types,(a,b)->{
	    		if(a.diaCount!=b.diaCount) {
	    			return b.diaCount-a.diaCount;
	    		}else if(a.ironCount!=b.ironCount) {
	    			return b.ironCount-a.ironCount;
	    		}else {
	    			return b.stoneCount-a.stoneCount;
	    		}	
	    	});
	    	int i=0;
	    	int answer=0;
	    	for(Type t : types) {
	    		String type=pickString[i++];
	    		Map<String,Integer> typeMap=maps.get(type);
	    		

	    		int m=0;
	    		m+=t.diaCount*typeMap.get("diamond");
	    		m+=t.ironCount*typeMap.get("iron");
	    		m+=t.stoneCount*typeMap.get("stone");
	    		
	    		answer+=m;
	    	}
	    	System.out.println(answer);
	    	return answer;
	    	
	    
		    
		    
		    
		    
		    
	  }
	  
	  class Type{
		  int diaCount=0;
		  int ironCount=0;
		  int stoneCount=0;
		  
		  public Type(int diaCount,int ironCount,int stoneCount) {
			  this.diaCount=diaCount;
			  this.ironCount=ironCount;
			  this.stoneCount=stoneCount;
		  }
	  }
}
