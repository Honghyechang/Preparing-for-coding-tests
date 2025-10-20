package 네트워크_43162;

import java.util.ArrayList;
import java.util.List;

public class Solution {

//	public static void main(String[] args) {
//	Solution s = new Solution();
//    int result1 = s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
// 
//}

	
	public int solution(int n, int[][] computers) {
		
		Node[] nodes=new Node[n];
		for(int i=0; i<nodes.length; i++) {
			nodes[i]=new Node(i);
		}
		
		
		for(int i=0; i<computers.length; i++) {
		    Node node=nodes[i];
			for(int j=0; j<computers[i].length; j++) {
				if(i!=j && computers[i][j]==1) {
					
					Node target=nodes[j];
					node.insert(target);
				}
			}
		}
		
		int answer=0;
		boolean visited[]=new boolean[n];
		for(int i=0; i<nodes.length; i++) {
			Node node=nodes[i];
			if(visited[i])continue;
			recursion(node,visited);
			answer++;
			
			
		}
		System.out.println(answer);
		return answer;
		
		
		
	}
	
	public void recursion(Node node , boolean[] visited) {
		if(visited[node.nodeNumber])return;
		
		visited[node.nodeNumber]=true;
		for(Node know : node.knows) {
			recursion(know,visited);
		}
		
		
	}
	
	
	class Node{
		int nodeNumber;
		List<Node> knows=new ArrayList<Solution.Node>();
		public Node(int nodeNumber) {
			this.nodeNumber=nodeNumber;
		}
		public void insert(Node node) {
			knows.add(node);
		}
		
	}
}
