package 네트워크개선;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	
//	public static void main(String[] args) {
//	Solution s = new Solution();
//    System.out.println("Test 1:");
//    int result1 = s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}});
// 
//}

	
	public int solution(int n, int[][] computers) {
		
		//visit 여부
		Map<Integer,Boolean> map=new HashMap<Integer, Boolean>();
		List<Node> nodes=new ArrayList<Solution.Node>();
		
		for(int i=0; i<n; i++) {
			map.put(i, false);
			nodes.add(new Node(i));
		}
		
		for(int i=0; i<computers.length; i++) {
			for(int j=0; j<computers.length; j++) {
				if(computers[i][j]==1 && i!=j) {
					//i - > j를 안다.
					Node inode=nodes.get(i);
					Node jnode=nodes.get(j);
					System.out.println(i+"가"+j+"를 안다");
					
					inode.children.add(jnode);
				}
			}
		}
		
		int count=0;
		for(int i=0; i<computers.length; i++) {
			
			if(map.get(i)==false) {
				Node node=nodes.get(i);
				dfs(node,map);
				count++;
			}
		}
		System.out.println(count);
		
		return count;
	}
	class Node{
		int number;
		List<Node> children=new ArrayList<Node>();
		
		public Node(int number) {
			this.number=number;
		}
	}
	
	public void dfs(Node node,Map<Integer,Boolean> map) {
		
		map.put(node.number, true);
		
		for(int i=0; i<node.children.size(); i++) {
			if(map.get(node.children.get(i).number)==false) {
				dfs(node.children.get(i),map);
			}
			
		}
	}
}
