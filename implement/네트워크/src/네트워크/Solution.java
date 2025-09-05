package 네트워크;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
//
//	public static void main(String[] args) {
//		Solution s = new Solution();
//        System.out.println("Test 1:");
//        int result1 = s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
//        System.out.println("Result: " + result1);
//        
//        System.out.println("\nTest 2:");
//        int result2 = s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}});
//        System.out.println("Result: " + result2);
//	}

	public int solution(int n, int[][] computers) {
		
		Node[] nodes=new Node[n];
		for(int i=0; i<n; i++) {
			nodes[i]=new Node(i);
		}
		
		Set<String> existSet=new HashSet<String>();
//		
//		for(int i=0; i<computers.length; i++) {
//			int nodeA=i;
//	
//			for(int j=i+1; j<computers[i].length; j++) {
//				int  nodeB=j; // i가 j를 알고있는지 확인한다.
//				
//				if(i==j) continue;
//				if(computers[i][j]==1) {
//				
//					String str=i+""+j;
//					
//				    char[] chars=str.toCharArray();
//				    Arrays.sort(chars);
//				    
//					String setKey=new String(chars);
//					System.out.println(setKey);
//					if(existSet.contains(setKey)) {
//						System.out.println("i : "+i +" j : "+j +  "  "+setKey+"중복");
//						continue;
//					}else {
//						Node aNode=nodes[i];
//						Node bNode=nodes[j];
//						 Node rootA = aNode.getRootNode();
//		                    Node rootB = bNode.getRootNode();
//		                    
//		                    if(rootA != rootB) {
//		                        rootB.parent = rootA; // 루트끼리 연결
//		                    }
//						//bNode.merge(aNode);
//						existSet.add(setKey);
//					}
//				}
//				
//			}
//		}
		
	     for(int i = 0; i < n; i++) {
             for(int j = i + 1; j < n; j++) { // j = i+1부터 시작해서 중복 자연 방지
                 if(computers[i][j] == 1) {
                     Node aNode = nodes[i];
                     Node bNode = nodes[j];

                     // 개선 2: 루트끼리 연결 (트리 깊이 최소화)
                     Node rootA = aNode.getRootNode();
                     Node rootB = bNode.getRootNode();

                     if(rootA != rootB) {
                         rootB.parent = rootA; // 루트끼리 연결
                     }
                 }
             }
         }
		
		Set<Integer> rootSet=new HashSet<Integer>();
		for(int i=0; i<n; i++) {
			Node node=nodes[i];
			Node root=node.getRootNode();
			rootSet.add(root.computerNumber);
		}
		
		System.out.println(rootSet.size());
        return rootSet.size();
    }
	
	
	class Node{
		Node parent=null;
		int computerNumber;
		
		public Node(int computerNumber) {
		this.computerNumber=computerNumber;	
		}
//		
//		public void merge(Node node) {
//			
//			Node current=getRootNode();
//			Node mer=node.getRootNode();
//			if(current!=mer) {
//				current.parent=mer;
//			}
////			node.parent=this;
//			//node가 this 를알고 있으면 this의 자식으로 들어간다.
//		}
		
		public Node getRootNode() {
			if(parent==null) return this;
			parent = parent.getRootNode(); // 경로 압축 추가
			return parent;
		}
		
		
	}
	
	
}
