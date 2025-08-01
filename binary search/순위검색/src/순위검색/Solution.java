package 순위검색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		String infos[]=new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
//		String query[]=new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
//		
//		Solution s=new Solution();
//		int [] result=s.solution(infos, query);
//		System.out.println(Arrays.toString(result));
//
//	}
//	
	public int[] solution(String [] info,String [] query) {
		Info infos[]=reset(info);
		
		int result[]=new int[query.length];
		
		for(int i=0; i<query.length; i++) {
			String[] queryArr=query[i].replaceAll("and","").replaceAll("\\s+"," ").trim().split(" ");
			//System.out.println(i+"일떄" +queryArr[0]+queryArr[1]+queryArr[2]+queryArr[3]+queryArr[4]);
			//result[i]=recurison(queryArr,0,infos);
			result[i]=countMatches(queryArr,infos);
			//System.out.println(result[i]);
		}
		return result;
	}
	
	//인포에서 조건에 맞는 애들 찾기.
	public int recurison(String[] conditions, int currentConditionIndex,Info[] infos) {
		if(currentConditionIndex==5) {
			return infos.length;
		}
		
		List<Info> newInfos=new ArrayList<Info>();
		
		String condition=conditions[currentConditionIndex];
		for(Info info : infos) {
			if(condition.equals("-")) {
				newInfos.add(info);
			}else if(currentConditionIndex==4) {
				if(Integer.parseInt(condition)<=Integer.parseInt(info.getByIndex(currentConditionIndex))) {
					newInfos.add(info);
				}
			}
			else if(condition.equals(info.getByIndex(currentConditionIndex))) {
				newInfos.add(info);
			}
		}
		
		Info[] newInfosArray=newInfos.toArray(new Info[newInfos.size()]);
		
//		System.out.println(condition+"조건에 거른 info");
//		for(int i=0; i<newInfosArray.length; i++) {
//			System.out.println(newInfosArray[i]);
//		}
		
		return recurison(conditions,currentConditionIndex+1,newInfosArray);
		
	}
	
	public int countMatches(String[] conditions, Info[] infos) {
	    int count = 0;
	    int targetScore = Integer.parseInt(conditions[4]);
	    
	    for(Info info : infos) {
	        // 모든 조건을 한 번에 체크
	        if((conditions[0].equals("-") || conditions[0].equals(info.language)) &&
	           (conditions[1].equals("-") || conditions[1].equals(info.role)) &&
	           (conditions[2].equals("-") || conditions[2].equals(info.career)) &&
	           (conditions[3].equals("-") || conditions[3].equals(info.food)) &&
	           (conditions[4].equals("-") || targetScore <= Integer.parseInt(info.score))) {
	            count++;
	        }
	    }
	    return count;
	}
	
	public class Info{
		public String language;
		public String role;
		public String career;
		public String food;
		public String score;
		
		public Info(String language,String role, String career, String food ,String score) {
			this.career=career;
			this.food=food;
			this.language=language;
			this.role=role;
			this.score=score;
		}
		
		public String getByIndex(int index) {
			switch(index) {
			case 0:
				return this.language;
			case 1:
				return this.role;
			case 2:
				return this.career;
			case 3:
				return this.food;
			case 4:
				return this.score;
			}
			return "";
			
		}
		
	}
	
	public Info[] reset(String datas[]) {
		
		Info infos[]=new Info[datas.length];
		for(int i=0; i<datas.length; i++) {
			String dataArr[]=datas[i].split(" ");
			infos[i]=new Info(dataArr[0],dataArr[1],dataArr[2],dataArr[3],dataArr[4]);
		}
		return infos;
	}

}
