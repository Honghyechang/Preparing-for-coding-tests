package 섬연결하기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		int n=s.solution(4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}});
//		System.out.println(n);
//	}
	
	 public int solution(int n, int[][] costs) {
		 
		 List<Edge> edges=new ArrayList<Edge>();
		 
		 for(int i=0; i<costs.length; i++) {
			 Edge edge=new Edge(costs[i][0],costs[i][1],costs[i][2]);
			 edges.add(edge);
		 }
		 
		 Collections.sort(edges,(a,b)->a.weight-b.weight);
		 
		
		 
		 List<Node> nodes=new ArrayList<Node>();
		 for(int i=0; i<n; i++) {
			 Node node=new Node();
			 nodes.add(node);
		 }
		 

	        int answer = 0;
		for(int i=0; i<edges.size(); i++) {
			Edge edge=edges.get(i);
			Node node1=nodes.get(edge.node1);
			Node node2=nodes.get(edge.node2);
			
			if(node1.connect(node2))continue;
			node1.merge(node2);
			answer+=edge.weight;
			
			
			if(node1.getRoot().deep==n) {
				return answer;
			}
		}
		 
		 
	        return answer;
	    }
	
	class Edge{
		int node1;
		int node2;
		int weight;
		
		public Edge(int node1,int node2,int weight) {
			this.node1=node1;
			this.node2=node2;
			this.weight=weight;
		}
	}
	 
	class Node{
		int deep=1;
		
		Node parent=null;
		
		
	
		public boolean connect(Node node) {
			Node node1=this.getRoot();
			Node node2=node.getRoot();
			if(node1==node2) {
				return true;
			}
			else {
				return false;
			}
		}
		
		public void merge(Node node) {
			
			Node node1=this.getRoot();
			Node node2=node.getRoot();
			if(connect(node)) {
				return;
			}
			
			if(node1.deep>node2.deep) {
				node2.parent=node1;
			}else if(node1.deep<node2.deep) {
				node1.parent=node2;
			}else if(node1.deep==node2.deep) {
				node2.parent=node1;
				node1.deep++;
			}
			
		}
		
		public Node getRoot() {
			if(parent==null) return this;
			return parent.getRoot();
		}
	}

}
