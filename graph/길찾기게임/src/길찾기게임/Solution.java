package 길찾기게임;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		Solution s=new Solution();
//		s.solution(new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}});
//
//	}

	   public int[][] solution(int[][] nodeinfo) {
		   
		   List<Node> nodes=new ArrayList<Node>();
		   	for(int i=0; i<nodeinfo.length; i++) {
		   		nodes.add(new Node(nodeinfo[i][0],nodeinfo[i][1],i+1));
		   	}
		   	
		   	Collections.sort(nodes,(a,b)->b.y-a.y);
		   	
		   	
		   	Node root=nodes.get(0);
		   	for(int i=1; i<nodes.size(); i++) {
		   		insert(root, nodes.get(i));
		   	}
		   	
		   
	        int[][] answer = new int[2][];
	        
	        
	        List<Integer> pre=new ArrayList<Integer>();

	        List<Integer> post=new ArrayList<Integer>();
	        		

	        a(nodes.get(0),pre);

	        b(nodes.get(0),post);
	        
	        
	        answer[0]=pre.stream()
	        			.mapToInt(a->a.intValue())
						.toArray();
	        
	        answer[1]=post.stream()
        			.mapToInt(a->a.intValue())
					.toArray();
	        
	        
	        System.out.println(Arrays.toString(answer[0]));
	        System.out.println(Arrays.toString(answer[1]));
	        
	        return answer;
	        
	    }
	   
	   
	   public void a(Node node,List<Integer> list) {
		   
		if(node==null) return ;
		list.add(node.nodeNumber);
		a(node.left,list);
		a(node.right,list);
		
	   }
	   
	   public void b(Node node,List<Integer> list) {
		   
			if(node==null) return;
			
			b(node.left,list);
			b(node.right,list);
			list.add(node.nodeNumber);
			
	 }
		   
	   
	   
	   public void insert(Node root,Node children) {
		   if(root.x>children.x) {
			   if(root.left==null) {
				   root.left=children;
			   }else {
				   insert(root.left, children);
			   }
		   }else if(root.x<children.x) {
			   if(root.right==null) {
				   root.right=children;
			   }else {
				   insert(root.right, children);
			   }
		   }
		   
	   }
	   
	   
	   class Node{
		   
		   int x;
		   int y;
		   int nodeNumber;
		   Node left;
		   Node right;
		   
		   public Node(int x,int y, int nodeNumber) {
			   this.x=x;
			   this.y=y;
			   this.nodeNumber=nodeNumber;
			   left=null;
			   right=null;
		   }
		  
	   }
}
