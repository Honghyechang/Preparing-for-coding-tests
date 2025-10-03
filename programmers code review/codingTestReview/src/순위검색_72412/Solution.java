package 순위검색_72412;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	String infos[]=new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
	String query[]=new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
	
	Solution s=new Solution();
	int [] result=s.solution(infos, query);
	System.out.println(Arrays.toString(result));

	}
	
	public int[] solution(String [] info,String [] query) {
		
		for(int i=0; i<info.length; i++) {
			String infoString=info[i];
			String splits[]=infoString.split(" ");
			int score=Integer.parseInt(splits[4]);
			splits=Arrays.copyOfRange(splits, 0, 4);
			
			System.out.println(Arrays.toString(splits) +" ,score : "+score);
			dfs(splits,new ArrayList<Integer>(),0);
			
		}
		return new int[4];
		
	}

	public void dfs(String splits[],List<Integer> selectIndex,int start) {
		
		if(selectIndex.size()>0) {
			StringBuilder sb=new StringBuilder();
			for(int i=0; i<splits.length; i++) {
				String sp=splits[i];
				if(selectIndex.contains(i)) {
					sb.append("-");
				}else {
					sb.append(sp);
				}
			}
			System.out.println(sb.toString());
			if(selectIndex.size()==5)return;
		}
		
		for(int i=start; i<splits.length; i++) {
			
			selectIndex.add(i);
			dfs(splits,selectIndex,i+1);
			selectIndex.remove(Integer.valueOf(i));
		}
		
	}
}
