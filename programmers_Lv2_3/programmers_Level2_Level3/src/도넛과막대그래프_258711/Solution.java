package 도넛과막대그래프_258711;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution(new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {7, 8}, {8, 9}, {9, 10}, {11, 10}, {11, 1}});
//	}
	
	int max=Integer.MIN_VALUE;
	public int[] solution(int[][] edges) {
		//max찾기
		for(int i=0; i<edges.length; i++) {
			for(int j=0; j<edges[i].length; j++) {
				if(max < edges[i][j]) {
					max=edges[i][j];
				}
			}
		}
		max=max+1;
		
		//생성한 정점 찾기
		//나에게 들어오는것은 0이고, 나가는것은 2이상인것 찾기
	
		//[4]=2 라는것은 4정점이 2를 가리키고 있다 라는것
		Node[] nodes=new Node[max];
		for(int i=1; i<nodes.length; i++) {
			nodes[i]=new Node(i);
		}
		
		for(int i=0; i<edges.length; i++) {
			int edge[]=edges[i];
			Node a=nodes[edge[0]];
			Node b=nodes[edge[1]];
			a.addKnow(b);
			b.isSelected();
		}
		
		
		//새로운 정점 찾기
		Node createdNode=null;
		for(int i=1; i<nodes.length; i++) {
			Node node=nodes[i];
			if(!node.selected && node.knows.size()>=2) {
				createdNode=node;
				break;
			}
		}
		
		System.out.println("createNode number : "+createdNode.number);
		
		int totalGraphCount=createdNode.knows.size();
		
		
		//knows 사이즈 0이 있담ㄴ! 막대 모양 그래프
		//2개가 나가고 2개가 들어오는게 있다면 도넛 모양 그래프
		//나머지는 도넛 모양
		
		//[createNumber, 도넛모양,막대모양,8자모양]
		 int[] answer = new int[4];
		 answer[0]=createdNode.number;
		 
		 for(Node node : createdNode.knows) {
			 int type=getType(node);
			 answer[type]+=1;
		 }
		 System.out.println(Arrays.toString(answer));
		
		
		
		
       
        return answer;
    }
	
	public int getType(Node node) {
		//node로 부터 알고 있는것을 다 집어넣는데,
		//만약 그 노드가 know가 0이라면 return 2
		//만약 그 노드가드 2개를 알고있고, 누군가 이 노드를 2개를 알고 있다면 return 3
		//아무것도 없이 다 돌았다면 return 1;
		
		Map<Integer,Integer> map=new HashMap<Integer, Integer>();
		//map(1,2) 라는것은 1을 2번 알고 있다.
		
		Queue<Node> queue= new LinkedList<Solution.Node>();
		boolean visited[]=new boolean[max];
		queue.add(node);
		visited[node.number]=true;
		
		List<Node> donutPossibleList=new ArrayList<Solution.Node>();
		while(!queue.isEmpty()) {
			Node n=queue.poll();
			
			if(n.knows.size()==0) {
				return 2;
			}
			if(n.knows.size()==2) {
				donutPossibleList.add(n);
			}
			for(Node know : n.knows) {
				map.merge(know.number, 1, (a,b)->a+b);
				if(!visited[know.number]) {
					visited[know.number]=true;
					queue.add(know);
				}
			}
			
			
		}
		
		for(Node donut : donutPossibleList) {
		//	System.out.println(donut.number);
			if(map.containsKey(donut.number) && map.get(donut.number)==2) {
				return 3;
			}
		}
		
		return 1;
		
		
	}
	
	class Node{
		int number;
		List<Node> knows;
		boolean selected; //selected는 다른 노드가 나를 알고 있다면! true 아니면 false이다.
		public Node(int number) {
			this.number=number;
			knows=new ArrayList<Solution.Node>();
			selected=false;
		}
		
		public void addKnow(Node node) {
			knows.add(node);
		}
		public void isSelected(){
			this.selected=true;
		}
	}

}
